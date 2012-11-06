package br.com.brr.model;

import br.com.brr.tools.StringManager;

public class Alarm {
	private int id;
	private String name;
	
	public Alarm() {
		super();
	}
	public Alarm(int id, String name) {
		super();
		setId(id);
		setName(name);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return StringManager.parseShowFormat(name);
	}
	public void setName(String name) {
		this.name = StringManager.parseStorageFormat(name);
	}
	
	

}
