import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Getter
@Setter
public class DataGenerator {

    private DataGenerator() {
    }

    public static String generateDate(int newDays) {
        return LocalDate.now().plusDays(newDays).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


    public static String generateCity() {
        List<String> list = Arrays.asList("Санкт-Петербург", "Москва", "Омск",
                "Самара", "Воронеж", "Сочи", "Калининград", "Казань", "Адлер", "Вологда", "Краснодар",
                "Тюмень", "Новосибирск", "Ростов");
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));

        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }


    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }


}

