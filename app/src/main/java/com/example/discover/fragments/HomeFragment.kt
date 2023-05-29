package com.example.discover.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.discover.activities.NewsApplication
import com.example.discover.adapters.AllNewsAdapter
import com.example.discover.databinding.FragmentHomeBinding
import com.example.discover.viewModels.NewsViewModel
import com.example.discover.viewModels.NewsViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var newsViewModel: NewsViewModel
    private lateinit var binding: FragmentHomeBinding
    private val allNewsAdapter by lazy { AllNewsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val newsRepository = (activity?.applicationContext as NewsApplication).newsRepository
        newsViewModel = ViewModelProvider(this, NewsViewModelFactory(newsRepository))[NewsViewModel::class.java]


        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = allNewsAdapter

        newsViewModel.allNewsData.observe(viewLifecycleOwner, Observer {
            allNewsAdapter.setData(it.articles)
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}