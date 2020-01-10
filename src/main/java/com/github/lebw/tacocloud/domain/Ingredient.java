package com.github.lebw.tacocloud.domain;

import lombok.Data;

/**
 * @author LBW
 */
@Data
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;


    public static enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
