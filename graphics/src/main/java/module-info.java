import com.bigcorp.project.business.services.JournalService;
import com.bigcorp.project.data.contract.AddressService;

module com.bigcorp.project.graphics{

	requires com.bigcorp.project.business;
	exports com.bigcorp.project.graphics.windows;
	
	uses AddressService;
	uses JournalService;
}