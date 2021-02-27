package ir.intechdev.firstdays.signup

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import ir.intechdev.firstdays.R
import ir.intechdev.firstdays.api.ApiClient
import ir.intechdev.firstdays.api.ApiService
import ir.intechdev.firstdays.model.Result
import ir.intechdev.firstdays.model.Signup
import ir.intechdev.firstdays.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupApiService(var context:Application) {
    private var signupApiService = ApiClient.getClient().create(ApiService::class.java)

    fun signup(user:Signup):MutableLiveData<Result>{
        val signupMutable = MutableLiveData<Result>()
        signupApiService.signup(user).enqueue(object:Callback<Result>{
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                signupMutable.value = response.body()
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                Toast.makeText(context,R.string.connection_fail,Toast.LENGTH_SHORT).show()
            }

        })

        return signupMutable
    }
}