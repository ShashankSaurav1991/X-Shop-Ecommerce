package com.neu.shopping.dao;

import java.util.List;

import com.neu.shopping.model.CartInfo;
import com.neu.shopping.model.OrderDetailInfo;
import com.neu.shopping.model.OrderInfo;
import com.neu.shopping.model.PaginationResult;

public interface OrderDAO {
	 
    public void saveOrder(CartInfo cartInfo);
 
    public PaginationResult<OrderInfo> listOrderInfo(int page,
            int maxResult, int maxNavigationPage);
    
    public OrderInfo getOrderInfo(String orderId);
    
    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
 
}