package `in`.starbow.broadcast

import `in`.starbow.broadcast.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
const val Topic = "/topics/broadcast"
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        FirebaseMessaging.getInstance().subscribeToTopic(Topic)
        var broadCastBtn=findViewById<Button>(R.id.btnBroadCast)
        var tit = findViewById<TextInputEditText>(R.id.edTitleTxt)
        var msg = findViewById<TextInputEditText>(R.id.edtxtMsg)
       broadCastBtn.setOnClickListener {
           val title = tit.text.toString()
           val message = msg.text.toString()
           Log.d("DEBB","$title"+" "+"$message");
           if(title.isNotEmpty()&&message.isNotEmpty())
           {
                pushNotification(NotificationData(title, message), Topic).also {
                    sendNotification(it)
                }
           }

       }
    }
    private fun sendNotification(notification:pushNotification)= CoroutineScope(Dispatchers.IO).launch {
        try{
           val response = Retrofitinstance.api.postNotification(notification)
        }catch (e:Exception){
            Log.i("Main",e.toString())
        }
    }



}