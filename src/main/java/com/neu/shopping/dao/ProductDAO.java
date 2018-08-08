package com.neu.shopping.dao;

import com.neu.shopping.entity.Product;
import com.neu.shopping.model.PaginationResult;
import com.neu.shopping.model.ProductInfo;

public interface ProductDAO {  
    public Product findProduct(String code);
    
    public ProductInfo findProductInfo(String code) ;
  
    public PaginationResult<ProductInfo> queryProducts(int page,
                       int maxResult, int maxNavigationPage  );
    
    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult,
                       int maxNavigationPage, String likeName);
    public PaginationResult<ProductInfo> querySearchProducts(int page, int maxResult,
            int maxNavigationPage, String likeName);
 
    public void save(ProductInfo productInfo);
    
}