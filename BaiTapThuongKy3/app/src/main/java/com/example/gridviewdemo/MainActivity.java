package com.example.gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.ISendDataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            Fragment1 firstFragment = new Fragment1();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.frgmnt1_DSSP, firstFragment);
            ft.commit();
        }

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Fragment2 secondFragment = new Fragment2();
            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
            ft2.add(R.id.frgmnt2_CTSP, secondFragment);
            ft2.commit();
        }
    }

    @Override
    public void sendData(String ten, String gia, int hinh, String mota, String xuatxu, String thanhphan, String khuyenmai) {
        Fragment2 fragment2 = new Fragment2();

        Bundle args = new Bundle();
        args.putString("ten", ten);
        args.putString("gia", gia);
        args.putString("mota", mota);
        args.putString("xuatxu", ten);
        args.putString("thanhphan", thanhphan);
        args.putString("khuyenmai", khuyenmai);
        args.putInt("hinh", hinh);
        fragment2.setArguments(args);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frgmnt2_CTSP, fragment2)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frgmnt1_DSSP, fragment2)
                    .addToBackStack(null)
                    .commit();
        }
    }
}