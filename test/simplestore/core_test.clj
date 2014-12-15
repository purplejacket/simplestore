(ns simplestore.core-test
  (:require [clojure.test :refer :all]
            [simplestore.crud :as crud]
            [simplestore.datastore :as ds]))

(deftest test-read
  (testing "it reads a value"
    (dosync (ref-set ds/datastore {"key1" "val1"}))
    (is (= (crud/read "key1") "val1"))
    (is (= @ds/datastore {"key1" "val1"}))))

(deftest test-create
  (testing "it creates a value"
    (dosync (ref-set ds/datastore {"key1" "val1"}))
    (is (= (crud/create "key2" "val2") true))
    (is (= @ds/datastore {"key1" "val1"
                            "key2" "val2"}))))

(deftest test-delete
  (testing "it deletes a map entry"
    (dosync (ref-set ds/datastore {"key1" "val1"
                                     "key2" "val2"}))
    (is (= (crud/delete "key1") true))
    (is (= @ds/datastore {"key2" "val2"}))))