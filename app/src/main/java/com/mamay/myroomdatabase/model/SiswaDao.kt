package com.mamay.myroomdatabase.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// DAO untuk menjalankan operasi SQL tanpa menulis kode SQLite manual.
@Dao
interface SiswaDao {
    @Query("SELECT * from tblSiswa ORDER BY nama ASC")
    fun getAllSiswa(): Flow<List<Siswa>>

    // Menambah siswa secara asynchronous ke database.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(siswa: Siswa)

    // mencari data by id
    @Query("SELECT * from tblSiswa WHERE id = :id")
    fun getSiswa(id: Int): Flow<Siswa?>

    // delete data
    @Delete
    suspend fun delete(siswa: Siswa)

    // update data
    @Update
    suspend fun update(siswa: Siswa)


}
