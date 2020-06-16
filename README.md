# CHAOS
Collaborative Health Adherence Optimization in Sociotechnical Systems

# Prescription model

Prescriptions consist of *requirements* and *restriction*.

[![](https://mermaid.ink/img/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgXG4gIGNsYXNzIFJlc3RyaWN0IHtcbiAgdmFsdWUgOiBpbnRcbiAgdW5pdCA6IHVuaXQgOiBbRGF5fFdlZWt8TmlnaHR8TW9ybmluZ3xBZnRlcm5vb258SG91cnxNaW51dGVdXG4gIGtpbmQgOiBbTWlufE1heHxUb2dldGhlcnxOb3RUb2dldGhlcnxBZnRlcnxOb3RBZnRlcl1cbiAgfVxuXG4gIGNsYXNzIEFjdGlvbntcbiAgaWQgOiBUb2tlblxuICB9XG5cblJlc3RyaWN0IC0tPiBBY3Rpb24gOiBmaXJzdFxuUmVzdHJpY3QgLS0-IEFjdGlvbiA6IHNlY29uZFxuXG5SZXF1aXJlIC0tPiBGcmFtZVxuXG5GcmFtZSAtLT4gRnJhbWUgOiBzdWJcblxuRnJhbWUgLS0-IEFkbWluaXN0cmF0aW9uIDogYWRtaW5cblxuUmVxdWlyZSAtLT4gQWN0aW9uIDogYWN0aW9uXG5cbmNsYXNzIEFkbWluaXN0cmF0aW9ue1xuIHF1YW50aXR5IDogW2ludCwgaW50XVxufVxuXG5cdGNsYXNzIFJlcXVpcmV7XG4gICAgc3RhcnQgOiBQb2ludEluVGltZVxuICAgIGR1cmF0aW9uIDogaW50XG5cdH1cblxuICBSZXF1aXJlIC0tPiBSZXF1aXJlIDogdGhlblxuXG5cbiAgY2xhc3MgRnJhbWUge1xuICAgIHVuaXQgOiBbRGF5fFdlZWt8TmlnaHR8TW9ybmluZ3xBZnRlcm5vb258SG91cnxNaW51dGVdXG4gICAgaW5jcmVtZW50IDogaW50XG4gICAgc2VsZWN0IDogc2V0IG9mIGludFxuICB9XG5cblxuXG5cdFx0XHRcdFx0IiwibWVybWFpZCI6eyJ0aGVtZSI6ImRlZmF1bHQifSwidXBkYXRlRWRpdG9yIjpmYWxzZX0)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cbiAgXG4gIGNsYXNzIFJlc3RyaWN0IHtcbiAgdmFsdWUgOiBpbnRcbiAgdW5pdCA6IHVuaXQgOiBbRGF5fFdlZWt8TmlnaHR8TW9ybmluZ3xBZnRlcm5vb258SG91cnxNaW51dGVdXG4gIGtpbmQgOiBbTWlufE1heHxUb2dldGhlcnxOb3RUb2dldGhlcnxBZnRlcnxOb3RBZnRlcl1cbiAgfVxuXG4gIGNsYXNzIEFjdGlvbntcbiAgaWQgOiBUb2tlblxuICB9XG5cblJlc3RyaWN0IC0tPiBBY3Rpb24gOiBmaXJzdFxuUmVzdHJpY3QgLS0-IEFjdGlvbiA6IHNlY29uZFxuXG5SZXF1aXJlIC0tPiBGcmFtZVxuXG5GcmFtZSAtLT4gRnJhbWUgOiBzdWJcblxuRnJhbWUgLS0-IEFkbWluaXN0cmF0aW9uIDogYWRtaW5cblxuUmVxdWlyZSAtLT4gQWN0aW9uIDogYWN0aW9uXG5cbmNsYXNzIEFkbWluaXN0cmF0aW9ue1xuIHF1YW50aXR5IDogW2ludCwgaW50XVxufVxuXG5cdGNsYXNzIFJlcXVpcmV7XG4gICAgc3RhcnQgOiBQb2ludEluVGltZVxuICAgIGR1cmF0aW9uIDogaW50XG5cdH1cblxuICBSZXF1aXJlIC0tPiBSZXF1aXJlIDogdGhlblxuXG5cbiAgY2xhc3MgRnJhbWUge1xuICAgIHVuaXQgOiBbRGF5fFdlZWt8TmlnaHR8TW9ybmluZ3xBZnRlcm5vb258SG91cnxNaW51dGVdXG4gICAgaW5jcmVtZW50IDogaW50XG4gICAgc2VsZWN0IDogc2V0IG9mIGludFxuICB9XG5cblxuXG5cdFx0XHRcdFx0IiwibWVybWFpZCI6eyJ0aGVtZSI6ImRlZmF1bHQifSwidXBkYXRlRWRpdG9yIjpmYWxzZX0)

## Requirements
A **Requirement** is associate to a single action (that is uniquely identified), has a start time (which is an absolute point in time), a duration in terms of a quantity of time **Frames** (e.g., 10 weeks). Time Frames can be decomposed into sub-ordinate points that are Frames themselves by specifying a set of ordinal values in attribute *select* or by specifying a particular *inacrement*. If an ordinal value is specified, it must be interpreted in the context of the enclosed time Frame. For example, an ordinal value of 1 for a Frame of unit *Day* in a Frame of unit *week* must be interpreted as the first day of the week (Monday). If an increment "i" is specified for a Frame, it selects every ith sub-unit in the enclosing Frame.

A Frame must be further decomposed in a more granular Frame *or* it must specify a quantified **Administration** of the required action (with a miniumum and maximum quantity).

Example: ``require A1 for 10 weeks every 2nd day administer 1-2`` . Here the *action* is `A1` that is administered between 1 and 2 times, the toplevel *Frame* is `weeks`, the duration is 10, the selected sub-ordinate *Frames* are every 2nd day (it has an increment value of 2).


A **Frame** can can further be decomposed by a Frame. For example: ``require A2 for 10 weeks every day every morning administer 2-3 and every evening administer 0-1``. Here the Frame (unit of day) selected from the top-level Frame (unit of week) have been further decomposed in a sub-ordinate Frame of unit day (with two Frames of unit morning and afternoon, respectively).

Note, the above example could be rewritten as ``require A3 for 10 weeks every morning administer 2-3 and every evening administer 0-1``. 

Requirements may also be temporally sequenced such that one prescribed requirement must follow the administration of another one (see `then` relationship). Example ``require A1 for 10 weeks every day administer 2 and then require A2 for 2 weeks every 2nd day administer 1``

## Restrictions

**Restrictions** specify situations to avoid. They refer to a unit time (e.g;, 3 hours).
* **Min** and **Max** restrictions restrict the maximum or minumum actions that should be taken during any specified time.
* **Together**  restrictions require that two actions must be administered together  (in the same unit time).
* **Apart** restrictions require that two actions must be administered apart  (in the same unit time).

Examples: 
```
restrict A3 to a minimum of 10 per day

restrict A3 to a maximum of 10 per day

restrict taking A3 and A4 apart by at least 4 hours

restrict taking A3 and A4 together within at most 2 hours
```

# Prototype

see here:
http://viewer.gorilla-repl.org/view.html?source=github&user=jenshweber&repo=chaos&path=test/chaos/core_test.clj

# References
1. Planken's PhD thesis: Algorithms for Simple Temporal Reasoning http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.978.8678&rep=rep1&type=pdf
1. Siemon's thesis: https://dspace.library.uvic.ca/handle/1828/8458
