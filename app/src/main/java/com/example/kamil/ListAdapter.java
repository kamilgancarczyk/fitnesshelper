package com.example.kamil;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);

        final ListViewHolder viewHolder = new ListViewHolder(view);

        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.dialog_workout);



        viewHolder.item_workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView workoutName = myDialog.findViewById(R.id.workoutName);
                TextView workoutPartOfBody = myDialog.findViewById(R.id.workoutBodyPart);
                TextView workoutDesc = myDialog.findViewById(R.id.workoutDesc);
                ImageView dialog_img = myDialog.findViewById(R.id.workoutImage);
                Button dialog_button = myDialog.findViewById(R.id.closeButton);

                workoutName.setText(OurData.title[viewHolder.getAdapterPosition()]);
                workoutPartOfBody.setText(OurData.description[viewHolder.getAdapterPosition()]);
                workoutDesc.setText(OurData.specification[viewHolder.getAdapterPosition()]);
                dialog_img.setImageResource(OurData.imgPath[viewHolder.getAdapterPosition()]);

                //Toast.makeText(context,"Nacisniety element nr: " + String.valueOf(viewHolder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                myDialog.show();

                dialog_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.cancel();
                    }
                });
            }
        });

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

    public static class ListViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout item_workout;
        private TextView mItemText, mItemDesc;
        private ImageView mItemImage;

        public ListViewHolder(View itemView){

            super(itemView);
            item_workout = itemView.findViewById(R.id.workout_item_id);
            mItemText = itemView.findViewById(R.id.itemText);
            mItemImage = itemView.findViewById(R.id.itemImage);
            mItemDesc = itemView.findViewById(R.id.itemDesc);
            //itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mItemText.setText(OurData.title[position]);
            mItemDesc.setText(OurData.description[position]);
            mItemImage.setImageResource(OurData.imgPath[position]);
        }

        /*@Override
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
        }*/

    }

}
