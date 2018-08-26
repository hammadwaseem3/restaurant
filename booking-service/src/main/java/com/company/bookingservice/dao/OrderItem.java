package com.company.bookingservice.dao;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Order_Item")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Integer orderItemId;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderOfRestaurant orderOfRestaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public OrderItem(Integer orderItemId, Integer quantity) {
        this.orderItemId = orderItemId;
        this.quantity = quantity;
    }

    public OrderItem(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", quantity=" + quantity +
                '}';
    }
}
