package com.bigcorp.booking.tpSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

@Component
public class MonControlerWebTp {
	@Autowired
	private MonServiceTp monServiceTp;

	public MonServiceTp getMonServiceTp() {
		return monServiceTp;
	}

	public void setMonServiceTp(MonServiceTp monServiceTp) {
		this.monServiceTp = monServiceTp;
	}
	
	
}
