(ns spriter.writer-test
  (:use helper)
  (:use (spriter core util writer))
  (:use [circumspec])
  (:require [clojure.contrib.duck-streams :as io])
  (:import java.io.StringWriter))

(testing "write verbose"
  (let [string-writer (StringWriter.)
        writer (io/writer string-writer)
        image (merge {:dimensions [16 16] :coordinates [15 0]} (first (get-images tango-dir)))]
    (write-css-selector (:compact outputs) writer image)
    (.flush writer)
    (should (= (.toString string-writer) "._16x16_actions_address-book-new { width: 16px; height: 16px; background-position: -15px 0;}\n"))))