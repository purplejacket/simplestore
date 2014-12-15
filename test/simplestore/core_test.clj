(ns simplestore.core-test
  (:require [clojure.test :refer :all]
            [simplestore.crud :as crud]))

(deftest test-read
  (testing "it reads a value"
    (dosync (ref-set crud/datastore {"key1" "val1"}))
    (is (= (crud/read "key1") "val1"))
    (is (= @crud/datastore {"key1" "val1"}))))

(deftest test-create
  (testing "it creates a value"
    (dosync (ref-set crud/datastore {"key1" "val1"}))
    (is (= (crud/create "key2" "val2") true))
    (is (= @crud/datastore {"key1" "val1"
                            "key2" "val2"}))))

