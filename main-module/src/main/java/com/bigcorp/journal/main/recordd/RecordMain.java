package com.bigcorp.journal.main.recordd;

import com.bigcorp.journal.main.sealedd.GeanteBleue;

public class RecordMain {
	
	public static void main(String[] args) {
		GeanteBleue geanteBleue = new GeanteBleue();
		DtoAsRecord testRecord1 = new DtoAsRecord(1, "Record 1", geanteBleue);
		System.out.println("L'identifiant de test Record est : " +  testRecord1.identifiant());
		
		System.out.println(testRecord1.toString());
		
		DtoAsRecord testRecord2 = new DtoAsRecord(1, "Record 1", geanteBleue);
		System.out.println(testRecord1 == testRecord2);
		System.out.println(testRecord1.equals(testRecord2));
		
	}

}
