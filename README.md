# Billing-Account-Microservice-Project using Java

Billing Account Microservice project using Java programming language that have 3 endpoints:

- Retrieve subscribers for a specific ban (billing account).
- Retrieve subscriber Info.
- Create new subscriber.

## Details:

- Create Contract Using Open API.
- Error Handling:
    - In case subscriber not found, return 404 Subscriber Not Found
    - In case creating subscriber already exists, return 403 Forbidden Subscriber Already Exists
    - In case subscriber not related to the ban in retrieve subscriber info request, Return 401 Unauthorized
    - Any validation Error: 400 Bad Request, Parameter xxx is invalid
- Validation for i/p parameters.
- Throw Custom Exceptions.
- Logging.

- Create a PostqreSQL Database

## Used Technologies:
- Java Programming Language.
- MVC concepts.
- Swagger for viewing the endpoints’ outputs and testing the APIs.
- PostgreSQL database for storing the users’ data.

## How it Works?

### Sequence Diagram:
![image](https://user-images.githubusercontent.com/46838441/188269371-721510bf-1d85-4269-8943-4234141a09d9.png)

### Swagger's Contracts:

- Main Functions:
![image](https://user-images.githubusercontent.com/46838441/188269103-e44eb00d-3464-4ed5-acb3-642320d6a9aa.png)


- Create User Function (POST):
![image](https://user-images.githubusercontent.com/46838441/188269126-adb27664-6cb9-4e6d-a741-93c0579a1f9c.png)

- Create User Function Error: User Already Exists:

![image](https://user-images.githubusercontent.com/46838441/188269138-898dcd26-3ac7-42f9-9132-532b4d41cec3.png)

- Create User Function Succssefully:
![image](https://user-images.githubusercontent.com/46838441/188269187-849bcd1c-12e2-435d-9465-b62b2a35cfb8.png)


- Retrive User's Info using ban and ID (GET):
![image](https://user-images.githubusercontent.com/46838441/188269211-90424b63-7312-46d5-a36a-4d6ba8820f08.png)


![image](https://user-images.githubusercontent.com/46838441/188269228-34dad5fa-6c21-4d61-ad67-813095c6da1a.png)


![image](https://user-images.githubusercontent.com/46838441/188269236-60b35cc8-2280-45ef-b8d6-42c1c4d886d3.png)

- Retrive List of Users Info using ban (GET):

![image](https://user-images.githubusercontent.com/46838441/188269273-daf3ab55-1399-4806-8adb-773d9677871d.png)


![image](https://user-images.githubusercontent.com/46838441/188269281-e69d3ead-7349-4728-b2ca-36c58a10559e.png)


![image](https://user-images.githubusercontent.com/46838441/188269286-bb3c994e-6b65-402d-a266-9bd27ab61a51.png)


- PostgreSQL Darabase's Table:

![image](https://user-images.githubusercontent.com/46838441/188269303-a82bcd40-29fc-4bc3-b28c-ded6584c67cd.png)






