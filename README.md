# Communication to Rabbit AMQP service provisioned on PCF

Demonstrates the example of connecting and using AMQP from Spring (Not Spring Boot) application.

1. Configure a new rabbit mq service on PCF.  PCF Dev was used for this example.

```bash
cf create-service p-rabbitmq standard amqp-simple
```

2. Bind service to a sample application.

```bash
cf bind-service rabbit amqp-simple
```

## To run locally, connecting to AMQP service provisioned on PCF

1. Run cf env app-name to obtain amqp properties from VCAP_SERVICES.

2. Provide amqp properties in `app.properties` file

3. Run app.  Tail the log to see queue messages process.

```bash
java -jar target/rabbit.jar
```

## To run on Cloud Foundry

1. Make sure that service `amqp-simple` is created

```bash
cf services
Getting services in org pcfdev-org / space pcfdev-space as admin...
OK

name          service      plan       bound apps                   last operation
amqp-simple   p-rabbitmq   standard   instrument-details, rabbit   create succeeded
```
2. Push the application, and observe logs.

```bash
cf push
```
