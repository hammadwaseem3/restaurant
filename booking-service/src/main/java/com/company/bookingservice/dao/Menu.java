package com.company.bookingservice.dao;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Menu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Integer menuId;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_detail")
    private String menuDetail;

    @Column(name = "price")
    private Integer price;

    @OneToMany(
            mappedBy = "menu",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderItem> orderItemList = new ArrayList<>();

    public Menu(Integer menuId, String menuName, String menuDetail, Integer price) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuDetail = menuDetail;
        this.price = price;
    }

    public Menu(String menuName, String menuDetail, Integer price) {
        this.menuName = menuName;
        this.menuDetail = menuDetail;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuDetail='" + menuDetail + '\'' +
                ", price=" + price +
                '}';
    }
}
