package com.woozooha.demo.dto;

public class GreetingDto {

    private Long id;

    private String content;

    public GreetingDto() {
    }

    public Long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {
        return "GreetingDto(id=" + this.getId() + ", content=" + this.getContent() + ")";
    }

}
