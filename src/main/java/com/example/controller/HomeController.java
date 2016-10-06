package com.example.controller;

import com.example.event.EventMessage;
import com.google.common.eventbus.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * Created by victorzagnitko on 05.10.16.
 */
@RestController
@RequestMapping(value = "/hello")
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private EventBus eventBus;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Map<String, String> homeController(@RequestParam String message) {
        try {
            eventBus.post(new EventMessage(message));
            return Collections.singletonMap("success", "true");
        } catch (Exception exc) {
            LOG.error("Error {}", exc);
            return Collections.singletonMap("success", "false");
        }
    }

}
