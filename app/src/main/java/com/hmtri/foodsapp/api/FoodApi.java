/*-----------------------------------------------------------------------------
 - Developed by hmtri-it                                                      -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.hmtri.foodsapp.api;

import com.hmtri.foodsapp.model.Categories;
import com.hmtri.foodsapp.model.Meals;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodApi {

    @GET("latest.php")
    Call<Meals> getMeal();

    // TODO also make the Call like getMeals() method for category

    /*
     * @GET (" url ") -->
     *     this is the request annotation with REQUEST METHOD [GET]
     *
     * Call <Object> methodName(); -->
     *     we will make the getCategoris () method with the Call <Category> || method meaning
     *     that the result of the request [GET] will be accommodated into Object (Category)
     *
     */
    @GET("categories.php")
    Call<Categories> getCategories();
}
