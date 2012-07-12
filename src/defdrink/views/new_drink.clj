(ns defdrink.views.new-drink
  (:require [defdrink.views.common :as common]
            [hiccup.page-helpers :as html]
            [hiccup.form-helpers :as form]
            [noir.core :as noir]))

(noir/defpage "/new-drink" []
  (common/layout
    (form/form-to [:post "/new-drink"]
      (form/label "name" "Name: ")
      (form/text-field "name")
      (form/submit-button "(defdrink)"))))
