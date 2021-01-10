package main.java.model;

public class Users {

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public int getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "id = " + id + "\n" +
                "name = " + name + '\n' +
                "username = " + username + '\n' +
                "email = " + email + '\n' +
                "phone = " + phone + '\n' +
                "website = " + website + '\n' + '\n' +
                company.toString() + '\n' +
                address.toString() + '\n';
    }

    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Company company;
    private Address address;
}
