package io.microsamples.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.service.common.AmqpServiceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Slf4j
@Profile("cloud")
public class CloudAmqpConfiguration {

    @Value("${amqp.serviceName:amqp-simple}")
    private String amqpService;

    @Bean
    @Profile("cloud")
    public ConnectionFactory connectionFactory() {
        CloudFactory cloudFactory = new CloudFactory();
        Cloud cloud = cloudFactory.getCloud();
        AmqpServiceInfo serviceInfo = (AmqpServiceInfo) cloud.getServiceInfo(amqpService);
        String serviceID = serviceInfo.getId();
        log.info("Bound to {}", serviceInfo.getId());
        return cloud.getServiceConnector(serviceID, ConnectionFactory.class, null);
    }

}
