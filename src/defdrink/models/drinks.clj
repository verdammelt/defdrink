(ns defdrink.models.drinks
  (:require [clojure.java.jdbc :as sql2])
  (:require [defdrink.utils.sql :as sql]))

(defn all []
  (sql/select :drinks))

(defn insert [name]
  (sql/insert :drinks {:name name}))
