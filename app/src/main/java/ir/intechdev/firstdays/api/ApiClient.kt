package ir.intechdev.firstdays.api

import ir.intechdev.firstdays.utility.Token
import ir.intechdev.firstdays.utility.Utils
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        var retrofit:Retrofit? = null
        var baseUrl = "http://10.0.2.2:5000/api/"
        fun getClient():Retrofit{
            if(retrofit == null){
                var okHttpClient = OkHttpClient().newBuilder()
                    .addInterceptor {
                        var oldRequest = it.request()
                        var newRequestBuilder = oldRequest.newBuilder()
                        if (Utils.myToken != null) {
                            newRequestBuilder.addHeader("token", Utils.myToken!!)
                        }
                        newRequestBuilder.addHeader("Accept", "application/json")
                        newRequestBuilder.method(oldRequest.method, oldRequest.body)
                        return@addInterceptor it.proceed(newRequestBuilder.build())
                    }.build()
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
            }
            return retrofit!!
        }
    }
}