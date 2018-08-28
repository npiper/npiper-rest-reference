# Rest reference

## Test libraries

Karate

## Prometheus monitoring

https://g00glen00b.be/monitoring-spring-prometheus-grafana/


## Jolokia Monitoring

https://hub.docker.com/r/jolokia/java-jolokia/

## Testing from tools

```
POST http://{HOSTNAME:PORT}/depot/10001/inventory_summaries

Request Body:
{
	"inventoryLocation" : "BRISTOL"
}
```

Read the response Header 'location'
location →
http://{HOSTNAME:PORT}/depot/10001/inventory_summaries/1

```
GET http://{HOSTNAME:PORT}/depot/10001/inventory_summaries/1

Response Body:
{
    "id": 1,
    "inventoryLocation": "BRISTOL"
}
```

# Other endpoints

Uses the Spring Boot actuator out of the box endpoints

https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html

`GET http://{HOSTNAME:PORT}/beans`
`GET http://{HOSTNAME:PORT}/health`
`GET http://{HOSTNAME:PORT}/metrics`
`GET http://{HOSTNAME:PORT}/env`
`		
