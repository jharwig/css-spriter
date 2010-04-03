(ns spriter.writer-test
  (:use (spriter core util writer))
  (:use circumspec)
  (:require [clojure.contrib.duck-streams :as io])
  (:import java.io.StringWriter))

(def tango-dir "test/resources/tango-icon-theme")

(testing "write verbose"
  (let [string-writer (StringWriter.)
        writer (io/writer string-writer)
        image (merge {:coordinates [15 0]} (first (get-images tango-dir)))]
    (write-css-selector (:compact outputs) writer image)
    (.flush writer)
    (should (= (.toString string-writer) "._16x16_actions_address-book-new { width: 16px; height: 16px; background-position: -15px 0;}\n"))))
