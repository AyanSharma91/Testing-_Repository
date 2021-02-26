package com.example.test_project

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.elite_classroom.Retrofit.DestinationService
import com.example.elite_classroom.Retrofit.ServiceBuilder.buildService
import com.example.test_project.Retrofit_Models.Auth_Responses
import com.example.test_project.Retrofit_Models.Google_Logins
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val service = buildService(DestinationService::class.java)
        val request: Call<Auth_Responses> = service.login_Google_User(Google_Logins("example", "example@gmail.com", "ffuisfhdiuhd"))


        request.enqueue(object : Callback<Auth_Responses?> {
            override fun onResponse(call: Call<Auth_Responses?>, response: Response<Auth_Responses?>) {
                if (response.body() != null) {
                    Toast.makeText(this@MainActivity, response.body()!!.token.toString(),Toast.LENGTH_LONG).show()

                } else {

                    Toast.makeText(this@MainActivity, "Something is wrong",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Auth_Responses?>, t: Throwable) {
            }
        })

    }
}