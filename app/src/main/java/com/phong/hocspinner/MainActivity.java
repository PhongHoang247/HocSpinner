package com.phong.hocspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerSanPham;
    ArrayAdapter<String> adapter;

    TextView txtSanPham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        /*
        ListView thì dùng setOnItemClick
        Spinner thì dùng setOnItemSelected
         */
        spinnerSanPham.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Đối số thứ 3 int i là vị trí đc chọn
                String s = adapter.getItem(i);
                txtSanPham.setText(s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void addControls() {
        spinnerSanPham = (Spinner) findViewById(R.id.spinnerSanPham);
        /*Đối số đầu tiên là màn hình sử dụng adapter
        Đối số thứ 2 là layout
         */
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item);
        //Gán dữ liệu cho Adapter
        adapter.add("Cocal");
        adapter.add("Pepsi");
        adapter.add("RedBull");
        adapter.add("Aquavina");
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        //Gán cho Spinner:
        spinnerSanPham.setAdapter(adapter);
        txtSanPham = (TextView) findViewById(R.id.txtSanPham);
    }
}
