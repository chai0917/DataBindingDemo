package com.example.databindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.databindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding /* lateinit = assigned/initialize it later on */
    private var aPerson: Person =
        Person("ali", "123456", "ali@gmail.com", "TARUC") /* can use Person = new */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* val can only assigned once var can be assigned many times */

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.personData = aPerson

        binding.btnUpdate.setOnClickListener(){
            aPerson.email = "xxx@gmail.com"
            aPerson.address = "123 Jalan XYZ"
            binding.apply { invalidateAll() }
        }

        /*binding.tvName.text = aPerson.name
        binding.tvNRIC.text = aPerson.ic
        binding.tvEmail.text = aPerson.email
        binding.tvAddress.text = aPerson.address*/

        /* var tvName : TextView = findViewById(R.id.name) //Once button clicked, start to find view by ID
         var tvName : TextView = findViewById(R.id.name)
         var tvName : TextView = findViewById(R.id.name)
         var tvName : TextView = findViewById(R.id.name) */

    }
}