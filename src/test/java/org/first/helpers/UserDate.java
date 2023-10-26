package org.first.helpers;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class UserDate {
    private static final Faker faker = new Faker(new Locale("ru"));
    private static final Faker fakerEU = new Faker(new Locale("eu-US"));
    private static final Random random = new Random();
    private static final String [] genderRole = {"Male", "Female", "Other"};
    public static String [] subjects = {"Arts", "Maths", "Hindi"};
    public static String [] hobbies = {"Sports", "Reading", "Music"};
    public static String [] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static String lastName = faker.name().lastName();
    public static String firstName = faker.name().firstName();
    public static String email = fakerEU.internet().emailAddress();
    public static String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public static String currentAddress = faker.address().fullAddress();
    public static String yearBirth = String.valueOf(faker.number().numberBetween(1960,1999));
    public static String gender = genderRole[random.nextInt(0, genderRole.length)];
    public static String mouthBirth = month[random.nextInt(0, month.length)];
    public static String dayBirth = String.format("%02d", faker.number().numberBetween(1,28));
    public static String state = "NCR";
    public static String city = "Delhi";

}
