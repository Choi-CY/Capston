package com.example.cy.cody_.Closet;

import android.content.Intent;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.example.cy.cody_.R;

import java.io.File;
import java.util.ArrayList;

public class OuterActivity extends AppCompatActivity{
    private DrawerLayout mDrawerLayout; // 서랍 레이아웃
    private RecyclerView mRecyclerView;
    private ListViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private File file;
    private ArrayList Outer_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);// 뒤로가기 버튼
        actionBar.setDisplayHomeAsUpEnabled(true); // 네비게이션 메뉴를 사용하기 위한 코드

        mDrawerLayout = findViewById(R.id.drawer_layout); // 네비게이션 메뉴 사용 객체

        NavigationView navigationView = findViewById(R.id.navigation_view);
        // 네비게이션 메뉴바 구동
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();

                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.navigation_item_attachment:
                        Intent MyInfo = new Intent(OuterActivity.this, UserinfoActivity.class);
                        startActivity(MyInfo);
                        break;
                    case R.id.nav_sub_menu_item01:
                        Toast.makeText(OuterActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_sub_menu_item02:
                        Toast.makeText(OuterActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_sub_menu_item03:
                        Toast.makeText(OuterActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_sub_menu_item04:
                        Toast.makeText(OuterActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                        break;

                }

                return true;
            }
        });

        GridView gridView = (GridView) findViewById(R.id.gridview1);

        Outer_list= new ArrayList<>();

        String rootSD = Environment.getExternalStorageDirectory().toString();
        file = new File(rootSD+"/Pictures");
        File[] list = file.listFiles();// SD 카드 전체 파일을 다 불러 오는 친구들

        for(int i=0; i<list.length;i++){
            if(list[i].getName().substring((list[i].getName().length()-10),(list[i].getName().length()-4)).equals("_Outer")){
                Outer_list.add(list[i]);
            };
        }

        gridView.setAdapter(new ImageAdapter(this,Outer_list,"Outer"));


    }








    // 보통 ListView는 통신을 통해 가져온 데이터를 보여줍니다.
    // arrResId, titles, contents를 서버에서 가져온 데이터라고 생각하시면 됩니다.

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // 메뉴키를 눌렀을때
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }// 메뉴키를 눌렀을때 해당 아이디에 있는 메뉴를 객체화 시킨다.

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // 메뉴 아이템이 클릭되었을때 발동
        int id = item.getItemId(); // 아이템의 아이디를 얻는다.
        switch (id) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START); // 햄버거 메뉴를 눌렀을때
                return true;
            case R.id.action_settings: // 점 3개를 눌렀을때
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
