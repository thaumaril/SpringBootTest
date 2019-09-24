package de.rest.begoodtoday.controller;

import de.rest.begoodtoday.model.Mood;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoodController {

    @GetMapping(value="/mood")
    public Mood createNewMood ()
    {
        return new Mood();
    }

}
