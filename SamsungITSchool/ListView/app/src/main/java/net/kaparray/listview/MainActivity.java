package net.kaparray.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        final ListView listView = (ListView) findViewById(R.id.List_View);
        final CountAdapter adapter = new CountAdapter(this,
                getResources().getStringArray(R.array.countries_array));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i,
                                    long id) {
                String country = (String)adapterView.getItemAtPosition(i);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://en.wikipedia.org/wiki/"
                        + country.replace(" ", "_") ));
                startActivity(intent);
            }

        });
        listView.setAdapter(adapter);
    }


    public class CountAdapter extends ArrayAdapter{

        public CountAdapter(@NonNull Context context,
                        @NonNull Object[] objects) {
            super(context, R.layout.fuck, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            //if(convertView == null) {
               convertView = LayoutInflater.from(getContext()).inflate(R.layout.fuck, null);
                TextView num = convertView.findViewById(R.id.tv_number);
                int id = (int)getItemId(position);
                num.setText(id + "");
                if (id % 2 == 0) {
                    convertView.setBackgroundColor(Color.rgb(200, 200, 200));
                }
                TextView name = convertView.findViewById(R.id.tv_countr);
                name.setText((String) getItem(position));
            //}
            return convertView;
        }
    }
}
