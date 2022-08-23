# Billing-Account-Microservice-Project using Java

Billing Account Microservice project using Java programming language that have 3 endpoints:

- retrieve subscribers for a specific ban (billing account)
- retrieve subscriber Info
- Create new subscriber

## Details:

- Create Contract Using Open API
- Error Handling:
    - In case subscriber not found, return 404 Subscriber Not Found
    - In case creating subscriber already exists, return 403 Forbidden Subscriber Already Exists
    - In case subscriber not related to the ban in retrieve subscriber info request, Return 401 Unauthorized
    - Any validation Error: 400 Bad Request, Parameter xxx is invalid
- Validation for i/p parameters.
- Throw Custom Exceptions
- Logging

- Create a PostqreSQL Database
