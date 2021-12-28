(ns alphabet-cipher.coder
  (:require [clojure.string :refer [index-of]]))

(def ab "abcdefghijklmnopqrstuvwxyz")

(def alphabet
  (into {} (map-indexed vector ab)))

(defn encode [secret-key message]
  (apply str
         (map
          (fn [k m]
            (alphabet (mod (+ (index-of ab k) (index-of ab m)) 26)))
          (take (count message) (cycle secret-key))
          message)))

(defn decode [secret-key message]
  (apply str
         (map
          (fn [m k] (alphabet (mod (- (index-of ab m) (index-of ab k)) 26)))
          message
          (take (count message) (cycle secret-key)))))

(defn decipher [cipher message]
  (let [extended-cipher (decode cipher message)]
    extended-cipher))

(decipher "meetmebythetree" "egsgqwtahuiljgs")

(comment 
(alphabet (mod (- (index-of ab \e) (index-of ab \s)) 26))
(alphabet (mod (- (index-of ab \g) (index-of ab \e)) 26))

(def message "meetmebythetree")
(def msg "egsgqwtahuiljgs")
(count message)
(apply str (take (count msg) (cycle "scones")))


)
