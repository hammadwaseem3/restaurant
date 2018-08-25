package com.company.bookingservice.service;

import com.company.bookingservice.commons.error.TableErrorType;
import com.company.bookingservice.commons.exception.ServiceException;
import com.company.bookingservice.dao.TableOfRestaurant;
import com.company.bookingservice.repository.TableOfRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    private TableOfRestaurantRepository tableOfRestaurantRepository;

    @Autowired
    public TableService(TableOfRestaurantRepository tableOfRestaurantRepository) {
        this.tableOfRestaurantRepository = tableOfRestaurantRepository;
    }

    public void addTable(TableOfRestaurant tableOfRestaurant) {
        try {
            tableOfRestaurantRepository.save(tableOfRestaurant);
        }catch (Exception e){
            throw new ServiceException(TableErrorType.UNABLE_TO_INSERT);
        }
    }

    public List<TableOfRestaurant> getAllTable() {
        try {
            return tableOfRestaurantRepository.findAll();
        }catch (Exception e){
            throw new ServiceException(TableErrorType.SOMETHING_BAD_HAPPEN);
        }
    }

    public TableOfRestaurant getTableById(Integer id) {
        Optional<TableOfRestaurant> tableOfRestaurant = null;
        try {
            tableOfRestaurant = tableOfRestaurantRepository.findById(id);
        }catch (Exception e){
            throw new ServiceException(TableErrorType.SOMETHING_BAD_HAPPEN);
        }

        if(tableOfRestaurant != null && tableOfRestaurant.isPresent()){
            return tableOfRestaurant.get();
        }else{
            throw new ServiceException(TableErrorType.NO_TABLE_FOUND);
        }
    }

    public void updateTable(TableOfRestaurant tableOfRestaurant) {
        try {
            tableOfRestaurantRepository.save(tableOfRestaurant);
        }catch (Exception e){
            throw new ServiceException(TableErrorType.UNABLE_TO_UPDATE);
        }
    }

    public void deleteTableById(Integer id) {
        try {
            tableOfRestaurantRepository.deleteById(id);
        }catch (Exception e){
            throw new ServiceException(TableErrorType.UNABLE_TO_DELETE);
        }
    }
}
