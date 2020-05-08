# CHAOS
Collaborative Health Adherence Optimization in Sociotechnical Systems

# Prescription model

Prescriptions consist of *requirements* and *restriction*.

[![](https://mermaid.ink/img/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgXG4gIGNsYXNzIFJlc3RyaWN0IHtcbiAgdmFsdWUgOiBpbnRcbiAgdW5pdCA6IHVuaXQgOiBbRGF5fFdlZWt8TmlnaHR8TW9ybmluZ3xBZnRlcm5vb258SG91cnxNaW51dGVdXG4gIGtpbmQgOiBbTWlufE1heHxUb2dldGhlcnxOb3RUb2dldGhlcnxBZnRlcnxOb3RBZnRlcl1cbiAgfVxuXG4gIGNsYXNzIEFjdGlvbntcbiAgaWQgOiBUb2tlblxuICB9XG5cblJlc3RyaWN0IC0tPiBBY3Rpb24gOiBmaXJzdFxuUmVzdHJpY3QgLS0-IEFjdGlvbiA6IHNlY29uZFxuXG5SZXF1aXJlIC0tPiBGcmFtZSA6IGRlY29tcFxuXG5cblxuXG5Qb2ludCAtLT4gRnJhbWUgOiBkZWNvbXBcblxuXG5GcmFtZSAtLT4gUG9pbnQgOiBzZWxlY3Rpb25cblxuUG9pbnQgLS0-IEFkbWluaXN0cmF0aW9uIDogYWRtaW5cblxuUmVxdWlyZSAtLT4gQWN0aW9uIDogYWN0aW9uXG5cbmNsYXNzIEFkbWluaXN0cmF0aW9ue1xuIHF1YW50aXR5IDogW2ludCwgaW50XVxufVxuXG5cdGNsYXNzIFJlcXVpcmV7XG4gICAgc3RhcnQgOiBQb2ludEluVGltZVxuICAgIGR1cmF0aW9uIDogaW50XG5cdH1cblxuICBjbGFzcyBGcmFtZSB7XG4gICB1bml0IDogW0RheXxXZWVrfE5pZ2h0fE1vcm5pbmd8QWZ0ZXJub29ufEhvdXJ8TWludXRlXVxuICB9XG5cbiAgY2xhc3MgUG9pbnQge1xuICAgIHVuaXQgOiBbRGF5fFdlZWt8TmlnaHR8TW9ybmluZ3xBZnRlcm5vb258SG91cnxNaW51dGVdXG4gICAgaW5jcmVtZW50IDogaW50XG4gICAgc2VsZWN0IDogaW50XG4gIH1cblxuXG5cblx0XHRcdFx0XHQiLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlfQ)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgXG4gIGNsYXNzIFJlc3RyaWN0IHtcbiAgdmFsdWUgOiBpbnRcbiAgdW5pdCA6IHVuaXQgOiBbRGF5fFdlZWt8TmlnaHR8TW9ybmluZ3xBZnRlcm5vb258SG91cnxNaW51dGVdXG4gIGtpbmQgOiBbTWlufE1heHxUb2dldGhlcnxOb3RUb2dldGhlcnxBZnRlcnxOb3RBZnRlcl1cbiAgfVxuXG4gIGNsYXNzIEFjdGlvbntcbiAgaWQgOiBUb2tlblxuICB9XG5cblJlc3RyaWN0IC0tPiBBY3Rpb24gOiBmaXJzdFxuUmVzdHJpY3QgLS0-IEFjdGlvbiA6IHNlY29uZFxuXG5SZXF1aXJlIC0tPiBGcmFtZSA6IGRlY29tcFxuXG5cblxuXG5Qb2ludCAtLT4gRnJhbWUgOiBkZWNvbXBcblxuXG5GcmFtZSAtLT4gUG9pbnQgOiBzZWxlY3Rpb25cblxuUG9pbnQgLS0-IEFkbWluaXN0cmF0aW9uIDogYWRtaW5cblxuUmVxdWlyZSAtLT4gQWN0aW9uIDogYWN0aW9uXG5cbmNsYXNzIEFkbWluaXN0cmF0aW9ue1xuIHF1YW50aXR5IDogW2ludCwgaW50XVxufVxuXG5cdGNsYXNzIFJlcXVpcmV7XG4gICAgc3RhcnQgOiBQb2ludEluVGltZVxuICAgIGR1cmF0aW9uIDogaW50XG5cdH1cblxuICBjbGFzcyBGcmFtZSB7XG4gICB1bml0IDogW0RheXxXZWVrfE5pZ2h0fE1vcm5pbmd8QWZ0ZXJub29ufEhvdXJ8TWludXRlXVxuICB9XG5cbiAgY2xhc3MgUG9pbnQge1xuICAgIHVuaXQgOiBbRGF5fFdlZWt8TmlnaHR8TW9ybmluZ3xBZnRlcm5vb258SG91cnxNaW51dGVdXG4gICAgaW5jcmVtZW50IDogaW50XG4gICAgc2VsZWN0IDogaW50XG4gIH1cblxuXG5cblx0XHRcdFx0XHQiLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlfQ)

## Requirements
A **Requirement** is associate to a single action (that is uniquely identified), has a start time (which is an absolute point in time) and a duration in terms of a quantity of time frames (**Frame**) of a nominal time unit (e.g., 10 weeks).  A Frame conists of selected sub-units called **Points** (e.g., weeks consist of days, hours etc.) Points are selected by specifying a specific ordinal value in attribute *select* or by specifying a particular *increment*. If an ordinal value is specified, it must be interpreted in the context of the enclosed Frame. For example, an ordinal value of 1 for a Point of unit Day in a Frame of unit week must be interpreted as the first day of the week (Monday). If an increment "i" is specified for a Point, it selects every ith sub-unit in the Frame.

A Point must be further decomposed in a more granular Frame *or* it must specify a quantified **Administration** of the required action (with a miniumum and maximum quantity).

Example: ``require A1 for 10 weeks, every 2nd day, administer 1-2 times``. Here the *action* is `A1` that is administered between 1 and 2 times, the *Frame* is `weeks`, the duration is 10, the selected *Point* is every 2nd day (it has an increment value of 2).


A **Point** can can further be decomposed by a Frame. For example: ``Require A2 for a duration of 10 weeks, every day, every morning administer 2-3 times and every evening administer 0-1 times``. Here the Point (unit of day) selected from the top-level Segmentation (unit of week) have been further decomposed in a sub-ordinate Frame of unit day (with two Points of unit morning and afternoon, respectively).

```clojure
(require
  :action 'A2
  :startTime (date :year 2020 :month 4 :day 07)
  :duration 10
  :decomp [(Frame :unit 'week
                  :selection [(Point :unit 'day
                                     :incement 1
                                     :decomp (Frame :unit 'day
                                                    :selection [(Point :unit 'morning
                                                                       :increment 1)
                                                                       :admin [2 3])
                                                                (Point :unit 'evening
                                                                       :increment 1
                                                                       :admin [0 1])]))])])                                     
```

Note, the above example could be rewritten as ``Require A3 for a duration of 10 weeks, every morning administer 2-3 times and every evening administer 0-1 times``. In that case, we only have one segmentation (weeks).

```clojure
(require
  :action 'A2
  :id 'A1
  :startTime (date :year 2020 :month 4 :day 07)
  :duration 10
  :decomp [(Frame :unit 'week
                  :selection [(Point :unit 'morning
                                     :increment 1
                                     :admin [2 3])
                              (Point :unit 'evening
                                     :increment 1)
                                     :admin [0 1]]))])                                     
```

## Restrictions

**Restrictions** specify situations to avoid. They refer to a value and with a nominal time unit (e.g;, 3 hours).
* **Min** and **Max** restrictions restrict the maximum or minumum actions that should be taken during any specified time unit.
* **Together**  restrictions require that the first action must be administered with the second action  (in the same unit time)
* **Apart** restrictions require that the first action must not be administered with the second action  (in the same unit time)
* **after** restrictions require that the second action must be taken at most *value* time units the first one
* **notAfter** restrictions require that the second action must not be taken at most *value* time units the first one

Example: ``Restriction: administer 'A2 and 'A1 at least 6 hours apart ``

```clojure
(restrict
  :first 'A2
  :second 'A1
  :value 6
  :unit 'hour
  :kind 'apart))                                     
```


# References
1. Siemon's thesis: https://dspace.library.uvic.ca/handle/1828/8458
