package com.example.student.test08;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2017-07-06.
 */

public class MainActivity extends Activity {
    private EditText editText;
    private Button btnadd;
    private Button btnshow;
    private ListView listviewWord;

    // 리스트뷰 아니템 나열하는 어댑터와 단어 묶음
    private ArrayAdapter<String> adapter;
    private List<String> wordList;
    private MyDBHelper helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_word);
        btnadd = (Button)findViewById(R.id.btn_add);
        btnshow = (Button) findViewById(R.id.btn_show);
        listviewWord = (ListView) findViewById(R.id.listview_word);


        wordList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, wordList);

        listviewWord.setAdapter(adapter);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputword = editText.getText().toString();

                // 입력된 단어를 데이터베이스에 추가
                helper.insert(inputword);
            }
        });
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 데이터베이스의 단어들을 select 해서
                // 어댑터에게 단어 목록을 넘겨야 함.

                List<String> selectedWordList = helper.selectAll();

            }
        });
    }
}
