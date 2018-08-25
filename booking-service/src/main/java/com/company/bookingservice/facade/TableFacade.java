package com.company.bookingservice.facade;

import com.company.bookingservice.commons.error.TableErrorType;
import com.company.bookingservice.commons.exception.FacadeException;
import com.company.bookingservice.dao.TableOfRestaurant;
import com.company.bookingservice.dto.TableDto;
import com.company.bookingservice.factory.TableFactory;
import com.company.bookingservice.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TableFacade {

    private TableService tableService;

    @Autowired
    public TableFacade(TableService tableService) {
        this.tableService = tableService;
    }

    public void addTable(TableDto tableDto) {
        checkForDetails(tableDto.getDetails());
        tableService.addTable(TableFactory.getTableFromDto(tableDto));
    }

    public List<TableDto> getAllTable() {
        List<TableOfRestaurant> tableOfRestaurantList = tableService.getAllTable();
        List<TableDto> tableDtoList = new ArrayList<>();
        for(TableOfRestaurant tableOfRestaurant : tableOfRestaurantList){
            tableDtoList.add(TableFactory.getTableDtoFromTableOfRestaurant(tableOfRestaurant));
        }
        return tableDtoList;
    }

    public TableDto getTableById(Integer id) {
        return TableFactory.getTableDtoFromTableOfRestaurant(tableService.getTableById(id));
    }

    public void updateTable(TableDto tableDto) {
        checkForDetails(tableDto.getDetails());
        checkForId(tableDto.getTableNo());
        tableService.updateTable(TableFactory.getTableFromDto(tableDto));
    }

    public void deleteTableById(Integer id) {
        checkForId(id);
        tableService.deleteTableById(id);
    }

    private void checkForId(Integer id) {
        if(id == null || id <= 0){
            throw new FacadeException(TableErrorType.EMPTY_OR_NEGATIVE_ID);
        }
    }

    private void checkForDetails(String details){
        if(details.length() == 0){
            throw new FacadeException(TableErrorType.EMPTY_DETAIL_NAME);
        }
    }
}
