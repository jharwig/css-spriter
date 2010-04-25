(ns spriter.writer
  (:use spriter.util))

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
  CssWriter
  (write-css-selector [_ writer image]
    (let [class-name (str "." (image->class-name image))
          nl (if (= format :verbose) "\n" "")
          [css-width css-height] (map num->css-str (:dimensions image))
          negate-and-cssify (comp num->css-str -)
          [css-x css-y] (map negate-and-cssify (:coordinates image))]
      (.println writer (str class-name " {" nl
                            " width: " css-width ";" nl
                            " height: " css-height ";" nl
                            " background-position: " css-x " " css-y ";" nl
                            "}")))))

(def outputs {:verbose (new Writer :verbose) :compact (new Writer :compact)})
