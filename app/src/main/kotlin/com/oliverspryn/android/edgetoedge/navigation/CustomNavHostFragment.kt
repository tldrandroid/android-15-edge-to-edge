package com.oliverspryn.android.edgetoedge.navigation

import android.annotation.SuppressLint
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.plusAssign
import com.oliverspryn.android.edgetoedge.di.assisted.CustomFragmentNavigatorAssistedFactory
import com.oliverspryn.android.edgetoedge.navigation.navigators.HttpNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CustomNavHostFragment : NavHostFragment() {

    @Inject
    lateinit var customFragmentNavigatorAssistedFactory: CustomFragmentNavigatorAssistedFactory

    @Inject
    lateinit var httpNavigator: HttpNavigator

    @SuppressLint("MissingSuperCall")
    override fun onCreateNavHostController(navHostController: NavHostController) {
        val customFragmentNavigator = customFragmentNavigatorAssistedFactory.newInstance(
            fragmentManager = childFragmentManager,
            containerId = id
        )

        navHostController.navigatorProvider += customFragmentNavigator // <custom-fragment />
        navHostController.navigatorProvider += httpNavigator // <http />
    }
}
