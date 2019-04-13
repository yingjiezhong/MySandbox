
### DESCRIPTION
# this is a rest server application based on jax-rs and Jersey

# ISSUES
# post is not working - may be own json marshaling


### Client urls: 

# index page
http://localhost:8080/jax-rs-server/

# POJO object as json
http://localhost:8080/jax-rs-server/rest/notifications/get/1

# ping
http://localhost:8080/jax-rs-server/rest/notifications/ping

# post
curl -X POST -d '{"id":23,"text":"lorem ipsum","username":"johana"}' http://localhost:8080/jax-rs-server/rest/notifications/post --header "Content-Type:application/json"


### resources
https://www.baeldung.com/jax-rs-spec-and-implementations

https://www.mkyong.com/webservices/jax-rs/jersey-hello-world-example/


