package com.group4.loginapptk2.home.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.group4.loginapptk2.R
import com.group4.loginapptk2.databinding.HomeActivityBinding
import com.group4.loginapptk2.home.aapter.HomeAdapter
import com.group4.loginapptk2.home.model.HomeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: HomeActivityBinding
    private lateinit var homeAdapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        homeAdapter = HomeAdapter()
        val layoutManager = LinearLayoutManager(this)
        binding.rvHome.layoutManager = layoutManager
        binding.rvHome.setHasFixedSize(true)
        binding.rvHome.adapter = homeAdapter

        fetchData()
    }

    private fun fetchData() {
        lifecycleScope.launch(Dispatchers.Main) {
            val data = listOf(
                HomeModel(R.drawable.image1, getString(R.string.the_image_of_you), 150),
                HomeModel(R.drawable.image2, getString(R.string.spider_man_no_way_home), 1245),
                HomeModel(R.drawable.image3, getString(R.string.venom), 7862)
            )
            val pagingData = PagingData.from(data)
            homeAdapter.submitData(pagingData)
            homeAdapter.notifyDataSetChanged()
        }
    }
}