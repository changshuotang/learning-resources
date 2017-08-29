## Key Topics

### Concurrency

##### Cache Coherence

All processors should see the same data for a __particular memory address__, as they should if there were no caches in the system.

##### Memory Consistency

Ensures all memory instructions execute in program order. 

##### Threads, Starvation, and Deadlocks

Threads are independent paths of execution. Starvation happens when a thread has a low priority and is never allocated the CPU resources to execute. Deadlocks happen when a thread requests a resource that another thread is holding while the other thread requests a resource that the original thread is holding, resulting in a deadlock.
