package com.example.registar.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface UsersDao {

    //for single user insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(users: Users): Long

    //for list of users insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserAll(users: List<Users>): List<Long>

    //checking user exist or not in our db
    @Query("SELECT * FROM USER_TABLE WHERE email LIKE :email")
    fun readUserData(email: String):Users


    //getting user data details
    @Query("SELECT * FROM USER_TABLE WHERE id LIKE :id")
    fun getUserDataDetails(id:Long):Users

    //deleting all user from db
    @Query("DELETE FROM USER_TABLE WHERE id LIKE :id")
    fun deleteUser(id: Long)


    //check if user is loggedIn
    @Query("SELECT  logged_in FROM USER_TABLE WHERE id LIKE :id")
    suspend fun checkIfLoggedin(id: Long)





}
