package com.getmydeal.bean;

public class SampleDropwizardBean {
    private final long id;
    private final String content;

    public SampleDropwizardBean(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}