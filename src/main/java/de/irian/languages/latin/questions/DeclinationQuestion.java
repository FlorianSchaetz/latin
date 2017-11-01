package de.irian.languages.latin.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import de.irian.languages.latin.domain.Casus;
import de.irian.languages.latin.domain.Language;
import de.irian.languages.latin.domain.Noun;
import de.irian.languages.latin.domain.NounExample;
import de.irian.languages.latin.domain.Numerus;

public class DeclinationQuestion implements MultipleChoiceQuestion {
	private final Noun noun;
	private final Casus casus;
	private final Numerus numerus;

	public DeclinationQuestion(Noun noun, Casus casus, Numerus numerus) {
		this.noun = noun;
		this.casus = casus;
		this.numerus = numerus;
	}

	public Noun getNoun() {
		return noun;
	}

	public Casus getCasus() {
		return casus;
	}

	public Numerus getNumerus() {
		return numerus;
	}

	@Override
	public boolean isCorrect(String answer) {
		return WordChecker.isSameWord(answer, getCorrectAnswer());
	}

	@Override
	public String getCorrectAnswer() {
		return getNoun().declinate(getCasus(), getNumerus());
	}

	@Override
	public String getQuestion() {
		return String.format("%s %s of '%s'?", getNumerus(), getCasus(),
				getNoun().declinate(Casus.NOMINATIVE, Numerus.SINGULAR));
	}

	@Override
	public String[] getPossibleAnswers() {

		List<String> answers = new ArrayList<>();
		answers.add(getNoun().declinate(getCasus(), getNumerus()));

		Random r = new Random(new Date().getTime());

		// ToDo Check Student config for allowed casus
		while (answers.size() < 4) {

			Casus casus = Casus.values()[r.nextInt(Casus.values().length)];
			Numerus numerus = Numerus.values()[r.nextInt(Numerus.values().length)];

			String answer = getNoun().declinate(casus, numerus);
			if (!answers.contains(answer)) {
				answers.add(answer);
			}
		}

		Collections.shuffle(answers);

		return answers.toArray(new String[answers.size()]);
	}

	@Override
	public Set<NounExample> getExamples() {
		return getNoun().getExamples(Language.GERMAN, getCasus(), getNumerus());
	}
}