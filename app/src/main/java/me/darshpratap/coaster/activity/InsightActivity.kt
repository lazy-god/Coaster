package me.darshpratap.coaster.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_insight.*
import me.darshpratap.coaster.R
import me.darshpratap.coaster.adapter.ContentAdapter
import me.darshpratap.coaster.database.repository.ContentRepository

class InsightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insight)

        val id = intent.getIntExtra("id", 1)
        val title = intent.getStringExtra("title")
        heading.text = title
        val contents = ContentRepository(application).getContentsForCategory(id)

        val adapter = ContentAdapter(this, contents)
        content_view.layoutManager = LinearLayoutManager(this)
        content_view.adapter = adapter
    }
}
