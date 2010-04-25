(ns spriter.layout-test
  (:use (spriter core layout))
  (:use circumspec))

(def tango-dir "test/resources/tango-icon-theme")

(testing "vertical layout"
	(let [images (get-images tango-dir)
				layout (:vertical layouts)
				coord-images (with-coordinates layout images)]
		(should (= (count coord-images) (count images)))))

(testing "available layouts"
  (should (not (nil? (:vertical layouts))))
  (should (not (nil? (:horizontal layouts)))))
