package com.test.networkandjson.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.test.networkandjson.MainViewModel
import com.test.networkandjson.R
import com.test.networkandjson.adapter.NowPlayingAdapter
import com.test.networkandjson.databinding.FragmentNowPlayingBinding


class NowPlayingFragment : Fragment() {

    lateinit var mainViewModel: MainViewModel
    lateinit var binding: FragmentNowPlayingBinding
    var layoutManager: GridLayoutManager? = null
    lateinit var recycleView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v : View = inflater.inflate(R.layout.fragment_now_playing, container, false)
        recycleView = v.findViewById(R.id.nowplayingrec)
        layoutManager = GridLayoutManager(v.context, 1)
        recycleView.layoutManager = layoutManager
        recycleView.adapter = NowPlayingAdapter(layoutManager as GridLayoutManager)
        val adapter = NowPlayingAdapter();
        recycleView.adapter = adapter

        mainViewModel.getNowPlaying().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        return v
    }


}
