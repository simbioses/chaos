# chaos
Collaborative Health Adherence Optimization in Sociotechnical Systems

# Prescription model

A **Prescription** is identified by a unique id. It has a start time (which is an absolute time point in form of a date) and it is bounded either by a *duration* or a *quantity* (of total actions to be administered).

A prescription has a **TimeFrame** which refers to a nominal time unit **NominalTU** (weeks, months, etc.) and specifies an *every* and *total* attribute. Example: ``P1: every 2nd day for 10 days``. Here the *every* attribute is 2, the total is 10 and the NominalTU is *Day*.

A **TimeFrame** can have another time frame as a sub-ordinate time frame. For example: ``P2: every second hour of every second day for 10 days``. Here the toplevel time frame (every second day) has subordinate time frame (every second hour), which then points to an action. 

Prescriptions can also have **Restrictions**. Restrictions also refer to a Nominal Time Unit.
* **Min** and **Max** restrictions restrict the maximum or minumum actions that should be taken during any specified time unit.
* **Together**  restrictions require that subsequent prescribed actions need to be taken no longer than *value* time units apart. 
* **Apart**  restrictions require that subsequent prescribed actions need to be taken at least *value* time units apart. 
* **With** / **WithOut** restrictions require that each prescribed action needs to be taken with / without to an action specified by a different prescription
* **after** require that each prescribed action needs to be taken at most *value* time units after the most recent other  specified action

[![](https://mermaid.ink/img/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgXG4gIGNsYXNzIFJlc3RyaWN0aW9uIHtcbiAga2luZCA6IFtNaW58TWF4fFdpdGh8V2l0aG91dHxBcGFyZHxUb2dldGhlcnxCZWZvcmV8QWZ0ZXJdXG4gIH1cblxuUmVzdHJpY3Rpb24gLS0-IEFjdGlvblxuXG5SZXN0cmljdGlvbiAtLT4gVW5pdFRpbWVcblxuUHJlc2NyaXB0aW9uIC0tPiBUaW1lRnJhbWUgOiBpbnN0cnVjdGlvblxuUHJlc2NyaXB0aW9uIC0tPiBcIipcIiBSZXN0cmljdGlvbiA6IHJlc3RyaWN0aW9uc1xuXG5QcmVzY3JpcHRpb24gLS0-IEFjdGlvbiA6IGFjdGlvblxuXG5cblRpbWVGcmFtZSAtLT4gVW5pdFRpbWUgOiBldmVyeVxuVGltZUZyYW1lIC0tPiBUaW1lRnJhbWUgOiBzdWJGcmFtZVxuXG5cdGNsYXNzIFByZXNjcmlwdGlvbntcbiAgICBpZCA6IFRva2VuXG4gICAgc3RhcnQgOiBEYXRlVGltZVxuICAgIGR1cmF0aW9uIDogaW50XG4gICAgcXVhbnRpdHkgOiBpbnRcblx0fVxuXG5cblxuXG4gIGNsYXNzIFRpbWVGcmFtZSB7XG4gIGV2ZXJ5OiBpbnRcbiAgdW5pdDogTm9taW5hbFRVIFxuICB9XG5cbiAgY2xhc3MgVW5pdFRpbWV7XG4gIHVuaXQ6IFtEYXl8V2Vla3xOaWdodHxNb3JuaW5nfEFmdGVybm9vbnxIb3VyfE1pbnV0ZV1cbiAgdmFsdWU6IGludFxuICB9XG5cdFx0XHRcdFx0IiwibWVybWFpZCI6eyJ0aGVtZSI6ImRlZmF1bHQifSwidXBkYXRlRWRpdG9yIjpmYWxzZX0)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgXG4gIGNsYXNzIFJlc3RyaWN0aW9uIHtcbiAga2luZCA6IFtNaW58TWF4fFdpdGh8V2l0aG91dHxBcGFyZHxUb2dldGhlcnxCZWZvcmV8QWZ0ZXJdXG4gIH1cblxuUmVzdHJpY3Rpb24gLS0-IEFjdGlvblxuXG5SZXN0cmljdGlvbiAtLT4gVW5pdFRpbWVcblxuUHJlc2NyaXB0aW9uIC0tPiBUaW1lRnJhbWUgOiBpbnN0cnVjdGlvblxuUHJlc2NyaXB0aW9uIC0tPiBcIipcIiBSZXN0cmljdGlvbiA6IHJlc3RyaWN0aW9uc1xuXG5QcmVzY3JpcHRpb24gLS0-IEFjdGlvbiA6IGFjdGlvblxuXG5cblRpbWVGcmFtZSAtLT4gVW5pdFRpbWUgOiBldmVyeVxuVGltZUZyYW1lIC0tPiBUaW1lRnJhbWUgOiBzdWJGcmFtZVxuXG5cdGNsYXNzIFByZXNjcmlwdGlvbntcbiAgICBpZCA6IFRva2VuXG4gICAgc3RhcnQgOiBEYXRlVGltZVxuICAgIGR1cmF0aW9uIDogaW50XG4gICAgcXVhbnRpdHkgOiBpbnRcblx0fVxuXG5cblxuXG4gIGNsYXNzIFRpbWVGcmFtZSB7XG4gIGV2ZXJ5OiBpbnRcbiAgdW5pdDogTm9taW5hbFRVIFxuICB9XG5cbiAgY2xhc3MgVW5pdFRpbWV7XG4gIHVuaXQ6IFtEYXl8V2Vla3xOaWdodHxNb3JuaW5nfEFmdGVybm9vbnxIb3VyfE1pbnV0ZV1cbiAgdmFsdWU6IGludFxuICB9XG5cdFx0XHRcdFx0IiwibWVybWFpZCI6eyJ0aGVtZSI6ImRlZmF1bHQifSwidXBkYXRlRWRpdG9yIjpmYWxzZX0)

## Input format

```clojure
;; takePill1 for 10 weeks every morning
(prescription
  :action 'takePill1
  :startTime (date 2020 4 07)
  :duration 10
  :durationUnit 'week 
  :instruction (TF :tu 'morning :every 1))

  ;; takePill2 for 10 weeks every other day in the evening 
  ;; at least 6 hours apart from takePill1
  (prescription
    :action 'takePill2
    :startTime (date 2020 4 07)
    :duration 10
    :durationUnit 'week 
    :instruction (TF :tu 'day :every 2
                     :subtu (TF 'evening))
    :restriction (Without 'takePill1 6 'hour))
```
  

# References
1. Siemon's thesis: https://dspace.library.uvic.ca/handle/1828/8458

