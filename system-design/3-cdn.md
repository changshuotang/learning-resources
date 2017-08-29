## CDN (Content Delivery Network)

CDNs are a network of proxy servers, to serve content from locations closer to the user. Generally used for static files, thought some CDNs support dynamic content. A site's DNS resolution will tell clients which server to contact.

CDNs improve performance in two ways:
- User receives content from data centers close to them
- Your own servers do not have to serve requests that the CDN fulfills

### PUSH CDNs

Push CDNs receive new content whenever changes occur on your server. You have full responsibility of providing the content uploading directly to the CDN, and rewriting URLs to point to the CDN.

### Pull CDNs

Pull CDNs grab new content from your server when the first user requests the content. You still rewrite the URLs to point to the CDN. THis results in a slower request until the content is cached on the CDN. Good for sites with heavy traffic as traffic is spread out more evenly with only recently-requested content remaining on the CDN.