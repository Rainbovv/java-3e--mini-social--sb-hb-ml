package student.examples.minisocial.domain.entities;

import student.examples.minisocial.domain.entities.interfaces.HasAuthor;
import student.examples.minisocial.domain.entities.interfaces.HasSentiment;
import student.examples.minisocial.domain.entities.interfaces.IsChronological;
import student.examples.minisocial.domain.entities.interfaces.IsCommentable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Post implements HasAuthor, HasSentiment, IsCommentable, IsChronological {

    @Id
    private Integer id;
    private String title;
    private String body;
}