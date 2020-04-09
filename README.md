# chaos
Collaborative Health Adherence Optimization in Sociotechnical Systems

# Prescription model

A **Prescription** has a uniquely identified **action**. It has a start time (which is an absolute time point in form of a date).  A prescription is defined over **TimeFrames** (defined by a **UnitTime** (a number and a nominal time unit such as day, month, hour etc.). A *TimeFrame* can be repeated n times. The number of that unit time defines the increment.  The time frame also has a minimum / maximum *quantity* that specifies how often the action should happen during the time.

Example: ``Take 2-3 A1 every 2nd day repeated 10 times``. Here the *action* is `A1`, the *TimeFrame* is `day`, the repeat   is 10 *Day*, the quantity interval is 2-3.

```clojure
(prescription
  :action 'A1
  :startTime (date 2020 4 07)
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


[![](https://mermaid.ink/img/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgXG4gIGNsYXNzIFJlc3RyaWN0aW9uIHtcbiAga2luZCA6IFtNaW58TWF4fFdpdGh8V2l0aG91dHxBcGFyZHxUb2dldGhlcnxCZWZvcmV8QWZ0ZXJdXG4gIH1cblxuICBjbGFzcyBBY3Rpb257XG4gIGlkIDogVG9rZW5cbiAgfVxuXG5SZXN0cmljdGlvbiAtLT4gQWN0aW9uIDogb3RoZXJcblxuUmVzdHJpY3Rpb24gLS0-IFVuaXRUaW1lIDogZnJhbWVcblxuUHJlc2NyaXB0aW9uIC0tPiBUaW1lRnJhbWUgOiBmcmFtZVxuUHJlc2NyaXB0aW9uIC0tPiBcIipcIiBSZXN0cmljdGlvbiA6IHJlc3RyaWN0aW9uc1xuXG5cblByZXNjcmlwdGlvbiAtLT4gQWN0aW9uIDogYWN0aW9uXG5cblxuVGltZUZyYW1lIC0tPiBVbml0VGltZSA6IGV2ZXJ5XG5UaW1lRnJhbWUgLS0-IFRpbWVGcmFtZSA6IHN1YkZyYW1lXG5cblx0Y2xhc3MgUHJlc2NyaXB0aW9ue1xuICAgIHN0YXJ0IDogRGF0ZVRpbWVcblx0fVxuXG4gIGNsYXNzIFRpbWVGcmFtZSB7XG4gIHJlcGVhdDogaW50XG4gIHF1YW50aXR5IDogaW50LCBpbnRcbiAgfVxuXG4gIGNsYXNzIFVuaXRUaW1le1xuICB1bml0OiBbRGF5fFdlZWt8TmlnaHR8TW9ybmluZ3xBZnRlcm5vb258SG91cnxNaW51dGVdXG4gIHZhbHVlOiBpbnRcbiAgfVxuXHRcdFx0XHRcdCIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In0sInVwZGF0ZUVkaXRvciI6ZmFsc2V9)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgXG4gIGNsYXNzIFJlc3RyaWN0aW9uIHtcbiAga2luZCA6IFtNaW58TWF4fFdpdGh8V2l0aG91dHxBcGFyZHxUb2dldGhlcnxCZWZvcmV8QWZ0ZXJdXG4gIH1cblxuICBjbGFzcyBBY3Rpb257XG4gIGlkIDogVG9rZW5cbiAgfVxuXG5SZXN0cmljdGlvbiAtLT4gQWN0aW9uIDogb3RoZXJcblxuUmVzdHJpY3Rpb24gLS0-IFVuaXRUaW1lIDogZnJhbWVcblxuUHJlc2NyaXB0aW9uIC0tPiBUaW1lRnJhbWUgOiBmcmFtZVxuUHJlc2NyaXB0aW9uIC0tPiBcIipcIiBSZXN0cmljdGlvbiA6IHJlc3RyaWN0aW9uc1xuXG5cblByZXNjcmlwdGlvbiAtLT4gQWN0aW9uIDogYWN0aW9uXG5cblxuVGltZUZyYW1lIC0tPiBVbml0VGltZSA6IGV2ZXJ5XG5UaW1lRnJhbWUgLS0-IFRpbWVGcmFtZSA6IHN1YkZyYW1lXG5cblx0Y2xhc3MgUHJlc2NyaXB0aW9ue1xuICAgIHN0YXJ0IDogRGF0ZVRpbWVcblx0fVxuXG4gIGNsYXNzIFRpbWVGcmFtZSB7XG4gIHJlcGVhdDogaW50XG4gIHF1YW50aXR5IDogaW50LCBpbnRcbiAgfVxuXG4gIGNsYXNzIFVuaXRUaW1le1xuICB1bml0OiBbRGF5fFdlZWt8TmlnaHR8TW9ybmluZ3xBZnRlcm5vb258SG91cnxNaW51dGVdXG4gIHZhbHVlOiBpbnRcbiAgfVxuXHRcdFx0XHRcdCIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In0sInVwZGF0ZUVkaXRvciI6ZmFsc2V9)

  

# References
1. Siemon's thesis: https://dspace.library.uvic.ca/handle/1828/8458

