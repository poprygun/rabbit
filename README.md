# Communication to Rabbit AMQP service provisioned on PCF

1. Configure a new rabbit mq service on PCF.  PCF Dev was used for this example.
2. Bind service to a sample application.
3. Run cf env app-name to obtain amqp properties from VCAP_SERVICES.
4. Provide amqp properties in `app.properties` file
