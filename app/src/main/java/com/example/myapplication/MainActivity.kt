package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editButton1 = findViewById<Button>(R.id.editButton1)
        editButton1.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)
            val bundle = Bundle()
            val editTextName = findViewById<EditText>(R.id.editTextName).text
            val editTextNumber = findViewById<EditText>(R.id.editTextNumber).text

            bundle.putString("key1", editTextName.toString())
            bundle.putString("key2",editTextNumber.toString())
            intent.putExtras(bundle)
            startActivityForResult(intent,1)

            findViewById<EditText>(R.id.editTextName).visibility = View.INVISIBLE
            findViewById<EditText>(R.id.editTextNumber).visibility = View.INVISIBLE
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            if (requestCode ==1 && resultCode == Activity.RESULT_OK){
                findViewById<TextView>(R.id.editTextView3).text=
                    "姓名: ${it.getString("key1")}\n\n"+"電話: ${it.getString("key2")}\n\n"+
                    "大小: ${it.getString("key3")}\n\n"+"顏色: ${it.getString("key4")}\n\n"
            }
        }
    }
}