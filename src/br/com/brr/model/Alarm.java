package br.com.brr.model;

public class Alarm {
	private int id;
	private String name;
	
	public Alarm() {
		super();
	}
	public Alarm(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
