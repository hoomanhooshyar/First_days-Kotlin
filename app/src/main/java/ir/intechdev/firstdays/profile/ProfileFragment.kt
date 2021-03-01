package ir.intechdev.firstdays.profile

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques
import com.mikhaellopez.circularimageview.CircularImageView
import com.squareup.picasso.Picasso
import ir.intechdev.firstdays.R
import ir.intechdev.firstdays.api_local.LocalViewModel
import ir.intechdev.firstdays.api_local.entities.CountryCitiesEntity
import ir.intechdev.firstdays.api_local.entities.StudyFieldsEntity
import ir.intechdev.firstdays.api_local.entities.UsersEntity
import ir.intechdev.firstdays.login.LoginFragment
import ir.intechdev.firstdays.utility.Utils

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var linAddPic:LinearLayout
    private lateinit var cimgProfile:CircularImageView
    private lateinit var localViewModel:LocalViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        /************************************Initialize Views**************************************/
        linAddPic = view.findViewById(R.id.linear_profileFragment_changePhoto)
        cimgProfile = view.findViewById(R.id.cimg_profileFragment_profileImg)
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        localViewModel = ViewModelProvider(this).get(LocalViewModel::class.java)
        /************************************Fetch Data********************************************/
        //Get user data from server
        profileViewModel.getUserData().observe(viewLifecycleOwner,{
            if(it == null || it.id == -1){
                val manager = activity?.supportFragmentManager
                Toast.makeText(context,R.string.not_login,Toast.LENGTH_SHORT).show()
                Utils.createAnimation(activity?.findViewById(R.id.frm_mainActivity_mainLayout),Techniques.SlideInRight,700,0)
                Utils.createFragment(manager!!,LoginFragment(),true)
            }else{
                if(it.image == null){
                    if(it.gender == 1){
                        cimgProfile.setImageResource(R.drawable.man)
                    }else{
                        cimgProfile.setImageResource(R.drawable.woman)
                    }
                }else{
                    Picasso.get().load(it.image).into(cimgProfile)
                }
                Toast.makeText(context,"${it.name} ${it.family}",Toast.LENGTH_SHORT).show()
                //Add data to local DB
                var user = UsersEntity(
                    id = 0,
                    name = it.name,
                    family = it.family,
                    email = it.email,
                    username = it.username,
                    password = it.password,
                    token = it.token,
                    age = it.age,
                    countryCityId = 1,
                    credit = it.credit,
                    gender = it.gender,
                    image = it.image,
                    mobile = it.mobile,
                    phone = it.phone,
                    roleId = it.roleId,
                    setting = it.setting,
                    status = it.status,
                    studyFieldId = 1
                )
                localViewModel.insertProfileData(user)
                Toast.makeText(context,"با موفقیت ثبت شد",Toast.LENGTH_SHORT).show()
                //End Add data to local DB
            }
        })
        return view
    }
}