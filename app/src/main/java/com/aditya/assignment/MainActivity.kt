package com.aditya.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aditya.assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Implementing ViewBinding in the activity
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //This function will call when the user click on the next Button
        binding.next.setOnClickListener {

            //If Website Link Edit Text is Empty
            if(binding.websiteLink.text.toString() == "") {
                Toast.makeText(this@MainActivity, "Please Enter Website Link", Toast.LENGTH_SHORT).show()
            } else {

                //The app goes to the WebViewActivity
                val intent = Intent(this@MainActivity, WebViewActivity::class.java)
                intent.putExtra("WebsiteLink", binding.websiteLink.text.toString())
                startActivity(intent)
            }
        }


    }
}