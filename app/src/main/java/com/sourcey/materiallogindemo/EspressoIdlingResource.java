package com.sourcey.materiallogindemo;

/**
 * Created by JirathEak on 17/3/2018 AD.
 */
import android.support.test.espresso.idling.CountingIdlingResource;

public class EspressoIdlingResource {

    private static final String RESOURCE = "GLOBAL";
    private static CountingIdlingResource countingIdlingResource = new CountingIdlingResource(RESOURCE, true);


//    public static CountingIdlingResource getCountingIdlingResource(){
//        return countingIdlingResource;
//    }

    public static CountingIdlingResource getCountingIdlingResource() {

        if (countingIdlingResource != null) {
            return countingIdlingResource;
        }
        return new CountingIdlingResource(RESOURCE);
    }

}