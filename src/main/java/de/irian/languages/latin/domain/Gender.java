package de.irian.languages.latin.domain;

public enum Gender {

	FEMALE("f"),
	MALE("m"),
	NEUTRUM("n");
	
	private final String shortcut;
	
	private Gender(String shortcut) {
		this.shortcut = shortcut;
	}

	public String getShortcut() {
		return shortcut;
	}
}
