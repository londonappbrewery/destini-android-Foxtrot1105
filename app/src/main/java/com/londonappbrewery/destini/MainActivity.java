package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView actualStory;
    Button topButton;
    Button bottomButton;
    int mStoryIndex=1;
    int topCounter;
    int bottomCounter;
    int[] story_array= new int[]{R.string.T1_Story, R.string.T2_Story, R.string.T3_Story,
            R.string.T4_End, R.string.T5_End, R.string.T6_End};
    int[] top_array= new int[] {R.string.T1_Ans1, R.string.T2_Ans1, R.string.T3_Ans1};
    int[] bottom_array= new int[] {R.string.T1_Ans2, R.string.T2_Ans2, R.string.T3_Ans2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        actualStory= findViewById(R.id.storyTextView);
        topButton= findViewById(R.id.buttonTop);
        bottomButton= findViewById(R.id.buttonBottom);

        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStoryIndex==1 || topCounter==2) {
                    display(3);
                    mStoryIndex=0;
                    topCounter=3;
                    bottomCounter=3;
                }else if(topCounter==3){
                    display(6);
                }

            }
        });

        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStoryIndex==1){
                    display(2);
                    mStoryIndex=0;
                    topCounter=2;
                    bottomCounter=2;
                }else if(bottomCounter==3){
                    display(5);
                }else if(bottomCounter==2){
                    display(4);
                }

            }
        });
    }

    public void display(int index){
        actualStory.setText(story_array[index-1]);
        if(index<4) {
            topButton.setText(top_array[index-1]);
            bottomButton.setText(bottom_array[index-1]);
        }
        else{
            topButton.setVisibility(View.GONE);
            bottomButton.setVisibility(View.GONE);
        }
    }
}
