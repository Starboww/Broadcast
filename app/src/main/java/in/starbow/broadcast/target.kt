package `in`.starbow.broadcast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class target : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target)
        var x : String? = intent.getStringExtra("title")
        var y : String? = intent.getStringExtra("message")
        val textTitle = findViewById<TextView>(R.id.tvTitle)
        val textDescp = findViewById<TextView>(R.id.tvDescription)
        textTitle.text= textTitle.toString()
        textDescp.text= textDescp.toString()
        Log.d("Target","$x");

    }
}