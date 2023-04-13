package com.example.finalapp.repositories;
import com.example.finalapp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryRepository,Integer> {
    Category findByName(String name);
}
