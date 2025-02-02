(ns predicates)

(+ 1 2)

(some even? [1 2 3])  

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n )))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x]
    (and (pred1 x) (pred2 x))))
 
(defn pred-or [pred1 pred2]
  (fn [x]
    (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? (fn [x]
            (let [strX (str x)]
              (or (whitespace? x) (empty? strX) (nil? x))))  string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [x]
            (has-award? book x)) awards))

(defn my-some [pred a-seq]
  (first (filter (fn [x] x) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (fn [x] (not x)) (map pred a-seq))))

(defn prime? [n]
  (let [pred (fn [x] (== (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
