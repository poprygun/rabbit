package io.microsamples.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Slf4j
@Profile("cloud")
public class CloudAmqpConfiguration  extends AbstractCloudConfig {

    @Value("${amqp.serviceName:amqp-simple}")
    private String amqpService;

    @Bean(name = "connectionFactory")
    @Profile("cloud")
    public ConnectionFactory amqpConnectionFactory() {

        ConnectionFactory connectionFactory = super.connectionFactory().rabbitConnectionFactory(amqpService);
        log.info("Bound to {}", amqpService);
        return connectionFactory;
    }

}
