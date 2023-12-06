package com.example.islami.ui.home.tabs.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.islami.Constants
import com.example.islami.databinding.FragmentTasbehBinding

class TasbehFragment : Fragment() {
    lateinit var viewBinding: FragmentTasbehBinding
    private lateinit var sebhaIv: ImageView
    private lateinit var counterTv: TextView
    private lateinit var convertTv: TextView

    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentTasbehBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sebhaIv = viewBinding.bodyOfSebha
        counterTv = viewBinding.tasbehCounter
        convertTv = viewBinding.convertTv


        convertTv.text = Constants.SOBHAN_ALLAH
        counterTv.text = "$counter"

        sebhaIv.setOnClickListener {
            sebhaOnClick()
        }
    }

    private fun sebhaOnClick() {
        sebhaIv.rotation += 5
        counter++
        counterTv.text = "$counter"

        if (counter == 33) {
            if (convertTv.text == Constants.SOBHAN_ALLAH) {
                convertTv.text = Constants.AL_HAMDO_ALLAH
                counter = 0
                counterTv.text = "$counter"
            } else if (convertTv.text == Constants.AL_HAMDO_ALLAH) {
                convertTv.text = Constants.ALLAH_AKBAR
                counter = 0
                counterTv.text = "$counter"
            } else if (convertTv.text == Constants.ALLAH_AKBAR) {
                convertTv.text = Constants.AL_Khatema
                counter = 0
                counterTv.text = "$counter"
            } else if (convertTv.text == Constants.AL_Khatema) {
                convertTv.text = Constants.SOBHAN_ALLAH
                counter = 0
                counterTv.text = "$counter"
            }
        }
    }


}