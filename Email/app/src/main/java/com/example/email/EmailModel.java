package com.example.email;

public class EmailModel {
    private String letter;
    private String name;
    private String subject;
    private String content;
    private String time;
    private boolean isfavourite;

    public EmailModel(String letter, String name, String subject, String content, String time) {
        this.letter = letter;
        this.name = name;
        this.subject = subject;
        this.content = content;
        this.time = time;
        isfavourite  = false;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isIsfavourite() {
        return isfavourite;
    }

    public void setIsfavourite(boolean favourite) {
        isfavourite = favourite;
    }
}
