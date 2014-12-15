(ns simplestore.crud
  (:refer-clojure :exclude [read])
  (:require [simplestore.datastore :as ds]))

(defn read [key]
  (get @ds/datastore key))

;; TODO - decide if create should blow up on trying
;; to put in a key-val where key already exists
(defn create [key val]
  (dosync
    (alter ds/datastore
           (fn [themap]
             (assoc themap key val))))
  true)

(defn delete [key]
  (dosync
    (alter ds/datastore
           (fn [themap]
             (dissoc themap key))))
  true)

