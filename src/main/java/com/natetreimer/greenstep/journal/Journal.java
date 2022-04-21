package com.natetreimer.greenstep.journal;

import com.natetreimer.greenstep.security.User;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Basic
    @Column(nullable = false)
    private Date date;

    @Lob
    @Column(nullable = false, length=500)
    private String content;

    public Journal() {
    }

    public Journal(Long id, User user, Date date, String content) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.content = content;
    }

    public Journal(Long id, Date date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
