# scalajs-mapbox
A Scala.js interface to [Mapbox](https://github.com/mapbox) and related APIs, like [Leaflet.js](https://github.com/Leaflet/Leaflet).

## Get started

To get started, open `sbt` in this example project, and execute the task
`fastOptJS`. This creates the file `target/scala-2.11/example-fastopt.js`.
You can now open `index-fastopt.html` in your favorite Web browser!

During development, it is useful to use `~fastOptJS` in sbt, so that each
time you save a source file, a compilation of the project is triggered.
Hence only a refresh of your Web page is needed to see the effects of your
changes.

## Run the tests

To run the test suite, execute the task `test`. If you have installed
[Node.js](http://nodejs.org/), you can use that runtime to run the tests,
which is faster:

    > set scalaJSStage in Global := FastOptStage
    > test

## The fully optimized version

For ultimate code size reduction, use `fullOptJS`. This will take several
seconds to execute, so typically you only use this for the final, production
version of your application. While `index-fastopt.html` refers to the
JavaScript emitted by `fastOptJS`, `index.html` refers to the optimized
JavaScript emitted by `fullOptJS`.

If Node.js is installed, the tests can also be run in their fully optimized
version with:

    > set scalaJSStage in Global := FullOptStage
    > test

# What if a feature is missing?

APIs can change, even API's like [MPI](https://en.wikipedia.org/wiki/Message_Passing_Interface) (if barely). If you find a function or feature that is missing or can be improved, please submit a pull request. It is trivial to add most features, but we currently don't hae the time or inclination to support all features (especially if they aren't going to be used), so we are passing the buck on to our collective selves.

# Other libraries of interest

* [Autowire](https://github.com/lihaoyi/autowire) is a pair of macros that allows you to perform type-safe, reflection-free RPC between Scala systems (Scala-JS or Scala-JVM).
* [scalajs-google-maps](https://github.com/coreyauger/scalajs-google-maps) is a similar library but for Google Maps instead of the Mapbox ecosystem.
# Barebone application written in Scala.js


