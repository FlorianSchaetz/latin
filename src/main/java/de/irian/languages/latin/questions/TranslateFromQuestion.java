package de.irian.languages.latin.questions;

import java.util.Set;

import de.irian.languages.latin.domain.Example;
import de.irian.languages.latin.domain.Language;
import de.irian.languages.latin.domain.Word;

public class TranslateFromQuestion implements EnterableQuestion {
	private final Word word;
	private final Language language;

	public TranslateFromQuestion(Word word, Language language) {
		this.word = word;
		this.language = language;
	}

	public Word getWord() {
		return word;
	}

	public Language getLanguage() {
		return language;
	}

	@Override
	public boolean isCorrect(String answer) {
		return getWord().getTranslations(language).stream()
				.filter(s -> WordChecker.isSameWord(answer, s))
				.findFirst()
				.isPresent();
	}

	@Override
	public String getCorrectAnswer() {
		return getWord().getTranslations(language).toString();
	}

	@Override
	public String getQuestion() {
		return String.format("Translate '%s' into %s.", word.getBase(), language);
	}

	@Override
	public Set<? extends Example> getExamples() {
		return getWord().getExamples(language);
	}
}