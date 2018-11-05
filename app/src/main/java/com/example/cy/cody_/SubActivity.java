package com.example.cy.cody_;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Button button = (Button)findViewById(R.id.usergetpic);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
        Button button1=(Button)findViewById(R.id.usersaveboa);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shows();
            }
        });
    }
    void show()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(" 오늘 뭐 입지?");
        builder.setMessage("사진 선택을 위해 카메라 액세스 허용 하시겠습니까? ");
        builder.setPositiveButton("승인",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"승인을 선택했습니다.",Toast.LENGTH_LONG).show();
                    }
                });
        builder.setNegativeButton("차단",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"차단을 선택했습니다.",Toast.LENGTH_LONG).show();
                    }
                });
        builder.show();
    }
    void shows(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(" 오늘 뭐 입지?");
        builder.setMessage("작성하신 게시물을 저장하시겠습니까? ");
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"예를 선택했습니다.",Toast.LENGTH_LONG).show();
                    }
                });
        builder.setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"아니오를 선택했습니다.",Toast.LENGTH_LONG).show();
                    }
                });
        builder.show();
    }
//    public void onClick(View view){
//        finish();
//    }
}