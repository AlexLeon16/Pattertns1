package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        // Generate date with shift days
        LocalDate date = LocalDate.now().plusDays(shift);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.format(formatter);
    }

    public static String generateCity(Faker faker) {
        // Array of valid cities
        String[] cities = {
                "Москва", "Санкт-Петербург", "Казань", "Екатеринбург",
                "Новосибирск", "Красноярск", "Владивосток", "Сочи",
                "Уфа", "Ростов-на-Дону", "Нижний Новгород", "Самара"
        };
        Random random = new Random();
        return cities[random.nextInt(cities.length)];
    }

    public static String generateCity(String locale) {
        // Alternative method to generate city by locale
        Faker faker = new Faker(new Locale(locale));
        return generateCity(faker);
    }

    public static String generateName(Faker faker) {
        // Generate name in "Lastname Firstname" format
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return generateName(faker);
    }

    public static String generatePhone(Faker faker) {
        // Generate Russian phone number
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return generatePhone(faker);
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new UserInfo(
                    generateCity(faker),
                    generateName(faker),
                    generatePhone(faker)
            );
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}