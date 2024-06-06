package com.example.locationsharingapp.viewModel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthenticationViewModel : ViewModel() {

    private val firebaseAuth = FirebaseAuth.getInstance()

    //Login function.......
    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onSuccess()
                } else {
                    onFailure(task.exception?.message ?: "Login failed.")
                }
            }
    }

    //Register function........
    fun register(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onSuccess()
                } else {
                    onFailure(task.exception?.message ?: "Registration failed.")
                }
            }
    }


    //for Current user........
    fun getCurrentUserId(): String {
        return firebaseAuth.currentUser?.uid ?: ""
    }


    //for check if Login or not
    fun isLoggedIn(): Boolean {
        return firebaseAuth.currentUser != null
    }

    //for get the current user .......
    fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }
}