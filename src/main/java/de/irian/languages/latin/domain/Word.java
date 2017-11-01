package de.irian.languages.latin.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@Getter
@Setter
public class Word {

	@Id
	@GeneratedValue
	private long id;

	@OneToMany(mappedBy = "word", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Translation> translations;

	public Set<? extends Example> getExamples() {
		return new HashSet<>();
	}

	public Set<? extends Example> getExamples(Language language) {
		return new HashSet<>();
	}

	public Set<String> getTranslations(Language language) {
		return this.translations.stream().filter(l -> l.getLanguage() == language).map(Translation::getTranslation)
				.collect(Collectors.toSet());
	}

	public String getBase() {
		return "-?-";
	}
}
