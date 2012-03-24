(ns defdrink.views.welcome
  (:require [defdrink.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/welcome" []
         (common/layout

           [:p "(defdrink) will help you choose drinks based upon what you have
               in your liquor cabinet."]

           [:p "It will let you define what you have in your cabinet, to rate
               cocktails (so that ones you don't like one be suggested and ones
                             you love will be suggested first"]))
