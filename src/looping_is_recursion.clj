(ns looping-is-recursion)

(defn power [base exp]
  (loop [res 1 e exp]
    (if (zero? e) res
      (recur (* res base) (dec e)))))

(defn last-element [a-seq]
  (reduce (fn [_ e] e) nil a-seq))

(defn seq= [seq1 seq2]
  ":(")

(defn find-first-index [pred a-seq]
  ":(")

(defn avg [a-seq]
  -1)

(defn parity [a-seq]
  ":(")

(defn fast-fibo [n]
  ":(")

(defn cut-at-repetition [a-seq]
  [":("])

