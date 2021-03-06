(defproject clj-json-patch "0.1.7"
  :description "Clojure implementation of http://tools.ietf.org/html/rfc6902"
  :url "http://github.com/daviddpark/clj-json-patch"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main clj-json-patch.core
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.597"]
                 [cheshire "5.10.0"]
                 [doo "0.1.11"]]
  :deploy-repositories [["releases" :clojars]
                        ["snapshots" :clojars]]
  :profiles {:dev {:dependencies [[midje/midje "1.9.9"]]
                   :plugins [[lein-midje "3.2.2"]
                             [lein-doo "0.1.11"]]}}
  :doo {:paths {:karma "./node_modules/karma/bin/karma"}
        :build "test"
        :alias {:default [:firefox]}}
  :test-paths ["test/clj"]
  :hooks [leiningen.cljsbuild]
  :cljsbuild
      {:builds
       {:test
        {:source-paths ["src" "test/cljs"]
         :compiler
         {:output-to "resources/public/js/runner-cljs.js"
          :main clj-json-patch.runner-cljs
          :optimizations :whitespace
          :pretty-print true}}
        :builds nil}})
