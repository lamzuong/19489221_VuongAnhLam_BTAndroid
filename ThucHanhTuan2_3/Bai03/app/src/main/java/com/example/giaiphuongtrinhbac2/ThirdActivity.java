package com.example.giaiphuongtrinhbac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        EditText et_SoA = findViewById(R.id.editText_SoA);
        EditText et_SoB = findViewById(R.id.editText_SoB);
        Button bt_Giai = findViewById(R.id.button_Giai);
        bt_Giai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                float a = Float.parseFloat(et_SoA.getText().toString());
                float b = Float.parseFloat(et_SoB.getText().toString());
                PhuongTrinhBacNhat nhat = new PhuongTrinhBacNhat(a,b);
                String kQua = nhat.giaiPhuongTrinhBac1();
                intent.putExtra("kq", kQua);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}