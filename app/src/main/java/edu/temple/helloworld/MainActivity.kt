package edu.temple.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams

class MainActivity : AppCompatActivity() {

    lateinit var displayTextView: TextView
    lateinit var nameEditText: EditText
    lateinit var clickMeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        displayTextView = findViewById(R.id.displayTextView)
        nameEditText = findViewById(R.id.nameEditText)
        clickMeButton = findViewById(R.id.clickMeButton)

        // Improve layout
        organizeLayout()

        clickMeButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            if (name.isNotEmpty()) {
                displayTextView.text = "Hello, $name"
            } else {
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show()
                displayTextView.text = ""
            }
        }
    }

    private fun organizeLayout() {
        nameEditText.updateLayoutParams<ConstraintLayout.LayoutParams> {
            topToTop = ConstraintLayout.LayoutParams.PARENT_ID
            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            topMargin = resources.getDimensionPixelSize(R.dimen.margin_top)
        }

        clickMeButton.updateLayoutParams<ConstraintLayout.LayoutParams> {
            topToBottom = nameEditText.id
            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            topMargin = resources.getDimensionPixelSize(R.dimen.margin_standard)
        }

        displayTextView.updateLayoutParams<ConstraintLayout.LayoutParams> {
            topToBottom = clickMeButton.id
            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            topMargin = resources.getDimensionPixelSize(R.dimen.margin_standard)
        }
    }
}