package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        intent?.extras?.let{ it ->

            val editTextView4 = findViewById<TextView>(R.id.editTextView4)
            editTextView4.text =
                "姓名: ${it.getString("key1")}\n\n"+"電話: ${it.getString("key2")}\n\n"
            
            val temp1 = it.getString("key1")
            val temp2 = it.getString("key2")
            
            val editButton2 = findViewById<Button>(R.id.editButton2)
            editButton2.setOnClickListener {

                val editTextSize = findViewById<EditText>(R.id.editTextSize).text
                val editTextColor = findViewById<EditText>(R.id.editTextColor).text
                val bundle = Bundle()

                bundle.putString("key1",temp1)
                bundle.putString("key2",temp2)
                bundle.putString("key3",editTextSize.toString())
                bundle.putString("key4",editTextColor.toString())

                val intent = Intent().putExtras(bundle)
                setResult(Activity.RESULT_OK,intent.putExtras(bundle))
                finish()
            }
        }
    }
}