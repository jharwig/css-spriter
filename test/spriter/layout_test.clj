(ns spriter.layout-test
  (:use helper)
  (:use (spriter core util layout))
  (:use [circumspec]))

(testing "vertical layout"
	(let [images (get-images tango-dir)
				layout (:vertical layouts)
				coord-images (with-coordinates layout images)]
		(should (= (count coord-images) (count images)))))

(testing "available layouts"
  (should (= (:vertical layouts) (Simple :vertical)))
  (should (= (:horizontal layouts) (Simple :horizontal))))
