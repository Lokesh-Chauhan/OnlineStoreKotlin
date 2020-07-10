package com.example.onlinestorekotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setTitle("SignUp")

        btnSignupSignup.setOnClickListener {
            if (edtSignupPassword.text.toString().equals(edtSignupConfirmPassword.text.toString())){
                val serverURL="https://192.168.43.12/OnlineStoreApp/join_new_user.php?email="+
                        edtSignupEmail.text.toString()+"&name="+edtSignupUsername.text.toString()+
                        "&pass="+edtSignupPassword.text.toString()
                var requestQueue:RequestQueue=Volley.newRequestQueue(this@SignUpActivity)
                val stringRequestQueue= StringRequest(Request.Method.GET,serverURL,Response.Listener {
                    response -> textView.text=response
                },Response.ErrorListener { error -> textView.text=error.message  })
                requestQueue.add(stringRequestQueue)
            }
        }

        btnSignupLogin.setOnClickListener {
            finish()
        }
    }
}