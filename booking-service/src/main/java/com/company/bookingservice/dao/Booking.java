package com.company.bookingservice.dao;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Booking")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer bookingId;

    @Column(name = "date_of_booking")
    private Date dateOfBooking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_no")
    private TableOfRestaurant tableOfRestaurant;

    @OneToMany(
            mappedBy = "booking",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderItem> orderItemList = new ArrayList<>();

    public Booking(Integer bookingId, Date dateOfBooking) {
        this.bookingId = bookingId;
        this.dateOfBooking = dateOfBooking;
    }

    public Booking(Date dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", dateOfBooking=" + dateOfBooking +
                '}';
    }
}
