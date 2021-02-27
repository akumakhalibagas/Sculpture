package com.makhalibagas.sculpture.Retrofit;

import com.makhalibagas.sculpture.Model.Login.Login;
import com.makhalibagas.sculpture.Model.Question.ResponseData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {


    @GET("api/quiz/all")
    Call<ResponseData> getQuestionData(@Header("Authorization") String auth);

    @FormUrlEncoded
    @POST("api/users/login")
    Call<Login> getLogin(@Field("email") String email, @Field("password") String password, @Field("code") int code);


    @FormUrlEncoded
    @POST("api/users/register")
    Call<Login> getRegister(@Field("username") String username,@Field("fullname") String name,@Field("email") String email, @Field("password") String password, @Field("code") int code);


}
