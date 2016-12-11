package com.p4fun.otinane.repository;

import com.p4fun.otinane.model.Inventory;
import com.p4fun.otinane.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hrystos on 7/12/2016.
 */

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findByUserId(int user_Id);

}