/*-----------------------------------------------------------------------------
 - Developed by hmtri-it                                                      -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.hmtri.foodsapp.view.home;

import android.support.annotation.NonNull;

import com.hmtri.foodsapp.Utils;
import com.hmtri.foodsapp.model.Categories;
import com.hmtri.foodsapp.model.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class HomePresenter {

    private HomeView view;

    // TODO Create the constructor (View)


    public HomePresenter(HomeView view) {
        this.view = view;
    }

    void getMeals() {
        // TODO do loading before making a request to the server
        view.showLoading();

        // TODO with the line you have made a request
        Call<Meals> mealsCall = Utils.getApi().getMeal();

        // TODO waiting for Callback
        mealsCall.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(@NonNull Call<Meals> call, @NonNull Response<Meals> response) {
                // TODO Close loading when you have received a response from the server
                view.hideLoading();

                // TODO Non-empty results check & Non-empty results check
                if (response.isSuccessful() && response.body() != null) {
                    /*
                     * TODO 22 Receive the result
                     * input the results obtained into the setMeals() behavior
                     * and enter response.body() to the parameter
                     */
                    view.setMeals(response.body().getMeals());


                }
                else {
                    // TODO Show an error message if the conditions are not met
                    view.onErrorLoading(response.message());

                }
            }

            @Override
            public void onFailure(@NonNull Call<Meals> call, @NonNull Throwable t) {
                /*
                 * Failure will be thrown here
                 * for this you must do
                 * 1. closes loading
                 * 2. displays an error message
                 */

                // TODO Close loading
                view.hideLoading();
                // TODO Show an error message
                view.onErrorLoading(t.getLocalizedMessage());

            }
        });
    }


    void getCategories() {
        // TODO do loading before making a request to the server
        view.showLoading();
        // TODO create Call<Categories> categoriesCall = ...
        Call<Categories> categoriesCall = Utils.getApi().getCategories();

        // TODO waiting for enqueue Callback
        categoriesCall.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(@NonNull Call<Categories> call, @NonNull Response<Categories> response) {
                // TODO Non-empty results check & Non-empty results check
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    /*
                     * TODO Receive the result
                     * input the results obtained into the setMeals() behavior
                     * and enter response.body() to the parameter
                     */
                    view.setCategory(response.body().getCategories());


                }
                else {
                    // TODO Show an error message if the conditions are not met
                    view.onErrorLoading(response.message());

                }
            }

            @Override
            public void onFailure(@NonNull Call<Categories> call, @NonNull Throwable t) {
                /*
                 * Failure will be thrown here
                 * for this you must do
                 * 1. closes loading
                 * 2. displays an error message
                 */

                // TODO Close loading
                view.hideLoading();
                // TODO Show an error message
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
