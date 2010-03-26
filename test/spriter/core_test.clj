(ns spriter.core-test
  (:use [spriter.core] :reload-all)
  (:use [circumspec]))

(def tango-dir "test/resources/tango-icon-theme")
	
(testing "get images"
	(should (> (count (get-images tango-dir)) 0)))

(testing "vertical layout"
	(let [images (get-images tango-dir)
				layout (:vertical layouts)
				coord-images (with-coordinates layout images)]
		(should (= (count coord-images) (count images)))))
			
(testing "gen sprite"
	(gen-sprite tango-dir :layout :vertical :png "~/Desktop/sprite.png" :css "~/Desktop/sprite.css"))
	