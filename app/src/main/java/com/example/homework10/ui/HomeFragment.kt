package com.example.homework10.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework10.data.DataSource
import com.example.homework10.data.DogCard
import com.example.homework10.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    private val adapter = DogCardsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        adapter.cardList = DataSource.listCards
        binding?.recycleView?.layoutManager = GridLayoutManager(requireContext(), 3)
        binding?.recycleView?.adapter = adapter

        adapter.dogCardClick = {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(item = it)
            findNavController().navigate(action)
        }

        binding?.searchEditTxtView?.doOnTextChanged { text, _, _, _ ->
            onSearchTextChange(title = text)
        }
    }

    private fun onSearchTextChange(title: CharSequence?) {
        if (title.isNullOrEmpty()) {
            setData(DataSource.listCards)
        }
        val searchedList = DataSource.listCards.filter { it.title.contains(title.toString()) }
        setData(searchedList)
    }

    private fun setData(list: List<DogCard>) {
        adapter.cardList = list
    }
}