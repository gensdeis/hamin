package uc.daelim.com.dmoney;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class Management_View extends Activity {

    Integer[] posterID = {R.drawable.list1, R.drawable.list2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management_view);

        // ArrayAdapter를 통해 LIST로 표시할 오브젝트를 지정한다.
        // 여기서는 심플하게 그냥 String
        // 레이아웃 android.R.layout.simple_list_item_1 는 안드로이드가 기본적으로 제공하는 간단한 아이템 레이아웃
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        Integer[] imageId = {
                R.drawable.list1,
                R.drawable.list2
        };

        // 아이템을 추가
        adapter.add("item1");
        adapter.add("item2");
        adapter.add("item3");

        // ListView 가져오기
        ListView listView = (ListView) findViewById(R.id.managementList);

        // ListView에 각각의 아이템표시를 제어하는 Adapter를 설정
        listView.setAdapter(adapter);

        // 아이템을 [클릭]시의 이벤트 리스너를 등록
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;
                // 아이템 클릭시에 구현할 내용은 여기에.
                String item = (String) listView.getItemAtPosition(position);
                Toast.makeText(Management_View.this, item, Toast.LENGTH_LONG).show();
            }
        });

        // 아이템을 [선택]시의 이벤트 리스너를 등록
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                ListView listView = (ListView) parent;
                // 아이템 선택시에 구현할 내용은 여기에.
                String item = (String) listView.getSelectedItem();
                Toast.makeText(Management_View.this, item, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
