package ir.intechdev.firstdays.api

import ir.intechdev.firstdays.model.Login
import ir.intechdev.firstdays.model.Result
import ir.intechdev.firstdays.model.Signup
import ir.intechdev.firstdays.model.User
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
}