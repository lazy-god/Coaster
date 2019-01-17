package me.darshpratap.coaster.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_history_bottom_sheet.view.*
import me.darshpratap.coaster.R
import me.darshpratap.coaster.models.db.History

class HistoryAdapter: ListAdapter<History, HistoryAdapter.HistoryHolder>(DIFF_CALLBACK) {
    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history_bottom_sheet, parent, false)
        return HistoryHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        val response = getItem(position)
        holder.itemView.url_text.text = response.url
        if (response.strategy == "desktop") {
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
    }

    inner class HistoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener?.onItemClick(getItem(position))
                }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<History>() {
            override fun areItemsTheSame(oldItem: History, newItem: History): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: History, newItem: History): Boolean {
                return oldItem.url == newItem.url &&
                        oldItem.strategy == newItem.strategy
            }

        }
    }

    interface OnItemClickListener {
        fun onItemClick(history: History)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}