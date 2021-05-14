package com.example.sweater.domain.dto;

import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import com.example.sweater.domain.util.MessageHelper;

import java.time.LocalDateTime;

public class MessageDto {

    private final Long id;
    private final String text;
    private final String tag;
    private final User author;
    private final String filename;
    private final Long likes;
    private final Boolean meLiked;
    private final LocalDateTime creationDate;

    public MessageDto(Message message, Long likes, Boolean meLiked, LocalDateTime creationDate) {
        this.id = message.getId();
        this.text = message.getText();
        this.tag = message.getTag();
        this.author = message.getAuthor();
        this.filename = message.getFilename();
        this.likes = likes;
        this.meLiked = meLiked;
        this.creationDate = creationDate;
    }

    public String getAuthorName() {
        return MessageHelper.getAuthorName(author);
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    public User getAuthor() {
        return author;
    }

    public String getFilename() {
        return filename;
    }

    public Long getLikes() {
        return likes;
    }

    public Boolean getMeLiked() {
        return meLiked;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }


    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", author=" + author +
                ", likes=" + likes +
                ", meLiked=" + meLiked +
                ", creationDate=" + creationDate +
                '}';
    }
}
