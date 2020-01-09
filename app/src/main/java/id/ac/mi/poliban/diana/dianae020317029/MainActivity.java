package id.ac.mi.poliban.diana.dianae020317029;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = findViewById(R.id.rg);
        Button btClear = findViewById(R.id.btClear);
        Button btSubmit = findViewById(R.id.btSubmit);
        EditText editText = findViewById(R.id.etNim);
        EditText editText1 = findViewById(R.id.etNama);
        EditText editText2 = findViewById(R.id.etAlamat);
        EditText editText3 = findViewById(R.id.etTelp);
        RadioButton radioButton = findViewById(R.id.rbLaki);
        RadioButton radioButton1 = findViewById(R.id.rbPr);
        Switch aSwitch = findViewById (R.id.sw);

        aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    if (aSwitch.isChecked()) {
                        editText.setEnabled(true);
                        editText1.setEnabled(true);
                        editText2.setEnabled(true);
                        editText3.setEnabled(true);
                        radioGroup.setEnabled(true);
                    } else {
                        editText.setEnabled(false);
                        editText1.setEnabled(false);
                        editText2.setEnabled(false);
                        editText3.setEnabled(false);
                        radioGroup.setEnabled(false);

                    }
                });


        btSubmit.setOnClickListener(v -> {
            String gender = "";
            if (radioButton.isChecked()) {
                gender+= "Laki Laki";
            }
            if (radioButton1.isChecked()){
                gender+= "Perempuan";
            }

                new AlertDialog.Builder(this)
                        .setTitle("INFO")
                        .setMessage("NIM : " + editText.getText().toString() + "\n" +
                                "Nama : " + editText1.getText().toString() + "\n" +
                                "Gender : " + radioGroup.getCheckedRadioButtonId() + "\n" +
                                "Alamat : " + editText2.getText().toString() + "\n" +
                                "Telp : " + editText3.getText().toString()
                        )
                        .setPositiveButton("OK", null)
                        .setNegativeButton("Cancel", null).show();

            });
            btClear.setOnClickListener(v1 -> {
                editText.setText("");
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                radioGroup.clearCheck();
            });
        }

    }