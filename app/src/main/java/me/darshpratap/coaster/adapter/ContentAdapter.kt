package me.darshpratap.coaster.adapter

import android.content.Context
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_content.view.*
import me.darshpratap.coaster.R
import me.darshpratap.coaster.models.db.Content

class ContentAdapter(val context: Context, private val contents: List<Content>?): RecyclerView.Adapter<ContentAdapter.ContentHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false)
        return ContentHolder(view)
    }

    override fun onBindViewHolder(holder: ContentHolder, position: Int) {
        val cView = holder.itemView

        cView.content_title.text = contents?.get(position)?.title
        cView.content_description.text = contents?.get(position)?.description
//        cView.content_description.movementMethod = LinkMovementMethod()
//        cView.content_score.text = contents?.get(position)?.score.toString()
    }

    override fun getItemCount(): Int {
        return contents?.size!!
    }

    inner class ContentHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}