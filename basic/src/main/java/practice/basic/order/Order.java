package practice.basic.order;

import lombok.Data;

@Data
public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discount;

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discount = discountPrice;
    }

    public Order(Long memberId, String itemName, int itemPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int calculatePrice() {
        return itemPrice - discount;
    }
}
