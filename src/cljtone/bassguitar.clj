(ns cljtone.bassguitar
"Bass guitar sample. This makes heavy use of the patterns in overtone for the piano and flute samples.
The samples are recorded mezzo-forte which seemed to sound the best."
  (:use [overtone.core]))

(defn- registered-mf-samples  [] (registered-assets ::BassGuitarMF))

(def FREESOUND-BASS-SAMPLES-MF
  {163022 :D#3
   163020 :D3
   163016 :C#3
   163014 :C3
   163010 :B3
   163007 :A#3
   163005 :A3
   163000 :G#3
   162999 :G3
   162994 :F#3
   162993 :F3
   162988 :E3
   162986 :D#2
   162982 :D2
   162981 :C#2
   162977 :C2
   162973 :B2
   162971 :A#2
   162967 :A2
   162965 :G#2
   162963 :G2
   162959 :F#2
   162956 :F2
   162954 :E2
   162949 :D#1
   162946 :D1
   162944 :C#1
   162940 :C1
   162937 :B1
   162935 :A#1
   162932 :A1
   162929 :G#1
   162926 :G1
   162924 :F#1
   162920 :F1
   162916 :E1 })



(def SAMPLE-IDS (keys FREESOUND-BASS-SAMPLES-MF))

(def bass-samples (doall (map freesound-sample SAMPLE-IDS)))

(defn- buffer->midi-note [buf note-map] (-> buf :freesound-id note-map name note))

(defn- note-index [buffers note-map]
  (reduce (fn [index buf]
            (let [id (:id buf)
                  note (buffer->midi-note buf note-map)]
              (assoc index note id)))
          {}
          buffers))

(defonce ^:private silent-buffer (buffer 0))

(defonce bass-index-buffer
  (let [tab (note-index bass-samples FREESOUND-BASS-SAMPLES-MF)
        buf (buffer 128)]
    (buffer-fill! buf (:id silent-buffer))
    (doseq [[idx val] tab]
      (println idx " " val)
      (buffer-set! buf idx val))
        buf))

(definst sampled-bass
  [note 59 level 1 rate 1 loop? 0
   attack 0 decay 1 sustain 1 release 0.1 curve -4 gate 1]
  (let [buf (index:kr (:id bass-index-buffer) note)
     ;   env2 (env-gen (perc 0 decay) 1 1 0 1 FREE)
        env (env-gen (adsr attack decay sustain release level curve)
                     :gate gate
                     :action FREE)]
    (* env (scaled-play-buf 1 buf :level level :loop loop? :action FREE))))

;(sampled-bass)
