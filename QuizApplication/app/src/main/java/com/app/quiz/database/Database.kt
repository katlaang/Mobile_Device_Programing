package com.app.quiz.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.app.quiz.dao.QuizDao
import com.app.quiz.entity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors


@Database(
    entities = [Question::class],
    version = 1,
    exportSchema = true )
abstract  class QuizDatabase : RoomDatabase(){
    private val IO_EXECUTOR = Executors.newSingleThreadExecutor()
    abstract fun getQuizDao() : QuizDao
    companion object {
        @Volatile private var instance : QuizDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context, scope: CoroutineScope) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context, scope).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context,scope: CoroutineScope) = Room.databaseBuilder(
            context.applicationContext,
            QuizDatabase::class.java,
            "QuizDatabase"
        ).addCallback(object :RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                scope.launch {
                    instance?.let {
                        it.getQuizDao().addQuestions(
                            Question("1. Android is developed by.", "Google","Nokia","Android Inc",  "Microsoft", 2, 1),
                            Question("2. Which company bought Adroid?", "Apple","No company", "Nokia", "Google", 3, 1),
                            Question("3. Web browser available in android is based on", "Chrome", "Firefox", "Open-source Webkit", "Opera", 2, 1),
                            Question("4. Android is based on which kernel?", "Linux Kernel", "Windows Kernel", "MAC Kernel", "Hybrid Kernel",0, 1),
                            Question("5. Android is based on which language", "C", "C++", "Kotlin", "C#", 2, 1),
                            Question("6.  If you want to increase the whitespace between widgets, you will need to use the ____________ property", "Android:padding", "Android:digits", "Android:capitalize", "Android:autoText", 0, 1),
                            Question("7. Which of the following Dialog boxes are supported by Android? 1) AlertDialog 2) ProgressDialog 3) DatePickerDialog 4) TimePickerDialog", "1 and 2", "3 and 4", "All of the above", "None of the above", 2, 1),
                            Question("8. Using a content provider, which of the following operations are able to perform? 1) create 2) read 3) update 4) delete", "1,2,3","2,3,4", "All of the above", "None of the above",1,1 ),
                            Question("9. Which of the following are different storage methods available in Android? 1) Shared Preferences 2) Internal Storage 3) External Storage 4) SQLite Databases 5) Network Connection 6)Intermediate storage", "1,2,3,4,6", "2,3,4,5,6", "1,2,3,4,5", "All", 3, 1),
                            Question("10. In ___________, sender specifies type of receiver.", "implicit intent", "explicit intent", "Both", "None", 1, 1),
                            Question("11. Which of the following(s) is/are component of APK file?", "Resources", "Delvik Excetuable", "Both", "None",2, 1),
                            Question("12. Which of the following don’t have any UI component and run as a background process?", "Services", "Simulator", "Emulator", "None", 0, 1),
                            Question("13. What are the layouts available in android?", "LinearLayout", "FrameLayout", "TableLayout", "All", 3, 1),
                            Question("14. How to store heavy structured data in android?", "SharedPreferences", "Cursor", "SQLIte database", "Not possible",  2, 1),
                            Question("15. Is it mandatory to call onCreate() and onStart() in android?", "No, we can write the program without writing onCreate() and onStart()", "Yes, we should call onCreate() and onStart() to write the program", "At least we need to call onCreate() once", "None", 2, 1)
                        )
                    }

                }


            }
        }).build()
    }


}