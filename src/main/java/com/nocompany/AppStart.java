package com.nocompany;

import com.nocompany.data.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AppStart {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppStart.class);
    public static void main(String[] args) {
        LOGGER.info("Start application");
        Environment env = new Environment();
        String greeting = env.returnGreeting();
        System.out.println(greeting);
        LOGGER.info("Exit from application");
    }
}
