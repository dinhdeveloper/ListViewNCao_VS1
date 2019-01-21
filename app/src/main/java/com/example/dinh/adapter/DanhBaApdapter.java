package com.example.dinh.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dinh.listviewncao_vs1.R;
import com.example.dinh.model.DanhBa;

import java.util.List;

public class DanhBaApdapter extends ArrayAdapter<DanhBa> {

    Activity context; //màn hình sử dụng layout này.
    int resource;//layout cho từng dòng muốn hiển thị : item.xml
    List<DanhBa> objects;// danh sách nguồn dữ liệu hiển thị lên giao diện.
    public DanhBaApdapter(Activity context, int resource, List<DanhBa> objects) {
        super(context, resource, objects);
        this.context= context;
        this.objects = objects;
        this.resource = resource;
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        //Là 1 lớp build 1 layout bình thường thành code java mà andoid hiểu đc.
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null); //lay item.xml qua
        //lay tung cai trong item.xml
        TextView txtTen = row.findViewById(R.id.txtTen);
        TextView txtPhone = row.findViewById(R.id.txtPhone);
        ImageButton btnCall = row.findViewById(R.id.btnCall);
        ImageButton btnSMS = row.findViewById(R.id.btnSms);
        ImageButton btnChiTiet = row.findViewById(R.id.btnChiTiet);
        //int position : ve tung cai len tren layout
        final DanhBa db = this.objects.get(position);//trả về danh bạ hiện tại muốn vẽ
        txtTen.setText(db.getTen());
        txtPhone.setText(db.getSdt());

        //xu ly su kien
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLySuKienCall(db);
            }
        });
        return row;
    }

    private void xuLySuKienCall(DanhBa db) {
        Toast.makeText(this.context,"Bạn muốn gọi: "+db.getTen(),Toast.LENGTH_SHORT).show();
    }
}
