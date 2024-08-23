# Gateway Service Microservices Architecture

This project demonstrates a microservices architecture utilizing Spring Boot, Spring Cloud, and KeyCloak for robust security and service discovery. It includes services such as a Gateway Service, Eureka Discovery Service, and multiple back-end services for handling business operations.

## Why KeyCloak?

KeyCloak provides an out-of-the-box solution for handling authentication and authorization in modern applications:

- **Centralized User Management**: Simplifies user management across services with a single point of control.
- **Standards Compliant**: Supports OAuth2, OpenID Connect, and SAML 2.0, ensuring compatibility with modern security protocols.
- **Reduced Implementation Effort**: Offers ready-to-use features that reduce the need to implement complex security features manually.

## Setup and Configuration

### Prerequisites

- Java 17
- Maven
- Docker

### Running KeyCloak with Docker

Start the KeyCloak server using Docker:

```bash
docker run -p 9090:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:25.0.4 start-dev
```

## Configuring KeyCloak

Follow these steps to set up KeyCloak for handling authentication and authorization across your services:

### 1. Login to KeyCloak
Access the KeyCloak admin console by navigating to `http://localhost:9090`

![Login to KeyCloak](images/1.%20LoginToKeyCloak.jpg)

### 2. Create a New Realm
- In the KeyCloak admin console, create a new realm.
- Customize the settings of the realm according to your security needs, providing a layer of isolation and management.
  
- ![Create a New Realm](images/2.%20CreateANewRealm.jpg)


### 3. Create a New Client
- Within your realm, create a new client for your application.
- Configure the client specifics to match the OAuth2 settings required by your microservices.

- ![Create a New Client](images/3.%20CreateANewClient.jpg)


### 4. Configure Client Settings
- Configure access settings and capabilities for the client.
- Define roles and further access controls that suit your security policies.

- ![Configure Client Settings](images/4.AccessSettingsAndCapabilityConfigOfClient.jpg)
  

### 5. Note Security Credentials
- Keep a record of the realm name, client ID, client secret, issuer URI, and token endpoint.
- These credentials will be used to configure your microservices to authenticate and authorize using KeyCloak.

- ![Security Credentials](images/5.%20KeepNoteOfRealmNameClientIdClientSecretIssuerAndTokenEndpoint.jpg)


## Testing Security Integration

To verify the security implementation with KeyCloak, follow these steps to test the authentication and authorization flow:

### 1. Make GET Request Without Token And It Fails
- Initially, attempt to make a GET request to a secured endpoint without providing any authentication token.
- Use tools like Postman

![Make GET Request Without Token And It Fails](images/test/1.%20MakeGETrequestWithoutTokenAndItFails.jpg)

### 2. Create New App Token In Postman With Details You Saved

Generate a new access token using Postman by following these streamlined steps:

- **Open Postman**: Launch and prepare to create a new request.
- **Configure Authentication**:
  - Navigate to the `Authorization` tab.
  - Select `OAuth 2.0` and click on `Get New Access Token`.
- **Input Details**:
  - Fill in the `Token Name`.
  - Choose `Client Credentials` for `Grant Type`.
  - Provide the `Access Token URL`, `Client ID`, and `Client Secret` from your KeyCloak setup.
  - Click `Request Token` to generate the token.
- **Verify the Token**:
  - Ensure the token appears under `Existing Tokens` and verify its validity.

![Create New App Token In Postman With Details You Saved](images/test/2.%20CreateNewAppTokenInPostmanWithDetailsYouSaved.jpg)

### 3. Make The Same GET Request Now

After acquiring your access token, reattempt the initial GET request using Postman, this time including the access token in the request headers:

- **Prepare the Request**:
  - Set up the GET request URL as before.
  - Go to the `Authorization` tab.
  - Choose `Bearer Token` from the type dropdown.
  - Paste the generated access token into the `Token` field.

- **Send the Request**:
  - Hit the `Send` button to execute the request with authentication.

This will authenticate the request via KeyCloak, ensuring proper access control is enforced.

![Make The Same GET Request Now](images/test/3.%20MakeTheSameGETRequestNow.jpg)

### 4. Observe The Server Response Which Is 200

Verify the success of the authentication:

- **Check the Response**:
  - Upon submission of the GET request with the bearer token, observe the server's response.
  - A `200 OK` status confirms that the endpoint is accessible with a valid token and that the security integration with KeyCloak is operational.

![Observe The Server Response Which Is 200](images/test/4.%20NowObserveTheServerReponseWhichIs200.jpg)








