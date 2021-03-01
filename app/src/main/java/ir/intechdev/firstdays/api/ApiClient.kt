package ir.intechdev.firstdays.api

import ir.intechdev.firstdays.utility.Token
import ir.intechdev.firstdays.utility.Utils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object{
        var retrofit:Retrofit? = null
        var baseUrl = "http://10.0.2.2:5000/api/"
        fun getClient():Retrofit{
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            if(retrofit == null){

                val okHttpClient = OkHttpClient().newBuilder()
                    .addInterceptor {
                        var oldRequest = it.request()
                        var newRequestBuilder = oldRequest.newBuilder()
                        if (Utils.myToken != null) {
                            newRequestBuilder.addHeader("HTTP_TOKEN", Utils.myToken!!)
                        }
                        newRequestBuilder.addHeader("Accept", "application/json")
                        newRequestBuilder.method(oldRequest.method, oldRequest.body)

                        return@addInterceptor it.proceed(newRequestBuilder.build())
                    }
                    .addInterceptor(loggingInterceptor)
                    .build()
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