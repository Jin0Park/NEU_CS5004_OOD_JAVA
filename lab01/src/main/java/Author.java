import java.sql.SQLOutput;

public class Author {
    private final String email;
    private final String address;
    private final Person person;

    public Author(Person person, String email, String address) {
        this.person = person;
        this.email = email;
        this.address = address;
    }

    public Person getName() {
        return person;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
