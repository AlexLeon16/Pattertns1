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
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new UserInfo(
                    generateCity(),
                    generateName(faker),
                    generatePhone(faker)
            );
        }

        private static String generateCity() {
            String[] cities = {
                    "Москва", "Санкт-Петербург", "Казань", "Екатеринбург",
                    "Новосибирск", "Красноярск", "Владивосток", "Сочи",
                    "Уфа", "Ростов-на-Дону", "Нижний Новгород", "Самара"
            };
            return cities[new Random().nextInt(cities.length)];
        }

        private static String generateName(Faker faker) {
            return faker.name().firstName() + " " + faker.name().lastName();
        }

        private static String generatePhone(Faker faker) {
            return "+7" + faker.number().digits(10);
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}