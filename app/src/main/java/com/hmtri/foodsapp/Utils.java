/*-----------------------------------------------------------------------------
 - Developed by hmtri-it                                                      -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.hmtri.foodsapp;

import android.app.AlertDialog;
import android.content.Context;

import com.hmtri.foodsapp.api.FoodApi;
import com.hmtri.foodsapp.api.FoodClient;

public class Utils {

    public static FoodApi getApi() {
        return FoodClient.getFoodClient().create(FoodApi.class);
    }

    public static AlertDialog showDialogMessage(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
        return alertDialog;
    }
}
