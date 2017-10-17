package com.bookstore.model;

public class HealthCheck {
	
	private String name;
	private String version;
	private boolean status;
	
	public HealthCheck() {

	}

	public HealthCheck(String name, String version, boolean status) {
		super();
		this.name = name;
		this.version = version;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "HealthCheck [name=" + name + ", version=" + version + ", status=" + status + "]";
	}
	
	

}
