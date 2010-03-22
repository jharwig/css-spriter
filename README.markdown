### css-spriter
===========

Concat image files into single sprite and generate background-image css.

## Installation

1. Install leiningen (http://github.com/technomancy/leiningen)
2. lein uberjar

## Usage

java -jar css-spriter-standalone.jar [dir] [options]

Options
* :layout (:vertical or :horizontal)
* :png [location of output sprite png]
* :css [location of output sprite css]
* :output (:compact or :verbose css output)

## License

Eclipse Public License 1.0
