package uz.alisoft.data.repository

import uz.alisoft.data.storage.User
import uz.alisoft.data.storage.UserStorage
import uz.alisoft.domain.models.SaveUserNameParam
import uz.alisoft.domain.models.UserName
import uz.alisoft.domain.repository.UserRepository


class UserRepositoryImpl(private val sharedPreferences: UserStorage) : UserRepository {


    override fun saveName(param: SaveUserNameParam) =
        sharedPreferences.save(User(param.name, ""))


    override fun getName(): UserName {
        val user = sharedPreferences.get()
        return UserName(user.firstname, lastname = user.lastname)
    }

}