package com.saramin.communication.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
