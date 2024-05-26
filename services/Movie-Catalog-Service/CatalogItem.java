package com.example.demo;

public class CatalogItem {

	private String name;
	private String rating;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "CatalogItem [name=" + name + ", rating=" + rating + "]";
	}
	public CatalogItem(String name, String rating) {
		super();
		this.name = name;
		this.rating = rating;
	}
	public CatalogItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
