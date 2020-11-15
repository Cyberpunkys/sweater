package com.example.sweater.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity //Сущность, которую необходимо сохранять в БД
public class Message {

    @Id //Поле будет индентификатором
    @GeneratedValue(strategy= GenerationType.AUTO) //auto generate
    private Integer id;

    private String text;
    private String tag;

    public Message() { // у Entity всегда нужно создавать пустой конструктор, иначе возможны ошибки
    }

    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
