package franck.example.crudthymyleaf.Entities;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Employees")
public class Employe {

    private Long Id;

    @NotNull
    @Size(min=2,message = "First Name should have atleast 2 characters")
    private String firstName;

    @NotNull
    @Size(min=2 ,message = "Last Name should have atleast 2 characters")
    private  String lastName;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Size(min = 2,message = "passport number should have atleast 2 characters")
    private String passportNumber;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Column(name = "first_name",nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="last_name",nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="email_adresse",nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "Passport_number",nullable = false)
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
