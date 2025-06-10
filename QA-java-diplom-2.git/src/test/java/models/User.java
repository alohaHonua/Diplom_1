package models;

import java.util.UUID;

public class User {
    private String email;
    private String password;
    private String name;

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public static User getRandomUser() {
        String uuid = UUID.randomUUID().toString();
        return new User(
                "user_" + uuid.substring(0, 8) + "@test.com",
                "password_" + uuid.substring(0, 8),
                "user_" + uuid.substring(0, 8)
        );
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
}

