package student.examples.minisocial.domain.entities;

import student.examples.minisocial.domain.entities.interfaces.IsCommentable;
import javax.persistence.*;

@Entity(name="Profile")
public class User implements IsCommentable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nickName;
    private String password;
    private String email;
    private String avatar;

    public User() {}

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

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nickName='" + nickName + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + ", avatar='" + avatar + '\'' + '}';
    }
}
