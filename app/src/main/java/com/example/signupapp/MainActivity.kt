package com.example.signupapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName: EditText = findViewById(R.id.etName)
        val etContact: EditText = findViewById(R.id.etContact)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val etAddress: EditText = findViewById(R.id.etAddress)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            validateAndSubmit(
                etName,
                etContact,
                etEmail,
                etPassword,
                etAddress
            )
        }
    }

    private fun validateAndSubmit(
        etName: EditText,
        etContact: EditText,
        etEmail: EditText,
        etPassword: EditText,
        etAddress: EditText
    ) {
        var isValid = true

        // Name validation
        if (etName.text.isNullOrBlank()) {
            etName.error = "Name is required"
            isValid = false
        } else {
            etName.error = null
        }

        // Contact validation
        val contact = etContact.text.toString()
        if (contact.isBlank()) {
            etContact.error = "Contact is required"
            isValid = false
        } else if (contact.length != 10) {
            etContact.error = "Contact must be 10 digits"
            isValid = false
        } else {
            etContact.error = null
        }

        // Email validation
        val email = etEmail.text.toString()
        if (email.isBlank()) {
            etEmail.error = "Email is required"
            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.error = "Invalid email address"
            isValid = false
        } else {
            etEmail.error = null
        }

        // Password validation
        if (etPassword.text.isNullOrBlank()) {
            etPassword.error = "Password is required"
            isValid = false
        } else {
            etPassword.error = null
        }

        // Address validation
        if (etAddress.text.isNullOrBlank()) {
            etAddress.error = "Address is required"
            isValid = false
        } else {
            etAddress.error = null
        }

        if (isValid) {
            // Handle form submission (e.g., save data or send to server)
            Toast.makeText(this, "Form Submitted Successfully!", Toast.LENGTH_SHORT).show()
        }
    }
}
