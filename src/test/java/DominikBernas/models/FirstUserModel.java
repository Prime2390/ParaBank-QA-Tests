package DominikBernas.models;

public class FirstUserModel {
    private String firstName = "Dominik";
    private String lastName = "Bernas";
    private String address = "Adama Mickiewicz 14/10";
    private String city = "Warszawa";
    private String state = "Wielkopolski";
    private String zip = "42-400";
    private String phone = "696596965";
    private String ssn = "415262514536";
    private String username ="Tester2390";
    private String password ="Testerpass2390";

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

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getSsn() {
        return ssn;
    }

    public String getPhone() {
        return phone;
    }

    public String getZip() {
        return zip;
    }

    public String getState() {
        return state;
    }
}
