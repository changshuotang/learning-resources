## Asynchronism

Async workflows reduces request times for expensive operations that would otherwise be performed in-line.

### Message Queues

Message queues receive, hold, and deliver messages.

- Application pushes a job to the queue, then notifies the user of job status
- A worker picks up the job from the queue, processes it, and signal the job is complete

### Task Queues

Task queues receive tasks and their related data, runs them, hen delivers their results. 

### Back Pressure

If queues grow significantly and becomes larger than memory, performance will slow and cache misses will happen. Back pressure limits the queue size, tehrefore maintaining the throughput rate and response times. Once the queue hits the limit, client gets a HTTP 503 (service unavailable).  