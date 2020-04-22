package com.capgemini.tests.pages;

public abstract class Page {
    protected String title;

    public Page(String title) {
        this.title = title;
    }

    public void open() {
        System.out.println("Opening page: " + getUrl());
    }

    protected abstract String getUrl();

    public String getTitle() {
        return title;
    }

    //todo parametrized open?
}
