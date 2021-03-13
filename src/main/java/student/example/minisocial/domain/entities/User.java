package student.example.minisocial.domain.entities;

import student.example.minisocial.domain.entities.interfaces.IsCommentable;
import javax.persistence.*;

@Entity(name="Profile")
public class User implements IsCommentable {

    @Id
    private Integer id;
    private String nickName;
    private String password;
    private String email;
    private String avatar;

}
