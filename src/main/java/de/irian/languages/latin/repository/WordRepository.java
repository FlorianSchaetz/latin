package de.irian.languages.latin.repository;

import org.springframework.data.repository.CrudRepository;

import de.irian.languages.latin.domain.Word;

public interface WordRepository extends CrudRepository<Word, Long>{

}
