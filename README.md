# GreenStep

GreenStep is a web-based application for users who wish to calculate their carbon footprint and want to look for ways to improve it.

## Contents

- [Daily Progress](#Daily-progress)
- [User Stories](#User-stories)
- [Technical Architecture](technology_architecture_diagram.png)
- [Technical challenges](#Technical-challenges)
- [Lessons learned from this project](#Lessons-learned)
- [Wireframes](Treimer_Nate_Wireframe.fig)
- [Schema diagram](entity_relationship_diagram.png)
- [Case Study Rubric](https://docs.google.com/document/d/107MWFd85FxB6hQ3aMlY6wISP72BYc5fs_V6jnWmlSC8/edit?usp=sharing) Please contact [Nate Treimer](mailto:natetreimer@gmail.com) for accessing this rubric 

[//]: # (- [Jira]&#40;https://www.google.com/&#41; - Please contact [Nate Treimer]&#40;mailto:natetreimer@gmail.com&#41; for accessing this Jira account)

## Daily Progress

April 26th (100% done)
* Added logger to methods
* Service/Repository layer tests
* REST controller
* data.SQL update

April 25th (92% done)
* bootstrap styling
* exception handling
* save journal implementation

April 20th (83% done)
* used DTO to transfer checklist info

April 19th (79% done)
* joined Journal and User and can now view Journal entries on page
* attempted to add saveChecklist functionality

April 19th (75% done)
* sorted packages by model
* added ExtendedChecklist class for front end
* joined User and Checklist
* added custom query findChecklistByCheckedUser

April 18th (60% done)
* refactored getFootprintsByUserId to @Query annotation
* created view and sql for checklist
* added navbar to some pages

April 15th (54% done)
* Joined Footprint and User models, so footprints can be attributed to the logged-in user
* Attempted to create a custom query

April 14th (50% done)
* Added models for checklist and journal
* Added registration and security

April 13th (44% done)
* Added navbar to each page
* Added controllers and views for checklist and journal
* Added home controller

April 12th (41% done)
* Calculator table for the new_footprint page
* Calculator function added to calculate footprint

April 11th (35% done)
* Git init
* CRUD working, needs tweaking

## User Stories

* As a ____, I would like to ____ so that I can ____.
* As a user, I would like to create an account, so I can store my findings.
* As a user, I would like to log in using my existing credentials, so I can see what I have already done.
* As a user, I would like to use the carbon calculator page, so I can see my impact on the planet.
* As a user, I would like to access a health facts page, so I can see how climate change affects me.
* As a user, I would like to see a history of my calculations, so I can track my progress
* As a user, I would like to see a FAQs or tips page, so I can easily find ways to improve my habits.
* As a user, I would like to visit a page with recommended products, so I can find products that will help reduce my footprint.
* As a user, I would like to browse a menu at the top of the screen, so I can easily access any of the pages.

## Technical Challenges

* Capturing data specific to a user / Have to use Principal to obtain a user's ID for a query
* How to create a dropdown with values populated by Thymeleaf
* How to capture checklist items and have them unique to each user
* Implementing update with footprints

## Lessons Learned

* When a feature is proving really difficult to implement, try to figure out a way to get a similar result or move on to a different feature.
* Things may not go as planned, so be ready to adapt your plans to fit changing requirements. 
* Working in groups can be incredibly useful, even when not directly asking for help. 

## Future Steps

* I would like to add pages for cars, planes, and other vehicles
* Number of household members, so you can see footprint per person
* Dropdowns for other types of units, more rigorous calculations
* Admin function to add checklist items
* Graph of footprint over time