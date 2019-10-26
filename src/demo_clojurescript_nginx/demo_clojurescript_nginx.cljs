(ns ^:figwheel-hooks demo-clojurescript-nginx.demo-clojurescript-nginx
  (:require
    [reagent.core :as r]))


(defn app []
  [:h1.site__title
    [:span.site__title-text "demo-clojurescript-nginx.demo-clojurescript-nginx"]])


(defn mount []
  (r/render [app] (js/document.getElementById "root")))


(defn ^:after-load re-render []
  (mount))


(defonce start-up (do (mount) true))
