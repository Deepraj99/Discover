package com.example.discover.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.discover.models.News
import com.example.discover.retrofit.ApiInterface

class NewsRepository(private val apiInterface: ApiInterface) {

    private val newsMutableLiveData = MutableLiveData<News>()
    val newsLiveData: LiveData<News>
    get() = newsMutableLiveData

    suspend fun getTopHeadlines(country: String, category: String) {
        val topHeadlinesData = apiInterface.getTopHeadlines(country, category)

        if(topHeadlinesData.body() != null) {
            newsMutableLiveData.postValue(topHeadlinesData.body())
        }
    }
}