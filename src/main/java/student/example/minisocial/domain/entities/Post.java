package student.example.minisocial.domain.entities;

import student.example.minisocial.domain.entities.interfaces.HasAuthor;
import student.example.minisocial.domain.entities.interfaces.HasSentiment;
import student.example.minisocial.domain.entities.interfaces.IsChronological;
import student.example.minisocial.domain.entities.interfaces.IsCommentable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name="posts")
public class Post implements HasAuthor, HasSentiment, IsCommentable, IsChronological {

    @Id
    private Integer id;
    private String title;
    private String content;
    @OneToOne
    private User author;
    @OneToOne
    private Sentiment sentiment;
    @OneToMany(mappedBy = "comments")
    private List<Comment> comments;
    private Timestamp addedOn;

    public Post() {
        this.comments = new ArrayList<>();
    }

    public Post(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = new ArrayList<>();
    }

    public Post(String title, String content, User author, Sentiment sentiment) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.sentiment = sentiment;
        this.comments = new ArrayList<>();
    }

    public Post(Integer id, String title, String content, User author,
                Sentiment sentiment, List<Comment> comments, Timestamp postedOn) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.sentiment = sentiment;
        this.comments = comments;
        this.addedOn = postedOn;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", sentiment=" + sentiment +
                ", comments=" + comments +
                ", postedOn=" + addedOn +
                '}';
    }
}
