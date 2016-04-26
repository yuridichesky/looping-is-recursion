(ns looping-is-recursion)

(defn power [base exp]
  (loop [res 1 e exp]
    (if (zero? e) res
      (recur (* res base) (dec e)))))

(defn last-element [a-seq]
  (reduce (fn [_ e] e) nil a-seq))

(defn seq= [seq1 seq2]
  (loop [s1 seq1, s2 seq2]
    (cond (and (empty? s1) (empty? s2)) true
          (or (empty? s1) (empty? s2)) false
          (not (== (first s1) (first s2))) false
          :else (recur (rest s1) (rest s2)))))

(defn find-first-index [pred a-seq]
  (loop [idx 0, s a-seq]
    (cond (empty? s) nil
          (pred (first s)) idx
          :else (recur (inc idx) (rest s)))))

(defn avg [a-seq]
  (loop [acc 0, len 0, s a-seq]
    (if (empty? s)
      (if (zero? len) nil
        (/ acc len))
      (recur (+ acc (first s)) (inc len) (rest s)))))


(defn parity [a-seq]
  (reduce (fn [res e] (if (contains? res e) (disj res e) (conj res e))) #{} a-seq))

(defn fast-fibo [n]
  (cond (= 0 n) 0
        (= 1 n) 1
        :else 
          (loop [f-2 0, f-1 1, k 2]
            (let [fk (+ f-2 f-1)]
              (if (= k n) fk
                (recur f-1 fk (inc k)))))))


(defn cut-at-repetition [a-seq]
  (loop [res '(), exist-map #{}, s a-seq]
    (cond (empty? s) (reverse res)
          (contains? exist-map (first s)) (reverse res)
          :else (recur (cons (first s) res) (conj exist-map (first s)) (rest s)))))

