package me.darshpratap.coaster.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.history_bottom_sheet.*
import kotlinx.android.synthetic.main.item_history_bottom_sheet.*
import me.darshpratap.coaster.R
import me.darshpratap.coaster.adapter.HistoryAdapter
import me.darshpratap.coaster.api.PageInsightService
import me.darshpratap.coaster.database.viewModel.CascadedOperations
import me.darshpratap.coaster.database.viewModel.HistoryViewModel
import me.darshpratap.coaster.models.api.ResponsePojo
import me.darshpratap.coaster.models.db.History
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity: AppCompatActivity(){
    private val TAG = "MainActivityTAG"
    private val RECYCLER_VIEW_PADDING = 20
    private val RECYCLER_VIEW_MARGIN = 17


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO("check on text from input edit text")
        val historyViewModel = ViewModelProviders.of(this).get(HistoryViewModel::class.java)
        val adapter = HistoryAdapter()

        // setting recycler view
        hbs_recycler_view.layoutManager = LinearLayoutManager(this)
        hbs_recycler_view.adapter = adapter

        // live data observer set-up
        historyViewModel.getAllHistory()?.observe(this, Observer {
            adapter.submitList(it)
        })

        insight_btn_desktop.setOnClickListener {
            val url = url_text_input.text.toString()
            if(! url.isEmpty()) {
                requestApi(url, "desktop")
            }
        }

        insight_btn_mobile.setOnClickListener {
            val url = url_text_input.text.toString()
            if(! url.isEmpty()) {
                requestApi(url, "mobile")
            }
        }

        adapter.setOnItemClickListener(object: HistoryAdapter.OnItemClickListener {
            override fun onItemClick(history: History) {
                Log.d("shit", "item clicked")

            }
        })

        val scale = resources.displayMetrics.density
        BottomSheetBehavior.from(history_bottom_sheet).peekHeight = (50*scale).toInt()
    }

    private fun requestApi(url: String, strategy: String) {
        PageInsightService.getInsightApi()?.getResponse(url, strategy)?.enqueue(object: Callback<ResponsePojo> {
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