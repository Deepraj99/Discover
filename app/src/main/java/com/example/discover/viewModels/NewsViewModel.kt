package com.example.discover.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.discover.models.News
import com.example.discover.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getTopHeadlines("us", "business")
            newsRepository.getAllNews("india", "publishedAt")
        }
    }

    val topHeadlinesData: LiveData<News>
    get() = newsRepository.newsTopHeadlinesLiveData

    val allNewsData: LiveData<News>
    get() = newsRepository.newsAllLiveData
}