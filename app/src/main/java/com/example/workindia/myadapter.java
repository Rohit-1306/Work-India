package com.example.workindia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder> {
private OnItemClickListener listener;
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }



    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {
        holder.cmpname.setText(model.getName());
        holder.degree.setText(model.getName1());
        holder.cgpa.setText(model.getCgpa().toString());
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        ImageView imgicon ;
        TextView cmpname,degree,cgpa;

        public myviewholder(@NonNull final View itemView) {
            super(itemView);
             imgicon=itemView.findViewById(R.id.imgicon);
             cmpname=itemView.findViewById(R.id.cmpname);
            degree=itemView.findViewById(R.id.degree);
            cgpa=itemView.findViewById(R.id.cgpa);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position =getAdapterPosition();
                    if (position!=RecyclerView.NO_POSITION && listener!=null){
                        listener.OnItemClick(position);
                    }






                }
            });



        }





    }
    public interface OnItemClickListener {
        void OnItemClick(int position);
    }
    public  void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }




}
