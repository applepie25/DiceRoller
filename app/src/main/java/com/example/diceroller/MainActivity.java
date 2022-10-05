package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = (Button) findViewById(R.id.button);
        rollButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rollDice();
                    }
                }
        );

        rollDice();
    }
    private void rollDice() {
        Dice dice = new Dice(6);
        int diceRoll = dice.roll();

        ImageView diceImage = findViewById(R.id.imageView);

        int drawableResource;
        switch (diceRoll) {
            case 1: drawableResource = R.drawable.dice_1;
                break;
            case 2: drawableResource = R.drawable.dice_2;
                break;
            case 3: drawableResource = R.drawable.dice_3;
                break;
            case 4: drawableResource = R.drawable.dice_4;
                break;
            case 5: drawableResource = R.drawable.dice_5;
                break;
            default: drawableResource = R.drawable.dice_6;
                break;
        }
        diceImage.setImageResource(drawableResource);
        diceImage.setContentDescription(String.valueOf(diceRoll));

    }
}
class Dice {
    private final int numSides;

    public final int roll(){
        byte var1 = 1;
        IntRange var2 = new IntRange(var1, this.numSides);
        return RangesKt.random(var2, (Random.Default));
    }

    public Dice(int numSides) { this.numSides = numSides; }
}