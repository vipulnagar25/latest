package designPattern.creational.builder;

/**
 * The Builder Pattern is a creational design pattern used to build complex objects step by step,
 * especially when an object has many optional parameters.
 * It separates object construction from its representation.
 */
class User {
    private String name;
    private String email;
    private String country;
    private String state;
    private String city;

    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.country = builder.country;
        this.state = builder.state;
        this.city = builder.city;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public static class Builder {
        private String name;
        private String email;
        private String country;
        private String state;
        private String city;

        public Builder(String name, String email) { // mandatory
            this.name = name;
            this.email = email;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

public class Builder {
    static void main() {
        User user = new User.Builder("Vipul", "vipul@gmail.com")
                .country("India")
                .state("Karnataka")
                .city("Bangalore")
                .build();

        System.out.println(user);
    }
}
