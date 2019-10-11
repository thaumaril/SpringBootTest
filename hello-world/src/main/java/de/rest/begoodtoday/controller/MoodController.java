package de.rest.begoodtoday.controller;

import de.rest.begoodtoday.model.Mood;
import de.rest.begoodtoday.repository.MoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MoodController {

    @Autowired
    MoodRepository moodRepository;

    @GetMapping(value="/mood")
    public Mood createNewMood ()
    {
        Mood newMood = new Mood();
        moodRepository.saveAndFlush(newMood);
        return newMood;
    }


}
