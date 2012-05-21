(ns defdrink.views.welcome
  (:require [defdrink.views.common :as common])
  (:use 
        [hiccup.page-helpers :as html]
    [noir.core :as noir]))

(noir/defpartial welcome-text []
  [:div

   [:p "(defdrink) will help you choose drinks based upon what you have in
       your liquor cabinet."]

   [:p "It will let you define what you have in your cabinet, to rate
       cocktails (so that ones you don't like one be suggested and ones you
       love will be suggested first"]

   [:p "Let's start simply. You can add the names of drinks and (defdrink)
       will remember them"]])

(noir/defpage "/welcome" [] 
  (common/layout 
    (welcome-text)
    (html/link-to "/drinks" "Bartender - pour me a drink.")))

