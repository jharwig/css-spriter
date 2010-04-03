(ns spriter.util-test
  (:use spriter.util)
  (:use circumspec))

(testing-fn num->css-str
   (0 => "0")
   (1 => "1px")
   (16 => "16px")
   (-1 => "-1px"))

(testing "str->keyword"
  (should (keyword? (str->keyword ":test")))
  (should (keyword? (str->keyword "test"))))
