package sg.edu.rp.c346.id20023243.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class EditSong extends AppCompatActivity {

    TextView tvSongId, tvId, tvTitle, tvSingers, tvYear, tvStars;
    EditText etTitle, etSingers, etYear;
    Button btnUpdate, btnDelete, btnCancel;
    RadioGroup rgStars;
    Song song;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_song);

        tvSongId = findViewById(R.id.tvSongId);
        tvId = findViewById(R.id.tvId);
        tvTitle = findViewById(R.id.tvSongTitle);
        tvSingers = findViewById(R.id.tvSingers);
        tvYear = findViewById(R.id.tvYear);
        tvStars = findViewById(R.id.tvStars);
        etTitle = findViewById(R.id.etSongTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);
        rgStars = findViewById(R.id.rgStars);


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditSong.this);
                song.setTitle(etTitle.getText().toString());
                dbh.updateSong(song);
                dbh.close();

                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditSong.this);
                dbh.deleteSong(song.get_id());

                finish();
            }
        });



    }
}