package com.github.lebw.tacocloud.controller;

import com.github.lebw.tacocloud.domain.Ingredient;
import com.github.lebw.tacocloud.domain.Order;
import com.github.lebw.tacocloud.domain.Taco;
import com.github.lebw.tacocloud.repository.IngredientRepository;
import com.github.lebw.tacocloud.repository.TacoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.lebw.tacocloud.domain.Ingredient.Type;

import javax.validation.Valid;

/**
 * @author LBW
 */
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private TacoRepository tacoRepository;

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);

        Type[] types = Type.values();
        for (Type type: types) {
            List<Ingredient> filteredIngredients = new ArrayList<>();
            for (Ingredient ingredient: ingredients) {
                if (ingredient.getType() == type)
                    filteredIngredients.add(ingredient);
            }
            model.addAttribute(type.toString().toLowerCase(), filteredIngredients);
        }
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco taco, Errors errors, @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design";
        }

        Taco saved = tacoRepository.save(taco);

        order.getTacos().add(saved.getId());

        log.info("Processing design: " + taco);
        return "redirect:/orders/current";
    }
}
