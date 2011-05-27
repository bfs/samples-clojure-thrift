(ns samples-clojure-thrift.core
 (:import [org.apache.thrift TBase TException TSerializer TDeserializer]
   [org.apache.thrift.protocol TProtocol TProtocolFactory TBinaryProtocol TJSONProtocol TSimpleJSONProtocol]
   [org.apache.thrift.transport TMemoryInputTransport TTransport]
   [com.factual.samples.thrift Person Gender]
   )
 )


(defn to-thrift [obj]
  (let [serializer (TSerializer. (org.apache.thrift.protocol.TBinaryProtocol$Factory.))]
    (.serialize serializer obj)))


(defn from-thrift [thrift-payload target-obj]
  (let [deserializer (TDeserializer. (org.apache.thrift.protocol.TBinaryProtocol$Factory.))]
    (.deserialize deserializer target-obj thrift-payload))
  target-obj
  )


(defn to-json [obj]
  (let [serializer (TSerializer. (org.apache.thrift.protocol.TJSONProtocol$Factory.))]
    (.toString serializer obj)))

(defn from-json [json-obj target-obj]
  (let [deserializer (TDeserializer. (org.apache.thrift.protocol.TJSONProtocol$Factory.))]
    (.deserialize deserializer target-obj json-obj))
  target-obj
  )


(defn to-simple-json [obj]
  (let [serializer (TSerializer. (org.apache.thrift.protocol.TSimpleJSONProtocol$Factory.))]
    (.toString serializer obj)))


