package student.example.minisocial.domain.entities;

import student.example.minisocial.domain.entities.interfaces.IsCommentable;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name="users")
public class User implements IsCommentable {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private Date dateOfBirth;
    private String login;
    private String password;
    private String email;
    private Timestamp createdOn;
    @OneToMany(mappedBy = "comments")
    private List<Comment> comments;

    public User() {
        this.comments = new ArrayList<>();
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.createdOn = new Timestamp(System.currentTimeMillis());
        this.comments = new ArrayList<>();
    }

    public User(String firstName, String login, String password, String email) {
        this.firstName = firstName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.createdOn = new Timestamp(System.currentTimeMillis());
        this.comments = new ArrayList<>();

    }

    public User(String firstName, String lastName, String login, String password,
                String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.createdOn = new Timestamp(System.currentTimeMillis());
        this.comments = new ArrayList<>();

    }

    public User(String firstName, String lastName, String address, String login,
                String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.login = login;
        this.password = password;
        this.email = email;
        this.createdOn = new Timestamp(System.currentTimeMillis());
        this.comments = new ArrayList<>();

    }

    public User(String firstName, String lastName, String address, Date dateOfBirth,
                String login, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.login = login;
        this.password = password;
        this.email = email;
        this.createdOn = new Timestamp(System.currentTimeMillis());
        this.comments = new ArrayList<>();

    }

    public User(Integer id, String firstName, String lastName, String address,
                Date dateOfBirth, String login, String password, String email,
                Timestamp createdOn, List<Comment> comments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.login = login;
        this.password = password;
        this.email = email;
        this.createdOn = createdOn;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
