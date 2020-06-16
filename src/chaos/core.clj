;; gorilla-repl.fileformat = 1

;; @@
(ns chaos.core
  (:require
            [chaos.gts :refer :all]
            [net.cgrand.enlive-html :as en]
            [grape.core :refer [oid]]
            ))


;; ************************************
;; Helper functions to walk a prescription parse tree
;; ************************************

(defn requirements
  "Helper function to retrieve the _requirements_ for a prescription parse tree _p_"
  [p]
  (en/select p [:requirement]))

(defn action
  "Helper function to retrieve the _action_ for a prescription parse tree _p_"
  [p]
  (-> p
      (en/select [:action])
      first
      :content
      first
      ))

(defn duration_num
  "Helper function to retrieve the _duration_number_ for a prescription parse tree _p_"
  [p]
  (-> p
      (en/select [:duration :number])
      first
      :content
      first
      ))

(defn canonicalize_unit
  "Helper function to canonicalize a time unit _u_"
  [u]
  (cond (= u "weeks") "week"
        (= u "days") "day"
        (= u "years") "year"
        (= u "months") "month"
        (= u "mornings") "morning"
        (= u "afternoons") "afternoon"
        (= u "evenings") "evening"
        (= u "nights") "night"
        :else u
        ))

(defn duration_unit
  "Helper function to retrieve the _durations_unit_ for a prescription parse tree _p_"
  [p]
  (-> p
      (en/select [:duration :unit])
      first
      :content
      first
      canonicalize_unit
      ))

(defn frames
  "Helper function to retrieve the _frames_ for a prescription _p_"
  [p]

  (-> p
      (en/select [:frame])
      ))

(defn frame_kind
  "Helper function to retrieve the _kind_ for a frame _f_"
  [f]
  (if (->> (:content f)
           (map vals)
           flatten
           (some #(= :iteration %)))
    "iteration"
    "selection"))

(defn frame_quantity
  "Helper function to retrieve the _quantity_ for a frame _f_"
  [f]
  (-> f
      :content
      first
      (en/select [:number])
      first
      :content
      first))

(defn frame_unit
  "Helper function to retrieve the _unit_ for a frame _f_"
  [f]
  (-> f
      :content
      first
      (en/select [:unit])
      first
      :content
      first))

(defn subframes?
  "Helper function to retrieve subframes of a frame _f_"
  [f]
  (->> (:content f)
       (map vals)
       flatten
       (some #(= :administer %))
       not
       ))


(defn administer
  "Helper function to add an _administer_ node to a frame _f_"
  [f]
  (let [i (->> (en/select f [:administer :number])
                 (map :content)
                 flatten)]
    (if (= 1 (count i))
      (concat i i)
      i)))

;; **********************************************
;; Functions to build up an RTF graph for a parsed prescription
;; **********************************************

(defn createFrame! [f parent]
  "Helper function to add a frame _f_ to a parent frame _parent_"
  (sub-frame! (frame_quantity f)
              (frame_unit f)
              (frame_kind f)
              parent)
  (if (subframes? f)
    (doseq [sf (frames f)]
      (createFrame! sf (oid 'f2)))
    (let [n (administer f)]
      (admin! (first n) (second n) (oid 'f2)))))

(defn createRTF!
  "Function that takes a parsed requirement and creates an RTF graph structure for it"
  [r]
  (require! (action r) (duration_num r) (duration_unit r))
  (doseq [f (frames r)]
    (createFrame! f (oid 'f))))

;; **********************************************
;; Functions to build up an STN graph for a parsed prescription
;; **********************************************

(defn unit2unit [i o]
  (cond (= i o) 1
        (= i "week") (* 7 (unit2unit "day" o))
        (= i "day")  (* 24 (unit2unit "hour" o))
        (= i "hour")  (* 24 (unit2unit "minute" o))
        (= i "minute")  (* 60 (unit2unit "second" o))
        :else (println "Unit not supported")))

;; @@
