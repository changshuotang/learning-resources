## 9) System Design and Scalability

### Handling the Questions

- Communicate
- Go broad first
- Use the whiteboard
- Acknowledge the interview's concerns
- Be careful about assumptions
- State your assumptions explicitly
- Estimate when necessary
- Stay in the driver's seat

### Design: Step-By-Step

##### Step 1: Scope the Problem

##### Step 2: Make Reasonable Assumptions

##### Step 3: Draw the Major Components

##### Step 4: Identify the Key Issues

##### Step 5: Redesign for the Key Issues

### Algorithms that Scale: Step-By-Step

##### Step 1: Ask Questions

##### Step 2: Make Believe

##### Step 3: Get Real

##### Step 4: Solve Problems

### Key Concepts

##### Horizontal vs. Vertical Scaling

- Vertical scaling means increasing resources for a specific node
- Horizontal scaling means increasing the total number of nodes

___Load Balancers___ distributes network or application traffic across multiple servers to distribute the load evenly so that one server doesn't crash the whole system. We will need a network of cloned servers to accomplish this.

##### Database Denormalization and NoSQL

Joins in relational databases get very slow as the system grows bigger and bigger. We can use denormalization, adding redundant information into databases to speed up reads. Or we can use NoSQL databases which do not support join, but can be designed to scale better.

##### Database Partitioning (Sharding)

Sharding is splitting data across multiple machine s. A few common way of partitioning include:

- ___Vertical Partitioning___: basically partitioning by features. Drawback is that as tables get very large you will need to repartition.
- ___Hash-Based Partitioning___: using some part of the data to partition it. for example allocate N servers and put the data on ```mod(key, n)```. Adding additional servers means reallocating all data -  an expensive task.
- ___Directory-Based Partitioning___: you maintain a lookup table for where the data can be found. Easy to add more servers, but drawbacks include the lookup table being a single point of failure and that accessing this table impacts performance.

##### Caching

An in-memory cache is a simple key-value pairing that sits between your application layer and your data store. When your app requests information, it first tries the cache, then will loop in the data store. When you cache, you might cache the query and its results, or cache a specific object.

##### Asynchronous Processing & Queues

Slow operations should be done asynchronously; in fact we should pre-process operations on the queue. We can also 'promise' a response then notify when done.

##### Networking Metrics

- ___Bandwidth___: the max amount of data that can be transferred per a unit of time (typically bits per second).
- ___Throughput___: actual amount of data that is transferred.
- ___Latency___: delay between the sending and receiving of information.

##### MapReduce

Like the name implies, MapReduce uses a Map step and a Reduce step to process a huge amount of data.

- ```Map``` takes in some data and emits a ```<key, value>``` pair.
- ```Reduce``` takes a key and a set of associated values and "reduces" them in some way, emitting a new key and value. Can be reduced multiple times.

MapReduce allows us to do lots of processing in parallel, which help process huge data sets.

### Considerations

- Failures
- Availability and Reliability
- Read-heavy vs. Write-heavy
- Security

### Example Problem

___Given a list of millions of documents, how would you find al documents that contain a list of words? The words can appear in any order, but they must be complete words. That is, "book" does not match "bookkeeper".___

##### Step 1

First we consider a case with only a few dozen documents. We can pre-process each document and construct a hash table index mapping a word to a list of documents that contain the word, such as: ```"books" -> {doc2, doc3, doc6, doc8}```.

##### Step 2

Now consider the original problem. What problems will we face if we take the approach we took in step1 with millions of documents?
- We will need to divide our hash table, whether by keyword, document, etc.
- We may need to process a document on one machine and push the results off to other machines.
- We will need the machine to hold a piece of data. What does this lookup table look like, and where is it stored?

##### Step 3

One approach may be to divide the words alphabetically by keywords, so that a machine controls a range of words. The advantage of this approach is that the lookup table is small, so each machine can easily store one. However, the disadvantage is that adding new words may constitute an expensive shift of keywords.
