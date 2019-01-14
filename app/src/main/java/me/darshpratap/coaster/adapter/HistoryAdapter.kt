package me.darshpratap.coaster.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
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
        holder.urlText.text = response.url
    }

    inner class HistoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val urlText: TextView = itemView.findViewById(R.id.url_text)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (listener == null && position == RecyclerView.NO_POSITION) {
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
                return oldItem.url == newItem.url
            }

        }
    }

    interface OnItemClickListener {
        fun onItemClick(history: History)
    }

    private fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}