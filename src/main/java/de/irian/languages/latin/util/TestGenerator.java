package de.irian.languages.latin.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import de.irian.languages.latin.domain.Casus;
import de.irian.languages.latin.domain.Noun;
import de.irian.languages.latin.domain.Numerus;
import de.irian.languages.latin.domain.Word;
import de.irian.languages.latin.questions.DeclinationQuestion;
import de.irian.languages.latin.questions.TranslateFromQuestion;

public class TestGenerator {

	private static Random r = new Random(new Date().getTime());

	public static DeclinationQuestion createDeclinationQuestion(Set<Noun> nouns, StudentConfig config) {

		List<Noun> applicableNouns = nouns.stream().filter(n -> config.getDeclinations().contains(n.getDeclination()))
				.collect(Collectors.toList());

		Noun noun = applicableNouns.get(r.nextInt(nouns.size()));

		List<Casus> applicableCasus = new ArrayList<>(config.getCasus());

		Casus casus = applicableCasus.get(r.nextInt(applicableCasus.size()));
		Numerus numerus = Numerus.values()[r.nextInt(Numerus.values().length)];

		return new DeclinationQuestion(noun, casus, numerus);

	}

	public static TranslateFromQuestion createTranslateFromQuestion(Set<Word> words, StudentConfig config) {
		List<Word> applicableWords = words.stream()
				.filter(w -> !w.getTranslations(config.getLanguage()).isEmpty())
				.collect(Collectors.toList());

		Word word = applicableWords.get(r.nextInt(applicableWords.size()));

		return new TranslateFromQuestion(word, config.getLanguage());
	}
}
