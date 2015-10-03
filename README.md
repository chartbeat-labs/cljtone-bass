# charttone-bass

A library for a sampled bass-guitar in overtone.

This was made during a hackweek project at Chartbeat. A group of us wanted to play with overtone because we love music and we love clojure (or at least wanted to get more experience with clojure...). Overtone is a great library for exploring both. 

I was playing with the jazz sample project in overtone and was extremely disappointed by how weak the bass lines sounded while the drums were so awesome.
 
Poking around the overtone source code I found the [other sampled instruments](https://github.com/overtone/overtone/blob/master/src/overtone/samples/piano.clj) in the overtone library and decided to find a good sampled bass guitar. The samples are recorded mezzo-forte and I think they're great. 

I'd like to extend this into a library for adding other instrument samples. It's actually very straight forward, the hardest part is finding the samples and sed/awk/sh foo to make a list of the freesound sample ids. 

## Usage

use the cljtone.bassguitar.sampled-bass !

## License

Copyright © 2015 Chartbeat

MIT License. Go ahead. Enjoy.
