package me.darshpratap.coaster.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import me.darshpratap.coaster.R
import me.darshpratap.coaster.adapter.HistoryAdapter
import me.darshpratap.coaster.api.PageInsightService
import me.darshpratap.coaster.database.viewModel.CascadedOperations
import me.darshpratap.coaster.database.viewModel.HistoryViewModel
import me.darshpratap.coaster.models.api.ResponsePojo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity: AppCompatActivity(){
    private val TAG = "MainActivityTAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInputEditText = findViewById<TextInputEditText>(R.id.url_text_input)
        // TODO("check on text from input edit text")
        val insightBtn = findViewById<MaterialButton>(R.id.insight_btn_desktop)
        val recyclerView = findViewById<RecyclerView>(R.id.hbs_recycler_view)
        val historyViewModel = ViewModelProviders.of(this).get(HistoryViewModel::class.java)
        val adapter = HistoryAdapter()

        // setting recycler view
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // live data observer set-up
        historyViewModel.getAllHistory()?.observe(this, Observer {
            adapter.submitList(it)
        })

        insightBtn.setOnClickListener {
            val url: String = textInputEditText.text.toString()
            Log.d(TAG, url)
            PageInsightService.getInsightApi()?.getResponse(url, "desktop")?.enqueue(object: Callback<ResponsePojo> {
                override fun onFailure(call: Call<ResponsePojo>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Request Timed Out", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<ResponsePojo>, response: Response<ResponsePojo>) {
                    val cascadedOperations = CascadedOperations()
                    cascadedOperations.cascadedInsert(application, url, response.body())
                    Intent(this@MainActivity, InsightActivity::class.java).apply {
                        startActivity(this)
                    }
                }

            })
        }
    }

}