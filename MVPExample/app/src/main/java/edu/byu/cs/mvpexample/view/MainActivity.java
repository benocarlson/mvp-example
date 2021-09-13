package edu.byu.cs.mvpexample.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.byu.cs.mvpexample.R;
import edu.byu.cs.mvpexample.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainPresenter.MainView{

    private EditText textInput;
    private TextView lastWord;
    private Button submitButton;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textInput = findViewById(R.id.inputText);
        this.lastWord = findViewById(R.id.lastWord);
        this.submitButton = findViewById(R.id.submitButton);

        this.presenter = new MainPresenter(this);

        textInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                presenter.verifyText();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.enterInput();
            }
        });
    }

    @Override
    public void displayError() {
        Toast.makeText(MainActivity.this, "Word could not be added!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLastWord(String lastWord) {
        this.lastWord.setText(lastWord);
    }

    @Override
    public String getInputString() {
        return textInput.getText().toString();
    }

    @Override
    public void enableInput() {
        submitButton.setEnabled(true);
    }

    @Override
    public void disableInput() {
        submitButton.setEnabled(false);
    }

    @Override
    public void clearInput() {
        textInput.setText("");
    }
}