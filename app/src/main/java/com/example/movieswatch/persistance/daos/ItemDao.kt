package com.example.movieswatch.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movieswatch.data.vos.ItemsVO

@Dao
interface ItemDao {
    @Query("SELECT * FROM `movies_list` ")
    fun getAllItem():LiveData<List<ItemsVO>>
//
//    @Query("SELECT * FROM `movies_list` where genreIds=28 ")
//    fun getAllActionItem(genresId:Int):LiveData<List<ItemsVO>>
//
//    @Query("SELECT * FROM `movies_list` where genreIds=12 ")
//    fun getAllAventureItem(genresId:Int):LiveData<List<ItemsVO>>
//
//    @Query("SELECT * FROM `movies_list` where genreIds=16 ")
//    fun getAllAnimationItem(genresId:Int):LiveData<List<ItemsVO>>
//
//    @Query("SELECT * FROM `movies_list` where genreIds=35 ")
//    fun getAllComedyItem(genresId:Int):LiveData<List<ItemsVO>>
//
//    @Query("SELECT * FROM `movies_list` where genreIds=80 ")
//    fun getAllCrimeItem(genresId:Int):LiveData<List<ItemsVO>>
//
//    @Query("SELECT * FROM `movies_list` where genreIds=35 ")
//    fun getAllDocumentaryItem(genresId:Int):LiveData<List<ItemsVO>>
//
//    @Query("SELECT * FROM `movies_list` where genreIds=18 ")
//    fun getAllDramaItem(genresId:Int):LiveData<List<ItemsVO>>
//
//    @Query("SELECT * FROM `movies_list` where genreIds=10751 ")
//    fun getAllFamilyItem(genresId:Int):LiveData<List<ItemsVO>>
//
//    @Query("SELECT * FROM `movies_list` where genreIds=14 ")
//    fun getAllFantasyItem(genresId:Int):LiveData<List<ItemsVO>>
//
//    @Query("SELECT * FROM `movies_list` where genreIds=36 ")
//    fun getAllHistoryItem(genresId:Int):LiveData<List<ItemsVO>>
//
//    @Query("SELECT * FROM `movies_list` where genreIds=27 ")
//    fun getAllHorrorItem(genresId:Int):LiveData<List<ItemsVO>>

    @Query("DELETE FROM `movies_list`")
    fun deleteAllItem()

    @Delete
    fun deleteItem(itemsVO: ItemsVO)

    @Insert
    fun insertItem(itemsVO: ItemsVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItemList(itemList:List<ItemsVO>)


}