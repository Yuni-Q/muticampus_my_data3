package com.example.student.test07_naver;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;


/**
 * Created by student on 2017-07-05.
 */

public class BookAdapter extends ArrayAdapter<BookVO> {
    private Context context; //mainActiviy 주소
    private List<BookVO> bookList; // 데이터 묶음
    private int layoutId; // 아이템 레이아웃 xml

    public BookAdapter(Context context, int layoutId,List<BookVO> bookList) {
        super(context, layoutId,bookList);
        this.context=context;
        this.bookList=bookList;
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //데이터 묶음에서 position번째 데이터 하나 뽑아서
        //리스트뷰 아이템으로 만들어 주는 메소드
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View wholeItem = inflater.inflate(layoutId,null);


        TextView textTile=(TextView)wholeItem.findViewById(R.id.text_title);
        TextView textAuthor=(TextView)wholeItem.findViewById(R.id.text_author);
        TextView textPub=(TextView)wholeItem.findViewById(R.id.text_pub);
        TextView textPrice=(TextView)wholeItem.findViewById(R.id.text_price);
        TextView textDiscount=(TextView)wholeItem.findViewById(R.id.text_discount);

        BookVO bookVO = bookList.get(position);
        textTile.setText(bookVO.getTitle());
        textAuthor.setText(bookVO.getAuthor());
        textPub.setText(bookVO.getPublisher());
        textPrice.setText(bookVO.getPrice());
        textDiscount.setText(bookVO.getDiscount());

        return wholeItem;
    }
}
