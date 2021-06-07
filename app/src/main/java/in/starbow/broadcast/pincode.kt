package `in`.starbow.broadcast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class pincode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pincode2)
     val pin = findViewById<TextInputEditText>(R.id.pincode)
        val nextBtn =findViewById<FloatingActionButton>(R.id.doneBtn)
        nextBtn.setOnClickListener{
            val pinstr=pin.text.toString()
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("pin",pinstr);
            startActivity(intent)
        }


    }
}