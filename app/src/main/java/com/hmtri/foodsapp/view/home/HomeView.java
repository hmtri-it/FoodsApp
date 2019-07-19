/*-----------------------------------------------------------------------------
 - Developed by hmtri-it                                                      -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.hmtri.foodsapp.view.home;

import com.hmtri.foodsapp.model.Categories;
import com.hmtri.foodsapp.model.Meals;

import java.util.List;

public interface HomeView {
    /*
     * TODO Create void method
     *
     * The interface of this method will behave bridging between presenters to activities
     * then activity Overriding the interface
     *
     * 1. behavior, when loading must appear || showLoading();
     * 2. Loading must be removed || hideLoading()
     * 3. Display Meal data (with List <Meal> meals) parameters || setMeals();
     * 4. Displays Category data (with List parameters <Category> category) setCategories();
     * 5. and, Behavior when an error occurs when requesting data to the API
     */
    // TODO showLoading()

    void showLoading();
    void hideLoading();
    void setMeals(List<Meals.Meal> meal);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);

}
