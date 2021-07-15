package sg.edu.rp.c346.id20023243.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle, tvSingers, tvYear, tvStars;
    EditText etTitle, etSingers, etYear;
    Button btnInsert, btnShowList;
    RadioGroup rgStars;
    ArrayList<Song> alSong;
    ArrayAdapter<Song> aaSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvSongTitle);
        tvSingers = findViewById(R.id.tvSingers);
        tvYear = findViewById(R.id.tvYear);
        tvStars = findViewById(R.id.tvStars);
        etTitle = findViewById(R.id.etSongTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        btnInsert = findViewById(R.id.btnUpdate);
        btnShowList = findViewById(R.id.btnDelete);
        rgStars = findViewById(R.id.rgStars);

        alSong = new ArrayList<Song>();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String singers = etSingers.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int rbstar = 0;
                if (rgStars.getCheckedRadioButtonId() == R.id.rb1) {
                    rbstar += 1;
                }
                else if (rgStars.getCheckedRadioButtonId() == R.id.rb2) {
                    rbstar += 2;
                }
                else if (rgStars.getCheckedRadioButtonId() == R.id.rb3) {
                    rbstar += 3;
                }
                else if (rgStars.getCheckedRadioButtonId() == R.id.rb4) {
                    rbstar += 4;
                }
                else if (rgStars.getCheckedRadioButtonId() == R.id.rb5) {
                    rbstar += 5;
                }

                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertSong(title, singers, year, rbstar); // because insertMethod returns long, which is  num of items inserted

                if (inserted_id != -1){ //if id returned is -1, means insert to db fail
                    alSong.clear();
                    alSong.addAll(dbh.getAllSongs()); //add songs arrayList from DBHelper
                    aaSong.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ShowList.class);
                String rbstar = "";
                if (rgStars.getCheckedRadioButtonId() == R.id.rb1) {
                    rbstar = "*";
                }
                else if (rgStars.getCheckedRadioButtonId() == R.id.rb2) {
                    rbstar = "**";
                }
                else if (rgStars.getCheckedRadioButtonId() == R.id.rb3) {
                    rbstar = "***";
                }
                else if (rgStars.getCheckedRadioButtonId() == R.id.rb4) {
                    rbstar = "****";
                }
                else if (rgStars.getCheckedRadioButtonId() == R.id.rb5) {
                    rbstar = "*****";
                }
                i.putExtra("rbstar", rbstar);
                startActivity(i);
            }
        });
    }
}