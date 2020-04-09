# chaos
Collaborative Health Adherence Optimization in Sociotechnical Systems

# Prescription model

A **Prescription** has a unique *id* a start time (which is an absolute point in time) and a duration in terms of a quantity of time segments (**Segmentation**) (e.g., 10 weeks).  A segmentation conists selected **Segments** that represent important time intervals. Segments are selected by specifying a specific ordinal value in attribute *select* or by specifying a particular *increment*. If an ordinal value is specified, it must be interpreted in the context of the enclosed segmentation. For example, an ordinal value of 1 for a Segment in a segmentation of days must be interpreted in its enclosing segmentation (for example week), which would target a Monday. If an increment "i" is specified every ith Segment in the segmentation.

A Segment must be further dissected in a more granular segmentation *or* it must specify an **Administration** of an action (with a minimum and maximum quantity for its execution).

Example: ``P1: for a duration of 10 weeks, every 2nd day, administer A1 2-3``. Here the *action* is `A1`, the *Segmentation* is `weeks`, the duration is 10, the selected *Segment* is every 2nd day (it has an increment value of 2), the quantity is 2-3.

```clojure
(prescription
  :startTime (date :year 2020 :month 4 :day 07)
  :duration 10
  :decomp (Segmentation :unit 'week 
                        :selection (list (Segment :unit 'day
                                                  :incement 2
                                                  :take (Administration :quantity [2 3] : action 'A1)))                                         
```

A **Segment** can can further be decomposed by a segmentation. For example: ``P2: for a duration of 10 weeks, every day, every morning administer A1 1-2 times and every evening A1 1 time``. Here the Segments (days) selected from the top-level Segmentation (week) have been further decomposed in a sub-ordinate segmentation of days (with segments morning and afternoon). 

```clojure
(prescription
  :startTime (date :year 2020 :month 4 :day 07)
  :duration 10
  :decomp (Segmentation :unit 'week 
                        :selection (list (Segment :unit 'day
                                                  :incement 1
                                                  :decomp (Segmentation :unit 'day
                                                                        :selection (list (Segment :unit 'morning
                                                                                                  :increment 1
                                                                                                  :take (Administration :quantity [2 3] : action 'A1))
                                                                                         (Segment :unit 'evening
                                                                                                  :increment 1
                                                                                                  :take (Administration :quantity [1 1] : action 'A1)))))                                     
```


Prescriptions can also have **Restrictions**. Restrictions also refer to a UnitTime.
* **Min** and **Max** restrictions restrict the maximum or minumum actions that should be taken during any specified time unit.
* **Together**  restrictions require that subsequent prescribed actions need to be taken no longer than the specified time apart. 
* **Apart**  restrictions require that subsequent prescribed actions need to be taken at least the specified time apart. 
* **With** / **WithOut** restrictions require that each prescribed action needs to be taken with / without an action specified by a different prescription
* **after** require that each prescribed action needs to be taken at most *value* time units after the most recent other  specified action. Example: ``Take 3 A3 in the morning and 1-2 A3 in the afternoon for  10 days but not within 6 hours of taking A1``

```clojure
(prescription
  :action 'A3
  :startTime (date 2020 4 07)
  :frame (TF :every (UT 'day)
             :repeat 10 
             :sub (list (TF :every (UT 'morning)
                            :quantity [3 3])
                        (TF :every (UT 'evening)
                            :quantity [1 2])))
  :restrictions (list (restriction 'without (UT 6 'hour) 'A1)))
```


[![](https://mermaid.ink/img/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgXG4gIGNsYXNzIFJlc3RyaWN0aW9uIHtcbiAga2luZCA6IFtNaW58TWF4fFdpdGh8V2l0aG91dHxBcGFyZHxUb2dldGhlcnxCZWZvcmV8QWZ0ZXJdXG4gIH1cblxuICBjbGFzcyBBY3Rpb257XG4gIGlkIDogVG9rZW5cbiAgfVxuXG5SZXN0cmljdGlvbiAtLT4gQWN0aW9uIDogb3RoZXJcblxuUHJlc2NyaXB0aW9uIC0tPiBTZWdtZW50YXRpb24gOiBkZWNvbXBcblByZXNjcmlwdGlvbiAtLT4gXCIqXCIgUmVzdHJpY3Rpb24gOiByZXN0cmljdGlvbnNcblxuXG5BZG1pbmlzdHJhdGlvbiAtLT4gQWN0aW9uIDogYWN0aW9uXG5cblNlZ21lbnQgLS0-IFNlZ21lbnRhdGlvbiA6IGRlY29tcFxuXG5cblNlZ21lbnRhdGlvbiAtLT4gU2VnbWVudCA6IHNlbGVjdGlvblxuXG5TZWdtZW50IC0tPiBBZG1pbmlzdHJhdGlvbiA6IHRha2VcblxuXHRjbGFzcyBQcmVzY3JpcHRpb257XG4gICAgaWQgOiB0b2tlblxuICAgIHN0YXJ0IDogUG9pbnRJblRpbWVcbiAgICBkdXJhdGlvbiA6IGludFxuXHR9XG5cbiAgY2xhc3MgU2VnbWVudGF0aW9uIHtcbiAgIHVuaXQgOiBbRGF5fFdlZWt8TmlnaHR8TW9ybmluZ3xBZnRlcm5vb258SG91cnxNaW51dGVdXG4gIH1cblxuICBjbGFzcyBTZWdtZW50IHtcbiAgICB1bml0IDogW0RheXxXZWVrfE5pZ2h0fE1vcm5pbmd8QWZ0ZXJub29ufEhvdXJ8TWludXRlXVxuICAgIGluY3JlbWVudCA6IGludFxuICAgIHNlbGVjdCA6IGludFxuICB9XG5cbiAgY2xhc3MgQWRtaW5pc3RyYXRpb24ge1xuICAgIHF1YW50aXR5IDogW2ludCwgaW50XVxuICB9XG5cblx0XHRcdFx0XHQiLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlfQ)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgXG4gIGNsYXNzIFJlc3RyaWN0aW9uIHtcbiAga2luZCA6IFtNaW58TWF4fFdpdGh8V2l0aG91dHxBcGFyZHxUb2dldGhlcnxCZWZvcmV8QWZ0ZXJdXG4gIH1cblxuICBjbGFzcyBBY3Rpb257XG4gIGlkIDogVG9rZW5cbiAgfVxuXG5SZXN0cmljdGlvbiAtLT4gQWN0aW9uIDogb3RoZXJcblxuUHJlc2NyaXB0aW9uIC0tPiBTZWdtZW50YXRpb24gOiBkZWNvbXBcblByZXNjcmlwdGlvbiAtLT4gXCIqXCIgUmVzdHJpY3Rpb24gOiByZXN0cmljdGlvbnNcblxuXG5BZG1pbmlzdHJhdGlvbiAtLT4gQWN0aW9uIDogYWN0aW9uXG5cblNlZ21lbnQgLS0-IFNlZ21lbnRhdGlvbiA6IGRlY29tcFxuXG5cblNlZ21lbnRhdGlvbiAtLT4gU2VnbWVudCA6IHNlbGVjdGlvblxuXG5TZWdtZW50IC0tPiBBZG1pbmlzdHJhdGlvbiA6IHRha2VcblxuXHRjbGFzcyBQcmVzY3JpcHRpb257XG4gICAgaWQgOiB0b2tlblxuICAgIHN0YXJ0IDogUG9pbnRJblRpbWVcbiAgICBkdXJhdGlvbiA6IGludFxuXHR9XG5cbiAgY2xhc3MgU2VnbWVudGF0aW9uIHtcbiAgIHVuaXQgOiBbRGF5fFdlZWt8TmlnaHR8TW9ybmluZ3xBZnRlcm5vb258SG91cnxNaW51dGVdXG4gIH1cblxuICBjbGFzcyBTZWdtZW50IHtcbiAgICB1bml0IDogW0RheXxXZWVrfE5pZ2h0fE1vcm5pbmd8QWZ0ZXJub29ufEhvdXJ8TWludXRlXVxuICAgIGluY3JlbWVudCA6IGludFxuICAgIHNlbGVjdCA6IGludFxuICB9XG5cbiAgY2xhc3MgQWRtaW5pc3RyYXRpb24ge1xuICAgIHF1YW50aXR5IDogW2ludCwgaW50XVxuICB9XG5cblx0XHRcdFx0XHQiLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlfQ)

  

# References
1. Siemon's thesis: https://dspace.library.uvic.ca/handle/1828/8458

