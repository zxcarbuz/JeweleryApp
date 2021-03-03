package com.example.jeweleryapp.presentation.activities.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jeweleryapp.R;
import com.example.jeweleryapp.databinding.ActivityMainBinding;
import com.example.jeweleryapp.databinding.ItemBinding;
import com.example.jeweleryapp.repository.AppData;
import com.example.jeweleryapp.repository.database.entity.Product;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    AppData appData;
    List<Product> localProduct = new ArrayList<>();

    ActivityMainBinding binding;
    LayoutInflater inflater;
    productAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflater = getLayoutInflater();
        binding = ActivityMainBinding.inflate(inflater);
        setContentView(binding.getRoot());
//        adapter = new productAdapter();
//        binding.productsView.setAdapter(adapter);
        appData = AppData.getInstance(getApplicationContext());
//        nazvanie();



    initProductAdapter();
//        binding.floatingActionButton.setOnClickListener((v))
    }

    public void nazvanie() {
        Product product = new Product();
        product.url = "https://st.depositphotos.com/1660839/1627/i/600/depositphotos_16271929-stock-photo-jewellery-ring-isolated-on-a.jpg";
        product.name = "Кольцо";
        product.identity = "jopa 123-234-45-56";

        appData.db.productDao().insert(product);
    }

    private void initProductAdapter() {
        adapter = new productAdapter();
        binding.productsView.setAdapter(adapter);

        appData.db.productDao().getAll().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
             localProduct = products;
             adapter.notifyDataSetChanged();
            }
        });
    }

    public class productAdapter extends RecyclerView.Adapter<productAdapter.ViewHolder> {


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            ItemBinding itemProductBinding = ItemBinding.inflate(getLayoutInflater(),parent,false);
            View view = inflater.inflate(R.layout.item,parent,false);
            return new ViewHolder(view);
//            return new ViewHolder(ItemProductBinding.inflate(inflater,parent,false));

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Product item = localProduct.get(position);
            holder.productBinding.nameView.setText(item.name);
            appData.loadImage(item.url, holder.productBinding.photoView);

//            holder.itemView.setOnClickListener();
        }

        @Override
        public int getItemCount() {
            return localProduct.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ItemBinding productBinding;

            public ViewHolder( ItemBinding productBinding) {
                super(binding.getRoot());
                this.productBinding = productBinding;
            }

            public ViewHolder(View view) {
                super(view);
                productBinding = ItemBinding.bind(view);
            }
        }
    }
}