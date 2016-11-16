package com.p4fun.otinane.repository;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import com.p4fun.otinane.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
