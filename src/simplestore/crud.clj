(ns simplestore.crud)

(def datastore
  (ref {}))

(defn read [key]
  (get @datastore key))

;; TODO - decide if create should blow up on trying
;; to put in a key-val where key already exists
(defn create [key val]
  (dosync
    (alter datastore
           (fn [refvalue]
             (assoc refvalue key val))))
  true)
