package student.example.minisocial.domain.entities;

import student.example.minisocial.domain.entities.interfaces.HasAuthor;
import student.example.minisocial.domain.entities.interfaces.HasSentiment;
import student.example.minisocial.domain.entities.interfaces.IsChronological;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Entity(name = "messages")
public class Message implements HasAuthor, HasSentiment, IsChronological {

    @Id
    private Integer id;
    @OneToOne
    private User author;
    private String content;
    private Timestamp sentOn;
    @OneToOne
    private Sentiment sentiment;

    public Message() {}

    public Message(User author, String content) {
        this.author = author;
        this.content = content;
    }

    public Message(User author, String content, Sentiment sentiment) {
        this.author = author;
        this.content = content;
        this.sentiment = sentiment;
    }

    public Message(Integer id, User author, String content, Timestamp sentOn, Sentiment sentiment) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.sentOn = sentOn;
        this.sentiment = sentiment;
    }

    public Integer getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getSentOn() {
        return sentOn;
    }

    public void setSentOn(Timestamp sentOn) {
        this.sentOn = sentOn;
    }

    public Sentiment getSentiment() {
        return sentiment;
    }

    public void setSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", author=" + author +
                ", content='" + content + '\'' +
                ", sentOn=" + sentOn +
                ", sentiment=" + sentiment +
                '}';
    }
}
