package com.example.discover.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.discover.CategoryFragment

class DashboardPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> CategoryFragment("Chat")
            1 -> CategoryFragment("Status")
            else -> CategoryFragment("Calls")
        }
    }
}