package com.example.formvalidation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvDetails = findViewById<TextView>(R.id.tvDetails)

        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val age = intent.getStringExtra("age")
        val gender = intent.getStringExtra("gender")
        val phone = intent.getStringExtra("phone")
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        val resultText = """
            First Name: $firstName
            Last Name: $lastName
            Age: $age
            Gender: $gender
            Phone: $phone
            Email: $email
            Password: $password
        """.trimIndent()

        tvDetails.text = resultText
    }
}
