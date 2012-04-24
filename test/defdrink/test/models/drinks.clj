(ns defdrink.test.models.drinks
  (:use clojure.test)
  (:use midje.sweet)
  (:use defdrink.models.drinks)
  (:require [defdrink.utils.sql :as sql]))

(fact (all) => [...drink1... ...drink2...]
      (provided (sql/select :drinks) => [...drink1... ...drink2...])

      (insert ...name...) => ...not-important...
      (provided (sql/insert :drinks {:name ...name...}) => ...not-important...))
