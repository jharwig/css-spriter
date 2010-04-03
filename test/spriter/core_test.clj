(ns spriter.core-test
  (:use spriter.core)
  (:use circumspec)
  (:import java.io.File))

(def tango-dir "test/resources/tango-icon-theme")

(testing "get images"
	(should (> (count (get-images tango-dir)) 0)))

(testing "gen sprite"
  (let [prefix "css-spriter-"
        tmp-file (partial #(File/createTempFile %1 %2) prefix)
        png    (tmp-file "png")
        css    (tmp-file "css")]
    (println (str "Generating test files in " (.getPath png)))
	  (gen-sprite tango-dir :layout :vertical :png png :css css)))
