package com.api.demoexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.api.demoexamen.databinding.ActivityMainBinding
import com.api.demoexamen.network.ApiHandler
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        textView = binding.textView

        val apiHandler = ApiHandler()
        val service = apiHandler.service

        service.getActivity().subscribeOn(Schedulers.computation()).observeOn(
            AndroidSchedulers.mainThread()
        ).subscribe({ response ->
            Log.e("TAG", "response ${response.activity}")
            textView.text = response.activity

        }, { throwable ->
            throwable.printStackTrace()
            Toast.makeText(applicationContext, throwable.localizedMessage, Toast.LENGTH_LONG)
                .show()
        })
        setContentView(binding.root)
    }
}