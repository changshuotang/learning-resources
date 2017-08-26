## Reverse Proxy

A web server that centralizes internal services, and provides a unified interface to the public. Client requests are translated and forwarded to a server that can fulfill it before the reverse proxy returns the server's response to the client.

Benefits:
- __Increased Security__: hide information about backend servers, blacklist IPs, limit number of connection per client
- __Increased Scalability and Flexibility__: Client only sees the reverse proxy's IP
- __SSL Termination__: decrypt incoming requests and encrypt server responses so backend servers do not have to
- __Compression__: compress server responses
- __Caching__: return response for cache requests
- __Static Content__: serve static content directly

### Load Balancer vs Reverse Proxy

- Deploying a load balancer is useful when you have multiple servers. Most of the time load balancers route traffic to a set of servers that serve the same function.
- Reverse proxies can be useful even with just one web server/application server.

### Disadvantages: Reverse Proxy

- A single reverse proxy is a single point of failure
- Multiple reverse proxies further increases complexity

