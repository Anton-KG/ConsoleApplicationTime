package com.nocompany;

import com.nocompany.data.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is responsible for the running application.
 */
public class AppStart {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppStart.class);

    /**
     * This method is responsible for the running application.
     *
     * @param args any parameters that may be transfer to method (does not required in this application)
     */
    public static void main(String[] args) {
        LOGGER.info("Start application");
        Environment env = new Environment();
        String greeting = env.returnGreeting();
        System.out.println(greeting);
        LOGGER.info("Exit from application");
    }
}
