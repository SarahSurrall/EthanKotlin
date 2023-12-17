package com.example.ethanapp.ui.diary

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


data class DiaryEntry(
    val notes: String,
    val ts: String,
    val emoji: Int
)

class DiaryDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,  null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "diary.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "allnotes"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TS = "ts"
        private const val COLUMN_NOTES = "notes"
        private const val COLUMN_EMOJI = "emoji"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY_KEY, $COLUMN_NOTES TEXT, $COLUMN_TS TEXT, $COLUMN_EMOJI INTEGER)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }

    fun insertNote(entry: DiaryEntry ){
        val db = writableDatabase
        val values = ContentValues().apply{
            put(COLUMN_NOTES, entry.notes)
            put(COLUMN_EMOJI, entry.emoji)
            put(COLUMN_TS, entry.ts)
        }
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getAllEntries() : List<DiaryEntry>{
        val notesList = mutableListOf<DiaryEntry>()
        val db = readableDatabase
        val query =  "SELECT * FROM $TABLE_NAME"
        val cursor =  db.rawQuery(query, null)

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
            val notes = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOTES))
            val ts = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TS))
            val emoji = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_EMOJI))

            notesList.add(DiaryEntry(notes, ts, emoji))
        }
        return notesList
    }
}
