(ns snow-alert.resources-test
  (:require [clojure.test :refer :all]
            [snow-alert.resources :as r]))

(deftest one-plus-one-equals-snow? 
  (is (= "snow" (+ 1 1))))
