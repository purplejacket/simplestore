(ns simplestore.datastore
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(defn resource-path [path]
  (.getAbsolutePath
   (io/file
    (io/resource path))))

(def datastore
  (ref {}))

(def foo
  (agent 0))

(defn initialize-datastore []
  (dosync
    (ref-set datastore
             (edn/read-string (slurp (resource-path "datastore.edn"))))))

(defn write-datastore! []
  (spit
    (resource-path "datastore.edn")
    (pr-str @datastore)))