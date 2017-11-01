package de.irian.languages.latin.questions;

public interface EnterableQuestion extends Question {

	boolean isCorrect(String answer);

	String getCorrectAnswer();
}