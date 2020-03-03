package com.example.reciclerviewexample;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.reciclerviewexample.model.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.OnItemClickListener  {

    private RecyclerView recyclerView;
    private AnimalAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        mAdapter= new AnimalAdapter(getAnimalList(),this,this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Animal> getAnimalList (){
        Animal gato = new Animal("https://images.unsplash.com/photo-1525104885119-8806dd94ad58?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80","Gato Negro");
        Animal loro = new Animal("https://images.unsplash.com/photo-1560215619-9f555dc4c295?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1189&q=80","Loro Verde");
        Animal elefante = new Animal("https://images.unsplash.com/photo-1543055131-ac87bf2f6ac1?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80","Elefante");
        List<Animal> animals = new ArrayList<Animal>(Arrays.asList(gato,loro,elefante));
        return animals;
    }

    @Override
    public void onClick(AnimalAdapter.ViewHolder viewHolder, String nameAnimal, String animalUrl) {
        Toast.makeText(this,nameAnimal,Toast.LENGTH_SHORT).show();
        instanceDetailFragment(nameAnimal,animalUrl);
    }

    private void instanceDetailFragment (String name, String url){
        DetailFragment detailFragment = DetailFragment.newInstance(name,url);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,detailFragment,"DetailFragment").commit();
    }
}
