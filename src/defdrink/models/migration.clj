(ns defdrink.models.migration
  (:require [clojure.java.jdbc :as sql]))

(defn create-drinks []
  (sql/with-connection (System/getenv "DATABASE_URL")
                       (sql/create-table :drinks
                                         [:id :serial "PRIMARY KEY"]
                                         [:name :varchar "NOT NULL"])))

(defn -main []
  (print "Migrating database...") (flush)
  (create-drinks)
  (println " done."))

