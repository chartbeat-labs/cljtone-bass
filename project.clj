(defproject cljtone-bass "0.1.0"
  :description "Bass Sample library for overtone"
  :url "https://github.com/chartbeat-labs/"
  :license {:name "The MIT License (MIT)"
            :url "http://opensource.org/licenses/MIT"
            :distribution :repo
            :comments "The world would be a better place if everybody played the uke."}
  :deploy-repositories [["releases" :clojars]]
  :signing {:gpg-key "F0903068"}
  :aot :all
  :vcs :git
  :dependencies
  [[org.clojure/clojure "1.6.0"]
   [quantisan/overtone "0.10-SNAPSHOT"]
   [org.clojure/tools.namespace "0.2.3"]
   [clj-http "2.0.0"]
   [cider/cider-nrepl "0.9.1"]
   [org.clojure/tools.nrepl "0.2.10"]])
