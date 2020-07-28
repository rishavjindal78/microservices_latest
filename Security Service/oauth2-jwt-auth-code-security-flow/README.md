# oauth2-jwt-auth-code-security-flow

We can use an OAuth2 delegation approach inside the API Gateway to perform authentication for each microservice call. Mainly, 
whenever a user sends credentials for authenticating their identity, the API Gateway will forward these credentials to the OAuth server, and, 
if the user is authenticated, then we will get the token from the OAuth server. Once the token from the OAuth server is obtained, 
the API Gateway will then store this token in some in-memory database along with its expiry time.	

## Enabling TLS for the Zuul API Gateway

To enable TLS, first we need to create a public/private key pair. 
The following command uses keytool that comes with the default Java distribution to generate a key pair and stores it in mykeystore.jks file.
keytool -genkeypair -alias localhost -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore mykeystore.jks -validity 3650


## Running the application

Below are the URLs to run the application
http://localhost:8080/myapp/login 
redirect to secured url https://localhost:8443/myapp/login

Click on the button "login with Web Client Auth server"
Redirect to URL http://localhost:8081/auth/login
 Sign-in with the Username: user and Password: password
 
Redirect to the below URL to get the auth code from the authorization service
http://localhost:8081/auth/oauth/authorize?response_type=code&client_id=client&scope=user_info%20read&state=Wv-LcxYZNtYLjkFAqnVt2UD7DrxGJXG48_6w4i9KT7g%3D&redirect_uri=https://localhost:8443/myapp/login/oauth2/code/way2learnappclient
 
 click on Auhtorize button
Redirect to the URL "https://localhost:8443/myapp/hello"
Display the result "Trade is secured"

