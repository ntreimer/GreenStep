package com.natetreimer.greenstep.checklist;

import com.natetreimer.greenstep.security.User;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String description;

    @ManyToMany(mappedBy = "checkedItems")
    private Set<User> checkedUsers;

    public Checklist() {
    }

    public Checklist(Long id, String description, Set<User> checkedUsers) {
        this.id = id;
        this.description = description;
        this.checkedUsers = checkedUsers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getCheckedUsers() {
        return checkedUsers;
    }

    public void setCheckedUsers(Set<User> checkedUsers) {
        this.checkedUsers = checkedUsers;
    }
}
