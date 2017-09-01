## Application Layer

Separating the web layer from the application/platform layer allows you to scale and configure both layers independently. So a new API might only result in adding more application servers without needing to add more web webservers.

### Microservices

A suite of small, independently deployable, modular services. Each service runs a unique process and is typically exposed through an API. Easily deployable to containers.

Pinterest for example could have microservices for: user profiles, followers, feed, search, photo upload, etc.

### Virtual Machines and Containers (like Docker)

Virtual machines and Containers allow us to run multiple applications without interrupting each other. We allocate them with their own CPU, memory, and network resources along with blocking I/O is shared with the host OS kernel. 

##### Advantages of Containers

- Lightweight; low overhead, VMs have a lot more overhead
- Highly Portable; anyone can pull your Docker image and spin it up
- Isolation; decouple the application from the host machine
- Immutability; images are immutable and are layered, which allows versioning 

### Service Discovery

Find services in a network by mapping and keeping track of names, addresses, and ports in a service registry.



