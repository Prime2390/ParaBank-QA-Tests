package DominikBernas.models;

import com.github.javafaker.Faker;
import lombok.Getter;

@Getter
public class RegisterModelFaker {

 private final Faker faker = new Faker();
 private final String firstName = faker.name().firstName();
 private final String lastName = faker.name().lastName();
 private final String address = faker.address().streetAddress();
 private final String city = faker.address().city();
 private final String state = faker.address().state();
 private final String country = faker.address().country();
 private final String zipCode = faker.address().zipCode();
 private final String phoneNumber = faker.phoneNumber().phoneNumber();
 private final String pesel = faker.idNumber().valid();
 private final String login = faker.name().username();
 private final String password = faker.internet().password();
 private final String confirmPassword = faker.internet().password();
}