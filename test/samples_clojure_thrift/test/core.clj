(ns samples-clojure-thrift.test.core
 (:use [samples-clojure-thrift.core]
       [clojure.test]
   )
 (:import 
   [com.factual.samples.thrift Person Gender]
   ))

(def sample-person-obj
  (doto (Person.) 
    (.setUuid (str (java.util.UUID/randomUUID)))
    (.setFirst_name "Homer")
    (.setLast_name "Simpson")
    (.setMiddle_name "Jay")
    (.setGender Gender/MALE)
    )
  )


(deftest test-person-all
  (testing "Serializing and deserializing Person"
    
    (let [serialized-person (to-thrift sample-person-obj)]
      (is serialized-person "Serialized from TBase" )
      
      
      (let [deserialized-person (from-thrift serialized-person (Person.))]
        (is deserialized-person "Deserialized from byte[]")
        
        
        (let [thrift-json (to-json deserialized-person)]
          (is thrift-json "Serialzed from TBase to thrift-JSON")
          
          
          (let [deserialized-json (from-json (.getBytes thrift-json) (Person.))]
            (is deserialized-json "Deserialized from thrift-JSON")
            
            
            (let [simple-json (to-simple-json deserialized-json)]
              (is simple-json "Serialized from TBase to json")
              )
            )
          )
        )
      )
    )
  )