package com.example.prak_modul4.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

// Anotasi @Dao digunakan untuk memberi tahu Room bahwa interface ini adalah DAO (Data Access Object).
// DAO adalah interface yang berfungsi sebagai jembatan antara aplikasi dan database SQLite.
@Dao
interface PostDao {


    // Anotasi @Insert memberi tahu Room bahwa fungsi ini digunakan untuk memasukkan data.
    // Parameter onConflict digunakan untuk menentukan apa yang harus dilakukan Room jika data yang dimasukkan memiliki konflik dengan data yang sudah ada di database.
    // OnConflictStrategy.IGNORE berarti jika ada konflik, Room akan mengabaikan operasi insert.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPost(post: PostDatabase)


    // Query "SELECT * FROM PeopleEntity ORDER BY id DESC" berarti memilih semua data dari tabel PeopleEntity dan mengurutkannya berdasarkan id dalam urutan menurun.
    // Fungsi ini mengembalikan LiveData yang berisi daftar semua orang.
    // LiveData adalah kelas dari Android Architecture Components yang memungkinkan kita untuk mengamati
    // perubahan data dalam database dan secara otomatis memperbarui UI jika ada perubahan.
    @Query("SELECT * FROM postdatabase ORDER BY id DESC")

    //return data berupa live data list dari post database
    fun getAllPost() : LiveData<List<PostDatabase>>

    @Update
    fun updatePost(post: PostDatabase)

    @Delete
    fun deletePost(post: PostDatabase)

//    @Delete
//    fun deletePost(post: PostDatabase)
}