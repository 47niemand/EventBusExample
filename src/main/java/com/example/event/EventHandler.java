package com.example.event;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by victorzagnitko on 05.10.16.
 */
@Component
public class EventHandler {

    private static final Logger LOG = LoggerFactory.getLogger(EventHandler.class);

    @Autowired
    private EventBus eventBus;

    @Subscribe
    public void subscriber(EventMessage eventMessage) {
        LOG.info("Hello " + eventMessage.getMessage());
    }

    @PostConstruct
    public void init() {
        this.eventBus.register(this);
    }

}
