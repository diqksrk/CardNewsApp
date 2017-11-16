package com.alienage.android.imageeditor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class loginativity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        loginButton();
    }

    public void loginButton(){    //로그인 버튼 클릭시 작동하는 메소드
        Button btn=(Button)findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(loginativity.this,MainActivity2.class);
                startActivity(intent); // 화면 넘김.
            }
        });
    }
}
