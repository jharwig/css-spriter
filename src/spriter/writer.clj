(ns spriter.writer)

(defn image->class-name
    "Convert the image path to a valid CSS class name"
    [image]
    (.replaceAll
      (.replaceAll (:path image) "(\\\\|/)" "_")
      "(?i).png$"
      ""))

(defprotocol CssWriter
  (write-css-selector [c writer image]))

(deftype Writer [format]
  :as this
  CssWriter
  (write-css-selector [writer image]
    (let [class-name (str "." (image->class-name image))
          dim (:dimensions image)
          coord (:coordinates image)
          new-line (if (= format :verbose) "\n" "")
          ;TODO refactor
          x (* (coord 0) -1)
          x (if (= x 0) 0 (str x "px"))
          y (* (coord 1) -1)
          y (if (= y 0) 0 (str y "px"))]
      (.println writer (str class-name " {" new-line
                            " width: " (dim 0) "px;" new-line
                            " height: " (dim 1) "px;" new-line
                            " background-position: " x " " y ";" new-line
                            "}")))))

(def outputs {:verbose (Writer :verbose) :compact (Writer :compact)})
