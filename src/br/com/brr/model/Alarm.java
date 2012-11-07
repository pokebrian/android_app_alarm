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
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return id + ";" + StringManager.parseStorageFormat(name) + "\n";
	}
	
	public static Alarm fromString(String str) throws Exception{
		String[] dados = str.split(";");

		if (dados.length == 2)
			return new Alarm(Integer.valueOf(dados[0]), StringManager.parseShowFormat(dados[1]));
		else
			throw new Exception("Falha ao recuperar o alarme do arquivo, strint: \"" + str + "\"");
	}

}
