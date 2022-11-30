import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)
    val token = "cQIfGOX0T3K2iYccumEKUS:APA91bF-TgRs3_7PsPY5pndPs-7jfOJiiKSiD3GHi-jtch_rVJtRC3XEeVHyUfYUcm48Ooe6hsmGtp-bknN4EYP0ASURMDxpwtoMtlbzDWgVrQycdC1na0b9_Plt1J9XF1VF2rmV_N_H"
        //"cTKuU0y-Taujyc3zeJU93H:APA91bEffNzPfC8Jb3AWjUWjm8U-viD6N4ErvpR6kStHa3rU2s8IxqOXfb9iQUiv_N6rGTtfmW6nH0ourU7uksJg3WM1A9kWGxHdWXla3q7Byg3NnGFSSGDutPuX56wAQGTuxbr4nNhB"
    val message = Message.builder()
        .putData("action", "NEWPOST")
        .putData("contents", """{
          "id": 1,
          "author": " ",
          "content": " ",
          "publish": " ",
          "like": 0,
          "share": 10,
          "viewEye": 1,
          "likeByMe": false,
          "video": " "
        }""")
//        .putData("content", """{
//          "userId": 1,
//          "userName": "Vasiliy",
//          "postId": 2,
//          "postAuthor": "Netology"
//        }""")
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}