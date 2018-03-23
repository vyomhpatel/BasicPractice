package b12app.vyom.com.b12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    TextView tvHome ;
    Button btnHome;
    EditText hEdittxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        tvHome = findViewById(R.id.tvHome);
        hEdittxt = findViewById(R.id.etHome);
        Intent intent1 = getIntent();
       String username =  intent1.getStringExtra(Constants.KEY_USER);
       hEdittxt.setText(username);
}

    public void onClickHome(View view) {

        EditText hEditText = findViewById(R.id.etHome);
        String home = hEditText.getText().toString();
        Intent intent1 = new Intent();
        intent1.putExtra(Constants.KEY_HOME,home);
        setResult(RESULT_OK,intent1);
        finish();

    }
}
