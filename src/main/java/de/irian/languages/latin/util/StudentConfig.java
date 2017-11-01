package de.irian.languages.latin.util;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

import de.irian.languages.latin.domain.Casus;
import de.irian.languages.latin.domain.Declination;
import de.irian.languages.latin.domain.Language;

public class StudentConfig {

	private EnumSet<Declination> declinations = EnumSet.noneOf(Declination.class);
	private EnumSet<Casus> casus = EnumSet.noneOf(Casus.class);
	private Language language = Language.GERMAN;
	
	public void addDeclination(Declination...declinations) {
		this.declinations.addAll(Arrays.asList(declinations));
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Set<Declination> getDeclinations() {
		return EnumSet.copyOf(declinations);
	}
	
	public void addCasus(Casus...casus) {
		this.casus.addAll(Arrays.asList(casus));
	}
	
	public Set<Casus> getCasus() {
		return EnumSet.copyOf(casus);
	}
}
