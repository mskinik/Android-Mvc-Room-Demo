package com.example.androidmvcroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidmvcroom.Adapter.UserAdapter;
import com.example.androidmvcroom.Contract.MainActivityContract;
import com.example.androidmvcroom.Model.User;
import com.example.androidmvcroom.Presenter.MainActivityPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {
    private MainActivityPresenter mainActivityPresenter;
    private RecyclerView recyclerView;
    private EditText editTextName,editTextNumber;
    private Button listButton,addButton,deleteButton;
    private UserAdapter userAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityPresenter=new MainActivityPresenter(this);
        mainActivityPresenter.setModel(new User());
        mainActivityPresenter.start(getApplicationContext());

    }

    @Override
    public void define() {
        recyclerView=findViewById(R.id.recyclerView);
        editTextName =findViewById(R.id.editText);
        editTextNumber=findViewById(R.id.editTextNumber);
        listButton=findViewById(R.id.getButton);
        addButton=findViewById(R.id.addButton);
        deleteButton=findViewById(R.id.deleteButton);


    }

    @Override
    public void click() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityPresenter.add(editTextName.getText().toString(),Integer.parseInt(editTextNumber.getText().toString()));
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityPresenter.delete(editTextName.getText().toString());
            }
        });
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityPresenter.list();
            }
        });

    }

    @Override
    public void getAllUser(List<User> userList) {
        userAdapter= new UserAdapter(userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(userAdapter);
    }
}