package com.example.registar.database

import android.os.Parcel
import android.os.Parcelable
import javax.inject.Inject


interface UserRepository() : Parcelable {

    constructor(parcel: Parcel) : this() {
    }

    fun addUser(users: Users):Long

    fun addUserList(users: List<Users>):List<Long>

    fun deleteUser(id: Long)

    fun verifyUser(email:String): Users

    fun getUserDataDetails(id:Long):Users
    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserRepository> {
        override fun createFromParcel(parcel: Parcel): UserRepository {
            return UserRepository(parcel)
        }

        override fun newArray(size: Int): Array<UserRepository?> {
            return arrayOfNulls(size)
        }
    }


}


class UserRepositoryImpl @Inject constructor(
    private  var usersDao: UsersDao,


):UserRepository {

    override fun addUser(users: Users): Long {
        return usersDao.insertUser(users)
    }

    override fun addUserList(users: List<Users>): List<Long> {
        return usersDao.insertUserAll(users)
    }

    override fun deleteUser(id: Long) {
        return usersDao.deleteUser(id)
    }

    override fun verifyUser(email: String): Users {
        return usersDao.readUserData(email)
    }

    override fun getUserDataDetails(id: Long): Users {
        return usersDao.getUserDataDetails(id)
    }


}
