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

[![](https://mermaid.ink/img/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgTm9taW5hbFRVIDx8LS0gRGF5XG4gIE5vbWluYWxUVSA8fC0tIFdlZWtcbiAgTm9taW5hbFRVIDx8LS0gTmlnaHRcbiAgTm9taW5hbFRVIDx8LS0gTW9ybmluZ1xuICBOb21pbmFsVFUgPHwtLSBBZnRlcm5vb25cbiAgTm9taW5hbFRVIDx8LS0gSG91clxuICBOb21pbmFsVFUgPHwtLSBNaW51dGVcbiAgTm9taW5hbFRVIDx8LS0gTW9udGhcblxuICBSZXN0cmljdGlvbiA8fC0tIE1heFxuICBSZXN0cmljdGlvbiA8fC0tIE1pblxuICBSZXN0cmljdGlvbiA8fC0tIEFwYXJ0XG4gIFJlc3RyaWN0aW9uIDx8LS0gVG9nZXRoZXJcbiAgUmVzdHJpY3Rpb24gPHwtLSBXaXRoXG4gIFJlc3RyaWN0aW9uIDx8LS0gV2l0aG91dFxuICBSZXN0cmljdGlvbiA8fC0tIEFmdGVyXG4gIFxuICBjbGFzcyBSZXN0cmljdGlvbiB7XG4gIHZhbHVlIDogaW50XG4gIH1cblxuV2l0aCAtLT4gQWN0aW9uXG5XaXRob3V0IC0tPiBBY3Rpb25cbkJlZm9yZSAtLT4gQWN0aW9uXG5BZnRlciAtLT4gQWN0aW9uXG5cblByZXNjcmlwdGlvbiAtLT4gVGltZUZyYW1lIDogaW5zdHJ1Y3Rpb25cblByZXNjcmlwdGlvbiAtLT4gTm9taW5hbFRVIDogZHVyYXRpb25Vbml0XG5QcmVzY3JpcHRpb24gLS0-IFwiKlwiIFJlc3RyaWN0aW9uIDogcmVzdHJpY3Rpb25zXG5SZXN0cmljdGlvbiAtLT4gTm9taW5hbFRVIDogZnJhbWVcblxuUHJlc2NyaXB0aW9uIC0tPiBBY3Rpb24gOiBhY3Rpb25cblxuXG5UaW1lRnJhbWUgLS0-IE5vbWluYWxUVSA6IHVuaXRcblRpbWVGcmFtZSAtLT4gVGltZUZyYW1lIDogc3ViRnJhbWVcblxuXHRjbGFzcyBQcmVzY3JpcHRpb257XG4gICAgaWQgOiBUb2tlblxuICAgIHN0YXJ0IDogRGF0ZVRpbWVcbiAgICBkdXJhdGlvbiA6IGludFxuICAgIHF1YW50aXR5IDogaW50XG5cdH1cblxuICBjbGFzcyBSZXN0cmljdGlvbiB7XG4gIH1cblxuICBjbGFzcyBSZXN0cmljdGlvbiB7XG4gIH1cblxuXG5cdGNsYXNzIE5vbWluYWxUVXtcblx0fVxuXG4gIFx0Y2xhc3MgRGF5e1xuXHR9XG5cbiAgICBjbGFzcyBNb3JuaW5ne1xuXHR9XG4gICAgXHRjbGFzcyBBZnRlcm5vb257XG5cdH1cblxuICBcdGNsYXNzIE5pZ2h0e1xuXHR9XG5cbiAgY2xhc3MgSG91cntcblx0fVxuXG4gIGNsYXNzIFdlZWt7XG5cdH1cblxuICBjbGFzcyBUaW1lRnJhbWUge1xuICBldmVyeTogaW50XG4gIHRvdGFsIDogaW50XG4gIH1cblx0XHRcdFx0XHQiLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlfQ)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgTm9taW5hbFRVIDx8LS0gRGF5XG4gIE5vbWluYWxUVSA8fC0tIFdlZWtcbiAgTm9taW5hbFRVIDx8LS0gTmlnaHRcbiAgTm9taW5hbFRVIDx8LS0gTW9ybmluZ1xuICBOb21pbmFsVFUgPHwtLSBBZnRlcm5vb25cbiAgTm9taW5hbFRVIDx8LS0gSG91clxuICBOb21pbmFsVFUgPHwtLSBNaW51dGVcbiAgTm9taW5hbFRVIDx8LS0gTW9udGhcblxuICBSZXN0cmljdGlvbiA8fC0tIE1heFxuICBSZXN0cmljdGlvbiA8fC0tIE1pblxuICBSZXN0cmljdGlvbiA8fC0tIEFwYXJ0XG4gIFJlc3RyaWN0aW9uIDx8LS0gVG9nZXRoZXJcbiAgUmVzdHJpY3Rpb24gPHwtLSBXaXRoXG4gIFJlc3RyaWN0aW9uIDx8LS0gV2l0aG91dFxuICBSZXN0cmljdGlvbiA8fC0tIEFmdGVyXG4gIFxuICBjbGFzcyBSZXN0cmljdGlvbiB7XG4gIHZhbHVlIDogaW50XG4gIH1cblxuV2l0aCAtLT4gQWN0aW9uXG5XaXRob3V0IC0tPiBBY3Rpb25cbkJlZm9yZSAtLT4gQWN0aW9uXG5BZnRlciAtLT4gQWN0aW9uXG5cblByZXNjcmlwdGlvbiAtLT4gVGltZUZyYW1lIDogaW5zdHJ1Y3Rpb25cblByZXNjcmlwdGlvbiAtLT4gTm9taW5hbFRVIDogZHVyYXRpb25Vbml0XG5QcmVzY3JpcHRpb24gLS0-IFwiKlwiIFJlc3RyaWN0aW9uIDogcmVzdHJpY3Rpb25zXG5SZXN0cmljdGlvbiAtLT4gTm9taW5hbFRVIDogZnJhbWVcblxuUHJlc2NyaXB0aW9uIC0tPiBBY3Rpb24gOiBhY3Rpb25cblxuXG5UaW1lRnJhbWUgLS0-IE5vbWluYWxUVSA6IHVuaXRcblRpbWVGcmFtZSAtLT4gVGltZUZyYW1lIDogc3ViRnJhbWVcblxuXHRjbGFzcyBQcmVzY3JpcHRpb257XG4gICAgaWQgOiBUb2tlblxuICAgIHN0YXJ0IDogRGF0ZVRpbWVcbiAgICBkdXJhdGlvbiA6IGludFxuICAgIHF1YW50aXR5IDogaW50XG5cdH1cblxuICBjbGFzcyBSZXN0cmljdGlvbiB7XG4gIH1cblxuICBjbGFzcyBSZXN0cmljdGlvbiB7XG4gIH1cblxuXG5cdGNsYXNzIE5vbWluYWxUVXtcblx0fVxuXG4gIFx0Y2xhc3MgRGF5e1xuXHR9XG5cbiAgICBjbGFzcyBNb3JuaW5ne1xuXHR9XG4gICAgXHRjbGFzcyBBZnRlcm5vb257XG5cdH1cblxuICBcdGNsYXNzIE5pZ2h0e1xuXHR9XG5cbiAgY2xhc3MgSG91cntcblx0fVxuXG4gIGNsYXNzIFdlZWt7XG5cdH1cblxuICBjbGFzcyBUaW1lRnJhbWUge1xuICBldmVyeTogaW50XG4gIHRvdGFsIDogaW50XG4gIH1cblx0XHRcdFx0XHQiLCJtZXJtYWlkIjp7InRoZW1lIjoiZGVmYXVsdCJ9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlfQ)

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

