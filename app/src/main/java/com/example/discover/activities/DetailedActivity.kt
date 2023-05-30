package com.example.discover.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.discover.R
import com.example.discover.databinding.ActivityDetailedBinding
import com.example.discover.utils.Constants.Companion.AUTHOR
import com.example.discover.utils.Constants.Companion.DATE
import com.example.discover.utils.Constants.Companion.DESCRIPTION
import com.example.discover.utils.Constants.Companion.HEADING
import com.example.discover.utils.Constants.Companion.IMAGE_URL
import com.example.discover.utils.Constants.Companion.SOURCE


class DetailedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detailed)

        val author: String = intent.getStringExtra(AUTHOR).toString()
        val heading: String = intent.getStringExtra(HEADING).toString()
        val source: String = intent.getStringExtra(SOURCE).toString()
        val date: String = intent.getStringExtra(DATE).toString()
        val description: String = intent.getStringExtra(DESCRIPTION).toString()
        val imageUrl: String = intent.getStringExtra(IMAGE_URL).toString()

        binding.TvAuthor.text = author
        binding.TvDate.text = date
        binding.TvDescription.text = description
        binding.TvHeading.text = heading
        binding.collapsingToolbar.title = "by $source"
        Glide.with(this).load(imageUrl).centerCrop().placeholder(R.drawable.no_image_avaliable).into(binding.IvBackground)

    }
}