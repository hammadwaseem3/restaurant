package com.company.bookingservice.service;

import com.company.bookingservice.commons.error.BookingOrderErrorType;
import com.company.bookingservice.commons.error.MenuErrorType;
import com.company.bookingservice.commons.error.StaffErrorType;
import com.company.bookingservice.commons.error.TableErrorType;
import com.company.bookingservice.commons.exception.ServiceException;
import com.company.bookingservice.dao.*;
import com.company.bookingservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

        Optional<TableOfRestaurant> optionalTableOfRestaurant = tableOfRestaurantRepository.findById(tableOfRestaurantId);
        if(!optionalTableOfRestaurant.isPresent()){
            throw new ServiceException(TableErrorType.INVALID_TABLE_NUMBER);
        }

        Optional<Staff> optionalStaff = staffRepository.findById(staffId);
        if(!optionalStaff.isPresent()){
            throw new ServiceException(StaffErrorType.INVALID_STAFF_NUMBER);
        }

        Integer totalAmount = getTotalPriceFromOrderList(orderItemList);

        try {
            customer = customerRepository.save(customer);

            Booking booking = new Booking(new Date());
            booking.setTableOfRestaurant(optionalTableOfRestaurant.get());
            booking.setCustomer(customer);
            booking = bookingRepository.save(booking);

            OrderOfRestaurant orderOfRestaurant = OrderOfRestaurant.builder()
                    .comments("")
                    .totalPrice(totalAmount)
                    .staff(optionalStaff.get())
                    .build();
            orderOfRestaurant = orderOfRestaurantRepository.save(orderOfRestaurant);

            for (OrderItem orderItem : orderItemList) {
                orderItem.setOrderOfRestaurant(orderOfRestaurant);
                orderItem.setBooking(booking);
                orderItemRepository.save(orderItem);
            }

        } catch (Exception e){
            throw new ServiceException(BookingOrderErrorType.SOMETHING_BAD_HAPPENS);
        }
    }

    private Integer getTotalPriceFromOrderList(List<OrderItem> orderItemList){
        Integer totalAmount = 0;
        for(OrderItem orderItem : orderItemList){
            Optional<Menu> menu = menuRepository.findById(orderItem.getMenu().getMenuId());
            if(!menu.isPresent()){
                throw new ServiceException(MenuErrorType.INVALID_MENU_NUMBER);
            }
            totalAmount = totalAmount + menu.get().getPrice();
        }
        return totalAmount;
    }
}
