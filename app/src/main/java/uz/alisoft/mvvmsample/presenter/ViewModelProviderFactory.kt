package uz.alisoft.mvvmsample.presenter

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.alisoft.data.repository.UserRepositoryImpl
import uz.alisoft.data.storage.SharedPreferenceStorage
import uz.alisoft.domain.usecase.GetUserNameUseCase
import uz.alisoft.domain.usecase.SaveUserNameUseCase

class ViewModelProviderFactory(context: Context) : ViewModelProvider.Factory {
    private val repository by lazy {
        UserRepositoryImpl(
            sharedPreferences = SharedPreferenceStorage(
                context
            )
        )
    }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(repository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(repository) }


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            saveUserNameUseCase = saveUserNameUseCase,
            getUserNameUseCase = getUserNameUseCase
        ) as T
    }
}