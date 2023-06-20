import com.bigcorp.project.data.contract.AddressService;
import com.bigcorp.project.data.repository.AddressServiceImpl;

module com.bigcorp.project.data.repository{
	exports com.bigcorp.project.data.model;
	exports com.bigcorp.project.data.repository;
	
	requires transitive com.bigcorp.project.data.contract;
	
	provides AddressService with AddressServiceImpl;
}