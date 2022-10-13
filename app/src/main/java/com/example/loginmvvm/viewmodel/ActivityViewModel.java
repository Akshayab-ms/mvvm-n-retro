package com.example.loginmvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loginmvvm.model.RetroInterface;
import com.example.loginmvvm.model.RetrofitClientInstance;
import com.example.loginmvvm.model.User;
import com.example.loginmvvm.model.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityViewModel extends ViewModel {
    private MutableLiveData<UserResponse> createNewUserLiveData;

    public ActivityViewModel() {
        createNewUserLiveData =new MutableLiveData<>();

    }
    public MutableLiveData<UserResponse>getCreateUserObserver(){
        return createNewUserLiveData;
    }
    public void createNewUser(User user){
        RetroInterface retroInterface= RetrofitClientInstance.getInstance().create(RetroInterface.class);
        Call<UserResponse> call = retroInterface.createUser(user);
    call.enqueue(new Callback<UserResponse>() {
        @Override
        public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
            if(response.isSuccessful()){
                createNewUserLiveData.postValue(response.body());
            }else{
                createNewUserLiveData.postValue(null);
            }
        }

        @Override
        public void onFailure(Call<UserResponse> call, Throwable t) {
            createNewUserLiveData.postValue(null);

        }
    });}
}
