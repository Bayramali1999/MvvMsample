package uz.alisoft.mvvmsample

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import uz.alisoft.data.storage.SharedPreferenceStorage
import uz.alisoft.domain.usecase.GetUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val repository by lazy {
        uz.alisoft.data.repository.UserRepositoryImpl(
            sharedPreferences = SharedPreferenceStorage(
                applicationContext
            )
        )
    }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(repository) }
    private val saveUserNameUseCase by lazy {
        uz.alisoft.domain.usecase.SaveUserNameUseCase(
            repository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvData = findViewById<TextView>(R.id.tv_header)
        val dataEditText = findViewById<EditText>(R.id.et_text)
        val sentButton = findViewById<Button>(R.id.save_data)
        val receiveButton = findViewById<Button>(R.id.get_data)


        sentButton.setOnClickListener {
            val text = dataEditText.text.toString()
            val param = uz.alisoft.domain.models.SaveUserNameParam(text)
            val result = saveUserNameUseCase.execute(param)

            tvData.text = "Save result: $result"
        }

        receiveButton.setOnClickListener {

            val userName = getUserNameUseCase.execute()
            tvData.text = "${userName.firstname}  ${userName.lastname}"
        }

    }
}