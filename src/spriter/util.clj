(ns spriter.util
  (:import (java.io File)))

(defn file-str
  "Returns a java.io.File.  Replaces ~ at the start of the path 
  with the user.home system property."
  [& args]
  (let [#^String s (apply str args)
        s (if (.startsWith s "~")
            (str (System/getProperty "user.home")
                 File/separator (subs s 1))
            s)]
    (File. s)))

(defn str->keyword
  "Convert a string with an optional ':' into a keyword"
  [str]
  (keyword (.replaceAll str "^:" "")))

(defn num->css-str
  ([num] (num->css-str num "px"))
  ([num unit] (str num (when-not (zero? num) unit))))