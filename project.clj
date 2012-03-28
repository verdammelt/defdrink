(defproject defdrink "0.0.1-SNAPSHOT"
            :description "Web application to suggest drinks based upon the contents of your liquor cabinet."
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [postgresql/postgresql "9.1-901.jdbc4"]
                           [org.clojure/java.jdbc "0.1.3"]
                           [noir "1.2.1"]]
            :main defdrink.server)
