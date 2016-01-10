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
import static com.nocompany.data.Constants.MESSAGES_BUNDLE;
import static java.time.LocalTime.now;
import static java.time.LocalTime.of;
import static java.time.LocalTime.MIDNIGHT;
import static java.time.LocalTime.MAX;

/**
 * This is main class for using this console application.
 * An instance of current class by default contains information about locale (country and language codes)
 * and receives messages that depends from local time, by invoking {@link #returnGreeting()}.
 */
public class Environment {

    private static final Logger LOGGER = LoggerFactory.getLogger(Environment.class);

    private Locale currentLocale;

    private ResourceBundle messages;

    private LocalTime currentTime = now();

    private final LocalTime SIX_AM = of(6, 0, 0, 0);

    private final LocalTime NINE_AM = of(9, 0, 0, 0);

    private final LocalTime SEVEN_PM = of(19, 0, 0, 0);

    private final LocalTime ELEVEN_PM = of(23, 0, 0, 0);

    /**
     * This method is responsible for returning right greeting message, that depends from user`s locale
     * and time when program runs.
     * If program runs when time is between :
     * - [6 a.m. - 9 a.m.) - returns morning`s greeting message;
     * - [9 a.m. - 19 p.m.) - returns day`s greeting message;
     * - [19 p.m. - 23 p.m.) - returns evening`s greeting message;
     * - [23 p.m. - 23.59.59.999 p.m.)  - returns night`s greeting message;
     * - [0 a.m. - 6 a.m.)  - returns night`s greeting message;
     *
     * @return greeting message
     */
    public String returnGreeting() {

        LOGGER.info("Start returnGreeting()");
        String result = null;

        //initialize current environment
        this.initializeEnvironment();

        if ((this.getCurrentTime().equals(SIX_AM) || this.getCurrentTime().isAfter(SIX_AM)) &&
                this.getCurrentTime().isBefore(NINE_AM)) {

            result = this.getMessages().getString(MESSAGE_MORNING);

        } else if ((this.getCurrentTime().equals(NINE_AM) || this.getCurrentTime().isAfter(NINE_AM)) &&
                this.getCurrentTime().isBefore(SEVEN_PM)) {

            result = this.getMessages().getString(MESSAGE_DAY);

        } else if ((this.getCurrentTime().equals(SEVEN_PM) || this.getCurrentTime().isAfter(SEVEN_PM)) &&
                this.getCurrentTime().isBefore(ELEVEN_PM)) {

            result = this.getMessages().getString(MESSAGE_EVENING);

        } else if ((this.getCurrentTime().equals(ELEVEN_PM) || this.getCurrentTime().isAfter(ELEVEN_PM)) &&
                this.getCurrentTime().isBefore(MAX) || (this.getCurrentTime().equals(MIDNIGHT) ||
                this.getCurrentTime().isAfter(MIDNIGHT)) && this.getCurrentTime().isBefore(SIX_AM)) {

            result = this.getMessages().getString(MESSAGE_NIGHT);
        }
        LOGGER.info("End returnGreeting(), return message - " + result);
        return result;
    }

    private void initializeEnvironment() {
        if (currentLocale == null) {
            currentLocale = Locale.getDefault();
        }
        this.setMessages(ResourceBundle.getBundle(MESSAGES_BUNDLE, getCurrentLocale()));
    }

    /**
     * This method return current environment`s Locale.
     *
     * @return current environment`s Locale
     */
    public Locale getCurrentLocale() {
        return currentLocale;
    }

    /**
     * This method returns messages from Resource Bundle that current
     * environment will use.
     *
     * @return returns messages from Resource Bundle that current
     * environment will use
     */
    public ResourceBundle getMessages() {
        return messages;
    }

    /**
     * This method returns time that current environment uses.
     *
     * @return time that current environment uses
     */
    public LocalTime getCurrentTime() {
        return currentTime;
    }

    /**
     * This method allows to set Locale.
     *
     * @param currentLocale that current environment will use
     */
    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }

    /**
     * This method is responsible for setting messages that current environment
     * receive from Resource Bundle.
     *
     * @param messages that would be accessible for current environment
     */
    public void setMessages(ResourceBundle messages) {
        this.messages = messages;
    }

    /**
     * This method allows to set time of {@code Environment} object.
     *
     * @param currentTime set new time
     */
    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }
}
