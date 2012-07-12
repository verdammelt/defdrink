(ns defdrink.test.views.new-drink
  (:use midje.sweet)
  (:use defdrink.views.new-drink)
  (:use noir.util.test)
  (:use [net.cgrand.enlive-html :only [select]])
  (:use midje-html-checkers.core)
  )

(defn make-html [string] (html-resource-from-string string))

(defn find-elements [predicate html selector]
  (filter predicate (select html selector)))

(defn find-element [predicate html selector]
  (first (find-elements predicate html selector)))

(defn attr [attr html]
  (attr (:attrs html)))

(defchecker has-input-with-label [text]
  (checker [actual]
    (let [html (make-html actual)
          the-label (find-element (has-text text) html [:label])]
      (and the-label
           (let [for-attr (attr :for the-label)]
             (find-element identity html 
                           [(keyword (str "input#" for-attr))]))))))
      

(defchecker has-form-posting-to [url]
  (checker [actual]
    (find-element (and (has-attr :method "POST") 
                       (has-attr :action "/new-drink"))
                  (make-html actual) [:form])))

(defchecker has-submit-button-with-label [label]
  (checker [actual]
    (find-element (and (has-attr :type "foo")
                       (has-attr :value label)) 
      (make-html actual) [:input])))

(fact "about the new drink form"
  (fact "how it looks"
    (let [body (:body (send-request "/new-drink"))]
      body => (has-form-posting-to "/new-drink")
      body => (has-input-with-label "Name: ")
      body => (has-submit-button-with-label "(defdrink)"))))

