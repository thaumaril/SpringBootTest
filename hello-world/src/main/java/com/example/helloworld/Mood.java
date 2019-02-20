package com.example.helloworld;

import java.sql.Timestamp;
import java.lang.System;
import java.util.Random;

public class Mood {

    public final String mood;
    public final Timestamp dateTime;

    public Mood() {
        this.mood = getRandomMood();
        this.dateTime = new Timestamp(System.currentTimeMillis());

    }

    private String getRandomMood(){
        String newMood = "";
        int randonNumber = new Random().nextInt(3);

        switch(randonNumber) {
            case 0:
            newMood = "Happy";
            break;

            case 1:
            newMood = "Sad";
            break;

            case 2:
            newMood = "Angry";
            break;
        }
        return newMood;
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