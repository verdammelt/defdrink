(ns defdrink.models.drinks
  (:require [clojure.java.jdbc :as sql]))

(defn all []
  (sql/with-connection (System/getenv "DATABASE_URL")
                       (sql/with-query-results results
                                               ["select * from drinks order by name asc"]
                                               (into [] results))))

(defn insert [name]
  (sql/with-connection (System/getenv "DATABASE_URL")
                       (sql/insert-record :drinks {:name name})))

