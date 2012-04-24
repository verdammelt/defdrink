(defproject defdrink "0.0.1-SNAPSHOT"
            :description "Web application to suggest drinks based upon the contents of your liquor cabinet."
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [postgresql/postgresql "9.1-901.jdbc4"]
                           [org.clojure/java.jdbc "0.1.3"]
                           [noir "1.2.1"]]
            :dev-dependencies [[midje "1.3.0"]
                               [lein-midje "1.0.9"]
                               [com.stuartsierra/lazytest "1.2.3"]]
            :repositories {"stuart" "http://stuartsierra.com/maven2"}
            :main defdrink.server)
