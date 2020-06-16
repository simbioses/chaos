(ns chaos.parser
  (:require [instaparse.core :as insta]))

(def parse
  (insta/parser
    "prescription = (requirement|restriction)
     requirement = <'require'> <WS> action <WS> duration frame+ ?[then]
     then = <' and then '> requirement
     duration = <'for'> <WS> number <WS> unit
     frame =  (<WS> <'and'>)?  <WS> (iteration | indexing) (administer | <' ('>frame+ <' )'>)
     administer = <WS> <'administer'> <WS> number ?[<'-'> number]
     iteration = <'every'> <WS> ?[number <ordinal>] <WS> unit
     ordinal =  ['st' | 'nd' | 'rd' | 'th']
     indexing = (<'on'> | <'at'>)<WS> unit <WS> ?[numlist]
     numlist = number | (number <','> ?[<WS>] numlist)
     number = #'[0-9]+'
     unit = ['years'|'months'|'weeks'|'days'|'mornings'|'noons'|'afternoons'|'evening' | 'nights' 'year'|'month'|'week'|'day'|'morning'|'noon'|'afternoon'|'night'|'hour'|'hours'|'minutes'|'minute'|'Monday'|'Tuesday'|'Wednesday'|'Thursday'|'Friday'|'Saturday'|'Sunday']
     restriction = <'restrict'> <WS> [max | min | apart | together ]
     max = action <' to a maximum of '> number <' per '> unit
     min = action <' to a minimum of '> number <' per '> unit
     apart = <'taking '> action <' and '> action <' apart by at least '> number <WS> unit
     together = <'taking '> action <' and '> action <' together within at most '> number <WS> unit
     action = #'[a-zA-Z]+[a-zA-Z0-9_]*'
     WS = #'\\s+'
     NL = #'\\n+'
     "
    :output-format :enlive
    ))



(parse "require A1 for 10 weeks every 2nd day administer 1-2")
(parse "require A1 for 10 weeks every day administer 2 and then require A2 for 2 weeks every 2nd day administer 1")
(parse "require A2 for 10 weeks every day ( every morning administer 2-3 and every evening administer 0-1 )")
(parse "require A2 for 10 weeks every day every morning administer 2-3 and every evening administer 0-1")
(parse "require A2 for 10 weeks every day every morning administer 2-3 and every evening administer 0-1")
(parse "require A3 for 10 weeks every morning administer 2-3 and every evening administer 0-1")
(parse "restrict A3 to a minimum of 10 per day")
(parse "restrict A3 to a maximum of 10 per day")
(parse "restrict taking A3 and A4 apart by at least 4 hours")
(parse "restrict taking A3 and A4 together within at most 2 hours")


