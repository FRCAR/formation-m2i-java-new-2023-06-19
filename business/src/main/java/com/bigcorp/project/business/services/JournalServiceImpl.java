package com.bigcorp.project.business.services;

import java.util.HashMap;
import java.util.Map;

import com.bigcorp.project.data.model.Journal;

public class JournalServiceImpl implements JournalService {
	
	private Map<Long, Journal> journaux = new HashMap<>();

	@Override
	public void saveJournal(Journal journal) {
		journaux.put(journal.getId(), journal);
	}

	@Override
	public void deleteJournal(Journal journal) {
		journaux.remove(journal.getId());
	}
	
}
