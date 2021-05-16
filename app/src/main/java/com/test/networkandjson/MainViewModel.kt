package com.test.networkandjson

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.networkandjson.movie.Movie
import com.test.networkandjson.rest.RestClient
import kotlinx.coroutines.launch

/**
 * Created by nampham on 5/10/21.
 */
class MainViewModel : ViewModel() {
    private val nowPlayingList = MutableLiveData<List<Movie>>()
    private val topRatedList = MutableLiveData<List<Movie>>()
    fun getNowPlaying() : LiveData<List<Movie>> {
        viewModelScope.launch {
             val movieResp = RestClient.getInstance().API.listNowPlayMovies(
                language = "en-US",
                page = 1,
            )

            Log.e("TAG", movieResp.results.toString())
            nowPlayingList.value = movieResp.results!!
        }
        return nowPlayingList
    }

    fun getTopRated() : LiveData<List<Movie>> {
        viewModelScope.launch {
            val movieResp = RestClient.getInstance().API.listTopRatedMovies(
                language = "en-US",
                page = 1,
            )
            Log.e("TAG++++ upcomming", movieResp.toString())
            topRatedList.value = movieResp.results!!
        }
        return topRatedList
    }
}