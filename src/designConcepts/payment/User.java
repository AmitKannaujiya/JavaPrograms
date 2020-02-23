package designConcepts.payment;

public class User {
    private String name;
    private String mobile;

    private int id;

    public User(String name, String mobile, int id) {
        this.name = name;
        this.mobile = mobile;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", id=" + id +
                '}';
    }
}
