package com.makhalibagas.sculpture.ViewModel;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.makhalibagas.sculpture.Model.Question.DataItem;
import com.makhalibagas.sculpture.Model.Question.ResponseData;
import com.makhalibagas.sculpture.Retrofit.ApiService;
import com.makhalibagas.sculpture.Retrofit.RetroConfig;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizViewModel extends ViewModel {

    private static MutableLiveData<List<DataItem>> dataList = new MutableLiveData<>();

    public void setDataList(Context context){
        ApiService apiService = RetroConfig.getRetrofit().create(ApiService.class);
        SharedPreferences preferences = context.getSharedPreferences("myPREF", Context.MODE_PRIVATE);
        String token = "Bearer "+ preferences.getString("TOKEN", "abc");
        Call<ResponseData> call = apiService.getQuestionData(token);
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if (response.body() != null){
                    List<DataItem> dataItemList = response.body().getData();
                    dataList.postValue(dataItemList);
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {

            }
        });
    }


    public LiveData<List<DataItem>> getDataList(){
        return dataList;
    }
}
