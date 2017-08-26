## Load Balancer

Load balancers distribute incoming client requests to computing resources such as application servers and databases. 

Load balancers...
- Prevent requests from going to unhealthy servers
- Prevents overloading resources
- Helps eliminate single points of failure

Additional benefits include:
- __SSL Termination__: decrypt incoming requests and encrypt server responses so backend servers do not have to
- __Session Persistence__: issue cookies so we know to route client's request to the same instance (if web apps do not keep track of sessions)

Load balancers can route traffic in a variety of ways:
- Random
- Least Loaded
- Session/Cookies
- Round Robin/Weight Round Robin
- Layer 4
- Layer 7

##### Layer 4 Load Balancing

Load balancer looks at info at the Transport Layer (source IP, destination IP addresses, ports in the header, but NOT packet content) to make a decision, then performs a __Network Address Translation__ (NAT) to route the packet to the correct server.

##### Layer 7 Load Balancing

Load balancer looks at info at the Application Layer (header, message, cookies) to make a decision. It terminates the network traffic, then opens a connection to the selected server.

##### Layer 4 vs Layer 7

Layer 4 is less flexible, but requires less time and computing resources when compared to Layer 7.

### Horizontal Scaling

Load balancers help with horizontal scaling, improving performance and availability. Scaling out using commodity machines is more cost efficient and results in higher availability when compared to vertical scaling a single server.

##### Disadvantages: Horizontal Scaling

- Complexity of cloning servers
- Downstream servers like caches and databases need to handle more simultaneous connections as upstream servers scale out.

### Disadvantages: Load Balancer

- Without enough resources or not configured properly, a load balancer can become a performance bottleneck
- Introducing a load balancer helps eliminate single points of failure at the cost of increased complexity
- A single load balancer by itself is a single point of failure



