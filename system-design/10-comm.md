## Communication

### OSI 7 Layer Model

1. __Physical__: handles the transmission and reception of raw bit streams over physical mediums
2. __Data Link__: provides error-free transfer of data frames from one node to another over 
3. __Network__: operates the subnet; decides what protocol to use and physical path the data will take 
4. __Transport__: ensures that message are delivered error-free, in sequence, with no losses or duplication
5. __Session__: allows session establishment between processes running on different stations
6. __Presentation__: formats the data for the application layer
7. __Application__: allows the client to access network services

### Hypertext Transfer Protocol (HTTP)

HTTP is a standard for encoding and transporting data on the internet. HTTP is stateless or self-containted, allowing requests and resposnes to flow through many intermediate routers and servers that perform laod balancing, caching, encryption, and compression.

A basic HTTP request consists of a verb and a resource (specified by URI)

Common HTTP Verbs:
- __GET__: read; cacheable
- __POST__: create; cacheable if response has freshness info
- __PUT__: create or replace 
- __PATCH__: partially updates; cacheable if response has freshness info
- __DELETE__: delete

### Anatomy of an HTTP(S) Request

1. Browser checks cache
2. Browser asks OS for server IP address
3. OS makes a DNS lookup and returns IP address
4. Browser opens TCP connection to server through TCP handshake, and possibly also SSL handshake if HTTPS
5. Browser sends the HTTP request through TCP connection
6. Browser receives HTTP response
7. Browser checks response status code to decide how to handle response
8. Response is stored in cache if cacheable
9. Browser decodes the response
10. Browser determines what to do with response (HTML, image, etc.)
11. Browser renders response or offer download for unrecognizable types

### Transmission Control Protocol (TCP)

TCP is a connection-oriented protocol over an IP network. The connection is established via a three-way handshake.

TCP Handshake:
1. Host A sends a SYN packet to Host B
2. Host B sends back a SYN-ACK
3. Host A sends back a ACK

In TCP if the sender does not receive a correct response it will resend the packets. If there are multiple timeouts the connection is dropped. Because of this all packets sent via TCP is guaranteed to arrive and retain their original order.

### User Datagram Protocol (UDP)

UDP is a connectionless protocol. The data is only guaranteed at the datagram/packet level; they might arrive out of order or not at all.

### Representational State Transfer (ReST)

### How To Speed Up Slow Webpage

- Minify on client side (HTML, CSS, Javascript)
- Put scripts on the bottom of doc so the rest of the page loads first
- Lazy Loading: asynchronously load the page in order
- Cache (CDNs, in-memory caches, etc.)
- Backend services optimization
- Scale your resources

