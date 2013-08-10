(ns clj-tagsoup-selector.test
  (:use [clojure.test]
        [clojure.java.io :only [resource]]
        [pl.danieljanus.tagsoup]
        [clj-tagsoup-selector]))

(def test-html-tree (parse (resource "test.html")))
(def body (second (children test-html-tree)))

(deftest by-attribute-top
  (let [res (by-attribute test-html-tree {:class "body-class" :id "body-id"})
        expected (list body)]
    (is (= res expected))))

(deftest by-attribute-nested
  (let [res (by-attribute test-html-tree {:id "nested-span"})
        expected (list [:span {:id "nested-span"}])]
    (is (= res expected))))

(deftest by-tag-div
  (let [res (by-tag test-html-tree :div)
        expected (seq (children body))]
    (is (= res expected))))
