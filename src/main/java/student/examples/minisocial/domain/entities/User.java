package student.examples.minisocial.domain.entities;

import student.examples.minisocial.domain.entities.interfaces.IsCommentable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name="Profile")
public class User implements IsCommentable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, length = 25)
    private String nickName;
    @Column(length = 25)
    private String password;
    @Column(unique = true, length = 50)
    private String email;
    private String avatar;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> friendTo = new ArrayList<>();


    public User() {
    }

    public User(String nickName, String password, String email) {
        this.nickName = nickName;
        this.password = password;
        this.email = email;
    }

    public User(Integer id, String nickName, String password, String email, String avatar) {
        this.id = id;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<User> getFriendTo() {
        return friendTo;
    }

    public void setFriendTo(List<User> friendTo) {
        this.friendTo = friendTo;
    }

    public void addFriend(User user) {
        this.friendTo.add(user);
    }

    public void removeFriend(User user) {
        this.friendTo.remove(user);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nickName='" + nickName + '\''
                + ", password='" + password + '\'' + ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' + '}';
    }
}






















