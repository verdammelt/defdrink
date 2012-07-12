(ns defdrink.test.views.new-drink
  (:use midje.sweet)
  (:use defdrink.views.new-drink)
  (:use noir.util.test)
  (:use [net.cgrand.enlive-html :only [select]])
  (:use midje-html-checkers.core)
  )

(defchecker has-input-with-label [text]
  (checker [actual]
    (let [html (html-resource-from-string actual)
          the-label (first (filter (has-text text) 
                                   (select html [:label])))]
      (and the-label
           (let [for-attr (:for (:attrs the-label))]
             (select html [(keyword (str "input#" for-attr))]))))))
      

(defchecker has-form-posting-to [url]
  (checker [actual]
    (let [form (first (select (html-resource-from-string actual) [:form]))]
      (and ((has-attr :method "POST") form)
           ((has-attr :action "/new-drink") form)
           ))))

(defchecker has-submit-button-with-label [label]
  (checker [actual]
    (let [html (html-resource-from-string actual)
          all-inputs (select html [:input])
          submit-button (first (filter (and (has-attr :type "submit")
                                           (has-attr :value label)) all-inputs) ) ]
      submit-button
      )))


(fact "about the new drink page"
  (let [body (:body (send-request "/new-drink"))]
    body => (has-form-posting-to "/new-drink")
    body => (has-input-with-label "Name: ")
    body => (has-submit-button-with-label "(defdrink)")
    ))

