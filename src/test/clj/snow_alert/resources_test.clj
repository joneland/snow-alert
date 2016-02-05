(ns snow-alert.resources-test
  (:use conjure.core)
  (:require [clojure.test :refer :all]
            [snow-alert.resources :as r]))

(defn add [x y]
  )

(defn fn-under-test [x y]
  (add x y))

(deftest one-plus-one-equals-snow? 
  (stubbing [add "snow"]
    (is (= "snow" (fn-under-test 1 1)))))
