package com.example.formvalidation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.*
import android.util.Patterns

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etAge = findViewById<EditText>(R.id.etAge)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val firstName = etFirstName.text.toString().trim()
            val lastName = etLastName.text.toString().trim()
            val age = etAge.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()

            // Gender validation
            val selectedGenderId = rgGender.checkedRadioButtonId
            if (selectedGenderId == -1) {
                Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val selectedGender = findViewById<RadioButton>(selectedGenderId).text.toString()

            // Field validations
            if (firstName.isEmpty()) {
                etFirstName.error = "First name required"
                return@setOnClickListener
            }

            if (lastName.isEmpty()) {
                etLastName.error = "Last name required"
                return@setOnClickListener
            }

            if (age.isEmpty()) {
                etAge.error = "Age required"
                return@setOnClickListener
            }

            if (phone.isEmpty()) {
                etPhone.error = "Phone number required"
                return@setOnClickListener
            } else if (phone.length != 10 || !phone.all { it.isDigit() }) {
                etPhone.error = "Enter valid 10-digit phone number"
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                etEmail.error = "Email required"
                return@setOnClickListener
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Enter valid email"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etPassword.error = "Password required"
                return@setOnClickListener
            } else if (password.length < 8) {
                etPassword.error = "Minimum 8 characters required"
                return@setOnClickListener
            }

            // Send Data to ResultActivity
            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("firstName", firstName)
                putExtra("lastName", lastName)
                putExtra("age", age)
                putExtra("gender", selectedGender)
                putExtra("phone", phone)
                putExtra("email", email)
                putExtra("password", password) // Optional to pass
            }

            startActivity(intent)
        }
    }
}
