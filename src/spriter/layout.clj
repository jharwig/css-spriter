(ns spriter.layout
  (:require [clojure.contrib.seq-utils :as seq-utils]))

(defprotocol Layout
  (sprite-dimensions [l images])
  (with-coordinates [l images]))

(deftype Simple [direction]
  Layout
  (sprite-dimensions [this, i]
    (let [vertical (= direction :vertical)
          images (with-coordinates this i)
          x-dimension (apply max (map #((:dimensions %1) (if vertical 0 1)) images))
          y-dimension (+ ((:coordinates (last images)) (if vertical 1 0)) ((:dimensions (last images)) (if vertical 1 0)))
          dimensions [x-dimension y-dimension]]
        (if vertical dimensions (vec (reverse dimensions)))))
  (with-coordinates [_ images]
    (if (contains? (first images) :coordinates)
      images
      (let [vertical (= direction :vertical)
            direction-positions (map #((:dimensions %1) (if vertical 1 0)) images)
            opposite-positions (conj direction-positions 0)]
        (for [[i image] (seq-utils/indexed images)]
          (let [coord [0 (reduce + (take (inc i) opposite-positions))]
                coord (if vertical coord (vec (reverse coord)))]
            (merge image {:coordinates coord})))))))

(def layouts {:vertical (new Simple :vertical) :horizontal (new Simple :horizontal)})
