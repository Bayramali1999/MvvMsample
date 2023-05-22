package uz.alisoft.domain.usecase

import uz.alisoft.domain.repository.UserRepository

class GetUserNameUseCase(private val repository: UserRepository) {

    fun execute() = repository.getName()

}