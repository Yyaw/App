package com.example.zichaoyang.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private ImageView imageView;

    private TextView text1;

    private TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ArrayList<HashMap<String, Object>> data = new ArrayList<>();
        for (Student student : getStudents()){
            HashMap<String, Object> map = new HashMap<>();
            map.put("head", student.getImageID());
            map.put("text1", student.getName());
            map.put("text2", student.getAnnounce());
            data.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.item, new String[]{"head", "text1", "text2"}, new int[]{R.id.head, R.id.text1, R.id.text2});
        listView.setAdapter(adapter);
    }

    public void init(){
        this.listView = (ListView) findViewById(R.id.list);
        this.imageView = (ImageView) findViewById(R.id.head);
        this.text1 = (TextView) findViewById(R.id.text1);
        this.text2 = (TextView) findViewById(R.id.text2);
    }

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        int[] images = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e};
        for (int i=0;i<5;i++){
            Student student = new Student(images[i], "zichaoyang" + i, "zichaoyang" + i + "很帅");
            students.add(student);
        }
        return students;
    }

    private class Student{

        private int imageID;

        private String name;

        private String announce;

        public Student(int imageID, String name, String announce) {
            this.imageID = imageID;
            this.name = name;
            this.announce = announce;
        }

        public int getImageID() {
            return imageID;
        }

        public String getName() {
            return name;
        }

        public String getAnnounce() {
            return announce;
        }
    }

}
