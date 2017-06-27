package bank.bankToCentral;

import java.util.HashMap;

import bank.bean.Reservation;

public class ReservedRepository {

	private HashMap<String,Reservation> map=new HashMap<>();
	
	
	public HashMap<String, Reservation> getMap() {
		return map;
	}


	public void setMap(HashMap<String, Reservation> map) {
		this.map = map;
	}


	public void putIn(String x,Reservation r){
		map.put(x, r);
	}
	
}
