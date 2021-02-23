package ir.intechdev.firstdays

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.AdapterView
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.luseen.spacenavigation.SpaceItem
import com.luseen.spacenavigation.SpaceOnClickListener
import ir.intechdev.firstdays.advisors.AdvisorsFragment
import ir.intechdev.firstdays.home.HomeFragment
import ir.intechdev.firstdays.login.LoginFragment
import ir.intechdev.firstdays.login.LoginViewModel
import ir.intechdev.firstdays.profile.ProfileFragment
import ir.intechdev.firstdays.utility.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var frmMain: FrameLayout
    lateinit var loginViewModel: LoginViewModel
    val manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        frmMain = findViewById(R.id.frm_mainActivity_mainLayout)
        Utils.createFragment(manager, HomeFragment(), false)
        bn_mainActivity_navigation.setItemSelected(R.id.menu_home)
        initializeBottomNavigation()
    }

    private fun initializeBottomNavigation() {

        var fragment: Fragment? = null
        bn_mainActivity_navigation.setOnItemSelectedListener(object :
            ChipNavigationBar.OnItemSelectedListener {
            override fun onItemSelected(id: Int) {
                when (id) {
                    R.id.menu_home -> {
                        fragment = HomeFragment()
                        Utils.createAnimation(frmMain, Techniques.SlideInRight, 700, 0)
                        Utils.createFragment(manager, fragment!!, true)
                    }
                    R.id.menu_profile -> {
                        val token = loginViewModel.getToken()
                        if (token.equals(""))
                            fragment = LoginFragment()
                        else
                            fragment = ProfileFragment()

                        Utils.createAnimation(frmMain, Techniques.SlideInRight, 700, 0)
                        Utils.createFragment(manager, fragment!!, true)
                    }
                    R.id.menu_advisors -> {
                        fragment = AdvisorsFragment()
                        Utils.createAnimation(frmMain, Techniques.SlideInRight, 700, 0)
                        Utils.createFragment(manager, fragment!!, true)
                    }
                }
            }

        })
    }
}