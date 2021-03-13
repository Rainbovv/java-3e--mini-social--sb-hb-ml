package student.example.minisocial.domain.entities;

import student.example.minisocial.domain.entities.interfaces.HasAuthor;
import student.example.minisocial.domain.entities.interfaces.IsChronological;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Entity(name="sentiments")
public class Sentiment implements HasAuthor, IsChronological {

    @Id
    private Integer id;

    /** Content object to be set */
    private String content;
    @OneToOne
    private User author;
    private Timestamp addedOn;

    public Sentiment() {}

    public Sentiment(String content, User author) {
        this.content = content;
        this.author = author;
    }

    public Sentiment(Integer id, String content, User author, Timestamp setOn) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.addedOn = setOn;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Timestamp getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Timestamp addedOn) {
        this.addedOn = addedOn;
    }

    @Override
    public String toString() {
        return "Sentiment{" +
                "id=" + id +
                ", content=" + content +
                ", author=" + author +
                ", setOn=" + addedOn +
                '}';
    }
}