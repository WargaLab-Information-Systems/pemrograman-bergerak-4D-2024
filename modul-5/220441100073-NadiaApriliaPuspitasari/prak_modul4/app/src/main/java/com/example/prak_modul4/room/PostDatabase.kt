package com.example.prak_modul4.room

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.File

@Entity
data class PostDatabase(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "post_title")
    val name: String,

    @ColumnInfo(name = "post_desc")
    val description: String,

    @ColumnInfo(name = "post_image")
    val image: File,

    @ColumnInfo(name = "post_like")
    var like: Int = 0,



): Parcelable {
    // Konstruktor sekunder untuk membuat objek PlayerDatabase dari Parcel
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        File(parcel.readString()!!),
        parcel.readInt(),

    )

    // Fungsi untuk menulis data objek PlayerDatabase ke Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(image.path)
        parcel.writeInt(like)

    }

    // Fungsi untuk mendeskripsikan jenis konten khusus yang ditangani oleh Parcelable
    override fun describeContents(): Int {
        return 0
    }

    // Objek pendamping untuk PlayerDatabase yang berisi fungsi untuk membuat objek PlayerDatabase dari Parcel dan Array
    companion object CREATOR : Parcelable.Creator<PostDatabase> {
        // Fungsi untuk membuat objek PlayerDatabase dari Parcel
        override fun createFromParcel(parcel: Parcel): PostDatabase {
            return PostDatabase(parcel)
        }

        // Fungsi untuk membuat array dari objek PlayerDatabase
        override fun newArray(size: Int): Array<PostDatabase?> {
            return arrayOfNulls(size)
        }
    }
}
