package ir.intechdev.firstdays.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques
import ir.intechdev.firstdays.R
import ir.intechdev.firstdays.home.HomeFragment
import ir.intechdev.firstdays.model.Login
import ir.intechdev.firstdays.signup.SignupFragment
import ir.intechdev.firstdays.utility.Utils

class LoginFragment : Fragment() {

    private lateinit var edtUsername:EditText
    private lateinit var edtPassword:EditText
    private lateinit var btnLogin:Button
    private lateinit var btnRegister:Button
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_login, container, false)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        /*************************************Initialize Views*************************************/
        edtUsername = view.findViewById(R.id.edt_loginFragment_username)
        edtPassword = view.findViewById(R.id.edt_loginFragment_password)

        btnLogin = view.findViewById(R.id.btn_loginFragment_login)
        btnRegister = view.findViewById(R.id.btn_loginFragment_register)

        /*************************************Views Events*****************************************************/
        //Login Button onClickListener
        btnLogin.setOnClickListener {
            val username = edtUsername.text.toString()
            val password = edtPassword.text.toString()

            //Check EditTexts not Empty
            if(username.equals("")){
                Utils.createAnimation(edtUsername,Techniques.Tada,700,0)
                Toast.makeText(context,R.string.empty_username,Toast.LENGTH_SHORT).show()
            }else if(password.equals("")){
                Utils.createAnimation(edtUsername,Techniques.Tada,700,0)
                Toast.makeText(context,R.string.empty_password,Toast.LENGTH_SHORT).show()
            //End Check EditTexts not Empty

            //Connect to server and Check that username and password are match or not
            }else{
                val userLogin = Login(username,password)
                loginViewModel.login(userLogin).observe(viewLifecycleOwner,{
                    if(it.status < 0){
                        Toast.makeText(context,it.message,Toast.LENGTH_SHORT).show()
                    }else{
                        val manager = activity?.supportFragmentManager
                        loginViewModel.setToken(it.message)
                        loginViewModel.setRoleId(it.status)
                        Utils.createAnimation(activity?.findViewById(R.id.frm_mainActivity_mainLayout),Techniques.SlideInRight,700,0)
                        Utils.createFragment(manager!!,HomeFragment(),false)
                    }
                })
            }
            //End Connect to server and Check that username and password are match or not
        }
        //End Login Button onClickListener

        //Register Button onClickListener
        btnRegister.setOnClickListener {
            val manager = activity?.supportFragmentManager
            Utils.createAnimation(activity?.findViewById(R.id.frm_mainActivity_mainLayout),Techniques.SlideInRight,700,0)
            Utils.createFragment(manager!!,SignupFragment(),true)
        }
        //End Register Button onClickListener
        return view
    }

}