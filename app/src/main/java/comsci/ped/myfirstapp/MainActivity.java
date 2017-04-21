package comsci.ped.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //explicit
    ListView listView;
    private int[] ints = new int[]{R.drawable.traffic_01, R.drawable.traffic_02, R.drawable.traffic_03, R.drawable.traffic_04,
            R.drawable.traffic_05, R.drawable.traffic_06, R.drawable.traffic_07, R.drawable.traffic_08, R.drawable.traffic_09,
            R.drawable.traffic_10, R.drawable.traffic_11, R.drawable.traffic_12, R.drawable.traffic_13, R.drawable.traffic_14,
            R.drawable.traffic_15, R.drawable.traffic_16, R.drawable.traffic_17, R.drawable.traffic_18, R.drawable.traffic_19,
            R.drawable.traffic_20,};

    private String[] titleStrings, detailStrings, shortStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initial view ผูกตัวแปรกับไอดีของ view
        listView = (ListView) findViewById(R.id.livTraffic);

        //get value
        titleStrings = getResources().getStringArray(R.array.title);
        detailStrings = getResources().getStringArray(R.array.detail);
        shortStrings = new String[detailStrings.length]; // จองพื้นที่ในหน่วยความจำให้กับตัวแปร shortstring
        for (int i = 0; i < detailStrings.length; i++) {
            shortStrings[i] = detailStrings[i].substring(0, 29) + "..."; // ได้ข้อความ 30 ตัวอักษร


        }  // end for

        //Substring detailstring ตัดคำในส่วนของ detail เพื่อให้ไม่เกิน 30 ตัวอักษร

        //create listview
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, ints, titleStrings, shortStrings);
        listView.setAdapter(myAdapter);

        //active when cick listview ลิ้งไปหน้าdetail เมื่อคลิกเลือกไอเทม
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { //เมื่อมีการคลิ๊กข้อมูลต่ำแหน่งใดจะเก็บข้อมูลตำแหน่งจากการคลิ๊ก

                Intent intent = new Intent(MainActivity.this, Detail.class);
                intent.putExtra("Title", titleStrings[position]);
                intent.putExtra("Detail", detailStrings[position]);
                intent.putExtra("Image", ints[position]);
                startActivity(intent);
            }
        });

    } // main method onCreate

    public void onClickMoreInfo(View view) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.dlt.go.th/th/dlt-knowledge/view.php?_did=111"));
        startActivity(intent);

    }// main method onclickmoreinfo

    public void onClickAboutme(View view) {
        Intent intent = new Intent(MainActivity.this, Aboutme.class);
        startActivity(intent);
    }
}
