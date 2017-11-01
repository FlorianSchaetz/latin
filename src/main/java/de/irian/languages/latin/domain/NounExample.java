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
public class NounExample implements Example {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private Noun noun;

	@Enumerated(EnumType.STRING)
	private Language language;

	@Enumerated(EnumType.STRING)
	private Casus casus;

	@Enumerated(EnumType.STRING)
	private Numerus numerus;

	private String text;

	private String translation;

	@Override
	public Noun getWord() {
		return noun;
	}

}
