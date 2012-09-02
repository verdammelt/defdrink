(ns defdrink.models.migration
  (:require [clojure.java.jdbc :as sql])
  (:require [clojure.string :as str]))

(defn create-drinks []
  (sql/with-connection (System/getenv "DATABASE_URL")
                       (sql/create-table :drinks
                                         [:id :serial "PRIMARY KEY"]
                                         [:name :varchar "NOT NULL"])))

;; need to clean this up - the magic is something like:
;; (map #(st/replace (st/replace % #"\n " "\n") " **\n" "") (remove st/blank? (st/split slurped #"-")))
(defn load-drinks-file []
  (let [entire-file (slurp "drinks.txt")
        split-drinks (remove str/blank? (str/split entire-file #"-"))
        newline-space-cleaner #(str/replace % "\n " "\n")
        leading-stars-cleaner #(str/replace % "\n** " "")
        trailing-stars-cleaner #(str/replace % " **\n" "")
        cleaned-up (map #(-> %
                             newline-space-cleaner
                             leading-stars-cleaner
                             trailing-stars-cleaner)
                        split-drinks)
        tmp (map #(str/split % #"\n" 2) cleaned-up)
        drinks (map #(hash-map :name (first %)
                               :notes (second %)) tmp)]
    drinks))


(defn -main []
  (print "Migrating database...") (flush)
  (create-drinks)
  (println " done."))

