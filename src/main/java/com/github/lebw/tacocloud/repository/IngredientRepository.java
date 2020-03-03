package com.github.lebw.tacocloud.repository;

import com.github.lebw.tacocloud.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * @author LBW
 */
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
//    Iterable<Ingredient> findAll();
//
//    Ingredient findOne(String id);
//
//    Ingredient save(Ingredient ingredient);
}
