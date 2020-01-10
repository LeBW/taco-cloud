package com.github.lebw.tacocloud.repository;

import com.github.lebw.tacocloud.domain.Ingredient;

/**
 * @author LBW
 */
public interface IngredientRepository {
    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);
}
