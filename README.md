## HomeAway Test Cases Overview
This repository has Maven project containing source code for the test cases for the scenarios outlined in HomeAway assessment test slide deck.  The below sections provide details on the projet organization structure and how the project folders/packags map to test scenarios.

###Software Requirements
1. Eclipse Java IDE (with Maven plugin support)
2. FireFox (any latest version - preferably v45.02)

###Project Source Packages/Folder Structure
1. com.homeaway.pages --> contains all selenium classes representing browser pages covering Automation Excercise Part-1
2. com.homeaway.tests --> contains all automated tests covering Automation Excercise Part-1 and 2
3. com.homeaway.ws.rs --> contains all classes to make REST based calls to http://api.data.gov
4. resources --> contains Java Key Store containing certifcate for api.data.gov website
5. part-2-whitebox folder --> contains added unit test cases and  explanations related to white box testing excercise
6. part-3-specs folder --> contains questions/suggestions/expected answers for Part-3 Specification Review

###Notes
Please note that when running the automation tests the website may respond slow due to network latency and may fail the tests, plesae rerun the same test again to fix the problem.   

