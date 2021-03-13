package student.example.minisocial.domain.entities;

import student.example.minisocial.domain.entities.interfaces.HasSentiment;
import student.example.minisocial.domain.entities.interfaces.IsChronological;
import student.example.minisocial.domain.entities.interfaces.IsCommentable;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name="comments")
public class Comment implements HasSentiment, IsCommentable, IsChronological {

    @Id
    private Integer id;
    private String content;
    @OneToOne
    private Sentiment sentiment;
    @OneToMany(mappedBy = "parent")
    private List<Comment> comments;
    private Timestamp addedOn;
    @ManyToOne
    private Comment parent;

    public Comment() {
        this.comments = new ArrayList<>();
    }

    public Comment(String content) {
        this.content = content;
        this.comments = new ArrayList<>();
    }

    public Comment(String content, Sentiment sentiment) {
        this.content = content;
        this.sentiment = sentiment;
        this.comments = new ArrayList<>();
    }

    public Comment(Integer id, String content, Sentiment sentiment,
                   List<Comment> comments, Timestamp addedOn, Comment parent) {
        this.id = id;
        this.content = content;
        this.sentiment = sentiment;
        this.comments = comments;
        this.addedOn = addedOn;
        this.parent = parent;
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

    public Sentiment getSentiment() {
        return sentiment;
    }

    public void setSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Timestamp getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Timestamp addedOn) {
        this.addedOn = addedOn;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", content='" + content + '\'' +
                ", sentiment=" + sentiment + ", comments=" + comments +
                ", addedOn=" + addedOn + ", parent=" + parent + '}';
    }
}