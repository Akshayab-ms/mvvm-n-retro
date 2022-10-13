package com.example.loginmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginmvvm.model.User;
import com.example.loginmvvm.model.UserResponse;
import com.example.loginmvvm.viewmodel.ActivityViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewModel();
        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewUser();

            }
        });
    }
    public void createNewUser(){
        String name =((EditText )findViewById(R.id.editText)).getText().toString();
         String mail =((EditText)findViewById(R.id.editTextTextPersonName)).getText().toString();
         User user =new User("",name,"male",mail,"Active");
         viewModel.createNewUser(user);
    }
    private void initViewModel(){
        viewModel =new ViewModelProvider(this).get(ActivityViewModel.class);
                viewModel.getCreateUserObserver().observe(this, new Observer<UserResponse>() {
                    @Override
                    public void onChanged(UserResponse userResponse) {
                        if(userResponse==null){
                            Toast.makeText(MainActivity.this,"fail",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"sucess",Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }
}