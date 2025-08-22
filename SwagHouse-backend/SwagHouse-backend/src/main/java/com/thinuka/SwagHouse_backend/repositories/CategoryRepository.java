package com.thinuka.SwagHouse_backend.repositories;

import com.thinuka.SwagHouse_backend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
