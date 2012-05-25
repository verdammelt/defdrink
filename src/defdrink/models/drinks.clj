(ns defdrink.models.drinks
  (:require [defdrink.utils.sql :as sql]))

(defn all []
  (sql/select :drinks))

(defn insert [name]
  (sql/insert :drinks {:name name}))
