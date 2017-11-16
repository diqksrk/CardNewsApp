package com.alienage.android.imageeditor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

//메인 메소드
public class MainActivity2 extends AppCompatActivity implements New_gridadapter.onShareClickListener {
    GridView gv1;
    ArrayList<News_Data> data = new ArrayList<>();
    New_gridadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); //데이터가 포함 된 화면
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //액션버튼을 클릭했을때의 동작, 위의 옵션항목 카드뉴스만들기 메소드.
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.making_card:
                Intent intent = new Intent(MainActivity2.this, HomeActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //초기 화면 데이터.
    public void init(){
        gv1 = (GridView)findViewById(R.id.grid_view);
        data.add(new News_Data(R.drawable.signal, "터치는 구식… 이젠 '음파'로 결제한다", "http://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=105&oid=023&aid=0003325532"));
        data.add(new News_Data(R.drawable.sonydog, "소니, 애완견 로봇 '아이보' 내년 1월 출시… 주위 환경 인식 ", "http://news.naver.com"));
        data.add(new News_Data(R.drawable.iot, "홈IoT 노리는 해킹 급증…피해 우려에도 쉬쉬하는 제조사", "http://http://news.naver.com"));
        data.add(new News_Data(R.drawable.revol, "경기도, 로봇·AI·바이오 R&D에 5년간 7천725억 지원", "http://http://news.naver.com"));
        data.add(new News_Data(R.drawable.ai, "SKT,AI 연구 커뮤니티 만든다", "http://http://news.naver.com"));
        data.add(new News_Data(R.drawable.aiattack, "AI의 습격...비즈니스가 바뀐다", "http://news.naver.com"));

        adapter = new New_gridadapter(this, data);
        adapter.setOnShareClickListener(this);
        gv1.setAdapter(adapter);
    }

    @Override
    public void onShare(int position) { //공유하기 기능.
        Toast.makeText(getApplicationContext(), "share", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/sharer/sharer.php?u=" + data.get(position).getNews_html()));
        startActivity(intent);
    }
}

