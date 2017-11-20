package io.microsamples.queues;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.time.Instant;

@Slf4j
public class QueuePinger {

    public void ping() {

        String message = "Hello World " + Instant.now();
        this.template.convertAndSend(queue.getName(), message);
        log.info(" [ \u2713 ] Sent {} ",  message);

        Message receive = this.template.receive(queue.getName());
        log.info(" [ \u2713 ] Received {} ", message);

    }

    public void setTemplate(RabbitTemplate template) {
        this.template = template;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    private RabbitTemplate template;

    private Queue queue;
}
