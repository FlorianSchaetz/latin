package de.irian.languages.latin.questions;

import java.util.Set;

import de.irian.languages.latin.domain.Example;

public interface Question {
	String getQuestion();

	Set<? extends Example> getExamples();
}