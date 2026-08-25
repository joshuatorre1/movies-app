package com.joshuatorre.moviesapp.data.local.dao.people

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.joshuatorre.moviesapp.data.model.people.People

@Dao
interface PeopleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePeople(people: List<People>)

    @Query("DELETE FROM popular_people")
    suspend fun deleteAllPeople()

    @Query("SELECT * FROM popular_people")
    suspend fun getPeople(): List<People>

}