package com.example.dinh.listviewncao_vs1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.dinh.adapter.DanhBaApdapter;
import com.example.dinh.model.DanhBa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvDanhBa;
    ArrayList<DanhBa> arrDanhBa;
    DanhBaApdapter danhBaApdapter; //lop ke thua cua ArrayApdapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addvent();
    }

    private void addvent() {
    }

    private void addControls() {
        lvDanhBa = findViewById(R.id.lvDanhBa);

        arrDanhBa = new ArrayList<DanhBa>();
        arrDanhBa.add(new DanhBa(1,"Dinh","009876"));
        arrDanhBa.add(new DanhBa(2,"Thu","123456"));
        arrDanhBa.add(new DanhBa(3,"Kim Anh","213454"));
        arrDanhBa.add(new DanhBa(4,"Anh","ewewrf13"));
        arrDanhBa.add(new DanhBa(5,"Kim","213454"));

        danhBaApdapter = new DanhBaApdapter(
                MainActivity.this,
                R.layout.item,
                arrDanhBa
        );

        lvDanhBa.setAdapter(danhBaApdapter);
    }
}
