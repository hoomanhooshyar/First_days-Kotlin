package ir.intechdev.firstdays.profile

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import ir.intechdev.firstdays.R
import ir.intechdev.firstdays.api.ApiClient
import ir.intechdev.firstdays.api.ApiService
import ir.intechdev.firstdays.model.DtoUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileApiService(var context:Application) {
    private var profileApiService = ApiClient.getClient().create(ApiService::class.java)
    fun getUserData():MutableLiveData<DtoUser>{
        val profileMutable = MutableLiveData<DtoUser>()
        profileApiService.getUserData().enqueue(object:Callback<DtoUser>{
            override fun onResponse(call: Call<DtoUser>, response: Response<DtoUser>) {
                profileMutable.value = response.body()
            }

            override fun onFailure(call: Call<DtoUser>, t: Throwable) {
                Log.i("LOG",t.toString())
                Toast.makeText(context, R.string.connection_fail,Toast.LENGTH_SHORT).show()
            }

        })

        return profileMutable
    }
}