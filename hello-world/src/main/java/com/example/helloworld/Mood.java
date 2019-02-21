package com.example.helloworld;

import java.sql.Timestamp;
import java.lang.System;
import java.util.Random;

public class Mood {

    private final String mood;
    private final Timestamp dateTime;

    public Mood() {
        this.mood = getRandomMood();
        this.dateTime = new Timestamp(System.currentTimeMillis());

    }

    private String getRandomMood(){
        String newMood[] = {"Happy","Sad","Angry"};
        int randomNumber = new Random().nextInt(newMood.length);
        return newMood[randomNumber];
    }

    /**
     * @return the dateTime
     */
    public Timestamp getDateTime() {
        return dateTime;
    }

    /**
     * @return the mood
     */
    public String getMood() {
        return mood;
    }
}
