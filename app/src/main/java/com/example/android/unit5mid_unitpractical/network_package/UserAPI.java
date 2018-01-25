package com.example.android.unit5mid_unitpractical.network_package;

/**
 * Created by C4Q on 1/24/18.
 */
import retrofit2.Call;
import retrofit2.http.GET;

import com.example.android.unit5mid_unitpractical.model.Results;

public interface UserAPI {

    @GET("/api/?nat=us&inc=name,location,cell,email,dob,picture&results=20")
    Call<Results> getResults();


}