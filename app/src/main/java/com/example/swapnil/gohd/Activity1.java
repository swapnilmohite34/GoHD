package com.example.swapnil.gohd;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity1 extends ActionBarActivity implements AdapterView.OnItemClickListener {
 private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private ListView list;
    public TextView myText;
    String[] category;
    private MyAdapter myAdapter;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
       drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        list=(ListView)findViewById(R.id.list);
        category=getResources().getStringArray(R.array.category);
        myAdapter=new MyAdapter(this);
        list.setAdapter(myAdapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setOnItemClickListener(this);
       actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.drawable.ic_img,R.string.opendrawer,R.string.closedrawer);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
      ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        fragmentManager=getSupportFragmentManager();
            }


    private void loadSelection(int i){
        switch (i){
            case 0: Fragment2 fragmen=new Fragment2();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framgmentholder,fragmen);
                fragmentTransaction.commit();
            case 1:
                Fragment1 fragment1=new Fragment1();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framgmentholder,fragment1);
                fragmentTransaction.commit();
                break;
            case 2:
                Fragment2 fragment2=new Fragment2();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framgmentholder,fragment2);
                fragmentTransaction.commit();
                break;
            case 3:
                Fragment3 fragment3=new Fragment3();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framgmentholder,fragment3);
                fragmentTransaction.commit();
                break;
            case 4:
                Fragment4 fragment4=new Fragment4();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framgmentholder,fragment4);
                fragmentTransaction.commit();
                break;
            case 5:
                Fragment5 fragment5=new Fragment5();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framgmentholder,fragment5);
                fragmentTransaction.commit();
                break;
            case 6:
                Fragment6 fragment6=new Fragment6();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framgmentholder,fragment6);
                fragmentTransaction.commit();
                break;
        }
        drawerLayout.closeDrawer(list);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id==android.R.id.home){
            if(drawerLayout.isDrawerOpen(list)){
                drawerLayout.closeDrawer(list);
            }
            else{
                drawerLayout.openDrawer(list);
            }
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,category[i]+" was selected",Toast.LENGTH_SHORT).show();
        selectItem(i);
        loadSelection(i);
    }
    public void selectItem(int i){
        list.setItemChecked(i, true);
        setTitle(category[i]);
    }
    public  void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
class MyAdapter extends BaseAdapter{
    private Context context;
    String[] category;
    int[] images={R.drawable.ic_2,R.drawable.ic_1,R.drawable.ic_5,R.drawable.ic_3,R.drawable.ic_6,R.drawable.ic_4};
    public MyAdapter(Context context){
        this.context = context;
        category=context.getResources().getStringArray(R.array.category);

    }
    @Override
    public int getCount(){
    return category.length;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row;
        Typeface tf = Typeface.createFromAsset(context.getAssets(),
                "fonts/GreatVibes.otf");
        if (view == null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.custom_row,viewGroup,false);
        }
        else{
            row=view;
        }
        TextView title=(TextView)row.findViewById(R.id.t1);
        title.setTypeface(tf);
        ImageView titleimageView=(ImageView)row.findViewById((R.id.imageview));
        titleimageView.setImageResource(images[i]);
        title.setText(category[i]);

        return row;

    }
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Object getItem(int i) {
        return category[i];
    }
}