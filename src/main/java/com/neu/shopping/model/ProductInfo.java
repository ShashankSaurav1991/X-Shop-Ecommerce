package com.neu.shopping.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.neu.shopping.entity.Product;

public class ProductInfo {
    private String code;
    private String name;
    private double price;
    
    private String manufacturer;
    private String category;
    private String productType;
    private String productSubType;
    private String desciption;
    
    
 
    public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductSubType() {
		return productSubType;
	}

	public void setProductSubType(String productSubType) {
		this.productSubType = productSubType;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	private boolean newProduct=false;
 
    // Upload file.
    private CommonsMultipartFile fileData;
 
    public ProductInfo() {
    }
 
    public ProductInfo(Product product) {
        this.code = product.getCode();
        this.name = product.getName();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.manufacturer = product.getManufacturer();
        this.productType = product.getProductType();
        this.productSubType = product.getProductSubType();
    }
 
    public ProductInfo(String code, String name, double price, String category, String productType, String productSubType,String manufacturer) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.category = category;
        this.productType = productType;
        this.productSubType = productSubType;
        this.manufacturer = manufacturer;
    }
 
    public String getCode() {
        return code;
    }
 
    public void setCode(String code) {
        this.code = code;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
    public CommonsMultipartFile getFileData() {
        return fileData;
    }
 
    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }
 
    public boolean isNewProduct() {
        return newProduct;
    }
 
    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }
 
}