package ir.intechdev.firstdays.api

import ir.intechdev.firstdays.model.Login
import ir.intechdev.firstdays.model.Result
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @POST("authentication/login")
    fun login(@Body login: Login):Call<Result>

    @FormUrlEncoded
    @POST("authentication/signup")
    fun signup(
        @Field("name") name:String,
        @Field("family") family:String,
        @Field("phone") phone:String,
        @Field("username") username:String,
        @Field("password") password: String,
        @Field("email") email:String,
        @Field("roleId") roleId:Int,
        @Field("age") age:Int,
        @Field("gender") gender:Int
    ):Call<Result>
}