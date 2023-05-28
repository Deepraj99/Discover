package com.example.discover.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.discover.R
import com.example.discover.activities.NewsApplication
import com.example.discover.viewModels.NewsViewModel
import com.example.discover.viewModels.NewsViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var newsViewModel: NewsViewModel
//    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding = FragmentHomeBinding.inflate(inflater, container, false)
//        return binding.root

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsRepository = (activity?.applicationContext as NewsApplication).newsRepository
        newsViewModel = ViewModelProvider(this, NewsViewModelFactory(newsRepository))[NewsViewModel::class.java]

        newsViewModel.topHeadlinesData.observe(viewLifecycleOwner, Observer {
            val data = it.articles.size
            Log.d("DEEPAK", data.toString())
        })

    }
}