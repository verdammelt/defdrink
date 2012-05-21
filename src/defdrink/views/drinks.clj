(ns defdrink.views.drinks
  (:require 
    [defdrink.models.drinks :as drinks]
    [defdrink.views.common :as common])
  (:use [noir.core :as noir]
        [hiccup.core :as html]
        [hiccup.form-helpers :as form]))

(noir/defpartial new-drink-form []
  (label "name" "Drink Name:")
  (text-field "name" "")
  (form/submit-button "(defdrink)"))

(noir/defpartial display-drink [{:keys [id name]}]
  [:li {:id id} [:h3 name]])

(noir/defpartial list-of-drinks []
  (let [drinks (drinks/all)]
    (common/layout 
      [:h1 "All Known Drinks:"]
      [:ul#drinks
       (map display-drink drinks)])))

(defpage "/drinks" {}
  (common/layout
    (form/form-to [:post "/drinks" ]
                  (new-drink-form))
    (list-of-drinks)))

(defpage [:post "/drinks"] {:keys [name]}
  (drinks/insert name)
  (render "/drinks"))

