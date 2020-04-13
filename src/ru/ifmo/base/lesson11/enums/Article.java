package ru.ifmo.base.lesson11.enums;

import java.time.LocalDateTime;

public class Article {
    private String title;
    private String text;
    private LocalDateTime created;
    
    public Article(String title) {
        this.title = title;
        created = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

}
