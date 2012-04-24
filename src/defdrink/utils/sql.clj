(ns defdrink.utils.sql
  (:require [clojure.java.jdbc :as sql]))

(defn- run-query [query]
  (sql/with-query-results results [query] (into [] results)))

(defn select [table]
  (sql/with-connection 
    (System/getenv "DATABASE_URL")
    (run-query (format "select * from %s" table))))


