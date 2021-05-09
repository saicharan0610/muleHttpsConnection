# muleHttpsConnection
To create and access a simple HTTPS server.


Keystore — In short, Keystore is a server-side asset that stores the private keys and the certificates with their public and private keys.

Truststore — Truststore is a client-side asset that serves as a repository of certificates (CA or simple) that the client should trust.

------------------------------------------

Create a Keystore and Truststore
Let’s get our hands dirty now. The three-step process is as follows.

1. Create the Keystore and Generate a Certificate
We will use the keytool that comes with Java. Create a temporary directory somewhere in your drive. Then, open a terminal and navigate to the directory and execute the following command:


**keytool -genkey -alias mule -keyalg RSA -keystore keystore.jks**


On execution, it will ask for the Keystore password and some general information. At the end, it will ask for the password of the key. 


---------------------------------------------

Export the Certificate
The process above creates a Keystore as well as a certificate. We have to export the certificate so that it can be added to the Truststore as the trusted certificate. Execute the following command in the terminal:

**keytool -export -alias mule -file client.cer -keystore keystore.jks**


The key point here is to specify the key (mule) and the Keystore (keystore.jks) that we created in the previous step. You can use any file name for the certificate being exported. Here, I am calling it client.cer. On execution, it will ask for the password of the Keystore

------------------------------------------------


After creation of the certificate client.cer, we will populate our Truststore with it. So, let’s create a Truststore. Please execute the following command in the terminal:

**keytool -import -v -trustcacerts -alias mule -file client.cer -keystore truststore.ts**

Important points to be noted here is the key (mule), the certificate file (client.cer), and the name of the Truststore (truststore.ts). Upon execution of the command, it will ask for the password for the Truststore being created. You can choose anything you want.


------------------------------------------------------
For **My First Raml project**

Important Urls: https://www.apisero.com/implementing-api-auto-discovery-for-mulesoft-application-deployed-to-cloudhub-and-on-premise/

Anypoint Platform Urls: https://anypoint.mulesoft.com/cloudhub/#/console/home/applications/cloudhub/myfirstramlproj-v1-dev

