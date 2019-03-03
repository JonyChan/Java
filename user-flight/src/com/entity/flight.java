package com.entity;

public class flight {
	private int id;
	private String launch;
	private String land;
	private String name;
	private String length;
	private int price;
	public flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public flight(int id, String launch, String land, String name,
			String length, int price) {
		super();
		this.id = id;
		this.launch = launch;
		this.land = land;
		this.name = name;
		this.length = length;
		this.price = price;
	}
	@Override
	public String toString() {
		return "flight [id=" + id + ", launch=" + launch + ", land=" + land
				+ ", name=" + name + ", length=" + length + ", price=" + price
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLaunch() {
		return launch;
	}
	public void setLaunch(String launch) {
		this.launch = launch;
	}
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
