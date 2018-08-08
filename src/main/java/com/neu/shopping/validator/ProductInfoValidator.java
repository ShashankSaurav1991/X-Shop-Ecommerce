package com.neu.shopping.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.shopping.dao.ProductDAO;
import com.neu.shopping.entity.Product;
import com.neu.shopping.model.ProductInfo;

@Component
public class ProductInfoValidator implements Validator {
 
    @Autowired
    private ProductDAO productDAO;
 
    // This Validator support ProductInfo class.
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == ProductInfo.class;
    }
 
    @Override
    public void validate(Object target, Errors errors) {
        ProductInfo productInfo = (ProductInfo) target;
 
        // Check the fields of ProductInfo class.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "NotEmpty.productForm.code");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.productForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.productForm.price");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "NotEmpty.productForm.category");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productType", "NotEmpty.productForm.productType");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productSubType", "NotEmpty.productForm.productSubType");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manufacturer", "NotEmpty.productForm.manufacturer");
 
        String code = productInfo.getCode();
        if (code != null && code.length() > 0) {
            if (code.matches("\\s+")) {
                errors.rejectValue("code", "Pattern.productForm.code");
            } else if(productInfo.isNewProduct()) {
                Product product = productDAO.findProduct(code);
                if (product != null) {
                    errors.rejectValue("code", "Duplicate.productForm.code");
                }
            }
        }
        
        if(productInfo.getCategory().matches("^.*?(exec|execute|select|insert|update|delete|create|alter|drop|rename|truncate|backup|restore).*$") || productInfo.getCategory().matches("^.*?(or|and|=).*$") ||productInfo.getCategory().contains("*")) {
        	 errors.rejectValue("category", "Invalid.productForm.value");
        }
        if(productInfo.getManufacturer().matches("^.*?(exec|execute|select|insert|update|delete|create|alter|drop|rename|truncate|backup|restore).*$") || productInfo.getManufacturer().matches("^.*?(or|and|=).*$") ||productInfo.getManufacturer().contains("*")) {
        	errors.rejectValue("manufacturer", "Invalid.productForm.value");
        }
        if(productInfo.getProductType().matches("^.*?(exec|execute|select|insert|update|delete|create|alter|drop|rename|truncate|backup|restore).*$") || productInfo.getProductType().matches("^.*?(or|and|=).*$") ||productInfo.getProductType().contains("*")) {
        	errors.rejectValue("productType", "Invalid.productForm.value");
        }
        if(productInfo.getProductSubType().matches("^.*?(exec|execute|select|insert|update|delete|create|alter|drop|rename|truncate|backup|restore).*$") || productInfo.getProductSubType().matches("^.*?(or|and|=).*$") ||productInfo.getProductSubType().contains("*")) {
        	errors.rejectValue("productSubType", "Invalid.productForm.value");
        }
        if(productInfo.getName().matches("^.*?(exec|execute|select|insert|update|delete|create|alter|drop|rename|truncate|backup|restore).*$") || productInfo.getName().matches("^.*?(or|and|=).*$") ||productInfo.getName().contains("*")) {
        	errors.rejectValue("name", "Invalid.productForm.value");
        }
        if(productInfo.getCode().matches("^.*?(exec|execute|select|insert|update|delete|create|alter|drop|rename|truncate|backup|restore).*$") || productInfo.getCode().matches("^.*?(or|and|=).*$") ||productInfo.getCode().contains("*")) {
        	errors.rejectValue("code", "Invalid.productForm.value");
        }
    }
 
}
