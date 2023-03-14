package com.humanCloud.SpringBootProjectHumanCloud.HandlingDatastructure;

public class MenuItem {

	private int id;
	private String itemName;

	public MenuItem() {

	}

	public MenuItem(int id, String string) {
		this.id = id;
		this.itemName = string;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
