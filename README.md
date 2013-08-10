# clj-tagsoup-selector

This is selectors for clj-tagsoup Clojure library.

## Usage

    <html>
        <head></head>
        <body class="body-class" id="body-id">
            <div class="div0">
            </div>
            <div class="div1">
              <span id="nested-span"></span>
            </div>
            <div class="div2">
            </div>
        </body>
    </html>

Find all elements with class "body-class" and id "body-id":

    (by-attribute test-html-tree {:class "body-class" :id "body-id"})

Find all &lt;div&gt; elements:

    (by-tag test-html-tree :div)

Find all &lt;div&gt; elements with class "div1":

    (by-fn html-tree (fn [html-tree]
                       (and (= (tag html-tree) :div)
                            (= (attributes html-tree) {:class "div1"}))))

## License

Copyright © 2013 Eugene Apollonsky

Distributed under the Eclipse Public License, the same as Clojure.
