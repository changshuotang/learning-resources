## Basic Concepts

### Performance vs Scalability

A service is scalable if adding resources results in a proportional increase in performance. So in other words:
- A performance problem means your system is slow for a single user
- A scalability problem means your system is fast for a single user, but slow under heavy load

### Latency vs Throughput

Latency is the time to perform an action or produce some result. Throughput is the number of these actions per unit of time. In general, you should aim for maximum throughput with acceptable latency.

### Availability vs Consistency 

The __CAP Theorem__ states that distruted systems can only guarantee two of the following:

- __Consistency__: every read receives the most recent write or an error
- __Availability__: every request receives a response, without guarantee that it contains the most recent info
- __Partition Tolerance__: the system continues to operate despite arbitrary partitioning due to network failures

Networks are not reliable, so partition tolerance is mandatory. The tradeoff is choosing between availability and consistency.

#### CP - Consistency and Partition Tolerance

__Downside__: waiting for a response from a partitioned node might result in a timeout error.

CP is good if your business requires atomic read and writes. An online bank will want consistency over availability.

#### AP - Availability and Partition Tolerance

__Downside__: Might not return latest data. Writes need time to propagate when the partition is resolved.

AP is good when the system needs to continue working regardless of external errors. A good example of this would be a web store like Amazon. When the user clicks 'buy' you would always want the order to go through. The service is available. But sometimes if item is really popular it might actual had been out of stock when you ordered. The data was not consistent.

### Consistency Patterns

#### Weak Consistency

After a write, reads may or may not see it. A best effort approach is taken.

#### Eventual Consistency

After a write, reads will eventually see it (data is replicated asynchronously).

#### Strong Consistency

After a write, reads will see it (data is replicated synchronously).

### Availability Patterns

#### Failover

##### Active-Passive Failover

Also known as master-slave failover. The active server sends 'heartbeats' to a passive server, which is interrupted will cause the passive server to take over the active's IP address and resume service.

##### Active-Active Failover

Also known as master-master failover. Both servers manage the traffic, spreading the load between them.

##### Disadvantages

- Failover adds more hardware and additional complexity
- Potential loss of data if active system fails before newly written data is replicated to passive

#### Replication

Refer to the [Database](database.md) section for info on master-master and master-slave replication.