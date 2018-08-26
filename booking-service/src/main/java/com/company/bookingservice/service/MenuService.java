package com.company.bookingservice.service;

import com.company.bookingservice.commons.error.MenuErrorType;
import com.company.bookingservice.commons.exception.ServiceException;
import com.company.bookingservice.dao.Menu;
import com.company.bookingservice.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    private MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void addIntoMenu(Menu menu) {
        try {
            menuRepository.save(menu);
        }catch (Exception e){
            throw new ServiceException(MenuErrorType.UNABLE_TO_INSERT);
        }
    }

    public void deleteFromMenuById(Integer menuId) {
        try {
            menuRepository.deleteById(menuId);
        }catch (Exception e){
            throw new ServiceException(MenuErrorType.UNABLE_TO_DELETE);
        }
    }

    public List<Menu> getMenu() {
        try {
            return menuRepository.findAll();
        }catch (Exception e){
            throw new ServiceException(MenuErrorType.SOMETHING_BAD_HAPPEN);
        }
    }
}
