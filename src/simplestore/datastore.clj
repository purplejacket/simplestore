(ns simplestore.datastore)

(def datastore
  (ref {}))

(def foo
  (agent 0))

