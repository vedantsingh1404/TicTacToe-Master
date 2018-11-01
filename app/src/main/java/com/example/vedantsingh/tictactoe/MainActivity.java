package com.example.vedantsingh.tictactoe;

/*

** Developed by Vedant Singh
** Date : 31/10/2018

*/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.GridLayout;


public class MainActivity extends AppCompatActivity {
    int currentPlayer = 0;
    String winner;
    int[] currentBoard = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    int gameOn = 1;

    int[][] wins = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void onTurn(View view) {

        ImageView image = (ImageView) view;
        int pos = Integer.parseInt(image.getTag().toString());

        if(gameOn == 1 && currentBoard[pos] == 0) {



            if (currentPlayer == 0) {
                image.setImageResource(R.drawable.ct);
                currentBoard[pos] = currentPlayer + 1;

                image.animate().alpha(1f).setDuration(300);


            } else {
                image.setImageResource(R.drawable.t);
                currentBoard[pos] = currentPlayer + 1;

                image.animate().alpha(1f).setDuration(300);
            }


            for (int[] Wins : wins) {
                if (currentBoard[Wins[0]] == currentBoard[Wins[1]] && currentBoard[Wins[0]] == currentBoard[Wins[2]] && currentBoard[Wins[0]] != 0) {
                    if (currentPlayer == 0) {
                        winner = "Counter-Terrorists";

                    } else if (currentPlayer == 1) {
                        winner = "Terrorists";
                    }

                    TextView winningText = findViewById(R.id.winningText);

                    winningText.setText(winner + " Win!");

                    LinearLayout newGame = findViewById(R.id.layout2);

                    newGame.setVisibility(View.VISIBLE);

                    gameOn = 0;


                }
            }

            int flag = 0;

            for (int i = 0; i < 9; i++) {
                if (currentBoard[i] == 0) flag = 1;
            }

            if (flag == 0) {
                gameOn = 0;
                TextView winningText = findViewById(R.id.winningText);
                winningText.setText("It's a Draw !");

                LinearLayout newGame = findViewById(R.id.layout2);

                newGame.setVisibility(View.VISIBLE);
            }

            currentPlayer = (currentPlayer + 1) % 2;

            for (int i = 0; i < 9; i++) {

                String string = Integer.toString(currentBoard[i]);

                Log.i("Info", string);
            }
        }
    }

    public void playAgain(View view) {
        LinearLayout newGame = findViewById(R.id.layout2);

        newGame.setVisibility(View.INVISIBLE);

        gameOn = 1;
        currentPlayer = 0;

        for(int i = 0;i < 9;i ++) {
            currentBoard[i] = 0;
        }

        ImageView image1 = findViewById(R.id.imageView6);
        ImageView image2 = findViewById(R.id.imageView14);
        ImageView image3 = findViewById(R.id.imageView15);
        ImageView image4 = findViewById(R.id.imageView16);
        ImageView image5 = findViewById(R.id.imageView17);
        ImageView image6 = findViewById(R.id.imageView18);
        ImageView image7 = findViewById(R.id.imageView19);
        ImageView image8 = findViewById(R.id.imageView20);
        ImageView image9 = findViewById(R.id.imageView21);

        image1.setAlpha(0f);
        image2.setAlpha(0f);
        image3.setAlpha(0f);
        image4.setAlpha(0f);
        image5.setAlpha(0f);
        image6.setAlpha(0f);
        image7.setAlpha(0f);
        image8.setAlpha(0f);
        image9.setAlpha(0f);




    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
