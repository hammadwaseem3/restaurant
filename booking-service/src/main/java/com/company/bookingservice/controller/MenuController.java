package com.company.bookingservice.controller;

import com.company.bookingservice.dto.MenuDto;
import com.company.bookingservice.facade.MenuFacade;
import com.company.bookingservice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/menu/")
public class MenuController {

    MenuFacade menuFacade;

    @Autowired
    public MenuController(MenuFacade menuFacade){
        this.menuFacade = menuFacade;
    }

    @RequestMapping(name = "getMenu", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<MenuDto> getMenu(){
        return menuFacade.getMenu();
    }

    @RequestMapping(name = "addIntoMenu", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addIntoMenu(
            @RequestBody MenuDto menuDto){
        menuFacade.addIntoMenu(menuDto);
    }

    @RequestMapping(name = "deleteFromMenuById", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteFromMenuById(
            @RequestBody MenuDto menuDto) {
        menuFacade.deleteFromMenuById(menuDto);
    }

    @RequestMapping(name = "addWholeMenu", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addWholeMenu(
            @RequestBody List<MenuDto> menuDtoList){
        //TODO: we can use saveAll method of springData instead of iteratively save each object and we can improve performace :)
        for(MenuDto menuDto: menuDtoList){
            menuFacade.addIntoMenu(menuDto);
        }
    }

}
