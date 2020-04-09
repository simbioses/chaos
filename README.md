# CHAOS
Collaborative Health Adherence Optimization in Sociotechnical Systems

# Prescription model
[![](https://mermaid.ink/img/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgXG4gIGNsYXNzIFJlc3RyaWN0aW9uIHtcbiAgdmFsdWUgOiBpbnRcbiAgdW5pdCA6IHVuaXQgOiBbRGF5fFdlZWt8TmlnaHR8TW9ybmluZ3xBZnRlcm5vb258SG91cnxNaW51dGVdXG4gIGtpbmQgOiBbTWlufE1heHxXaXRofE5vdFdpdGh8QWZ0ZXJ8Tm90QWZ0ZXJdXG4gIH1cblxuICBjbGFzcyBBY3Rpb257XG4gIGlkIDogVG9rZW5cbiAgfVxuXG5SZXN0cmljdGlvbiAtLT4gQWN0aW9uIDogb3RoZXJcblxuUHJlc2NyaXB0aW9uIC0tPiBGcmFtZSA6IGRlY29tcFxuUHJlc2NyaXB0aW9uIC0tPiBcIipcIiBSZXN0cmljdGlvbiA6IHJlc3RyaWN0aW9uc1xuXG5cblxuUG9pbnQgLS0-IEZyYW1lIDogZGVjb21wXG5cblxuRnJhbWUgLS0-IFBvaW50IDogc2VsZWN0aW9uXG5cblByZXNjcmlwdGlvbiAtLT4gQWN0aW9uIDogYWN0aW9uXG5cblx0Y2xhc3MgUHJlc2NyaXB0aW9ue1xuICAgIGlkIDogdG9rZW5cbiAgICBzdGFydCA6IFBvaW50SW5UaW1lXG4gICAgZHVyYXRpb24gOiBpbnRcblx0fVxuXG4gIGNsYXNzIEZyYW1lIHtcbiAgIHVuaXQgOiBbRGF5fFdlZWt8TmlnaHR8TW9ybmluZ3xBZnRlcm5vb258SG91cnxNaW51dGVdXG4gIH1cblxuICBjbGFzcyBQb2ludCB7XG4gICAgdW5pdCA6IFtEYXl8V2Vla3xOaWdodHxNb3JuaW5nfEFmdGVybm9vbnxIb3VyfE1pbnV0ZV1cbiAgICBpbmNyZW1lbnQgOiBpbnRcbiAgICBzZWxlY3QgOiBpbnRcbiAgfVxuXG5cblxuXHRcdFx0XHRcdCIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In0sInVwZGF0ZUVkaXRvciI6ZmFsc2V9)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgXG4gIGNsYXNzIFJlc3RyaWN0aW9uIHtcbiAgdmFsdWUgOiBpbnRcbiAgdW5pdCA6IHVuaXQgOiBbRGF5fFdlZWt8TmlnaHR8TW9ybmluZ3xBZnRlcm5vb258SG91cnxNaW51dGVdXG4gIGtpbmQgOiBbTWlufE1heHxXaXRofE5vdFdpdGh8QWZ0ZXJ8Tm90QWZ0ZXJdXG4gIH1cblxuICBjbGFzcyBBY3Rpb257XG4gIGlkIDogVG9rZW5cbiAgfVxuXG5SZXN0cmljdGlvbiAtLT4gQWN0aW9uIDogb3RoZXJcblxuUHJlc2NyaXB0aW9uIC0tPiBGcmFtZSA6IGRlY29tcFxuUHJlc2NyaXB0aW9uIC0tPiBcIipcIiBSZXN0cmljdGlvbiA6IHJlc3RyaWN0aW9uc1xuXG5cblxuUG9pbnQgLS0-IEZyYW1lIDogZGVjb21wXG5cblxuRnJhbWUgLS0-IFBvaW50IDogc2VsZWN0aW9uXG5cblByZXNjcmlwdGlvbiAtLT4gQWN0aW9uIDogYWN0aW9uXG5cblx0Y2xhc3MgUHJlc2NyaXB0aW9ue1xuICAgIGlkIDogdG9rZW5cbiAgICBzdGFydCA6IFBvaW50SW5UaW1lXG4gICAgZHVyYXRpb24gOiBpbnRcblx0fVxuXG4gIGNsYXNzIEZyYW1lIHtcbiAgIHVuaXQgOiBbRGF5fFdlZWt8TmlnaHR8TW9ybmluZ3xBZnRlcm5vb258SG91cnxNaW51dGVdXG4gIH1cblxuICBjbGFzcyBQb2ludCB7XG4gICAgdW5pdCA6IFtEYXl8V2Vla3xOaWdodHxNb3JuaW5nfEFmdGVybm9vbnxIb3VyfE1pbnV0ZV1cbiAgICBpbmNyZW1lbnQgOiBpbnRcbiAgICBzZWxlY3QgOiBpbnRcbiAgfVxuXG5cblxuXHRcdFx0XHRcdCIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In0sInVwZGF0ZUVkaXRvciI6ZmFsc2V9)

A **Prescription** has relates to a unique **Action**. It has a start time (which is an absolute point in time) and a duration in terms of a quantity of time frames (**Frame**) of a nominal time unit (e.g., 10 weeks).  A Frame conists of selected sub-units called **Points** (e.g., weeks consist of days, hours etc. Points are selected by specifying a specific ordinal value in attribute *select* or by specifying a particular *increment*. If an ordinal value is specified, it must be interpreted in the context of the enclosed Frame. For example, an ordinal value of 1 for a Point of unit Day in a Frame of unit week must be interpreted as the first day of the week (Monday). If an increment "i" is specified for a Point, it selects every ith sub-unit in the Frame.

A Point must be further decomposed in a more granular Frame *or* it must specify an **Action** to be taken.

Example: ``A1: for a duration of 10 weeks, every 2nd day``. Here the *action* is `A1`, the *Frame* is `weeks`, the duration is 10, the selected *Point* is every 2nd day (it has an increment value of 2).

```clojure
(prescription
  :action 'A1
  :startTime (date :year 2020 :month 4 :day 07)
  :duration 10
  :decomp [(Frame :unit 'week 
                       :selection [(Point :unit 'day
                                               :incement 2
                                               :take 'A1)])])                                         
```

A **Point** can can further be decomposed by a Frame. For example: ``A2: for a duration of 10 weeks, every day, every morning and every evening``. Here the Point (unit of day) selected from the top-level Segmentation (unit of week) have been further decomposed in a sub-ordinate Frame of unit day (with two Points of unit morning and afternoon, respectively). 

```clojure
(prescription
  :action 'A2
  :startTime (date :year 2020 :month 4 :day 07)
  :duration 10
  :decomp [(Frame :unit 'week 
                  :selection [(Point :unit 'day
                                     :incement 1
                                     :decomp (Segmentation :unit 'day
                                                           :selection [(Point :unit 'morning
                                                                              :increment 1)
                                                                       (Point :unit 'evening
                                                                              :increment 1)]))])])                                     
```

Note, the above example could be rewritten as ``A2: for a duration of 10 weeks, every morning and every evening``. In that case, we only have one segmentation (weeks).

```clojure
(prescription
  :action 'A2
  :id 'A1
  :startTime (date :year 2020 :month 4 :day 07)
  :duration 10
  :decomp [(Frame :unit 'week 
                  :selection [(Point :unit 'morning
                                     :increment 1)
                              (Point :unit 'evening
                                     :increment 1)]))])                                     
```


Prescriptions can also have **Restrictions**. Restrictions also refer to a value and nominal time unit.
* **Min** and **Max** restrictions restrict the maximum or minumum actions that should be taken during any specified time unit.
* **Together**  restrictions require that subsequent prescribed actions need to be taken no longer than the specified time apart. 
* **Apart**  restrictions require that subsequent prescribed actions need to be taken at least the specified time apart. 
* **With** / **WithOut** restrictions require that each prescribed action needs to be taken with / without an action specified by a different prescription
* **after** require that each prescribed action needs to be taken at most *value* time units after the most recent other  specified action. Example: ``Take 3 A3 in the morning and 1-2 A3 in the afternoon for  10 days but not within 6 hours of taking A1``

Example: ``A2: for a duration of 10 weeks, every morning and every evening, but not within within 6 hours of taking A3``


```clojure
(prescription
  :action 'A2
  :id 'A1
  :startTime (date :year 2020 :month 4 :day 07)
  :duration 10
  :decomp [(Frame :unit 'week 
                  :selection [(Point :unit 'morning
                                     :increment 1)
                              (Point :unit 'evening
                                     :increment 1)]))]
  :restrictions [(restriction :value 6
                              :unit 'hour
                              :kind 'notWith
                              :other 'A3 )])                                     
```
  

# References
1. Siemon's thesis: https://dspace.library.uvic.ca/handle/1828/8458

