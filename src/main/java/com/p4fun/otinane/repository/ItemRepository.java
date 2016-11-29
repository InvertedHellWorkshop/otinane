package com.p4fun.otinane.repository;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import com.p4fun.otinane.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByName(String name);

    @Query(value = "select * from item", nativeQuery = true)
    List<Item> GetAll();
}
