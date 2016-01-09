package com.nocompany.data;

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

    private Locale currentLocale = Locale.getDefault();

    private ResourceBundle messagies = ResourceBundle.getBundle(MESSAGIES_BUNDLE, getCurrentLocale());

    private LocalTime currentTime = now();

    private final LocalTime SIX_AM = of(6, 0, 0, 0);

    private final LocalTime NINE_AM = of(9, 0, 0, 0);

    private final LocalTime SEVEN_PM = of(19, 0, 0, 0);

    private final LocalTime ELEVEN_PM = of(23, 0, 0, 0);


    public void displayGreeting() {
        System.out.println(chooseGreeting());
    }

    private String chooseGreeting() {
        String result = null;
        if (this.getCurrentTime().isAfter(SIX_AM) && this.getCurrentTime().isBefore(NINE_AM)) {
            result = this.getMessagies().getString(MESSAGE_MORNING);
        } else if (this.getCurrentTime().isAfter(NINE_AM) && this.getCurrentTime().isBefore(SEVEN_PM)) {
            result = this.getMessagies().getString(MESSAGE_DAY);
        } else if (this.getCurrentTime().isAfter(SEVEN_PM) && this.getCurrentTime().isBefore(ELEVEN_PM)) {
            result = this.getMessagies().getString(MESSAGE_EVENING);
        } else if (this.getCurrentTime().isAfter(ELEVEN_PM) && this.getCurrentTime().isBefore(MAX)
                || this.getCurrentTime().isAfter(MIDNIGHT) && this.getCurrentTime().isBefore(SIX_AM)) {
            result = this.getMessagies().getString(MESSAGE_NIGHT);
        }
        return result;
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
}
