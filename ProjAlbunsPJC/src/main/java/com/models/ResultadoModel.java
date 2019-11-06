package com.models;

public class ResultadoModel {
	private int ID;
	private String MSG;
 
	public ResultadoModel(){
 
	}
 
	public ResultadoModel(int ID, String MSG) {
		super();
		this.ID = ID;
		this.MSG = MSG;
	}
 
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getMSG() {
		return MSG;
	}
	public void setMSG(String MSG) {
		this.MSG = MSG;
	}
}
