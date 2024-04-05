package com.example.registar.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "USER_TABLE")
data class Users(
    @PrimaryKey(autoGenerate = true)
    val id:Long=0,
    var name: String ="",
    var email: String ="",
    var password: String ="",
    var logged_in: Boolean = false
)