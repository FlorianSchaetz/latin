package de.irian.languages.latin;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import de.irian.languages.latin.domain.Casus;
import de.irian.languages.latin.domain.Declination;
import de.irian.languages.latin.domain.Language;
import de.irian.languages.latin.domain.Noun;
import de.irian.languages.latin.domain.NounExample;
import de.irian.languages.latin.domain.Numerus;
import de.irian.languages.latin.domain.Word;
import de.irian.languages.latin.questions.DeclinationQuestion;
import de.irian.languages.latin.questions.EnterableQuestion;
import de.irian.languages.latin.questions.MultipleChoiceQuestion;
import de.irian.languages.latin.questions.TranslateFromQuestion;
import de.irian.languages.latin.questions.WordChecker;
import de.irian.languages.latin.repository.WordRepository;
import de.irian.languages.latin.util.StudentConfig;
import de.irian.languages.latin.util.TestGenerator;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(LatinApplication.class)
public class LatinApplicationTest {

	@Autowired
	public WordRepository nounRepository;

	@Test
	public void bla() {

		Word word = nounRepository.findOne(1L);
		assertThat(word).isNotNull();
		assertThat(word).isInstanceOf(Noun.class);

		Noun noun = (Noun) word;

		String declinated = noun.declinate(Casus.ACCUSATIVE, Numerus.PLURAL);

		assertThat(declinated).isEqualTo("nautâs");

		boolean sameWord = WordChecker.isSameWord(declinated, "nautas");

		assertThat(sameWord).as("Result of WordChecker test").isTrue();

		Set<String> germanTranslations = noun.getTranslations(Language.GERMAN);
		assertThat(germanTranslations).containsOnly("Seemann");

		Set<String> englishTranslations = noun.getTranslations(Language.ENGLISH);
		assertThat(englishTranslations).containsOnly("sailor");

		StudentConfig config = new StudentConfig();
		config.addDeclination(Declination.A);
		config.addCasus(Casus.values());

		try (Scanner scanner = new Scanner(System.in)) {
			DeclinationQuestion question = TestGenerator.createDeclinationQuestion(Collections.singleton(noun), config);

			askQuestion(question, scanner);

			TranslateFromQuestion question2 = TestGenerator.createTranslateFromQuestion(Collections.singleton(noun),
					config);
			askQuestion(question2, scanner);

		}
	}

	private void askQuestion(EnterableQuestion question, Scanner scanner) {
		System.out.println(question.getQuestion());

		if (question instanceof MultipleChoiceQuestion) {
			System.out.println(Arrays.toString(((MultipleChoiceQuestion) question).getPossibleAnswers()));
		}

		if (question instanceof DeclinationQuestion) {
			DeclinationQuestion dq = (DeclinationQuestion) question;
			for (NounExample ex : dq.getNoun().getExamples(Language.GERMAN)) {
				System.out.println(ex.getText() + " -> " + ex.getTranslation());
			}
		}

		String result = scanner.nextLine();

		boolean success = question.isCorrect(result);

		System.out.println(success);

		if (!success) {
			System.out.println("Correct: " + question.getCorrectAnswer());
		}
	}

}
