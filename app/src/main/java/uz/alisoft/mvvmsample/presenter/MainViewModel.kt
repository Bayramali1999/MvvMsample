package uz.alisoft.mvvmsample.presenter

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.alisoft.domain.models.SaveUserNameParam
import uz.alisoft.domain.usecase.GetUserNameUseCase
import uz.alisoft.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    val liveData = MutableLiveData<String>()

    private val liveDataLocal = liveData

    init {
        Log.d("TAGAA", "Create VM: ")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TAGAA", "onCleared: VM")
    }

    fun save(text: String) {
        val param = SaveUserNameParam(text)
        val result = saveUserNameUseCase.execute(param)
        liveDataLocal.postValue("save data $result")

    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        liveDataLocal.postValue("${userName.firstname} ${userName.lastname}")
    }
}