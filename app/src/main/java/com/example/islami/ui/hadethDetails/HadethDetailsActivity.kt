package com.example.islami.ui.hadethDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.Constants
import com.example.islami.databinding.ActivityHadethDetailsBinding
import com.example.islami.ui.model.Hadeth

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
        initParam()
        bindHadeth()
    }

    private fun initViews() {
        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun bindHadeth() {
        viewBinding.titleTv.text = hadeth?.title
        viewBinding.content.content.text = hadeth?.content
    }

    var hadeth: Hadeth? = null
    private fun initParam() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getParcelableExtra(Constants.EXTRA_HADETH, Hadeth::class.java)
        } else
            hadeth = intent.getParcelableExtra(Constants.EXTRA_HADETH) as Hadeth?
    }

}