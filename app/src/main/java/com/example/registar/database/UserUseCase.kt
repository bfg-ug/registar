package com.example.registar.database

interface UsersUseCase {
    suspend fun addUser(users: Users): Long
    suspend fun addUserList(users: List<Users>): List<Long>
    suspend fun getUserLoginVerify(email: String): Users
    suspend fun getUserData(id:Long): Users

}





class UsersUseCaseImpl (private var userRepository: UserRepository):UsersUseCase {
    override suspend fun addUser(users: Users): Long {
        val id = userRepository.addUser(users)
        return id
    }

    override suspend fun addUserList(users: List<Users>): List<Long> {
        val id = userRepository.addUserList(users)
        return id
    }

    override suspend fun getUserLoginVerify(email: String): Users {
        return userRepository.verifyUser(email)
    }

    override suspend fun getUserData(id: Long): Users {
        return userRepository.getUserDataDetails(id)
    }
}