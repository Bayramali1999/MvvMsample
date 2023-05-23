package uz.alisoft.mvvmsample.presenter

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import uz.alisoft.mvvmsample.R

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("TAGAA", "acticity lc")
        vm = ViewModelProvider(this@MainActivity, ViewModelProviderFactory(this@MainActivity)).get(
            MainViewModel::class.java
        )
        val tvData = findViewById<TextView>(R.id.tv_header)
        val dataEditText = findViewById<EditText>(R.id.et_text)
        val sentButton = findViewById<Button>(R.id.save_data)
        val receiveButton = findViewById<Button>(R.id.get_data)


        vm.liveData.observe(this, Observer { text ->

            tvData.text = text

        })
        sentButton.setOnClickListener {
            val text = dataEditText.text.toString()
            vm.save(text)
        }

        receiveButton.setOnClickListener {
            vm.load()
        }

    }
}