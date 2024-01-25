package com.service.hello;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//https://spring.io/guides/tutorials/rest/

@Entity
class Greeting {

    private @Id @GeneratedValue Long id;
    private String message;
    private String tone;

    Greeting() {}

    Greeting(String message, String tone) {
        this.message = message;
        this.tone = tone;
    }

    public Long getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTone() {
        return this.tone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }

    @Override
    public String toString() {
        return "Greeting{" + "id=" + this.id + ", message='" + this.message + '\'' + ", tone='" + this.tone + '\'' + '}';
    }
}