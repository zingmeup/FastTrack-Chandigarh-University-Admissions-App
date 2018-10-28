package com.example.deepakyadav.fasttrack.Phase1.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.deepakyadav.fasttrack.R;

import java.util.EventListener;

public class AssistantActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText assistantInput;
    ImageView actionBtn;
    boolean actionBtnVoiceSearch=true;
    //action btn false-text
    //action btn true-voice
    /*private View.OnKeyListener finishListening=new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction()==KeyEvent.ACTION_UP){
                Toast.makeText(AssistantActivity.this, "Listenong completed", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };*/
    private View.OnLongClickListener actionBtnOnLongClickLisener=new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            Toast.makeText(AssistantActivity.this, "Speak Now", Toast.LENGTH_SHORT).show();
            actionBtn.setOnTouchListener(finishListening);
            return true;
        }
    };
    private View.OnTouchListener finishListening=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                Log.d("assistant-TouchListener", "actionUp");
                actionBtn.setOnTouchListener(null);
            }
            return true;
        }
    };
    private View.OnKeyListener assistantInputKeyListener=new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            Log.d("assistant-keyListener", "event occured");
            if (assistantInput.getText().toString().isEmpty()){
                actionBtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_chat));
                actionBtnVoiceSearch=true;
            }else{
                actionBtn.setImageDrawable(getResources().getDrawable(R.drawable.flight));
                actionBtnVoiceSearch=false;
                actionBtn.setOnLongClickListener(null);

            }
            return true;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistant);
        assistantInput=findViewById(R.id.assistant_input);
        actionBtn=findViewById(R.id.assistant_action);
        toolbar=findViewById(R.id.assistant_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Talk to our Assistant");

        actionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (actionBtnVoiceSearch){
                    if (assistantInput.getText().toString().isEmpty()){
                        Toast.makeText(AssistantActivity.this, "Hold to speak", Toast.LENGTH_SHORT).show();

                        actionBtn.setOnLongClickListener(actionBtnOnLongClickLisener);
                    }else{
                        Toast.makeText(AssistantActivity.this, "Voice Query sent", Toast.LENGTH_SHORT).show();
                        actionBtn.setOnLongClickListener(actionBtnOnLongClickLisener);
                    }

                }else{
                    actionBtn.setOnLongClickListener(null);
                    if (!assistantInput.getText().toString().isEmpty()) {

                        Toast.makeText(AssistantActivity.this, "Query sent", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        assistantInput.setOnKeyListener(assistantInputKeyListener);
    }
}
