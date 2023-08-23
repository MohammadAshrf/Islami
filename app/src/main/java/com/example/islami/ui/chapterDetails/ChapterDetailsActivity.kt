package com.example.islami.ui.chapterDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.Constants
import com.example.islami.databinding.ActivityChapterDetailsBinding

class ChapterDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityChapterDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initParams()
        initViews()
        loadChapterFile()
    }

    private fun initViews() {
        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        viewBinding.titleTv.text = chapterName
        supportActionBar?.title = ""
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
//        onBackPressed()
        return true
    }

    private fun loadChapterFile() {
        val fileContent =
            assets.open("$chapterIndex.txt").bufferedReader().use { it.readText() }
        val lines = fileContent.trim().split("\n")
        bindVerses(lines)
    }

    lateinit var adapter: VersesAdapter
    private fun bindVerses(verses: List<String>) {
        adapter = VersesAdapter(verses)
        viewBinding.content2.versesRecyclerView.adapter = adapter
    }

    lateinit var chapterName: String
    var chapterIndex: Int = 0
    private fun initParams() {
        chapterName = intent.getStringExtra(Constants.EXTRA_CHAPTER_NAME) ?: ""
        chapterIndex = intent.getIntExtra(Constants.EXTRA_CHAPTER_INDEX, 0)
    }
}