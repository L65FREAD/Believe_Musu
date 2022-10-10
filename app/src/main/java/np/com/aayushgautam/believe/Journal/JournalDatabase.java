package np.com.aayushgautam.believe.Journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class JournalDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "JournalDB";
    private static final String DATABASE_TABLE = "JournalTable";

    //column names for database table
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_DATE = "date";
    private static final String KEY_TIME = "time";

    public JournalDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE nameTable(id INT PRIMARY KEY, title TEXT, content TEXT, date TEXT, time TEXT);
        String createDb = "CREATE TABLE "+DATABASE_TABLE+" ("+
                KEY_ID+" INTEGER PRIMARY KEY,"+
                KEY_TITLE+" TEXT,"+
                KEY_CONTENT+" TEXT,"+
                KEY_DATE+" TEXT,"+
                KEY_TIME+" TEXT"
                +" )";
        db.execSQL(createDb);
//        Journal journal = new Journal("What's a Journal?","Journaling is simply the recapturing of moments in the form of writing. We write down our feelings and thoughts into a journal to better understand them.\n" +
//                "\n" +
//                "Journaling has several mental health benefits. It provides us with the medium to keep our emotions in check, reduce stress, and manage anxiety. Writing down your life experiences can be future reminders that eventually everything will be fine. \n" +
//                "\n" +
//                "There are and will be hardships in life, but just like we outlived them before, we will eventually get past this one too. Writing a Journal not only makes us feel good, it provides us an opportunity to relive the events we’ve been through in a safe environment where we can process them without fear or stress. By journaling, we get to know ourselves better. \n" +
//                "\n" +
//                "Spend a few minutes every day writing in your journal. Keep a pen or paper close to you or use your smartphone. Draw or make creative interpretations if you like. Using Believe App, you can easily write unlimited journals","05/25","00:00");
//        addJournal(journal);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion>=newVersion){
            return;
        }
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }

    public long addJournal(Journal journal){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(KEY_TITLE, journal.getTitle());
        c.put(KEY_CONTENT, journal.getContent());
        c.put(KEY_DATE, journal.getDate());
        c.put(KEY_TIME, journal.getTime());

        long ID = db.insert(DATABASE_TABLE, null, c);
        return ID;
    }

    public Journal getJournal(long id){
        // select * from databaseTable where id=1
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DATABASE_TABLE,
                new String[] {KEY_ID, KEY_TITLE, KEY_CONTENT, KEY_DATE, KEY_TIME},
                KEY_ID+"=?", new String[] {String.valueOf(id)},
                null,
                null,
                null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        assert cursor != null;
        return new Journal(
                cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4));
    }

    public List<Journal> getJournals(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Journal> allJournals = new ArrayList<>();
        // select * from databaseName

        String query = "SELECT * FROM " + DATABASE_TABLE;
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()) {
            do {
                Journal journal = new Journal();

                journal.setID(cursor.getLong(0));
                journal.setTitle(cursor.getString(1));
                journal.setContent(cursor.getString(2));
                journal.setDate(cursor.getString(3));
                journal.setTime(cursor.getString(4));

                allJournals.add(journal);

            } while (cursor.moveToNext());
        }

        return  allJournals;
    }

    public int editJournal(Journal journal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();

        c.put(KEY_TITLE,journal.getTitle());
        c.put(KEY_CONTENT,journal.getContent());
        c.put(KEY_DATE,journal.getDate());
        c.put(KEY_TIME,journal.getTime());

        return db.update(DATABASE_TABLE,c, KEY_ID+"=?",new String[] {String.valueOf(journal.getID())});
    }

    public void deleteJournal(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE,KEY_ID+"=?", new String[] {String.valueOf(id)});
        db.close();
    }
}
