package com.bloggery.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roleId;

    @OneToMany(mappedBy = "userId")
    private List<Posts> postIDs;

    @OneToMany(mappedBy = "userId")
    private List<Comments> commentIDs;

    @OneToMany(mappedBy = "userId")
    private List<Reactions> reactionIDs;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Users(){}

    public Users(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public List<Posts> getPostIDs() {
        return postIDs;
    }

    public void setPostIDs(List<Posts> postIDs) {
        this.postIDs = postIDs;
    }

    public List<Comments> getCommentIDs() {
        return commentIDs;
    }

    public void setCommentIDs(List<Comments> commentIDs) {
        this.commentIDs = commentIDs;
    }

    public List<Reactions> getReactionIDs() {
        return reactionIDs;
    }

    public void setReactionIDs(List<Reactions> reactionIDs) {
        this.reactionIDs = reactionIDs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public void addPostToUser(Posts post){
        if(postIDs == null){
            postIDs = new ArrayList<>();
        }
        postIDs.add(post);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
