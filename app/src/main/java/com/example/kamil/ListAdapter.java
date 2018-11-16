package com.example.kamil;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kamil.fitnesshelper.R;

public class ListAdapter extends RecyclerView.Adapter {
    Context context;

    Dialog myDialog;


    public ListAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);

        final ListViewHolder viewHolder = new ListViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ListViewHolder) viewHolder).bindView(i);
    }

    @Override
    public int getItemCount() {
        return OurData.title.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public LinearLayout item_workout;
        private TextView mItemText, mItemDesc;
        private ImageView mItemImage;

        public ListViewHolder(View itemView){

            super(itemView);
            item_workout = itemView.findViewById(R.id.workout_item_id);
            mItemText = itemView.findViewById(R.id.itemText);
            mItemImage = itemView.findViewById(R.id.itemImage);
            mItemDesc = itemView.findViewById(R.id.itemDesc);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mItemText.setText(OurData.title[position]);
            mItemDesc.setText(OurData.description[position]);
            mItemImage.setImageResource(OurData.imgPath[position]);
        }

        @Override
        public void onClick(View v) {
            myDialog = new Dialog(context);
            myDialog.setContentView(R.layout.dialog_workout);
            System.out.println("Dialog context is: ");


            //workoutDesc.setText(OurData.description[getAdapterPosition()]);
            //workoutImage.setImageResource(OurData.imgPath[getAdapterPosition()]);

            item_workout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(context.getApplicationContext(), "Item clicked " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
                    TextView workoutName, workoutDesc;
                    ImageView workoutImage;
                    int pos;

                    pos = getAdapterPosition();

                    workoutName = v.findViewById(R.id.workoutName);
                    workoutDesc = v.findViewById(R.id.workoutDesc);
                    workoutImage = v.findViewById(R.id.workoutImage);


                    System.out.println("Position is: " + workoutName);


                    myDialog.show();
                }
            });
        }

    }

}
