package joseph.roundmelon.com.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Fetch extends AppCompatActivity {


    SharedPreferences sharedPreferences;

    TextView name,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);
        sharedPreferences = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);

        name = findViewById(R.id.name);
        number = findViewById(R.id.number);


        name.setText(sharedPreferences.getString("name",null));
        int num = sharedPreferences.getInt("number",0);
        number.setText(Integer.toString(num));
        //TODO add .remove(name) and .clear()

    }
}
