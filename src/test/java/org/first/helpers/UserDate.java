package org.first.helpers;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class UserDate {
    private final Faker faker = new Faker(new Locale("ru"));
    private final Faker fakerEU = new Faker(new Locale("eu-US"));
    public String [] subjects = {"Arts", "Maths", "Hindi"};
    public String [] hobbies = {"Sports", "Reading", "Music"};
    public String lastName = faker.name().lastName();
    public String firstName = faker.name().firstName();
    public String email = fakerEU.internet().emailAddress();
    public String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public String currentAddress = faker.address().fullAddress();
    public String yearBirth = String.valueOf(faker.number().numberBetween(1960,1999));
    public String gender =  faker.options().option("Male", "Female", "Other");
    public String mouthBirth = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public String dayBirth = String.format("%02d", faker.number().numberBetween(1,28));
    public String state = "NCR";
    public String city = "Delhi";
}
