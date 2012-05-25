(ns defdrink.test.models.drinks
  (:use midje.sweet)
  (:use defdrink.models.drinks)
  (:require [defdrink.utils.sql :as sql]))

(fact "getting drinks from database"
      (all) => [...drink1... ...drink2...]
      (provided (sql/select :drinks) => [...drink1... ...drink2...]))

(fact "inserting new drinks into the database"
      (insert ...name...) => irrelevant
      (provided (sql/insert :drinks {:name ...name...}) => irrelevant))
