package com.example.android.unit5mid_unitpractical.network_package;

/**
 * Created by C4Q on 1/24/18.
 */
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.example.android.unit5mid_unitpractical.controller.UserAdapter;
import com.example.android.unit5mid_unitpractical.model.Results;
import com.example.android.unit5mid_unitpractical.model.User;

import retrofit2.Call;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserAPIClient implements retrofit2.Callback<Results> {

    final static String BASE_URL = "https://randomuser.me";
    Results result;
    List<User> userList = new ArrayList<>();
    RecyclerView recyclerView;

    public UserAPIClient(RecyclerView recView){
        recyclerView = recView;
    }



    public void start(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserAPI userAPI = retrofit.create(UserAPI.class);
        Call<Results> call = userAPI.getResults();
        call.enqueue(this);
    }




    @Override
    public void onResponse(Call<Results> call, Response<Results> response) {
        result = response.body();
        userList = result.getResults();
        UserAdapter adapter = new UserAdapter(userList);
        recyclerView.setAdapter(adapter);
        Log.d("CALLCHECK","SUCCESS");


    }

    @Override
    public void onFailure(Call<Results> call, Throwable t) {
        t.printStackTrace();

    }


    public List<User> getUserList() {
        return userList;
    }
}