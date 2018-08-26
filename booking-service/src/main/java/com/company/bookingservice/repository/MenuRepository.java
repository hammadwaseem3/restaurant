package com.company.bookingservice.repository;

import com.company.bookingservice.dao.Menu;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu,Integer> {
//
//    @Cacheable(cacheNames = "redisCache", key = "'allMenu'")
//    List<Menu> findAll();
//
//    @CacheEvict(cacheNames = "redisCache", key = "'allMenu'")
//    Menu save(Menu menu);
//
//    @Caching(evict = {
//            @CacheEvict(cacheNames = "redisCache", key="'allMenu'"),
//            @CacheEvict(cacheNames = "redisCache", key="'menu:'.concat(#root.args)")
//    })
//    void deleteById(Integer id);
//
//    @Cacheable(cacheNames = "redisCache", key = "'menu-'.concat(#root.args)")
//    Optional<Menu> findById(Integer id);
}
