package com.nocompany.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.nocompany.data.Constants.MESSAGE_MORNING;
import static com.nocompany.data.Constants.MESSAGE_DAY;
import static com.nocompany.data.Constants.MESSAGE_EVENING;
import static com.nocompany.data.Constants.MESSAGE_NIGHT;
import static com.nocompany.data.Constants.MESSAGIES_BUNDLE;
import static java.time.LocalTime.now;
import static java.time.LocalTime.of;
import static java.time.LocalTime.MIDNIGHT;
import static java.time.LocalTime.MAX;

public class Environment {

    private static final Logger LOGGER = LoggerFactory.getLogger(Environment.class);

    private Locale currentLocale;

    private ResourceBundle messagies;

    private LocalTime currentTime = now();

    private final LocalTime SIX_AM = of(6, 0, 0, 0);

    private final LocalTime NINE_AM = of(9, 0, 0, 0);

    private final LocalTime SEVEN_PM = of(19, 0, 0, 0);

    private final LocalTime ELEVEN_PM = of(23, 0, 0, 0);

    public String returnGreeting() {

        LOGGER.info("Start returnGreeting()");
        String result = null;

        //initialize current environment
        this.initializeEnvironment();

        if ((this.getCurrentTime().equals(SIX_AM)|| this.getCurrentTime().isAfter(SIX_AM)) &&
                this.getCurrentTime().isBefore(NINE_AM)) {

            result = this.getMessagies().getString(MESSAGE_MORNING);

        } else if ((this.getCurrentTime().equals(NINE_AM)|| this.getCurrentTime().isAfter(NINE_AM)) &&
                this.getCurrentTime().isBefore(SEVEN_PM)) {

            result = this.getMessagies().getString(MESSAGE_DAY);

        } else if ((this.getCurrentTime().equals(SEVEN_PM)|| this.getCurrentTime().isAfter(SEVEN_PM)) &&
                this.getCurrentTime().isBefore(ELEVEN_PM)) {

            result = this.getMessagies().getString(MESSAGE_EVENING);

        } else if ((this.getCurrentTime().equals(ELEVEN_PM)|| this.getCurrentTime().isAfter(ELEVEN_PM)) &&
                this.getCurrentTime().isBefore(MAX) || (this.getCurrentTime().equals(MIDNIGHT)||
                this.getCurrentTime().isAfter(MIDNIGHT)) && this.getCurrentTime().isBefore(SIX_AM)) {

            result = this.getMessagies().getString(MESSAGE_NIGHT);
        }
        LOGGER.info("End returnGreeting(), return message - " + result);
        return result;
    }

    private void initializeEnvironment(){
        if(currentLocale == null){
            currentLocale = Locale.getDefault();
        }
        messagies = ResourceBundle.getBundle(MESSAGIES_BUNDLE, getCurrentLocale());
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public ResourceBundle getMessagies() {
        return messagies;
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }

    public void setMessagies(ResourceBundle messagies) {
        this.messagies = messagies;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }
}
