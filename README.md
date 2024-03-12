Remote User Authentication / User Storage SPI with Keycloak

Steps:
1) Implemented basic web service connecting to H2 database that will store the user credentials (MVC)
2) Created new project KeycloakRemoteUserStorage that will connect to the legacy webservice to look up password of username ( make HTTP calls to the webservice, then convert the JSON response into java object for further process)
3) Create META-INF/Service to store the UserSotrageProviderFactory class 
4) When the KeycloakRemoteUserStorage is ready => cd package directory=> mvn clean package and get the JAR file from Target folder.
5) Copy the JAR into provider folder from Keycloak resource folder and run the keycloak server.
6) In keycloak server, in User federation, enable the new detected JAR file
7) Run the legacy webservice
8) Make call to Keycloak Auhtoirzation code endpoint: http://localhost:8086/realms/appsdeveloper/protocol/openid-connect/auth?client_id=ostock2&response_type=code&scope=openid profile&redirect_uri=http://localhost:8086/callback&state=ouerhiuegpenijgoineroig
9) Be redirected to Login page for authentication with the credentials from the legacy app to finally get the authorization code in the redirectedURI.

Get some error with password encryption during the keycloak login authentication. Needs to investigate further.
