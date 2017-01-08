package com.p4fun.otinane.repository;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */
import com.p4fun.otinane.model.Inventory;
import com.p4fun.otinane.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findByUserId(int user_Id);


    @Modifying
    @Transactional
    @Query(value = "delete from inventory where user_id=?1", nativeQuery = true)
    void resetAccount(int userid);
}