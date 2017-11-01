package de.irian.languages.latin.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Translation {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne()
	private Word word;
	
	@Enumerated(EnumType.STRING)
	private Language language;
	
	private String translation;
	
}
