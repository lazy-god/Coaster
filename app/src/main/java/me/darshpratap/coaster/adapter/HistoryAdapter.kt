package me.darshpratap.coaster.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_history_bottom_sheet.view.*
import me.darshpratap.coaster.R
import me.darshpratap.coaster.models.db.HistoryWithCategory

class HistoryAdapter(val context: Context): ListAdapter<HistoryWithCategory, HistoryAdapter.HistoryHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history_bottom_sheet, parent, false)
        return HistoryHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        val response = getItem(position)
        holder.itemView.url_text.text = response.history.url
        if (response.history.strategy == "desktop") {
            holder.itemView.thumbnail_image.setImageResource(R.drawable.ic_laptop)
        } else {
            holder.itemView.thumbnail_image.setImageResource(R.drawable.ic_phone_android)
        }

        if(position == 0) {
            holder.itemView.details.visibility = VISIBLE
            holder.itemView.more.setImageResource(R.drawable.ic_arrow_drop_up_black)
        }

        holder.itemView.item_history.setOnClickListener {
            if(holder.itemView.details.visibility == GONE) {
                holder.itemView.details.visibility = VISIBLE
                holder.itemView.more.setImageResource(R.drawable.ic_arrow_drop_up_black)
            } else {
                holder.itemView.details.visibility = GONE
                holder.itemView.more.setImageResource(R.drawable.ic_arrow_drop_down_black)
            }
        }

        for(category in response.categoryList) {
            Log.d("shit C", category.title)
            val progress = (category.score * 100).toInt()
            when(category.title) {
                "Performance" -> setCategory(holder.itemView.score_performance, holder.itemView.progress_performance, progress)
                "Accessibility" -> setCategory(holder.itemView.score_accessibility, holder.itemView.progress_accessibility, progress)
                "Best Practices" -> setCategory(holder.itemView.score_best_practices, holder.itemView.progress_best_practices, progress)
                "Progressive Web App" -> setCategory(holder.itemView.score_pwa, holder.itemView.progress_pwa, progress)
                "SEO" -> setCategory(holder.itemView.score_seo, holder.itemView.progress_seo, progress)
            }
        }
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

    private fun setCategory(scoreView: TextView, progressView: ProgressBar, progress: Int) {
        scoreView.text = String.format(context.resources.getString(R.string.score), progress.toString())
        progressView.progress = progress
    }

//    interface OnItemClickListener {
//        fun onItemClick(history: History)
//    }
//
//    fun setOnItemClickListener(listener: OnItemClickListener) {
//        this.listener = listener
//    }
}