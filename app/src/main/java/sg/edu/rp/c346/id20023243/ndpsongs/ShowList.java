package sg.edu.rp.c346.id20023243.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowList extends AppCompatActivity {

    Button btnFiveStars;
    ArrayList<Song> alSongs;
    ArrayAdapter<Song> aaSongs;
    ListView lvSongs;
    Song song;
    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(ShowList.this);
        alSongs.clear(); //clear all contents
        alSongs.addAll(dbh.getAllSongs());
        aaSongs.notifyDataSetChanged();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        Intent i = getIntent();
        song = (Song) i.getSerializableExtra("song");

        lvSongs = findViewById(R.id.lvSongs);
        alSongs = new ArrayList<Song>();
        aaSongs = new ArrayAdapter<Song>(ShowList.this, android.R.layout.simple_list_item_1, alSongs);
        lvSongs.setAdapter(aaSongs);

        DBHelper dbh = new DBHelper(ShowList.this);
        alSongs.clear(); //clear all contents
        alSongs.addAll(dbh.getAllSongs());
        aaSongs.notifyDataSetChanged();

        lvSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song song = alSongs.get(position);
                Intent i = new Intent(ShowList.this,
                        EditSong.class);
                i.putExtra("song", song);
                startActivity(i);
            }
        });

        btnFiveStars = findViewById(R.id.btnFiveStars);
        btnFiveStars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ShowList.this);
                alSongs.clear(); //clear all contents
                //al.addAll(dbh.getAllNotes()); //add back updated notes arrayList from DBHelper
                alSongs.addAll(dbh.getAllSongs());
                aaSongs.notifyDataSetChanged();
            }
        });


    }
}