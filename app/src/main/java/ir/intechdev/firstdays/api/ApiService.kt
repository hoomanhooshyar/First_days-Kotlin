package ir.intechdev.firstdays.api

import ir.intechdev.firstdays.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @POST("authentication/login")
    fun login(@Body login: Login):Call<Result>

    @POST("authentication/signup")
    fun signup(@Body user:Signup):Call<Result>

    @POST("authentication/get_user_data")
    fun getUserData():Call<DtoUser>
}