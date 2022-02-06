package com.springboot.nelioalves.repositories;

import java.util.List;

import com.springboot.nelioalves.entities.CategoryEntity;
import com.springboot.nelioalves.entities.ProductEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, Integer> {

  @Transactional(readOnly = true)

  Page<ProductEntity> findDistinctByNameContainingAndCategoriesIn(String name,
      List<CategoryEntity> categorias, Pageable pageRequest);
}

/**
 * @Query("SELECT DISTINCT obj FROM product obj INNER JOIN obj.categories cat
 * WHERE obj.name LIKE %:name% AND cat IN :categories")
 * Page<ProductEntity>
 * findDistinctByNameContainingAndCategoriesIn(@Param("name") String name,
 * @Param("categories") List<CategoryEntity> categorias, Pageable pageRequest);
 */