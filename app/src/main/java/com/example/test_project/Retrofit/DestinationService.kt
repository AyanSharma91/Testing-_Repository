package com.example.elite_classroom.Retrofit


import com.example.test_project.Retrofit_Models.Auth_Responses
import com.example.test_project.Retrofit_Models.Google_Logins
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface DestinationService {


    @POST("users/login")
    fun login_Google_User(@Body Google_Logins  : Google_Logins)   : Call<Auth_Responses>


}