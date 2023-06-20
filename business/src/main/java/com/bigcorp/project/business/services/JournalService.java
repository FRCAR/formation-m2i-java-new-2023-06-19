package com.bigcorp.project.business.services;

import com.bigcorp.project.data.model.Journal;

public interface JournalService {
	
	void saveJournal(Journal journal);
	
	void deleteJournal(Journal journal);

}
