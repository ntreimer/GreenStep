
## Food catering app

Add some description of the app (one or two paragraph)

## Contents

- [Daily Progress](#Daily-Progess)
- [User Stories](#User-Stories)
    - [User](#User)
    - [Admin](#Admin)
- [Technical Architecture](https://www.diagramlink.com)
  - this will show technologies used at each level
- [Technical challenges](#Technical-challenges)
- [Lessons learned from this project](#Lessons-learned)
- [Wireframe](linktodiagram)
- [Schema diagram](linktoschema)
- [Jira](https://www.google.com/) - Please contact [Nate Treimer](mailto:natetreimer@gmail.com) for accessing this Jira account


## Daily Progress
- April 15th (80% done)
    - Added ADMIN, SUPERADMIN roles and have permission set for "/users" as accessible by SUPERADMIN and "/menu" and


### Login
- As an admin, I want to log in with an admin privilege so that I can edit the list of items in the menu, update
  the price, etc.
    - Tasks:
        1. Create a database and a User table containing username, password and privilege.
        2. Login screen asking for username and password.
        
- As a user, I want to log in with a user privilege so that I can do basic operations like entering a customer's order.
    - Tasks:
        1. Same as for admin login a-e
        2. If login is successful, show the screen for ordering.

## User Stories

### User
- As a user, I want to add each item in the order, in terms of name, options, and quantity.

#### Not implemented in this version:
- As a user, I want to have the kitchen pick sheet automatically created after I place an order.

### Admin
- As an admin, I want to view all the items on the menu listed with the price.

#### Not implemented in this version:

- As an admin, I want to view the quantity ordered for each menu item so I know which item is popular.


