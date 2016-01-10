package com.nocompany;

import com.nocompany.data.Environment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Locale;

/**
 * This class responsible for testing {@code Environment} class.
 */
public class EnvironmentTest {

    //Define Locale`s language and country codes

    private final String LOCALE_LANGUAGE_EN = "en";
    private final String LOCALE_COUNTRY_US = "US";

    private final String LOCALE_LANGUAGE_UK = "uk";
    private final String LOCALE_COUNTRY_UK = "UK";

    private final String LOCALE_LANGUAGE_RU = "ru";
    private final String LOCALE_COUNTRY_RU = "RU";

    //Define messages for English language

    private final String MSG_MORNING_EN = "Good morming, World!";
    private final String MSG_DAY_EN = "Good day, World!";
    private final String MSG_EVENING_EN = "Good evening, World!";
    private final String MSG_NIGHT_EN = "Good night, World!";

    //Define messages for Ukrainian language

    private final String MSG_MORNING_UK = "Доброго ранку, Світ!";
    private final String MSG_DAY_UK = "Доброго дня, Світ!";
    private final String MSG_EVENING_UK = "Доброго вечора, Світ!";
    private final String MSG_NIGHT_UK = "Доброї ночі, Світ!";

    //Define messages for Russian language

    private final String MSG_MORNING_RU = "Доброе утро, Мир!";
    private final String MSG_DAY_RU = "Добрый день, Мир!";
    private final String MSG_EVENING_RU = "Добрый вечер, Мир!";
    private final String MSG_NIGHT_RU = "Доброй ночи, Мир!";

    //Define time boundaries

    private final LocalTime TIME_MORNING_START = LocalTime.of(6, 0, 0, 0);
    private final LocalTime TIME_DAY_START = LocalTime.of(9, 0, 0, 0);
    private final LocalTime TIME_EVENING_START = LocalTime.of(19, 0, 0, 0);
    private final LocalTime TIME_NIGHT_START = LocalTime.of(23, 0, 0, 0);

    private final LocalTime TIME_MORNING_MIDDLE = LocalTime.of(6, 0, 0, 0);
    private final LocalTime TIME_DAY_MIDDLE = LocalTime.of(14, 0, 0, 0);
    private final LocalTime TIME_EVENING_MIDDLE = LocalTime.of(21, 0, 0, 0);
    private final LocalTime TIME_NIGHT_MIDDLE_TYPE_1 = LocalTime.of(23, 59, 59, 999);
    private final LocalTime TIME_NIGHT_MIDDLE_TYPE_2 = LocalTime.of(0, 0, 0, 0);
    private final LocalTime TIME_NIGHT_MIDDLE_TYPE_3 = LocalTime.of(0, 0, 0, 001);

    private final LocalTime TIME_MORNING_END = LocalTime.of(8, 59, 59, 999);
    private final LocalTime TIME_DAY_END = LocalTime.of(18, 59, 59, 999);
    private final LocalTime TIME_EVENING_END = LocalTime.of(22, 59, 59, 999);
    private final LocalTime TIME_NIGHT_END = LocalTime.of(5, 59, 59, 999);

    private Environment env;

    @Before
    public void prepareObject() {
        env = new Environment();
    }

    //Tests for language "en", country "US"

    @Test
    public void checkMessageNightUSType1Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_EN, LOCALE_COUNTRY_US));
        env.setCurrentTime(TIME_NIGHT_START);
        Assert.assertEquals(MSG_NIGHT_EN, env.returnGreeting());
    }

    @Test
    public void checkMessageNightUSType2Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_EN, LOCALE_COUNTRY_US));
        env.setCurrentTime(TIME_NIGHT_MIDDLE_TYPE_1);
        Assert.assertEquals(MSG_NIGHT_EN, env.returnGreeting());
    }

    @Test
    public void checkMessageNightUSType3Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_EN, LOCALE_COUNTRY_US));
        env.setCurrentTime(TIME_NIGHT_MIDDLE_TYPE_2);
        Assert.assertEquals(MSG_NIGHT_EN, env.returnGreeting());
    }

    @Test
    public void checkMessageNightUSType4Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_EN, LOCALE_COUNTRY_US));
        env.setCurrentTime(TIME_NIGHT_MIDDLE_TYPE_3);
        Assert.assertEquals(MSG_NIGHT_EN, env.returnGreeting());
    }

    @Test
    public void checkMessageNightUSType5Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_EN, LOCALE_COUNTRY_US));
        env.setCurrentTime(TIME_NIGHT_END);
        Assert.assertEquals(MSG_NIGHT_EN, env.returnGreeting());
    }

    @Test
    public void checkMessageEveningUSType1Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_EN, LOCALE_COUNTRY_US));
        env.setCurrentTime(TIME_EVENING_START);
        Assert.assertEquals(MSG_EVENING_EN, env.returnGreeting());
    }

    @Test
    public void checkMessageEveningUSType2Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_EN, LOCALE_COUNTRY_US));
        env.setCurrentTime(TIME_EVENING_MIDDLE);
        Assert.assertEquals(MSG_EVENING_EN, env.returnGreeting());
    }

    @Test
    public void checkMessageEveningUSType3Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_EN, LOCALE_COUNTRY_US));
        env.setCurrentTime(TIME_EVENING_END);
        Assert.assertEquals(MSG_EVENING_EN, env.returnGreeting());
    }

    @Test
    public void checkMessageDayUSType1Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_EN, LOCALE_COUNTRY_US));
        env.setCurrentTime(TIME_DAY_START);
        Assert.assertEquals(MSG_DAY_EN, env.returnGreeting());
    }

    @Test
    public void checkMessageDayUSType2Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_EN, LOCALE_COUNTRY_US));
        env.setCurrentTime(TIME_DAY_MIDDLE);
        Assert.assertEquals(MSG_DAY_EN, env.returnGreeting());
    }

    @Test
    public void checkMessageDayUSType3Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_EN, LOCALE_COUNTRY_US));
        env.setCurrentTime(TIME_DAY_END);
        Assert.assertEquals(MSG_DAY_EN, env.returnGreeting());
    }

    @Test
    public void checkMessageMorningUSType1Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_EN, LOCALE_COUNTRY_US));
        env.setCurrentTime(TIME_MORNING_START);
        Assert.assertEquals(MSG_MORNING_EN, env.returnGreeting());
    }

    @Test
    public void checkMessageMorningUSType2Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_EN, LOCALE_COUNTRY_US));
        env.setCurrentTime(TIME_MORNING_MIDDLE);
        Assert.assertEquals(MSG_MORNING_EN, env.returnGreeting());
    }

    @Test
    public void checkMessageMorningUSType3Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_EN, LOCALE_COUNTRY_US));
        env.setCurrentTime(TIME_MORNING_END);
        Assert.assertEquals(MSG_MORNING_EN, env.returnGreeting());
    }

    //Tests for language "uk", country "UK"

    @Test
    public void checkMessageNightUKType1Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_UK, LOCALE_COUNTRY_UK));
        env.setCurrentTime(TIME_NIGHT_START);
        Assert.assertEquals(MSG_NIGHT_UK, env.returnGreeting());
    }

    @Test
    public void checkMessageNightUKType2Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_UK, LOCALE_COUNTRY_UK));
        env.setCurrentTime(TIME_NIGHT_MIDDLE_TYPE_1);
        Assert.assertEquals(MSG_NIGHT_UK, env.returnGreeting());
    }

    @Test
    public void checkMessageNightUKType3Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_UK, LOCALE_COUNTRY_UK));
        env.setCurrentTime(TIME_NIGHT_MIDDLE_TYPE_2);
        Assert.assertEquals(MSG_NIGHT_UK, env.returnGreeting());
    }

    @Test
    public void checkMessageNightUKType4Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_UK, LOCALE_COUNTRY_UK));
        env.setCurrentTime(TIME_NIGHT_MIDDLE_TYPE_3);
        Assert.assertEquals(MSG_NIGHT_UK, env.returnGreeting());
    }

    @Test
    public void checkMessageNightUKType5Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_UK, LOCALE_COUNTRY_UK));
        env.setCurrentTime(TIME_NIGHT_END);
        Assert.assertEquals(MSG_NIGHT_UK, env.returnGreeting());
    }

    @Test
    public void checkMessageEveningUKType1Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_UK, LOCALE_COUNTRY_UK));
        env.setCurrentTime(TIME_EVENING_START);
        Assert.assertEquals(MSG_EVENING_UK, env.returnGreeting());
    }

    @Test
    public void checkMessageEveningUKType2Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_UK, LOCALE_COUNTRY_UK));
        env.setCurrentTime(TIME_EVENING_MIDDLE);
        Assert.assertEquals(MSG_EVENING_UK, env.returnGreeting());
    }

    @Test
    public void checkMessageEveningUKType3Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_UK, LOCALE_COUNTRY_UK));
        env.setCurrentTime(TIME_EVENING_END);
        Assert.assertEquals(MSG_EVENING_UK, env.returnGreeting());
    }

    @Test
    public void checkMessageDayUKType1Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_UK, LOCALE_COUNTRY_UK));
        env.setCurrentTime(TIME_DAY_START);
        Assert.assertEquals(MSG_DAY_UK, env.returnGreeting());
    }

    @Test
    public void checkMessageDayUKType2Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_UK, LOCALE_COUNTRY_UK));
        env.setCurrentTime(TIME_DAY_MIDDLE);
        Assert.assertEquals(MSG_DAY_UK, env.returnGreeting());
    }

    @Test
    public void checkMessageDayUKType3Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_UK, LOCALE_COUNTRY_UK));
        env.setCurrentTime(TIME_DAY_END);
        Assert.assertEquals(MSG_DAY_UK, env.returnGreeting());
    }

    @Test
    public void checkMessageMorningUKType1Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_UK, LOCALE_COUNTRY_UK));
        env.setCurrentTime(TIME_MORNING_START);
        Assert.assertEquals(MSG_MORNING_UK, env.returnGreeting());
    }

    @Test
    public void checkMessageMorningUKType2Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_UK, LOCALE_COUNTRY_UK));
        env.setCurrentTime(TIME_MORNING_MIDDLE);
        Assert.assertEquals(MSG_MORNING_UK, env.returnGreeting());
    }

    @Test
    public void checkMessageMorningUKType3Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_UK, LOCALE_COUNTRY_UK));
        env.setCurrentTime(TIME_MORNING_END);
        Assert.assertEquals(MSG_MORNING_UK, env.returnGreeting());
    }

    //Tests for language "ru", country "RU"

    @Test
    public void checkMessageNightRUType1Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_RU, LOCALE_COUNTRY_RU));
        env.setCurrentTime(TIME_NIGHT_START);
        Assert.assertEquals(MSG_NIGHT_RU, env.returnGreeting());
    }

    @Test
    public void checkMessageNightRUType2Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_RU, LOCALE_COUNTRY_RU));
        env.setCurrentTime(TIME_NIGHT_MIDDLE_TYPE_1);
        Assert.assertEquals(MSG_NIGHT_RU, env.returnGreeting());
    }

    @Test
    public void checkMessageNightRUType3Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_RU, LOCALE_COUNTRY_RU));
        env.setCurrentTime(TIME_NIGHT_MIDDLE_TYPE_2);
        Assert.assertEquals(MSG_NIGHT_RU, env.returnGreeting());
    }

    @Test
    public void checkMessageNightRUType4Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_RU, LOCALE_COUNTRY_RU));
        env.setCurrentTime(TIME_NIGHT_MIDDLE_TYPE_3);
        Assert.assertEquals(MSG_NIGHT_RU, env.returnGreeting());
    }

    @Test
    public void checkMessageNightRUType5Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_RU, LOCALE_COUNTRY_RU));
        env.setCurrentTime(TIME_NIGHT_END);
        Assert.assertEquals(MSG_NIGHT_RU, env.returnGreeting());
    }

    @Test
    public void checkMessageEveningRUType1Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_RU, LOCALE_COUNTRY_RU));
        env.setCurrentTime(TIME_EVENING_START);
        Assert.assertEquals(MSG_EVENING_RU, env.returnGreeting());
    }

    @Test
    public void checkMessageEveningRUType2Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_RU, LOCALE_COUNTRY_RU));
        env.setCurrentTime(TIME_EVENING_MIDDLE);
        Assert.assertEquals(MSG_EVENING_RU, env.returnGreeting());
    }

    @Test
    public void checkMessageEveningRUType3Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_RU, LOCALE_COUNTRY_RU));
        env.setCurrentTime(TIME_EVENING_END);
        Assert.assertEquals(MSG_EVENING_RU, env.returnGreeting());
    }

    @Test
    public void checkMessageDayRUType1Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_RU, LOCALE_COUNTRY_RU));
        env.setCurrentTime(TIME_DAY_START);
        Assert.assertEquals(MSG_DAY_RU, env.returnGreeting());
    }

    @Test
    public void checkMessageDayRUType2Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_RU, LOCALE_COUNTRY_RU));
        env.setCurrentTime(TIME_DAY_MIDDLE);
        Assert.assertEquals(MSG_DAY_RU, env.returnGreeting());
    }

    @Test
    public void checkMessageDayRUType3Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_RU, LOCALE_COUNTRY_RU));
        env.setCurrentTime(TIME_DAY_END);
        Assert.assertEquals(MSG_DAY_RU, env.returnGreeting());
    }

    @Test
    public void checkMessageMorningRUType1Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_RU, LOCALE_COUNTRY_RU));
        env.setCurrentTime(TIME_MORNING_START);
        Assert.assertEquals(MSG_MORNING_RU, env.returnGreeting());
    }

    @Test
    public void checkMessageMorningRUType2Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_RU, LOCALE_COUNTRY_RU));
        env.setCurrentTime(TIME_MORNING_MIDDLE);
        Assert.assertEquals(MSG_MORNING_RU, env.returnGreeting());
    }

    @Test
    public void checkMessageMorningRUType3Test() {
        env.setCurrentLocale(new Locale(LOCALE_LANGUAGE_RU, LOCALE_COUNTRY_RU));
        env.setCurrentTime(TIME_MORNING_END);
        Assert.assertEquals(MSG_MORNING_RU, env.returnGreeting());
    }
}
