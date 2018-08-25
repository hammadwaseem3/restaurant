package com.company.bookingservice.dao;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Order_Of_Resturant")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class OrderOfRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "comments")
    private String comments;

    @OneToMany(
            mappedBy = "orderOfRestaurant",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderItem> orderItemList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    private Staff staff;

    public OrderOfRestaurant(Integer totalPrice, String comments) {
        this.totalPrice = totalPrice;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "OrderOfRestaurant{" +
                "orderId=" + orderId +
                ", totalPrice=" + totalPrice +
                ", comments='" + comments + '\'' +
                '}';
    }
}
