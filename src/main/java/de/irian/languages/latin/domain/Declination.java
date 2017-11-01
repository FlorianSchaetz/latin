package de.irian.languages.latin.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.util.Pair;

public enum Declination {
	
	A(new ADeclinator());

	private final Declinator declinator;
	
	private Declination(Declinator declinator) {
		this.declinator = declinator;
	}

	public String getSuffix(Casus aCase, Numerus number) {
		return this.declinator.getSuffix(aCase, number);
	}
	
	private static interface Declinator {		
		String getSuffix(Casus aCase, Numerus number);		
	}
	
	private static class ADeclinator implements Declinator {
		
		private final Map<Casus, Pair<String, String>> suffixes;
		
		private ADeclinator() {
			Map<Casus, Pair<String, String>> suffixes = new HashMap<>();
			suffixes.put(Casus.NOMINATIVE, Pair.of("a", "ae"));
			suffixes.put(Casus.GENITIVE, Pair.of("ae", "arum"));
			suffixes.put(Casus.DATIVE, Pair.of("ae", "îs"));
			suffixes.put(Casus.ACCUSATIVE, Pair.of("am", "âs"));
			suffixes.put(Casus.ABLATIVE, Pair.of("â", "îs"));
			suffixes.put(Casus.VOCATIVE, Pair.of("a", "ae"));
			this.suffixes = Collections.unmodifiableMap(suffixes);
		}

		@Override
		public String getSuffix(Casus aCase, Numerus number) {			
			if (number == Numerus.SINGULAR) {
				return suffixes.get(aCase).getFirst();
			}
			return suffixes.get(aCase).getSecond();
		}
		
	}
}