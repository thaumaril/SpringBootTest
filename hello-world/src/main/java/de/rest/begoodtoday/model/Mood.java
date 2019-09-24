package de.rest.begoodtoday.model;

import de.rest.begoodtoday.MoodGenerator;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "moods")
@Data
public class Mood {

	public Mood(){
		MoodGenerator moodGen = new MoodGenerator();
		mood = moodGen.getMood();
		timestamp = moodGen.getDateTime();
	}

	@Id
	private long id;

	private String mood;

	private Timestamp timestamp;
	
}
