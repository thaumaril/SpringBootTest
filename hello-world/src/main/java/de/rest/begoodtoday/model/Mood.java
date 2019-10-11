package de.rest.begoodtoday.model;

import de.rest.begoodtoday.MoodGenerator;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
public class Mood {

	public Mood(){
		mood = MoodGenerator.getRandomMood();
		timestamp = new Date(System.currentTimeMillis());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Size(max=250)
	private String mood;

	@Temporal(TemporalType.DATE)
	private Date timestamp;

}
