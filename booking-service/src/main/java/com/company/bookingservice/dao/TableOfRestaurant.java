package com.company.bookingservice.dao;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Table_Of_Resturant")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class TableOfRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_no")
    private Integer tableNo;

    @Column(name = "details")
    private String details;

    @OneToMany(
            mappedBy = "tableOfRestaurant",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Booking> bookingList = new ArrayList<>();

    public TableOfRestaurant(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "TableOfRestaurant{" +
                "tableNo=" + tableNo +
                ", details='" + details + '\'' +
                '}';
    }
}
