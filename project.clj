(defproject chaos "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [instaparse "1.4.10"]
                 [leadlab/grape "0.2.8-SNAPSHOT"]
                 [org.clojars.benfb/gorilla-repl "0.6.0"]
                 [enlive "1.1.6"]
                 ]
  :main ^:skip-aot gorilla-test.core
  :plugins [[org.clojars.benfb/lein-gorilla "0.6.0"]
            [lein-environ "1.1.0"]]
  :profiles {:dev {}}
  :repl-options {:init-ns chaos.core})
