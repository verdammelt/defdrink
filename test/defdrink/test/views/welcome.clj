(ns defdrink.test.views.welcome
  (:use midje.sweet
        defdrink.views.welcome
        noir.util.test
        midje-html-checkers.core))

(defchecker has-link-with-href [href]
  (at-any [:a] (has-attr :href href)))

(defchecker has-link-with-text-matching [regexp]
  (at-any [:a] (has-text regexp)))

(fact
  ;(:body (send-request "/welcome")) => (has-link-with-href "foo")
  (:body (send-request "/welcome")) => (has-link-with-href "/drinks")

  (:body (send-request "/welcome")) => (has-link-with-text-matching #"\ABartender.*")
  )

