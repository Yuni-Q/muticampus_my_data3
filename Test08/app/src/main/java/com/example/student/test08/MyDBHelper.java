package com.example.student.test08;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2017-07-06.
 */

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="my_word.db";
    private static final int DB_VERSION = 1;

    private SQLiteDatabase db;

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        //db에 연결 생성. (insert select 수행전에 확보 해야함)
        db=getReadableDatabase();
        //db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //my_word.db 파일이 처음 생성될 때 1번 실햄됨.
        sqLiteDatabaseddls.execSQL("CREATE TABLE WORD_TAB(WORD_ID INSERT PRIMARY KEY AUTOINCREMENT, WORD TEXT");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //version 정보가 바뀌었을 때 1번 실행됨.
        //(버전 번호는 커지는 것만 가능.)
        //이 예제에서는 버전이 바뀌면 기존 테이블삭제하고 재생성 하게함
        db.execSQL("DROP TABLE IF EXISTS WORD_TAB");
        onCreate(db);
    }
    ////////////////////////////////////////////////////////////////////////
    public void insert(String word){
        // 1번 방법 : SQL 직접 작성
        db.execSQL("INSERT INTO WORD_TAB(WORD) VALUES('"+word+"')");
        // 2번 방법 : 칼럼명과 value를 맵 형태로 만들어서 삽입
        ContentValues values = new ContentValues();
        values.put("WORD",word);

        db.insert("WORD_TAB",null,values);
    }
    public List<String> selectAll(){
        String sql = "SELECT * FROM WORD_TAB";

        Cursor cursor = db.rawQuery(sql,null);

        List<String> wordList = new ArrayList<>();

        while (cursor.moveToNext()==true){
            //컬럼 번호는 0번부터임.
            String word = cursor.getString(1);
            wordList.add(word);

        }
        return  wordList;
    }
}
