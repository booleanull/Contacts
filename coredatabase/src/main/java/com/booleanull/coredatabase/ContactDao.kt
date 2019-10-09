package com.booleanull.coredatabase

import androidx.room.*
import com.booleanull.core.data.ContactEntity

@Dao
interface ContactDao {

    @Query("SELECT * FROM ContactEntity ORDER BY id")
    suspend fun all(): List<ContactEntity>

    @Query("SELECT * FROM ContactEntity WHERE id = :id")
    suspend fun getById(id: Long): ContactEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(models: List<ContactEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(model: ContactEntity)

    @Delete
    suspend fun delete(repositoryModel: ContactEntity)

    @Query("DELETE FROM ContactEntity")
    suspend fun deleteAll()
}