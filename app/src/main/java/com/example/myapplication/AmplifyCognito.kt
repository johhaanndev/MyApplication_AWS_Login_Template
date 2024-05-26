package com.example.myapplication

import android.content.Context
import android.util.Log
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.core.Amplify

class AmplifyCognito(private val context: Context) {

    public fun SignUp(email: String, username: String, password: String) {
        val options = AuthSignUpOptions.builder()
            .userAttribute(AuthUserAttributeKey.email(), email)
            .build()

        Amplify.Auth.signUp(username, password, options,
            {
                result ->
                Log.i("AmplifyCognito_SignUp", "Result: $result")
            },
            {
                error ->
                Log.e("AmplifyCognito_SignUp", "Sign up failed", error)
            })

    }

}