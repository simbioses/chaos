# chaos
Collaborative Health Adherence Optimization in Sociotechnical Systems

# Prescription model

A **Prescription** has a unique *id* a start time (which is an absolute point in time) and a duration in terms of a quantity of time frames (**Frame**) of a nominal time unit (e.g., 10 weeks).  A Frame conists of selected sub-units called **Points** (e.g., weeks consist of days, hours etc. Points are selected by specifying a specific ordinal value in attribute *select* or by specifying a particular *increment*. If an ordinal value is specified, it must be interpreted in the context of the enclosed Frame. For example, an ordinal value of 1 for a Point of unit Day in a Frame of unit week must be interpreted as the first day of the week (Monday). If an increment "i" is specified for a Point, it selects every ith sub-unit in the Frame.

A Point must be further decomposed in a more granular Frame *or* it must specify an **Administration** of an action (with a minimum and maximum quantity for its execution).

Example: ``P1: for a duration of 10 weeks, every 2nd day, administer A1 2-3``. Here the *action* is `A1`, the *Frame* is `weeks`, the duration is 10, the selected *Point* is every 2nd day (it has an increment value of 2), the quantity is 2-3.

```clojure
(prescription
  :startTime (date :year 2020 :month 4 :day 07)
  :duration 10
  :decomp (list (Frame :unit 'week 
                       :selection (list (Point :unit 'day
                                               :incement 2
                                               :take (Administration :quantity [2 3] : action 'A1))))                                         
```

A **Point** can can further be decomposed by a Frame. For example: ``P2: for a duration of 10 weeks, every day, every morning administer A1 1-2 times and every evening A1 1 time``. Here the Point (unit of day) selected from the top-level Segmentation (unit of week) have been further decomposed in a sub-ordinate Frame of unit day (with two Points of unit morning and afternoon, respectively). 

```clojure
(prescription
  :startTime (date :year 2020 :month 4 :day 07)
  :duration 10
  :decomp (list (Frame :unit 'week 
                       :selection (list (Point :unit 'day
                                               :incement 1
                                               :decomp (Segmentation :unit 'day
                                                                :selection (list (Point :unit 'morning
                                                                                        :increment 1
                                                                                        :take (Administration :quantity [2 3] : action 'A1))
                                                                                 (Point :unit 'evening
                                                                                        :increment 1
                                                                                        :take (Administration :quantity [1 1] : action 'A1)))))                                     
```

Note, the above example could be rewritten as ``P2: for a duration of 10 weeks, every morning administer A1 1-2 times, every evening administer A1 1 time``. In that case, we only have one segmentation (weeks).

```clojure
(prescription
  :startTime (date :year 2020 :month 4 :day 07)
  :duration 10
  :decomp (list (Frame :unit 'week 
                       :selection (list (Point :unit 'morning
                                               :increment 1
                                               :take (Administration :quantity [2 3] : action 'A1))
                                        (Point :unit 'evening
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


[![](https://mermaid.ink/img/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgXG4gIGNsYXNzIFJlc3RyaWN0aW9uIHtcbiAga2luZCA6IFtNaW58TWF4fFdpdGh8V2l0aG91dHxBcGFyZHxUb2dldGhlcnxCZWZvcmV8QWZ0ZXJdXG4gIH1cblxuICBjbGFzcyBBY3Rpb257XG4gIGlkIDogVG9rZW5cbiAgfVxuXG5SZXN0cmljdGlvbiAtLT4gQWN0aW9uIDogb3RoZXJcblxuUHJlc2NyaXB0aW9uIC0tPiBGcmFtZSA6IGRlY29tcFxuUHJlc2NyaXB0aW9uIC0tPiBcIipcIiBSZXN0cmljdGlvbiA6IHJlc3RyaWN0aW9uc1xuXG5cbkFkbWluaXN0cmF0aW9uIC0tPiBBY3Rpb24gOiBhY3Rpb25cblxuUG9pbnQgLS0-IEZyYW1lIDogZGVjb21wXG5cblxuRnJhbWUgLS0-IFBvaW50IDogc2VsZWN0aW9uXG5cblBvaW50IC0tPiBBZG1pbmlzdHJhdGlvbiA6IHRha2VcblxuXHRjbGFzcyBQcmVzY3JpcHRpb257XG4gICAgaWQgOiB0b2tlblxuICAgIHN0YXJ0IDogUG9pbnRJblRpbWVcbiAgICBkdXJhdGlvbiA6IGludFxuXHR9XG5cbiAgY2xhc3MgRnJhbWUge1xuICAgdW5pdCA6IFtEYXl8V2Vla3xOaWdodHxNb3JuaW5nfEFmdGVybm9vbnxIb3VyfE1pbnV0ZV1cbiAgfVxuXG4gIGNsYXNzIFBvaW50IHtcbiAgICB1bml0IDogW0RheXxXZWVrfE5pZ2h0fE1vcm5pbmd8QWZ0ZXJub29ufEhvdXJ8TWludXRlXVxuICAgIGluY3JlbWVudCA6IGludFxuICAgIHNlbGVjdCA6IGludFxuICB9XG5cbiAgY2xhc3MgQWRtaW5pc3RyYXRpb24ge1xuICAgIHF1YW50aXR5IDogW2ludCwgaW50XVxuICB9XG5cblx0XHRcdFx0XHQiLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlfQ)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgXG4gIGNsYXNzIFJlc3RyaWN0aW9uIHtcbiAga2luZCA6IFtNaW58TWF4fFdpdGh8V2l0aG91dHxBcGFyZHxUb2dldGhlcnxCZWZvcmV8QWZ0ZXJdXG4gIH1cblxuICBjbGFzcyBBY3Rpb257XG4gIGlkIDogVG9rZW5cbiAgfVxuXG5SZXN0cmljdGlvbiAtLT4gQWN0aW9uIDogb3RoZXJcblxuUHJlc2NyaXB0aW9uIC0tPiBGcmFtZSA6IGRlY29tcFxuUHJlc2NyaXB0aW9uIC0tPiBcIipcIiBSZXN0cmljdGlvbiA6IHJlc3RyaWN0aW9uc1xuXG5cbkFkbWluaXN0cmF0aW9uIC0tPiBBY3Rpb24gOiBhY3Rpb25cblxuUG9pbnQgLS0-IEZyYW1lIDogZGVjb21wXG5cblxuRnJhbWUgLS0-IFBvaW50IDogc2VsZWN0aW9uXG5cblBvaW50IC0tPiBBZG1pbmlzdHJhdGlvbiA6IHRha2VcblxuXHRjbGFzcyBQcmVzY3JpcHRpb257XG4gICAgaWQgOiB0b2tlblxuICAgIHN0YXJ0IDogUG9pbnRJblRpbWVcbiAgICBkdXJhdGlvbiA6IGludFxuXHR9XG5cbiAgY2xhc3MgRnJhbWUge1xuICAgdW5pdCA6IFtEYXl8V2Vla3xOaWdodHxNb3JuaW5nfEFmdGVybm9vbnxIb3VyfE1pbnV0ZV1cbiAgfVxuXG4gIGNsYXNzIFBvaW50IHtcbiAgICB1bml0IDogW0RheXxXZWVrfE5pZ2h0fE1vcm5pbmd8QWZ0ZXJub29ufEhvdXJ8TWludXRlXVxuICAgIGluY3JlbWVudCA6IGludFxuICAgIHNlbGVjdCA6IGludFxuICB9XG5cbiAgY2xhc3MgQWRtaW5pc3RyYXRpb24ge1xuICAgIHF1YW50aXR5IDogW2ludCwgaW50XVxuICB9XG5cblx0XHRcdFx0XHQiLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlfQ)

  

# References
1. Siemon's thesis: https://dspace.library.uvic.ca/handle/1828/8458

