package com.joshuatorre.moviesapp.data.local.dao.tvshow

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.joshuatorre.moviesapp.data.model.tvshow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(movies: List<TvShow>)

    @Query("DELETE FROM popular_tv_show")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tv_show")
    suspend fun getTvShows(): List<TvShow>

}