(defn calculate
  ([array] (calculate array false))
  ([[start & end :as arr] previous]
   (when-not (empty? arr)
     (if (= start :start)
       (recur end true)
       (if (or (= start :end) (false? previous))
         (recur end false)
         (lazy-seq (cons start (calculate end true))))))))


(def data1 [0 0 0 :start 1 2 :end 0 0 0 :start 3 4 :end 0 0 0 :start 5 6 :end])
(def result1 (vec (calculate data1)))
(println result1)

(def data2 (cons :start (cycle '(0 1 2))))
(def result2 (take 10 (calculate data2)))
(println result2)
