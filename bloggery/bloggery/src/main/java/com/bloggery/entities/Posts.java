package com.bloggery.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "posts")
public class Posts {
    public enum postState{
        draft,
        published,
        deleted
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "state")
    private postState state = postState.draft;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;

    @OneToMany(mappedBy = "postId")
    private List<Comments> commentIDs;

    @OneToMany(mappedBy = "postId")
    private List<Reactions> reactionIDs;

    @ManyToMany
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tags> tagIDs;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Posts(){}

    public Posts(String title, String content, postState state) {
        this.title = title;
        this.content = content;
        this.state = state;
    }

    public List<Tags> getTagIDs() {
        return tagIDs;
    }

    public void setTagIDs(List<Tags> tagIDs) {
        this.tagIDs = tagIDs;
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

    public postState getState() {
        return state;
    }

    public void setState(postState state) {
        this.state = state;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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

    public void addReactionToPost(Reactions reaction){
        if(reactionIDs == null){
            reactionIDs = new ArrayList<>();
            }
        reactionIDs.add(reaction);
    }


    public void addCommentToPost(Comments comment){
        if(commentIDs == null){
            commentIDs = new ArrayList<>();
        }
        commentIDs.add(comment);
    }

    public void addTagToPost(Tags tag){
        if(tagIDs == null){
            tagIDs = new ArrayList<>();
        }
        tagIDs.add(tag);
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
