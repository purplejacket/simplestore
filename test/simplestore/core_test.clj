(ns simplestore.core-test
  (:require [clojure.test :refer :all]
            [simplestore.crud :as crud]))

(deftest a-test
  (testing "it reads a value"
    (is (= (crud/read "key1") "val1"))))

