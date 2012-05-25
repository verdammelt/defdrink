(ns defdrink.views.common
  (:use [noir.core :as noir] 
        [hiccup.page-helpers :only [include-css html5] :as hiccup]))

(noir/defpartial layout [& content]
  (hiccup/html5
    [:head
     [:title "(defdrink)"]
     (hiccup/include-css "/css/reset.css")]
    [:body
     [:div#wrapper
      content]]))
