# css-spriter

Concat image files into single sprite and generate background-image css with Clojure.

### Get Started

If you don't want to build, use this prebuilt [css-spriter-standalone.jar](http://github.com/downloads/jharwig/css-spriter/css-spriter-standalone.jar) and refer to the Usage section.

### Installation

(requires leiningen (http://github.com/technomancy/leiningen)

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
