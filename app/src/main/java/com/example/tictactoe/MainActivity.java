package com.example.tictactoe;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tictactoe.databinding.TictoeBinding;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {
    TictoeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = TictoeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setbtn(binding.i1);
        setbtn(binding.i2);
        setbtn(binding.i3);
        setbtn(binding.i4);
        setbtn(binding.i5);
        setbtn(binding.i6);
        setbtn(binding.i7);
        setbtn(binding.i8);
        setbtn(binding.i9);

        binding.restart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                binding.i1.setText("");
                binding.i2.setText("");
                binding.i3.setText("");
                binding.i4.setText("");
                binding.i5.setText("");
                binding.i6.setText("");
                binding.i7.setText("");
                binding.i8.setText("");
                binding.i9.setText("");
                binding.win.setText("");
            }
        });
    }
    int i = 1;

    //2 user play
    void setbtn(Button btn)
    {
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (binding.win.getText().toString().isEmpty() && btn.getText().toString().isEmpty())
                {
                    btn.setText("0");
                    win(binding.i1, binding.i2, binding.i3);
                    win(binding.i4, binding.i5, binding.i6);
                    win(binding.i7, binding.i8, binding.i9);

                    win(binding.i1, binding.i4, binding.i7);
                    win(binding.i2, binding.i5, binding.i8);
                    win(binding.i3, binding.i6, binding.i9);

                    win(binding.i1, binding.i5, binding.i9);
                    win(binding.i3, binding.i5, binding.i7);

                    if (binding.win.getText().toString().isEmpty())
                    {
                        checkDraw();
                    }

                    if (binding.win.getText().toString().isEmpty())
                    {
                        robotTurn();
                    }
                }
            }
        });
    }

    private void robotTurn()
    {
        Random ran = new Random();
        while (true)
        {
            int number = ran.nextInt(9);
            Log.e("===", "robotTurn: " + number);
            if (number == 0)
            {
                if (binding.i1.getText().toString().isEmpty())
                {
                    binding.i1.setText("x");
                    break;
                }
            } else if (number == 1)
            {
                if (binding.i2.getText().toString().isEmpty())
                {
                    binding.i2.setText("x");
                    break;
                }
            } else if (number == 2)
            {
                if (binding.i3.getText().toString().isEmpty())
                {
                    binding.i3.setText("x");
                    break;
                }
            } else if (number == 3) {
                if (binding.i4.getText().toString().isEmpty()) {
                    binding.i4.setText("x");
                    break;
                }
            } else if (number == 4)
            {
                if (binding.i5.getText().toString().isEmpty()) {
                    binding.i5.setText("x");
                    break;
                }
            } else if (number == 5) {
                if (binding.i6.getText().toString().isEmpty()) {
                    binding.i6.setText("x");
                    break;
                }
            } else if (number == 6) {
                if (binding.i7.getText().toString().isEmpty()) {
                    binding.i7.setText("x");
                    break;
                }
            } else if (number == 7)
            {
                if (binding.i8.getText().toString().isEmpty())
                {
                    binding.i8.setText("x");
                    break;
                }
            } else if (number == 8)
            {
                if (binding.i9.getText().toString().isEmpty())
                {
                    binding.i9.setText("x");
                    break;
                }
            }
        }
        win(binding.i1, binding.i2, binding.i3);
        win(binding.i4, binding.i5, binding.i6);
        win(binding.i7, binding.i8, binding.i9);

        win(binding.i1, binding.i4, binding.i7);
        win(binding.i2, binding.i5, binding.i8);
        win(binding.i3, binding.i6, binding.i9);

        win(binding.i1, binding.i5, binding.i9);
        win(binding.i3, binding.i5, binding.i7);
    }

    void win(Button i1, Button i2, Button i3)
    {
        if(i1.getText().toString().equals("x") && i2.getText().toString().equals("x") && i3.getText().toString().equals("x"))
        {
            binding.win.setText("x is Winner");
        }
        else if (i1.getText().toString().equals("0") && i2.getText().toString().equals("0") && i3.getText().toString().equals("0"))
        {
            binding.win.setText("0 is Winner");
        }
    }
    void checkDraw()
    {
        if (!binding.i1.getText().toString().isEmpty() &&!binding.i2.getText().toString().isEmpty() &&!binding.i3.getText().toString().isEmpty()
                &&!binding.i4.getText().toString().isEmpty() &&!binding.i5.getTexxt().toString().isEmpty() &&!binding.i6.getText().toString().isEmpty()
                &&!binding.i7.getText().toString().isEmpty() &&!binding.i8.getText().toString().isEmpty() &&!binding.i9.getText().toString().isEmpty())
        {
            binding.win.setText("It's a draw");
        }
    }
}

// master