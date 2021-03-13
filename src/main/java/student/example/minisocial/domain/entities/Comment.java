package student.example.minisocial.domain.entities;

import student.example.minisocial.domain.entities.interfaces.HasAuthor;
import student.example.minisocial.domain.entities.interfaces.HasSentiment;
import student.example.minisocial.domain.entities.interfaces.IsChronological;
import student.example.minisocial.domain.entities.interfaces.IsCommentable;

import javax.persistence.*;

@Entity
public class Comment implements IsCommentable, IsChronological, HasSentiment, HasAuthor {

    @Id
    private Integer id;
    private String body;

}