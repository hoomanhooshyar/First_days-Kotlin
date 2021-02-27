package ir.intechdev.firstdays.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques
import ir.intechdev.firstdays.R
import ir.intechdev.firstdays.home.HomeFragment
import ir.intechdev.firstdays.model.Signup
import ir.intechdev.firstdays.model.User
import ir.intechdev.firstdays.utility.Utils

class SignupFragment : Fragment() {

    private lateinit var edtName:EditText
    private lateinit var edtFamily:EditText
    private lateinit var edtMobile:EditText
    private lateinit var edtUsername:EditText
    private lateinit var edtPassword:EditText
    private lateinit var edtEmail:EditText
    private lateinit var edtAge:EditText
    private lateinit var btnRegister:Button
    private lateinit var rgAs:RadioGroup
    private lateinit var rgGender:RadioGroup
    private lateinit var rbMan:RadioButton
    private lateinit var rbAdvisor:RadioButton
    private lateinit var signupViewModel: SignupViewModel
    private var genderId:Int = 0
    private var roleId:Int = 2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_signup, container, false)
        signupViewModel = ViewModelProvider(this).get(SignupViewModel::class.java)
        /***************************Initialize Views***********************************************/
        edtName = view.findViewById(R.id.edt_signupFragment_name)
        edtFamily = view.findViewById(R.id.edt_signupFragment_family)
        edtMobile = view.findViewById(R.id.edt_signupFragment_mobile)
        edtUsername = view.findViewById(R.id.edt_signupFragment_username)
        edtPassword = view.findViewById(R.id.edt_signupFragment_password)
        edtEmail = view.findViewById(R.id.edt_signupFragment_email)
        edtAge = view.findViewById(R.id.edt_signupFragment_age)
        btnRegister = view.findViewById(R.id.btn_signupFragment_register)
        rgAs = view.findViewById(R.id.rg_signupFragment_as)
        rgGender = view.findViewById(R.id.rg_signupFragment_gender)
        rbAdvisor = view.findViewById(R.id.rb_signupFragment_advisor)
        rbMan = view.findViewById(R.id.rb_signupFragment_man)
        /***************************View Events*******************************************/
        //rgGender CLICK
        rgGender.setOnCheckedChangeListener{ _, checkedId ->
            genderId = if(checkedId == rbMan.id)
                1
            else
                0
        }
        //END rgGender CLICK

        //rgAs CLICK
        rgAs.setOnCheckedChangeListener{ _, checkedId ->
            roleId = if(checkedId == rbAdvisor.id)
                3
            else
                2
        }
        //END rgAs CLICK

        //btnRegister CLICK
        btnRegister.setOnClickListener {
            val name = edtName.text.toString()
            val family = edtFamily.text.toString()
            val mobile = edtMobile.text.toString()
            val username = edtUsername.text.toString()
            val password = edtPassword.text.toString()
            val email = edtEmail.text.toString()
            val age = edtAge.text.toString()
            if(name == ""){
                Utils.createAnimation(edtName,Techniques.Tada,300,0)
                Toast.makeText(context,R.string.empty_name,Toast.LENGTH_SHORT).show()
            }else if(family == ""){
                Utils.createAnimation(edtFamily,Techniques.Tada,300,0)
                Toast.makeText(context,R.string.empty_family,Toast.LENGTH_SHORT).show()
            }else if(mobile == ""){
                Utils.createAnimation(edtMobile,Techniques.Tada,300,0)
                Toast.makeText(context,R.string.empty_mobile,Toast.LENGTH_SHORT).show()
            }else if(!Utils.isValidMobile(mobile)){
                Utils.createAnimation(edtMobile,Techniques.Tada,300,0)
                Toast.makeText(context,R.string.invalid_mobile,Toast.LENGTH_SHORT).show()
            }else if(username == ""){
                Utils.createAnimation(edtUsername,Techniques.Tada,300,0)
                Toast.makeText(context,R.string.empty_username,Toast.LENGTH_SHORT).show()
            }else if(password == ""){
                Utils.createAnimation(edtPassword,Techniques.Tada,300,0)
                Toast.makeText(context,R.string.empty_password,Toast.LENGTH_SHORT).show()
            }else if(password.length < 6){
                Utils.createAnimation(edtPassword,Techniques.Tada,300,0)
                Toast.makeText(context,R.string.short_password,Toast.LENGTH_SHORT).show()
            }else if(email == ""){
                Utils.createAnimation(edtEmail,Techniques.Tada,300,0)
                Toast.makeText(context,R.string.empty_email,Toast.LENGTH_SHORT).show()
            }else if(!Utils.isValidEmail(email)){
                Utils.createAnimation(edtEmail,Techniques.Tada,300,0)
                Toast.makeText(context,R.string.invalid_email,Toast.LENGTH_SHORT).show()
            }else if(age == ""){
                Utils.createAnimation(edtAge,Techniques.Tada,300,0)
                Toast.makeText(context,R.string.empty_age,Toast.LENGTH_SHORT).show()
            }else if(age.toInt() < 15){
                Utils.createAnimation(edtAge,Techniques.Tada,300,0)
                Toast.makeText(context,R.string.illegal_age,Toast.LENGTH_SHORT).show()
            }else{
                val user = Signup(
                    name,
                    family,
                    username,
                    password,
                    email,
                    null,
                    mobile,
                    age.toInt(),
                    null,
                    null,
                    roleId,
                    genderId,
                    null,
                    null,
                    null)
                signupViewModel.signup(user).observe(viewLifecycleOwner,{
                    if(it.status < 0)
                        Toast.makeText(context,it.message,Toast.LENGTH_SHORT).show()
                    else{
                        val manager = activity?.supportFragmentManager
                        signupViewModel.setRoleId(it.status)
                        signupViewModel.setToken(it.message)
                        Toast.makeText(context,R.string.signup_successful,Toast.LENGTH_SHORT).show()
                        Utils.createAnimation(activity?.findViewById(R.id.frm_mainActivity_mainLayout),Techniques.SlideInRight,700,0)
                        Utils.createFragment(manager!!,HomeFragment(),false)
                    }
                })
            }
        }
        //END btnRegister CLICK

        return view
    }
}