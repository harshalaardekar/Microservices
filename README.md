# Microservice-Implementation-with-SpringBoot

Developed 2 microservices as citizen service and vaccination center service where citizen service will handle requests for registering and fetching citizen data. And, vaccination center service will handle requests for vaccination center’s data and booking appointment for vaccination.

Registered both services to Eureka Server and implemented load balancing so that if any one instance is not available at any particular moment request will redirected to another instance.

Implemented circuit breaker using hystrix circuit breaker, implemented fallback methods and API gateway.
