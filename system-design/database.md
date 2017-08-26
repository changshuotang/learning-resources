## Database

### Relational Database Manage System (RDBMS)

A collection of data items organized in tables.

ACID Transactions:
- Atomicity: each transaction is all or nothing
- Consistency: transactions wil bring the database from one valid state to another
- Isolation: executing transactions concurrently has the same results as if they were executes serially
- Durability: Once a transaction is committed, it remains so

### Scaling RDBMSs

##### Master-Slave Replication

The master servers both reads and writes, replicating writes to one or more slaves, which serve only reads. Slaves can also replicate to additional slaves in a tree-like fashion. 

If the master goes offline the system can continue to operate in read-only mode until a slave is promoted to master, or a new master is provisioned.

##### Master-Master Replication

Both masters serve reads and writes and coordinate with each other on writes. If either master does down, the system can continue without delay to operate with both reads and writes.

##### Federation

Federation, or functional partitioning, splits data up to databases depending on its type/functionality. 

##### Sharding

Sharding distributes data across different databases such that each database can only manage a subset of the data.

##### Denormalization

Denormalization stores redundant copies of data into multiple tables to avoid expensive joins. This improves read performance at the cost of write performance. 

### NoSQL

A collection of data items represent in key-value stores, document stores, wide-column stores, or a graph database.

BASE:
- Basically Available: system guarantees availability
- Soft State: the state of the system may change over time, even without input
- Eventual Consistency: the system will become consistent over a period of time, given it doesn't receive new inputs during that period

##### Key-Value Store

A key-value store generally allows for O(1) reads and writes.

##### Document Store

Centered around documents (JSON, XML, etc.) where a document stores all information for a given object. Document stores provide APIs or a query language to query the document itself.

##### Wide Column Store

Basic unit of data is a column (name/value pairs). Columns can be grouped into families (like a SQL table). Super column families further group column families. Columns can be accessed independently with a row key. Each value contains a timestamp for versioning and conflict resolution.

Wide column stores offer high availability and high scalability.

##### Graph Database

Graph databases contain nodes and edges that represent relationship between two nodes. Graph databases are optimized to represent complex relationships with many foreign keys or many-to-many relationships.

### SQL vs NoSQL

SQL:
- Structured data
- Strict schema
- Relational data
- Allows complex joins
- transactions
- Clear patterns for scaling
- Scaling
- Lookups by index are very fast

NoSQL:
- Semi-structured data
- Dynamic/Flexible schema
- Non-relational data
- No need for complex joins
- Allows many data sets of extremely large size
- Very data intensive workload
- Very high throughput for IOPS