package com.hrsoft.enums;

public enum ManagerViewTabsType {

	DASHBOARD("Dashboard"), MY_TEAM("My Team"), COMPENSATION_STATEMENT("Compensation Statement"), REPORTS("Reports");
	
	private final String name;

	ManagerViewTabsType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
