package uz.alisoft.domain.repository

import uz.alisoft.domain.models.SaveUserNameParam
import uz.alisoft.domain.models.UserName

interface UserRepository {

    fun saveName(param: SaveUserNameParam): Boolean
    fun getName(): UserName

}