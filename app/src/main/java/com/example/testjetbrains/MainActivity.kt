package com.example.testjetbrains

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.testjetbrains.ui.repos.ListFragment
import com.example.testjetbrains.ui.repos.details.DetailFragment

class MainActivity : AppCompatActivity(), ListFragment.OnListFragmentListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateToFragment(ListFragment.newInstance(), withAnimation = true, addToBackStack = false)

    }

    private fun navigateToFragment(
        fragment: Fragment?,
        withAnimation: Boolean,
        addToBackStack: Boolean = true
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        if (addToBackStack)
            transaction.addToBackStack(fragment.toString())
        if (withAnimation) transaction.setCustomAnimations(
            R.anim.slide_up_anim,
            R.anim.slide_down_anim
        )
        else transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragment?.let { transaction.add(android.R.id.content, it).addToBackStack(null).commit() }
    }

    override fun goToDetail(fullName: String, description: String) {
        navigateToFragment(
            DetailFragment.newInstance(fullName, description),
            withAnimation = true,
            addToBackStack = true
        )
    }
}