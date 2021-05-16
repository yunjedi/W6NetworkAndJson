package com.test.networkandjson.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.networkandjson.MainViewModel
import com.test.networkandjson.R
import com.test.networkandjson.adapter.NowPlayingAdapter
import com.test.networkandjson.adapter.TopRatedMovieAdapter
import kotlinx.android.synthetic.main.fragment_now_playing.*


class TopRatedFragment : Fragment() {
    var layoutManager: GridLayoutManager? = null
    lateinit var recycleView: RecyclerView
    lateinit var mainViewModel: MainViewModel

    lateinit var fav: MenuItem


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setHasOptionsMenu(true)

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        val newId = 200
        fav  = menu.add(0, newId, 0, "Grid")
        fav.setIcon(R.drawable.icongrid);
        fav.setShowAsAction (MenuItem.SHOW_AS_ACTION_ALWAYS)




    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item?.itemId) {
            200-> {
                if (layoutManager?.spanCount == 1) {
                    layoutManager?.spanCount = 3
                    item.title = "list"
//                    item.icon = context?.let { getDrawable(it,R.drawable.listicon) }
                    fav.setIcon(R.drawable.listicon);

//                            list.setImageDrawable();
                } else {
                    layoutManager?.spanCount = 1
                    item.title = "grid"
//                        item.icon=  icongrid
//                   item.icon = context?.let { getDrawable(it,R.drawable.icongrid) }
                    fav.setIcon(R.drawable.icongrid);

                }
                nowplayingrec.adapter?.notifyItemRangeChanged(0, nowplayingrec.adapter?.itemCount ?: 0)
            }

        }
        return super.onOptionsItemSelected(item)
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
        val adapter = TopRatedMovieAdapter();
        recycleView.adapter = adapter

        mainViewModel.getTopRated().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        return v
    }
}