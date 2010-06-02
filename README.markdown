# css-spriter

Improve page performance by combining image resources into a single browser request using css sprites. This tool, written in Clojure, will recursively concatenate all PNG images into a single sprite image, and generate the appropriate CSS styles to display those images correctly. Css-spriter allows either vertical or horizontal image layouts.

A List Apart has more information on [css sprites](http://www.alistapart.com/articles/sprites).

### Get Started

If you don't want to build, use this prebuilt [css-spriter-standalone.jar](http://github.com/downloads/jharwig/css-spriter/css-spriter-standalone.jar) and refer to the Usage section.

### Building

_requires [leiningen](http://github.com/technomancy/leiningen)_

    lein uberjar

### Usage

    java -jar css-spriter-standalone.jar [dir] [options]

#### Options

    :layout [:vertical :horizontal] - how the sprite's images are arranged
    :png [dest file path] - destination of generated png
    :css [dest file path] - destination of generated css
    :output [:compact :verbose] - format of css

### Limitations

Only png files are supported.

### License

Eclipse Public License 1.0
