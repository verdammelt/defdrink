(ns defdrink.utils.sql
  (:require [clojure.java.jdbc :as sql]))

(def ^{:private true} connection-string 
  (System/getenv "DATABASE_URL"))

(defn- run-query [query]
  (sql/with-query-results results [query] (into [] results)))

(defn select [table]
  (sql/with-connection 
    connection-string 
    (run-query (format "select * from %s" (name table)))))

(defn insert [table data] 
  (sql/with-connection 
    connection-string 
    (sql/insert-record table data)))

