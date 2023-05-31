package com.example.discover.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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

    private val extraLines = "Are there monthly maintenance fees, and can they be waived? Some banks charge monthly account fees, but they can usually be avoided by maintaining minimum balances, linking your savings account to an eligible checking account or meeting another condition.\nAre there transaction limits? The Federal Reserve Board of Governors removed the cap on transfers and withdrawals from savings accounts, previously outlined under its Regulation D, in April 2020. Still, banks may restrict how many transfers or withdrawals you can complete monthly.\nAre there minimum balance or deposit requirements? Banks may require a minimum deposit to open a savings account or have minimum balance requirements.\nOther considerations may include how extensive the sign-up process is and whether you are required to have other accounts with that bank."


    private lateinit var binding: ActivityDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detailed)

        init()

        binding.IvBackButton.setOnClickListener {
            Log.d("DEEPAK", "CLICKED")
        }

    }
    @SuppressLint("SetTextI18n")
    private fun init() {
        val author: String = intent.getStringExtra(AUTHOR).toString()
        val heading: String = intent.getStringExtra(HEADING).toString()
        val source: String = intent.getStringExtra(SOURCE).toString()
        val date: String = intent.getStringExtra(DATE).toString()
        val description: String = intent.getStringExtra(DESCRIPTION).toString()
        val imageUrl: String = intent.getStringExtra(IMAGE_URL).toString()

        binding.TvAuthor.text = author
        binding.TvDate.text = date
        binding.TvDescription.text = description + extraLines
        binding.TvHeading.text = heading
        binding.collapsingToolbar.title = "by $source"
        Glide.with(this).load(imageUrl).centerCrop().placeholder(R.drawable.no_image_avaliable).into(binding.IvBackground)
    }
 }