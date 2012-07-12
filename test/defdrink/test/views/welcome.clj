(ns defdrink.test.views.welcome
  (:use midje.sweet
        defdrink.views.welcome
        noir.util.test
        midje-html-checkers.core))

(defchecker has-link-with-text [regexp]
  (checker [actual]
    ((at-any [:a] (has-text regexp)) (:body actual))))

(defchecker has-link-with-href [href]
  (checker [actual]
    ((at-any [:a] (has-attr :href href)) (:body actual))))

(fact "about the welcome page"
  (let [response (send-request "/welcome")]
    response => (has-link-with-href "/drinks")
    response => (has-link-with-text #"\ABartender.*")))


