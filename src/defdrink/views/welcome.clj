(ns defdrink.views.welcome
  (:require [defdrink.views.common :as common])
  (:use [noir.core :as noir]
        [hiccup.core :as html]
        [hiccup.form-helpers :as form]))

(noir/defpartial welcome-text []
            [:div
              [:p "(defdrink) will help you choose drinks based upon what you have in your liquor cabinet."]

              [:p "It will let you define what you have in your cabinet, to rate cocktails (so that ones you don't like one be suggested and ones you love will be suggested first"]

              [:p "Let's start simply. You can add the names of drinks and (defdrink) will remember them"]])

(noir/defpartial new-drink-form []
                 (label "name" "Drink Name:")
                 (text-field "name" "")
                 (form/submit-button "(defdrink)")
                 )


(noir/defpage "/welcome" []
         (common/layout
            (welcome-text) 
            (form/form-to [:post "/welcome"]
                          (new-drink-form))
            ))

(noir/defpage [:post "/welcome"] []
              (render "/welcome"))
