package me.darshpratap.coaster.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.lzyzsd.circleprogress.ArcProgress
import kotlinx.android.synthetic.main.item_history_bottom_sheet.view.*
import me.darshpratap.coaster.R
import me.darshpratap.coaster.activity.InsightActivity
import me.darshpratap.coaster.models.db.HistoryWithCategory

class HistoryAdapter(val context: Context): ListAdapter<HistoryWithCategory, HistoryAdapter.HistoryHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history_bottom_sheet, parent, false)
        return HistoryHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        val response = getItem(position)
        val hView = holder.itemView
        hView.url_text.text = response.history.url
        if (response.history.strategy == "desktop") {
            hView.thumbnail_image.setImageResource(R.drawable.ic_laptop)
        } else {
            hView.thumbnail_image.setImageResource(R.drawable.ic_phone_android)
        }

        if(position == 0) {
            hView.details.visibility = VISIBLE
            hView.more.setImageResource(R.drawable.ic_arrow_drop_up_black)
        }

        hView.item_history.setOnClickListener {
            if(hView.details.visibility == GONE) {
                hView.details.visibility = VISIBLE
                hView.more.setImageResource(R.drawable.ic_arrow_drop_up_black)
            } else {
                hView.details.visibility = GONE
                hView.more.setImageResource(R.drawable.ic_arrow_drop_down_black)
            }
        }

        var tProgress = 0
        val intent = Intent(context, InsightActivity::class.java)
        for(category in response.categoryList) {
            val progress = (category.score * 100).toInt()
            tProgress += progress
            when(category.title) {
                "Performance" -> {
                    hView.progress_performance.progress = progress
                    hView.performance.setOnClickListener {
                        intent.putExtra("id", category.id)
                        intent.putExtra("title", category.title)
                        context.startActivity(intent)
                    }
                }
                "Accessibility" -> {
                    hView.progress_accessibility.progress = progress
                    hView.accessibility.setOnClickListener {
                        intent.putExtra("id", category.id)
                        intent.putExtra("title", category.title)
                        context.startActivity(intent)
                    }
                }
                "Best Practices" -> {
                    hView.progress_best_practices.progress = progress
                    hView.best_practices.setOnClickListener {
                        intent.putExtra("id", category.id)
                        intent.putExtra("title", category.title)
                        context.startActivity(intent)
                    }
                }
                "Progressive Web App" -> {
                    hView.progress_pwa.progress = progress
                    hView.pwa.setOnClickListener {
                        intent.putExtra("id", category.id)
                        intent.putExtra("title", category.title)
                        context.startActivity(intent)
                    }
                }
                "SEO" -> {
                    hView.progress_seo.progress = progress
                    hView.seo.setOnClickListener {
                        intent.putExtra("id", category.id)
                        intent.putExtra("title", category.title)
                        context.startActivity(intent)
                    }
                }
            }
        }

        hView.progress_total.progress = (tProgress/5)
//        hView.progress_total.finishedStrokeColor = context.resources.getColor(R.color.colorDark)
//        hView.progress_total.textColor = context.resources.getColor(R.color.colorDark)
    }

    inner class HistoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    companion object {
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<HistoryWithCategory>() {
            override fun areItemsTheSame(oldItem: HistoryWithCategory, newItem: HistoryWithCategory): Boolean {
                return oldItem.history.id == newItem.history.id
            }

            override fun areContentsTheSame(oldItem: HistoryWithCategory, newItem: HistoryWithCategory): Boolean {
                return oldItem.history.url == newItem.history.url &&
                        oldItem.history.strategy == newItem.history.strategy
            }

        }
    }

//    interface OnItemClickListener {
//        fun onItemClick(history: History)
//    }
//
//    fun setOnItemClickListener(listener: OnItemClickListener) {
//        this.listener = listener
//    }
}