package com.masai.service;

import java.util.List;

import com.masai.exception.OrderException;
import com.masai.module.OrderDetails;



public interface OrderService {
    
    public OrderDetails addOrder(OrderDetails order, Integer cartId) throws OrderException;

    public OrderDetails updateOrder(OrderDetails order) throws OrderException;

    public OrderDetails removeOrder(Integer orderId) throws OrderException;

    public OrderDetails viewOrder(Integer orderId) throws OrderException;

    public List<OrderDetails> getAllOrderDetails() throws OrderException;

    // public List<OrderDetails> getOrderDetailsByDate(LocalDate date) throws OrderException;

    // public List<OrderDetails> getOrderDetailsByCustomerId(Integer id) throws OrderException;

}
