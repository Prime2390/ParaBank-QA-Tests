package DominikBernas.models;


import com.github.javafaker.Faker;

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


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPesel() {
        return pesel;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}