package ir.intechdev.firstdays.login

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import ir.intechdev.firstdays.R
import ir.intechdev.firstdays.api.ApiClient
import ir.intechdev.firstdays.api.ApiService
import ir.intechdev.firstdays.model.Login
import ir.intechdev.firstdays.model.Result
import ir.intechdev.firstdays.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginApiService(var context:Application) {
    private var apiService = ApiClient.getClient().create(ApiService::class.java)

    fun login(login:Login):MutableLiveData<Result>{
        val loginMutableLiveData = MutableLiveData<Result>()
        apiService.login(login).enqueue(object :Callback<Result>{
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                loginMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                Toast.makeText(context,R.string.connection_fail,Toast.LENGTH_SHORT).show()
                Log.i("LOG",t.toString())
            }

        })
        return loginMutableLiveData
    }
}