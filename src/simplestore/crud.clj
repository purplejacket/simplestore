(ns simplestore.crud)

(def datastore
  (ref {"key1" "val1"}))

(defn read [key]
  (get @datastore key))