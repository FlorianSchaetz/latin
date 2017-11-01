package de.irian.languages.latin.domain;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("noun")
@Getter
@Setter
public class Noun extends Word {

	private String stem;

	@Enumerated(EnumType.STRING)
	private Declination declination;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@OneToMany(mappedBy = "noun", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<NounExample> examples;

	public String declinate(Casus casus, Numerus numerus) {
		return stem + declination.getSuffix(casus, numerus);
	}

	@Override
	public String toString() {
		return String.format("%s, -%s (%s)", declinate(Casus.NOMINATIVE, Numerus.SINGULAR),
				declination.getSuffix(Casus.NOMINATIVE, Numerus.PLURAL), gender.getShortcut());
	}

	@Override
	public Set<NounExample> getExamples() {
		return examples;
	}

	@Override
	public Set<NounExample> getExamples(Language language) {
		return examples.stream()
				.filter(e -> e.getLanguage() == language)
				.collect(Collectors.toSet());
	}

	public Set<NounExample> getExamples(Language language, Casus casus, Numerus numerus) {
		return examples.stream()
				.filter(e -> e.getLanguage() == language)
				.filter(e -> e.getCasus() == casus)
				.filter(e -> e.getNumerus() == numerus)
				.collect(Collectors.toSet());
	}

	@Override
	public String getBase() {
		return declinate(Casus.NOMINATIVE, Numerus.SINGULAR);
	}
}
