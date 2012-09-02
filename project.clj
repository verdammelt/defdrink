(defproject defdrink "0.0.1-SNAPSHOT"
  :description "Web application to suggest drinks based upon the
  contents of your liquor cabinet."
  :dependencies [
                 [org.clojure/clojure "1.4.0"] 
                 [postgresql/postgresql "9.1-901.jdbc4"]
                 [org.clojure/java.jdbc "0.2.1"]
                 [noir "1.2.2"]
                 ]
  :profiles {:dev {:dependencies [
                                  [midje "1.5.0-SNAPSHOT"]
                                  [midje-html-checkers "1.0.1"]
                                  [com.stuartsierra/lazytest "1.2.3"]
                                  ]}}
  :aliases {"test" "midje"
            "test!" ["do", "clean," "midje"]}
  :repositories {"stuart" "http://stuartsierra.com/maven2"}
  :main defdrink.server)
