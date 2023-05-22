package uz.alisoft.domain.usecase

import uz.alisoft.domain.models.SaveUserNameParam
import uz.alisoft.domain.repository.UserRepository

class SaveUserNameUseCase(private val repository: UserRepository) {

    fun execute(param: SaveUserNameParam) = repository.saveName(param)
}