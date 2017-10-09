package com.task.currencyconverter.injection.repository.remote.api;

import com.task.currencyconverter.injection.repository.remote.misc.API;
import com.task.currencyconverter.injection.repository.remote.model.User;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface CommonApi {

    @FormUrlEncoded
    @POST(API.USER)
    Observable<User> getUser(@Field("userId") String userId, @Field("type") int type);

    @FormUrlEncoded
    @POST(API.USER)
    Observable<ResponseBody> loginUser(@Field("type") int type, @Field("email") String email, @Field("password") String password);

    @Multipart
    @Headers("Content-type:multipart/form-data")
    @POST(API.USER)
    Observable<ResponseBody> uploadProfilePicture(@Field("type") int type, @Part("userId") RequestBody userId, @Part MultipartBody.Part file);


}