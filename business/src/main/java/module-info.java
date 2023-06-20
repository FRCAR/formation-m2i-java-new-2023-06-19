import com.bigcorp.project.business.services.JournalService;
import com.bigcorp.project.business.services.JournalServiceImpl;

module com.bigcorp.project.business{
	
	exports com.bigcorp.project.business.services;
	requires transitive com.bigcorp.project.data.repository;
	
	provides JournalService with JournalServiceImpl;
}