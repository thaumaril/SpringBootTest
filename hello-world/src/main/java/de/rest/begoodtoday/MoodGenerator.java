package de.rest.begoodtoday;

import java.util.Random;

public class MoodGenerator {


    public static String getRandomMood(){
        String[] newMood = {"Happy","Sad","Angry"};
        int randomNumber = new Random().nextInt(newMood.length);
        return newMood[randomNumber];
    }

}
