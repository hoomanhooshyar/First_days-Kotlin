package ir.intechdev.firstdays.utility

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import ir.intechdev.firstdays.R

/**
 * This class is for functions that use in application that are public and almost all features and other classes use them
 */

object Utils {
    var myToken:String? = null

    //This method is for creating animation for views
    fun createAnimation(view: View?, techniques: Techniques,duration: Long,repeat:Int){
        YoYo.with(techniques)
                .duration(duration)
                .repeat(repeat)
                .playOn(view)
    }

    //This method is for switching between fragments
    fun createFragment(manager: FragmentManager,fragment: Fragment,isBack:Boolean){
        val transaction: FragmentTransaction =manager.beginTransaction()
        transaction.replace(R.id.frm_mainActivity_mainLayout,fragment)
        if(isBack)
            transaction.addToBackStack(null)
        transaction.commit()
    }
}