package `in`.starbow.broadcast

import `in`.starbow.broadcast.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
const val Topic = "/topics/broadcast"
class MainActivity : AppCompatActivity() {

    private lateinit var bind:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        FirebaseMessaging.getInstance().subscribeToTopic(Topic)
       bind.btnBroadCast.setOnClickListener {
           val title = bind.edTitleTxt.toString()
           val message = bind.edMsgTxt.toString()
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
            if(response.isSuccessful)
            {
                Log.d("MAIN","Response: ${Gson().toJson(response)}")
            }
            else
            {
                Log.d("MAin",response.errorBody().toString())
            }
        }catch (e:Exception){
            Log.i("Main",e.toString())
        }
    }



}