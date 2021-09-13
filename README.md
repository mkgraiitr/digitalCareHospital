# digitalCareHospital

The project is created to simulate a Hospital. User can simulate the future patients’ state, based on their current state and 
a list of drugs they take.

**How to run:**
It is a simple command line application, which can be run from the main method of DigitalCareHospitalApplication.


**Language, external libraries and dependencies:**
Language - Java 1.8
Libraries - Jupiter API for Junit (version 5.5.2)
          - Guava for equal/hashcode
          - Project lombok (1.18.20)

**Assumptions:**

1) One patient will be treated by one drug - given in the order by user
2) If patients are more than drugs, remaining patients in the user input will remain untreated
3) If drugs are more than patients, the remaining drugs will be unused.



**Design considerations:**
The following components are made extendable and loosely coupled with other components
1) Starting with CommandHandler, the class implements Handler interface. This can be replaced by any other class that takes inputs 
   from UI or any other API. 
2) Hospital Manager takes care of Hospital object creation that has all the required details on Hospital. 
   Later, details such as ward, payment information can be added here.
3) Currently, the Hospital object is built from user's inputs on patients and drugs. User can also input Doctor details, pharmacy details etc.
4) The strategy followed to cure patients in the implementation is immature strategy. A new strategy 
   can be built by implementing TreatmentStrategy interface. 
5) DigitalDoctor has a strategy field. This strategy can be changed for different doctors (experienced, immature).
6) The new strategies could also be focused on saving maximum patients (treating sever patients first), or any other strategy for that matter
7) Strategy can also be determined by AI/ML engines for treatment


