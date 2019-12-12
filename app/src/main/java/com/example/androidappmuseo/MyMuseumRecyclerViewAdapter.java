package com.example.androidappmuseo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.example.androidappmuseo.models.Element;
import com.squareup.picasso.Picasso;

public class MyMuseumRecyclerViewAdapter extends RecyclerView.Adapter<MyMuseumRecyclerViewAdapter.ViewHolderData> {


    List<Element> listofdata;//List that we are going to receive

    public MyMuseumRecyclerViewAdapter(List<Element> listofdata) {
        this.listofdata = listofdata;
    }

    @NonNull
    @Override
    public ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Relates this class with the layout
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.museum_item,null,false);

        return new ViewHolderData(view);
    }

    @Override
    public void onBindViewHolder( ViewHolderData holder, int position) { //Assign the value for each item in the list
        holder.tvMuseum.append(listofdata.get(position).getAdrecaNom());//Variables assigned in the  ViewHolderData
        Picasso.with(holder.imgMuseum.getContext()).load(""+listofdata.get(position).getImatge().get(0)).into(holder.imgMuseum);
    }

    @Override
    public int getItemCount() {
        return listofdata.size();
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {

        //We have to make reference to all the data of the layout list --> Image,TextView..
        public ImageView imgMuseum;
        public TextView tvMuseum;

        public ViewHolderData(@NonNull View itemView) { //Refrence the variable to each component
            super(itemView);
            //Know make reference
            imgMuseum = itemView.findViewById(R.id.museumimage);
            tvMuseum = itemView.findViewById(R.id.tvmuseum);
        }
    }
}