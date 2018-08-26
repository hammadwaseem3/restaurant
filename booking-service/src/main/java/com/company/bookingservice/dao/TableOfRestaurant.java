package com.company.bookingservice.dao;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Table_Of_Resturant")
@NoArgsConstructor
@AllArgsConstructor
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

    public TableOfRestaurant(Integer tableNo, String details) {
        this.tableNo = tableNo;
        this.details = details;
    }

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
