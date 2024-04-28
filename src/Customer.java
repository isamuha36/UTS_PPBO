import java.util.UUID;

public class Customer {
    private String nama;
    private String email;
    public String getNama() {
        return nama;
    }
    public String getEmail() {
        return email;
    }

    public Customer(String nama, String email) {
        this.nama = nama;
        this.email = email;
    }

}
