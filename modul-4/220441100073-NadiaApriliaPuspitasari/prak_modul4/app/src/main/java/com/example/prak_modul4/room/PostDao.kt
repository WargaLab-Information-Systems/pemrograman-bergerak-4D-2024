package com.example.prak_modul4.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPost(post: PostDatabase)

    @Query("SELECT * FROM postdatabase ORDER BY id DESC")

    //return data berupa live data list dari post database
    fun getAllPost() : LiveData<List<PostDatabase>>

//    @Delete
//    fun deletePost(post: PostDatabase)
}