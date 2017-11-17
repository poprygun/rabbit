package io.microsamples.queues;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
@Slf4j
public class QueueTests {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;


    @Test
    public void should_send_message() {
        String message = "Hello World!";
        this.template.convertAndSend(queue.getName(), message);
        log.info(" [x] Sent '" + message + "'");

        Message receive = this.template.receive(queue.getName());
        log.info(" [x] Received '" + message + "'");

        assertThat(receive, is(notNullValue()));
    }
}
