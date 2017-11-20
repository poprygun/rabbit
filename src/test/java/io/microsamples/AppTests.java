package io.microsamples;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
@Slf4j
public class AppTests {

    @Autowired
    private ApplicationContext context;

    @Test
    public void should_have_all_queues_initialized(){
        assertThat(context, is(notNullValue()));


        Queue myqueue = (Queue)context.getBean("myqueue");

        assertThat(myqueue, is(notNullValue()));


    }
}
