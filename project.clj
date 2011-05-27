(defproject samples-clojure-thrift "0.1.0-SNAPSHOT"
  :omit-default-repositories false
  :repositories {
                 "conjars" "http://conjars.org/repo"
                 "sun"  "http://download.java.net/maven/2"	
                }
  :description "Clojure-based Evented Factual Datastore API Server"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
		 [org.apache.thrift/libthrift "0.6.1"]
                 
                 ]
  :java-source-path "src/java"
  :javac-options {:debug "true" :fork "true"}
  )
