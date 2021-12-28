(ns wonderland-number.finder)

; You must find a way to generate this wonderland number.

; - It has six digits
; - If you multiply it by 2,3,4,5, or 6, the resulting number has all
;   the same digits in at as the original number.  
; - The only difference is the position that they are in.

(defn digitize [n]
  (frequencies (str n)))

(defn wonderland? [n]
  (apply = 
          (map digitize
               (map (partial * n) [2 3 4 5 6]))))

(defn wonderland-number []
  (->> (range 100000 999999)
       (filter wonderland?)
       first))

(wonderland-number)


