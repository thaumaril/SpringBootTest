package com.example.helloworld.data;

import com.example.helloworld.MoodGenerator;
import lombok.*;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Data
public class Mood {

	public Mood(){
		MoodGenerator moodGen = new MoodGenerator();
		mood = moodGen.getMood();
		timestamp = moodGen.getDateTime();
	}

	@Id
	private long id;

	@Getter @Setter
	private String mood;

	@Getter @Setter
	private Timestamp timestamp;
	
}
