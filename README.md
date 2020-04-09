# chaos
Collaborative Health Adherence Optimization in Sociotechnical Systems

# Prescription model

A **Prescription** has a uniquely identified **Action**. It has a start time (which is an absolute point in time) and a duration with is a unit time (e.g., 3 weeks).  A prescription is defined over a (possibly nested) **Segmentation** of time units (for example, a segmentation could be `weeks`, `days` etc.) A segmentation conists of **Frames** that are selected from the segmentation by specifying a specific ordinal value in attribute *select* or by specifying a particular *increment*. If an ordinal value is specified, it must be interpreted in the context of the enclosed segmentation. For example, an ordinal value of 1 for a Frame in a segmentation of days must be interpreted in its enclosing segmentation (for example week), which would target a Monday. If an increment "i" is specified, the Frame selects every ith Frame in the segmentation.

A Frame must be further dissected in a segmentation or it must specify an **Administration** of the prescribed action (with a minimum and maximum quantity for its execution).

Example: ``Take A1 2-3 times every 2nd day for a duration of 10 weeks``. Here the *action* is `A1`, the *Segmentation* is `day`, the duration is 10 *Weeks*, the selected Frame has an increment value of 2, the quantity is 2-3.

```clojure
(prescription
  :action 'A1
  :startTime (date 2020 4 07)
  :duration (UT 10 'weeks)
  :frame (TF :every (UT 2 'day)
             :repeat 10 
             :quantity [2 3]))
```

A **TimeFrame** can have subordinate time frames. For example: ``Take 3 A2 in the morning and 1-2 A2 in the afternoon for  10 days``. Here the toplevel time frame (day) has two subordinate time frames (morning and afternoon). 

```clojure
(prescription
  :action 'A2
  :startTime (date 2020 4 07)
  :frame (TF :every (UT 'day)
             :repeat 10 
             :sub (list (TF :every (UT 'morning)
                            :quantity [3 3])
                        (TF :every (UT 'evening)
                            :quantity [1 2]))))
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


[![](https://mermaid.ink/img/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgXG4gIGNsYXNzIFJlc3RyaWN0aW9uIHtcbiAga2luZCA6IFtNaW58TWF4fFdpdGh8V2l0aG91dHxBcGFyZHxUb2dldGhlcnxCZWZvcmV8QWZ0ZXJdXG4gIH1cblxuICBjbGFzcyBBY3Rpb257XG4gIGlkIDogVG9rZW5cbiAgfVxuXG5SZXN0cmljdGlvbiAtLT4gQWN0aW9uIDogb3RoZXJcblxuUHJlc2NyaXB0aW9uIC0tPiBTZWdtZW50YXRpb24gOiBzZWdtZW50c1xuUHJlc2NyaXB0aW9uIC0tPiBcIipcIiBSZXN0cmljdGlvbiA6IHJlc3RyaWN0aW9uc1xuXG5cblByZXNjcmlwdGlvbiAtLT4gQWN0aW9uIDogYWN0aW9uXG5QcmVzY3JpcHRpb24gLS0-IFVuaXRUaW1lIDogZHVyYXRpb25cblxuU2VnbWVudGF0aW9uIC0tPiBVbml0VGltZSA6IHVuaXRcbkZyYW1lIC0tPiBTZWdtZW50YXRpb24gOiBzZWdtZW50c1xuXG5TZWdtZW50YXRpb24gLS0-IEZyYW1lIDogZnJhbWVzXG5cbkZyYW1lIC0tPiBBZG1pbmlzdHJhdGlvbiA6IHRha2VcblxuXHRjbGFzcyBQcmVzY3JpcHRpb257XG4gICAgc3RhcnQgOiBQb2ludEluVGltZVxuXHR9XG5cbiAgY2xhc3MgRnJhbWUge1xuICAgIGV2ZXJ5IDogaW50XG4gICAgc2VsZWN0IDogaW50XG4gIH1cblxuICBjbGFzcyBBZG1pbmlzdHJhdGlvbiB7XG4gICAgcXVhbnRpdHkgOiBbaW50LCBpbnRdXG4gIH1cblxuICBjbGFzcyBVbml0VGltZXtcbiAgdW5pdDogW0RheXxXZWVrfE5pZ2h0fE1vcm5pbmd8QWZ0ZXJub29ufEhvdXJ8TWludXRlXVxuICB2YWx1ZTogaW50XG4gIH1cblx0XHRcdFx0XHQiLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlfQ)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgXG4gIGNsYXNzIFJlc3RyaWN0aW9uIHtcbiAga2luZCA6IFtNaW58TWF4fFdpdGh8V2l0aG91dHxBcGFyZHxUb2dldGhlcnxCZWZvcmV8QWZ0ZXJdXG4gIH1cblxuICBjbGFzcyBBY3Rpb257XG4gIGlkIDogVG9rZW5cbiAgfVxuXG5SZXN0cmljdGlvbiAtLT4gQWN0aW9uIDogb3RoZXJcblxuUHJlc2NyaXB0aW9uIC0tPiBTZWdtZW50YXRpb24gOiBzZWdtZW50c1xuUHJlc2NyaXB0aW9uIC0tPiBcIipcIiBSZXN0cmljdGlvbiA6IHJlc3RyaWN0aW9uc1xuXG5cblByZXNjcmlwdGlvbiAtLT4gQWN0aW9uIDogYWN0aW9uXG5QcmVzY3JpcHRpb24gLS0-IFVuaXRUaW1lIDogZHVyYXRpb25cblxuU2VnbWVudGF0aW9uIC0tPiBVbml0VGltZSA6IHVuaXRcbkZyYW1lIC0tPiBTZWdtZW50YXRpb24gOiBzZWdtZW50c1xuXG5TZWdtZW50YXRpb24gLS0-IEZyYW1lIDogZnJhbWVzXG5cbkZyYW1lIC0tPiBBZG1pbmlzdHJhdGlvbiA6IHRha2VcblxuXHRjbGFzcyBQcmVzY3JpcHRpb257XG4gICAgc3RhcnQgOiBQb2ludEluVGltZVxuXHR9XG5cbiAgY2xhc3MgRnJhbWUge1xuICAgIGV2ZXJ5IDogaW50XG4gICAgc2VsZWN0IDogaW50XG4gIH1cblxuICBjbGFzcyBBZG1pbmlzdHJhdGlvbiB7XG4gICAgcXVhbnRpdHkgOiBbaW50LCBpbnRdXG4gIH1cblxuICBjbGFzcyBVbml0VGltZXtcbiAgdW5pdDogW0RheXxXZWVrfE5pZ2h0fE1vcm5pbmd8QWZ0ZXJub29ufEhvdXJ8TWludXRlXVxuICB2YWx1ZTogaW50XG4gIH1cblx0XHRcdFx0XHQiLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlfQ)

  

# References
1. Siemon's thesis: https://dspace.library.uvic.ca/handle/1828/8458

