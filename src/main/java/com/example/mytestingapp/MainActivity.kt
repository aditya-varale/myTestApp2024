package com.example.mytestingapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
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

    //get data from room
    fun getData() {
        database.contactDao().getContact().observe(this) {
            Log.d("MAIN", "getData: ${it.toString()}")
        }
    }
}