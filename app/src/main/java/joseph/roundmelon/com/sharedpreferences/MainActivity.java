package joseph.roundmelon.com.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt,num;
    Button button;


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = sharedPreferences.edit();


        txt = findViewById(R.id.txt);
        num = findViewById(R.id.num);

        button = findViewById(R.id.button);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txt.getText().toString().equals("") && !num.getText().toString().equals("")){
                    editor.putString("name",txt.getText().toString());
                    editor.putInt("number",Integer.parseInt(num.getText().toString()));
                    editor.commit();


                    Intent fetchIntent = new Intent(MainActivity.this,Fetch.class);
                    startActivity(fetchIntent);

                }else {
                    Toast.makeText(MainActivity.this, "Please Fill All Fields!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
