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
2) If patient is more than drugs, last patients in the user input will remain untreated
3) If drugs are more than patients, the remaining drugs will be unused.



**Design considerations:**
The following components are made extendable and loosely coupled with other components
1) The strategy followed in the implementation is immature strategy. A new strategy 
   can be built by implementing TreatmentStrategy interface. 
2) The new strategies could be focused on saving maximum patients (treating sever patients first), or any other strategy for that matter
3) Hospital object is built from user's input. User can also input Doctor details, pharmacy details etc

