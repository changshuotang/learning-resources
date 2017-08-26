## Cache

Caching helps improve page load times and reduces the load on your servers and databases.

##### Client Caching

##### CDN Caching

[CDNs](cdn.md) are considered a type of cache.

##### Web Server Caching

[Reverse proxies](reverse-proxy.md) can serve static and dynamic content directly, as well as cache requests, returning responses without needing to contact application servers.

##### Database Caching

Databases usually include some level of caching by default.

##### Application Caching

In-memory caches are key-value stores nested between your application and your data storage. Since data is held in RAM it is much faster, but without much memory to work with, 'cold' data needs to be removed to make space for 'hot' data.

##### Database Query Level Caching

When you query a database, hash the query as a key and store the result in the cache.

##### Object Level Caching

Abstract your data into an object and cache the object. 

### When To Update Cache

##### Read-Through/Cache-Aside

- Look for entry in cache
- Load entry from database
- Add entry to cache
- Return entry

##### Write-Through

The application uses the cache as the main data store, reading and writing to it, while the cache is responsible for reading and writing to the database.

- Application writes to cache
- Cache synchronously writes entry to data store

##### Write-Behind/Write-Back

- Application writes to cache
- Cache asynchronously writes to database

##### Refresh-Ahead

Automatically refresh any recently accessed cache entry prior to its expiration to lower perceived latency.
