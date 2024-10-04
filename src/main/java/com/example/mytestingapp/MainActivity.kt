package com.example.mytestingapp

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.room.Room
import com.example.mytestingapp.databinding.ActivityMainBinding
import com.example.mytestingapp.learn_room.Contact
import com.example.mytestingapp.learn_room.ContactDatabase
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {


    lateinit var binding : ActivityMainBinding
    lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        database = ContactDatabase.getContactDatabase(this)

        runBlocking {
            database.contactDao().insertContact(Contact(0, "Aditya", "123456"))
        }
    }

    fun getData(view: View) {
        database.contactDao().getContact().observe(this, Observer {
            Log.d("MAIN", "getData: ${it.toString()}")
        })
    }
}