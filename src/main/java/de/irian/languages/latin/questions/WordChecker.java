package de.irian.languages.latin.questions;

import org.apache.commons.lang3.StringUtils;

public class WordChecker {

	public static boolean isSameWord(String a, String b) {
		
		String wordA = unify(a);
		String wordB = unify(b);
				
		return wordA.equals(wordB);
	}
	
	private static String unify(String str) {
		if (str == null) {
			return "";
		}
		
		return StringUtils.stripAccents(str.toLowerCase().trim());
	}
	
}

