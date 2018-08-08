package com.neu.shopping.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.shopping.model.CustomerInfo;

@Component
public class CustomerInfoValidator implements Validator {
 
    private EmailValidator emailValidator = EmailValidator.getInstance();
 
    // This Validator support CustomerInfo class.
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == CustomerInfo.class;
    }
 
    @Override
    public void validate(Object target, Errors errors) {
        CustomerInfo custInfo = (CustomerInfo) target;
 
        // Check the fields of CustomerInfo class.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.customerForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.customerForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.customerForm.address");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.customerForm.phone");
 
        if (!emailValidator.isValid(custInfo.getEmail())) {
            errors.rejectValue("email", "Pattern.customerForm.email");
        }
        if(custInfo.getName().matches("^.*?(exec|execute|select|insert|update|delete|create|alter|drop|rename|truncate|backup|restore).*$") || custInfo.getName().matches("^.*?(=).*$") ||custInfo.getName().contains("*")) {
       	 errors.rejectValue("name", "Invalid.registerForm.value");
       }
        if(custInfo.getEmail().matches("^.*?(exec|execute|select|insert|update|delete|create|alter|drop|rename|truncate|backup|restore).*$") || custInfo.getEmail().matches("^.*?(or|and|=).*$") ||custInfo.getEmail().contains("*")) {
          	 errors.rejectValue("email", "Invalid.registerForm.value");
          }
        if(custInfo.getAddress().matches("^.*?(exec|execute|select|insert|update|delete|create|alter|drop|rename|truncate|backup|restore).*$") || custInfo.getAddress().matches("^.*?(or|and|=).*$")) {
          	 errors.rejectValue("address", "Invalid.registerForm.value");
          }
        if(custInfo.getPhone().matches("^.*?(exec|execute|select|insert|update|delete|create|alter|drop|rename|truncate|backup|restore).*$") || custInfo.getPhone().matches("^.*?(or|and|=).*$") ||custInfo.getPhone().contains("*")) {
          	 errors.rejectValue("phone", "Invalid.registerForm.value");
          }
    }
 
}