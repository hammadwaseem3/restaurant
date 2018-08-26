package com.company.bookingservice.dao;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_numer")
    private String phoneNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "other_details")
    private String otherDetails;

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Booking> bookingList = new ArrayList<>();

    public Customer(Integer customerId, String firstName, String lastName, String phoneNumber, String emailAddress, String otherDetails) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.otherDetails = otherDetails;
    }

    public Customer(String firstName, String lastName, String phoneNumber, String emailAddress, String otherDetails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.otherDetails = otherDetails;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", otherDetails='" + otherDetails + '\'' +
                '}';
    }
}
