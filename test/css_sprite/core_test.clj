(ns css-sprite.core-test
  (:use [css-sprite.core] :reload-all)
  (:use [circumspec]))

(def tango-dir "test/resources/tango-icon-theme")

	
(testing "get images"
	(should (> (count (get-images tango-dir)) 0)))
	
(testing "combine"
	(combine-images (get-images tango-dir) :vertical "/Users/jharwig/Desktop/sprite.png"))

(testing "vertical layout"
	(let [images (get-images tango-dir)
				layout (:vertical layouts)
				coord-images (with-coordinates layout images)]
		(should (= (count coord-images) (count images)))))
		
(testing "write css"
	(let [images (get-images tango-dir)]
		(write-css images :vertical "~/Desktop/file.css")
		))