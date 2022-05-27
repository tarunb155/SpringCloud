package com.accenture.lkm.streams;

public class Product1 {
	private Integer id;  
    private String name;  
    private float price;  
    private String productType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	@Override
	public String toString() {
		return "Product1 [id=" + id + ", name=" + name + ", price=" + price + ", productType=" + productType + "]";
	}
	public Product1(Integer id, String name, float price, String productType) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.productType = productType;
	}
    public Product1(){
    	
    }
}
