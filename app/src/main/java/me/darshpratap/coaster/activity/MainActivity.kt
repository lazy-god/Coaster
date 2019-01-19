package me.darshpratap.coaster.activity

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.history_bottom_sheet.*
import me.darshpratap.coaster.R
import me.darshpratap.coaster.adapter.HistoryAdapter
import me.darshpratap.coaster.api.PageInsightService
import me.darshpratap.coaster.database.viewModel.CascadedOperations
import me.darshpratap.coaster.database.viewModel.HistoryWithCategoryViewModel
import me.darshpratap.coaster.models.api.ResponsePojo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivityTAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        TODO("check on text from input edit text")
//        val historyViewModel = ViewModelProviders.of(this).get(HistoryViewModel::class.java)
        val historyWithCategoryViewModel = ViewModelProviders.of(this).get(HistoryWithCategoryViewModel::class.java)
        val adapter = HistoryAdapter(this)
        val scale = resources.displayMetrics.density
        val bottomSheetBehavior = BottomSheetBehavior.from(history_bottom_sheet)

        // setting recycler view
        hbs_recycler_view.layoutManager = LinearLayoutManager(this)
        hbs_recycler_view.adapter = adapter

//        TODO("hide bottom sheet when scrolled")
//        hbs_recycler_view.addOnScrollListener(object: RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                if(dy != 0) {
//                    val scale = resources.displayMetrics.density
//                    BottomSheetBehavior.from(history_bottom_sheet).peekHeight = (50 * scale).toInt()
//                }
//            }
//        })
        bottomSheetBehavior.peekHeight = (50 * scale).toInt()
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

        // live data observer set-up
        historyWithCategoryViewModel.getHistoryWithCategory()?.observe(this, Observer {
            Log.d("shit HST", it.size.toString())
            adapter.submitList(it)
            hbs_recycler_view.smoothScrollToPosition(0)
        })

        insight_btn_desktop.setOnClickListener {
            val url = url_text_input.text.toString()
            if (!url.isEmpty()) {
                requestApi(url, "desktop")
            }
        }

        insight_btn_mobile.setOnClickListener {
            val url = url_text_input.text.toString()
            if (!url.isEmpty()) {
                requestApi(url, "mobile")
            }
        }
    }

    private fun requestApi(url: String, strategy: String) {
        disableButtons()
        PageInsightService.getInsightApi()?.getResponse(url, strategy)?.enqueue(object : Callback<ResponsePojo> {
            override fun onFailure(call: Call<ResponsePojo>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).apply {
                    setGravity(Gravity.TOP, 0, 60)
                    show()
                }
                enableButtons()
            }

            override fun onResponse(call: Call<ResponsePojo>, response: Response<ResponsePojo>) {
                enableButtons()
                if(response.body()?.performancePojo != null) {
                    val cascadedOperations = CascadedOperations()
                    cascadedOperations.cascadedInsert(application, url, strategy, response.body())
                } else {
                    Toast.makeText(this@MainActivity, "Invalid URL", Toast.LENGTH_SHORT).apply {
                        setGravity(Gravity.TOP, 0, 60)
                        show()
                    }
                }
//                Intent(this@MainActivity, InsightActivity::class.java).apply {
//                    startActivity(this)
//                }
            }

        })
    }

    private fun disableButtons() {
        loading.visibility = VISIBLE
        insight_icon.visibility = GONE
        insight_btn_desktop.isClickable = false
        insight_btn_desktop.backgroundTintList = ColorStateList.valueOf(Color.DKGRAY)
        insight_btn_mobile.backgroundTintList = ColorStateList.valueOf(Color.DKGRAY)
        insight_btn_mobile.isClickable = false
    }

    private fun enableButtons() {
        loading.visibility = GONE
        insight_icon.visibility = VISIBLE
        insight_btn_desktop.isClickable = true
        insight_btn_desktop.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.colorAccent))
        insight_btn_mobile.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.colorAccent))
        insight_btn_mobile.isClickable = true
    }
}