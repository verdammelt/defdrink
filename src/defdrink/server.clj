(ns defdrink.server
  (:require [noir.server :as server]
            [noir.core :as noir]
            [noir.response :as response]))

(server/load-views "src/defdrink/views/")

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (server/start port {:mode mode
                        :ns 'defdrink})))

(noir/pre-route "/" {} (response/redirect "/welcome"))

