## Security

### Secure Sockets Layer (SSL)/Transport Layer Security (TLS)

SSL is a security protocol used by HTTPS to establish an encrypted connection between a client and a web server via a handshake. Through using encryption and digital signatures, SSL provide confidentiality, integrity and authentication for data in transit.

SSL/TLS Handshake:
1. Client Hello; requests SSL certificate (contains public key) and cryptographic preference
2. Server Hello; sends SSL certificate and CipherSuite chosen
3. Client sends pre-master secret encrypted with public key
4. Server decrypts pre-master secret with private key
5. Client and Server both use pre-master secret to compute a secret key

TLS is simply the successor and more updated version of SSL.

### Encrypt Data In-Transit and At Rest

Data in-transit can be intercepted. Data at rest needs to be protected from unauthorized access.

### WEB security vulnerabilities

##### XSS (Cross-site Scripting)

Inject client-side scripts into web pages viewed by other users.

HOW: Malicious scripts in input fields.

COUNTERMEASURES: Sanitize user input.

##### CSRF (Cross-site Request Forgery)

Unauthorized commands are transmitted unknowingly by a user that the web application.

HOW: Authorized user without logging out goes to malicious web site which will execute commands on the users behalf.

COUNTERMEASURES: Anti-Forgery Token issued along with cookie token. Need both tokens to POST form.  

##### Session Fixation 

Exploits a limitation in how web application manages session ID, to hijack a valid user session.

HOW: Session idenitfiers being accepted from URLs or POST data.

COUNTERMEASURES: 

##### SQL Injection 

Inject SQL queries into input fields and forms that the DB unknowingly executes

HOW: SQL queries in input fields.

COUNTERMEASURES: Sanitize user input or using parameterized queries (function that constructs SQL queries from inputs).

##### Man-in-the-Middle  

An attacker secretly relays and possibly alters communication between two parties that believe they are directly communicating with each other.

COUNTERMEASURES: Enable HTTP Strict Transport Security (HSTS), which ensures that web servers will only interact via HTTPS

##### Buffer Overflow 

Buffer writes accidently writes over the buffer boundaries, overwriting other data.
