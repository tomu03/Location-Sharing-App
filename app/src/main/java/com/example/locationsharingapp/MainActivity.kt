package com.example.locationsharingapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.Debug.getLocation
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.locationsharingapp.adapter.UserAdapter
import com.example.locationsharingapp.viewModel.AuthenticationViewModel
import com.example.locationsharingapp.viewModel.FirestoreViewModel
import com.example.locationsharingapp.viewModel.LocationViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var authViewModel: AuthenticationViewModel

    private lateinit var firestoreViewModel: FirestoreViewModel
    private lateinit var userAdapter: UserAdapter
    private lateinit var recyclerViewUsers: RecyclerView
    private lateinit var locationBtn: FloatingActionButton

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navview: NavigationView
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    private lateinit var locationViewModel: LocationViewModel
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                getLocation()
            } else {
                // Permission denied
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

    }
}