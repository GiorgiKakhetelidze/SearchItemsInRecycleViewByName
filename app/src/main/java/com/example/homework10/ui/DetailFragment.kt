package com.example.homework10.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.homework10.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private var binding: FragmentDetailBinding? = null
    private val cardItem by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        binding?.dogImgView?.setBackgroundResource(cardItem.item.img)
        binding?.titleTxtView?.text = cardItem.item.title
        binding?.descriptionTxtView?.text = cardItem.item.description
    }

}