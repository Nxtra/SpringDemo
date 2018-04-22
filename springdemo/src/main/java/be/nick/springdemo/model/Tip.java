package be.nick.springdemo.model;

public class Tip {

    private Long id;
    private Long tipSentence;

    private User owner;

    public Tip(Long tipSentence, User owner) {
        this.tipSentence = tipSentence;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Tip{" +
                "id=" + id +
                ", tipSentence=" + tipSentence +
                ", owner=" + owner +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTipSentence() {
        return tipSentence;
    }

    public void setTipSentence(Long tipSentence) {
        this.tipSentence = tipSentence;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
