package com.bigcorp.booking.tpSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MonServiceTp {
	
	@Autowired
	private MonDaoTp monDaoTp;

	public MonDaoTp getMonDaoTp() {
		return monDaoTp;
	}

	public void setMonDaoTp(MonDaoTp monDaoTp) {
		this.monDaoTp = monDaoTp;
	}
	
	
}
