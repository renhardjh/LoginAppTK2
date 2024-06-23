package com.group4.loginapptk2.auth.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.group4.loginapptk2.R
import com.group4.loginapptk2.databinding.LoginMainBinding
import com.group4.loginapptk2.home.view.HomeActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginMainBinding
    private val expectedUser = "pengguna"
    private val expectedPswd = "masuk"

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = LoginMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.contentLogin.btnLogin.setOnClickListener {
            if (binding.contentLogin.etUserName.text.toString() == expectedUser && binding.contentLogin.etPswd.text.toString() == expectedPswd) {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                finish()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,
                    getString(R.string.username_or_password_is_wrong), Toast.LENGTH_SHORT).show()
            }
        }
    }
}