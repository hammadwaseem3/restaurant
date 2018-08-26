package com.company.bookingservice.facade;

import com.company.bookingservice.commons.error.MenuErrorType;
import com.company.bookingservice.commons.exception.FacadeException;
import com.company.bookingservice.commons.exception.ServiceException;
import com.company.bookingservice.dao.Menu;
import com.company.bookingservice.dto.MenuDto;
import com.company.bookingservice.factory.MenuFactory;
import com.company.bookingservice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuFacade {

    private MenuService menuService;

    @Autowired
    public MenuFacade(MenuService menuService) {
        this.menuService = menuService;
    }

    public void addIntoMenu(MenuDto menuDto) {
        if(menuDto.getPrice() < 0){
            throw new FacadeException(MenuErrorType.PRICE_CANNOT_BE_NEGATIVE);
        }
        Menu menu = MenuFactory.getMenuFromDto(menuDto);
        menuService.addIntoMenu(menu);
    }

    public void deleteFromMenuById(Integer id) {
        if(id == null){
            throw new ServiceException(MenuErrorType.NO_ID_SPECIFIED);
        }
        menuService.deleteFromMenuById(id);
    }

    public List<MenuDto> getMenu() {
        List<Menu> menuList = menuService.getMenu();
        List<MenuDto> menuDtoList = new ArrayList<>();
        for(Menu menu : menuList){
            menuDtoList.add(MenuFactory.getMenuDtoFromMenu(menu));
        }
        return menuDtoList;
    }
}
