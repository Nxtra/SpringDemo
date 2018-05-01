package be.nick.springdemo.model;

import javax.persistence.*;

@Entity
public class Tip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipSentence;

    @ManyToOne
    private User owner;

    public Tip() {
    }

    public Tip(String tipSentence, User owner) {
        this.tipSentence = tipSentence;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Tip{" +
                "id=" + id +
                ", tipSentence='" + tipSentence +
                ", owner=" + owner +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipSentence() {
        return tipSentence;
    }

    public void setTipSentence(String tipSentence) {
        this.tipSentence = tipSentence;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}

