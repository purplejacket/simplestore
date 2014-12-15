(ns simplestore.unit.datastore-test
  (:require [clojure.test :refer :all]
            [simplestore.datastore :as ds]
            [clojure.edn :as edn]))

(deftest test-initialize-the-awesomeness
  (testing "it initializes the data store"
    (ds/initialize-datastore)
    (is (= @ds/datastore {}))))

(deftest test-write
  (testing "it writes the data store"
    (dosync (ref-set ds/datastore {"key1" "val1"}))
    (ds/write-datastore!)
    (is (= {"key1" "val1"}
           (edn/read-string (slurp (ds/resource-path "datastore.edn")))))))

