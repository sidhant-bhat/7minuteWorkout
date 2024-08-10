package com.example.a7minutesworkout

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import eu.tutorials.a7_minutesworkoutapp.databinding.ActivityHistoryBinding
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {
    private var binding: ActivityHistoryBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarHistoryActivity)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true) // Set back button
            title = "HISTORY"
        }
        binding?.toolbarHistoryActivity?.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        val dao = (application as WorkOutApp).db.historyDao()
        getAllCompleteDates(dao)
    }

    private fun getAllCompleteDates(historyDao: HistoryDao) {
        lifecycleScope.launch {
            historyDao.fetchAllDates().collect { allCompletedDates ->
                if (allCompletedDates.isNotEmpty()) {
                    binding?.apply {
                        tvHistory.visibility = View.VISIBLE
                        rvHistory.visibility = View.VISIBLE
                        tvNoDataAvailable.visibility = View.INVISIBLE
                        rvHistory.layoutManager = LinearLayoutManager(this@HistoryActivity)
                        val dates = allCompletedDates.map { it.date } // Simplified list conversion
                        val historyAdapter = HistoryAdapter(dates)
                        rvHistory.adapter = historyAdapter
                    }
                } else {
                    binding?.apply {
                        tvHistory.visibility = View.GONE
                        rvHistory.visibility = View.GONE
                        tvNoDataAvailable.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
