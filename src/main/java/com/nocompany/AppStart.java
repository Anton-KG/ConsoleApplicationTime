package com.nocompany;

import com.nocompany.data.Environment;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.logging.Logger;

public class AppStart {

    public static void main(String[] args) {
        Environment env = new Environment();
        env.displayGreeting();
    }
}
