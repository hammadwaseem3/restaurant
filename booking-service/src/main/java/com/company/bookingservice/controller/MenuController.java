package com.company.bookingservice.controller;

import com.company.bookingservice.dto.MenuDto;
import com.company.bookingservice.facade.MenuFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu/")
public class MenuController {

    private MenuFacade menuFacade;

    @Autowired
    public MenuController(MenuFacade menuFacade){
        this.menuFacade = menuFacade;
    }

    @RequestMapping(value = "getMenu", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<MenuDto> getMenu(){
        return menuFacade.getMenu();
    }

    @RequestMapping(value = "addIntoMenu", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addIntoMenu(
            @RequestBody MenuDto menuDto){
        menuFacade.addIntoMenu(menuDto);
    }

    @RequestMapping(value = "deleteFromMenuById/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteFromMenuById(
            @PathVariable("id") Integer id ) {
        menuFacade.deleteFromMenuById(id);
    }

    @RequestMapping(value = "addWholeMenu", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addWholeMenu(
            @RequestBody List<MenuDto> menuDtoList){
        //TODO: we can use saveAll method of springData instead of iteratively save each object and we can improve performance :)
        for(MenuDto menuDto: menuDtoList){
            menuFacade.addIntoMenu(menuDto);
        }
    }

}
