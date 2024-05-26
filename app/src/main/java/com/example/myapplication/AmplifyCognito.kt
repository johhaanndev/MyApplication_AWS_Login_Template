package com.example.myapplication

import android.content.Context
import android.content.Intent
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
                loadConfirm(username)
            },
            {
                error ->
                Log.e("AmplifyCognito_SignUp", "Sign up failed", error)
            })
    }


    public fun confirm(username: String, code: String){
        Amplify.Auth.confirmSignUp(
            username,
            code,
            { result ->
                if (result.isSignUpComplete) {
                    Log.i("AmplifyCognito_Confirm", "Confirm signUp succeeded")
                    loadLogin()
                } else {
                }
                Log.i("AmplifyCognito_Confirm","Confirm sign up not complete")
            },
            { Log.e("AmplifyCognito_Confirm", "Failed to confirm sign up", it) }
        )
    }

    private fun loadConfirm(username: String) {
        val intent = Intent(context, ConfirmActivity::class.java)
        intent.putExtra("username", username)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    private fun loadLogin() {
        val intent = Intent(context, SignInActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

}
