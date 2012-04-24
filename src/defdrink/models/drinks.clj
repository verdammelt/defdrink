(ns defdrink.models.drinks
  (:require [clojure.java.jdbc :as sql2])
  (:require [defdrink.utils.sql :as sql]))

(defn all []
  (sql/select :drinks))

(defn insert [name]
  (sql2/with-connection (System/getenv "DATABASE_URL")
                       (sql2/insert-record :drinks {:name name})))

