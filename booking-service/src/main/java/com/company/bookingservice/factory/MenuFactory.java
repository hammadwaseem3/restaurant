package com.company.bookingservice.factory;

import com.company.bookingservice.dao.Menu;
import com.company.bookingservice.dto.MenuDto;

public class MenuFactory {

    public static Menu getMenuFromDto(MenuDto menuDto){
        return new Menu(menuDto.getMenuId(), menuDto.getMenuName(),menuDto.getMenuDetail(),menuDto.getPrice());
    }

    public static MenuDto getMenuDtoFromMenu(Menu menu){
        return new MenuDto(menu.getMenuId(), menu.getMenuName(), menu.getMenuDetail(), menu.getPrice());
    }
}
