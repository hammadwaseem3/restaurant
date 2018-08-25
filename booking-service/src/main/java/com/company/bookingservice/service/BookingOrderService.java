package com.company.bookingservice.service;

import com.company.bookingservice.dao.*;
import com.company.bookingservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class BookingOrderService {

    private CustomerRepository customerRepository;
    private BookingRepository bookingRepository;
    private OrderItemRepository orderItemRepository;
    private OrderOfRestaurantRepository orderOfRestaurantRepository;
    private TableOfRestaurantRepository tableOfRestaurantRepository;
    private MenuRepository menuRepository;
    private StaffRepository staffRepository;

    @Autowired
    public BookingOrderService(CustomerRepository customerRepository, BookingRepository bookingRepository,
                               OrderItemRepository orderItemRepository, OrderOfRestaurantRepository orderOfRestaurantRepository,
                               TableOfRestaurantRepository tableOfRestaurantRepository,
                               MenuRepository menuRepository, StaffRepository staffRepository) {

        this.customerRepository = customerRepository;
        this.bookingRepository = bookingRepository;
        this.orderItemRepository = orderItemRepository;
        this.orderOfRestaurantRepository = orderOfRestaurantRepository;
        this.tableOfRestaurantRepository = tableOfRestaurantRepository;
        this.menuRepository = menuRepository;
        this.staffRepository = staffRepository;
    }

    @Transactional
    public void addOrder(Integer tableOfRestaurantId, Customer customer, List<OrderItem> orderItemList,
                         Integer staffId) {
        customer = customerRepository.save(customer);
        TableOfRestaurant tableOfRestaurant = tableOfRestaurantRepository.getOne(tableOfRestaurantId);

        Booking booking = new Booking(new Date());
        booking.setTableOfRestaurant(tableOfRestaurant);
        booking.setCustomer(customer);

        booking = bookingRepository.save(booking);
        Integer totalAmount = getTotalPriceFromOrderList(orderItemList);

        Staff staff = staffRepository.getOne(staffId);
        OrderOfRestaurant orderOfRestaurant = OrderOfRestaurant.builder()
                .comments("")
                .totalPrice(totalAmount)
                .staff(staff)
                    .build();

        orderOfRestaurant = orderOfRestaurantRepository.save(orderOfRestaurant);
        for(OrderItem orderItem : orderItemList){
            orderItem.setOrderOfRestaurant(orderOfRestaurant);
            orderItem.setBooking(booking);
            orderItemRepository.save(orderItem);
        }
    }

    private Integer getTotalPriceFromOrderList(List<OrderItem> orderItemList){
        Integer totalAmount = 0;
        for(OrderItem orderItem : orderItemList){
            Menu menu = menuRepository.getOne(orderItem.getMenu().getMenuId());
            totalAmount = totalAmount + menu.getPrice();
        }
        return totalAmount;
    }
}
