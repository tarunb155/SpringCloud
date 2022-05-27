package com.accenture.lkm.streams;
import java.util.*;
public class ProductUtility {
	public static List<Product1> getProductList(){
		List<Product1> productsList = new ArrayList<Product1>();  
        //Adding Products  
        productsList.add(new Product1(1,"HP Laptop",25000f,"N"));  
        productsList.add(new Product1(2,"TV",30000f,"O"));  
        productsList.add(new Product1(3,"Sony Handy Cam",28000f,"N"));  
        productsList.add(new Product1(4,"Washing Machine",28000f,"O"));  
        productsList.add(new Product1(5,"Ipod",90000f,"N"));
        //productsList.add(new Product1(5,"IFool",90000f,"N"));
        productsList.add(new Product1(6,"Ipad",25000f,"N"));  
        productsList.add(new Product1(7,"A.C.",30000f,"O"));  
        productsList.add(new Product1(8,"Fan",28000f,"N"));  
        productsList.add(new Product1(9,"Table",28000f,"O"));  
        productsList.add(new Product1(10,"Shoe Stand",90000f,"O"));
      //  productsList.add(new Product1(10,"Shoe Stand",90000f,"O"));
        //intential duplicate products
       // productsList.add(new Product1(9,"Table",28000f,"N"));  
        productsList.add(new Product1(10,"Shoe Stand_new.....",90000f,"O"));
        return productsList;
	}
}
