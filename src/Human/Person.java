package Human;
import java.util.Date;

public abstract class Person {
    static private int count = 0;
    private final int id = ++count;
    private final String name;
    private final int age;
    private final String userName;
    private final String password;
    private final Date birthDate;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Person(String name, int age, Date birthDate, String userName, String password) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.userName = userName;
        this.password = password;
    }

    protected String getName() {
        return name;
    }

    protected int getAge() {
        return age;
    }

    protected Date getDate() {
        return birthDate;
    }
    protected abstract double getDiscount();

    public int getId() {
        return id;
    }
}
