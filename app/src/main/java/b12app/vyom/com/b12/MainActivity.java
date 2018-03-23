package b12app.vyom.com.b12;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String CALCULATOR_PACKAGE ="com.android.calculator2";
    public static final String CALCULATOR_CLASS ="com.android.calculator2.Calculator";

    public static String TAG = MainActivity.class.getSimpleName();

    EditText emailTxt;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         emailTxt = findViewById(R.id.etUsername);
         pass = findViewById(R.id.etPass);
        Button login = findViewById(R.id.btnLogin);
        Button signup = findViewById(R.id.btnSignup);

        signup.setOnClickListener(this);
        login.setOnClickListener(this);

        Log.i(TAG,getString(R.string.onCreateCall));

        if(savedInstanceState!=null){
            emailTxt.setText(savedInstanceState.getString(Constants.KEY_NAME));
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"On pause called");
    }

    @Override
    protected void onStop() {

        super.onStop();
        Log.i(TAG, "On Stop called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"On resume called");
    }

    @Override
    public void onClick(View view) {


            switch(view.getId()) {
                case R.id.btnSignup:
//                String email = emailTxt.getText().toString();
//                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 9998815086"));
//                startActivity(i);
//
//
//                Toast.makeText(this, "This Toast is for email: " + email, Toast.LENGTH_LONG).show();
//                break;

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    intent.setComponent(new ComponentName(
                            CALCULATOR_PACKAGE,
                            CALCULATOR_CLASS));

                    MainActivity.this.startActivity(intent);
                    break;
                    
                case R.id.btnLogin:
                    String email1 = emailTxt.getText().toString();
//                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//                    alertDialog.setTitle("Login Alert");
//                    alertDialog.setMessage("This is an alert for email: "+email1);
//                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"Ok" ,
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int which) {
//                                    dialog.dismiss();
//                                }
//                            });
//                    alertDialog.show();

                    Intent intent1 = new Intent(this,Home.class);
                    intent1.putExtra(Constants.KEY_USER,email1);
                    startActivityForResult(intent1,007);



                    break;
            }
        }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        String name = emailTxt.getText().toString();
        String pass1 = pass.getText().toString();
        outState.putString(Constants.KEY_NAME,name);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView tvMain = findViewById(R.id.tvMain);
        String home = data.getStringExtra("home");
        tvMain.setText(home);

    }
}
