package com.example.myNotes

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myNotes.Task

@Dao
interface TasksDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("Select * from taskTable order by id ASC")
    fun getAllTasks(): LiveData<List<Task>>
}