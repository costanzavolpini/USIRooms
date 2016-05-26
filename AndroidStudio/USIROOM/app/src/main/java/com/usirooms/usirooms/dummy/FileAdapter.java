package com.usirooms.usirooms.dummy;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.usirooms.usirooms.R;

import java.io.File;
import java.util.List;

/**
 * Created by costanzavolpini on 26/05/16.
 */
private class FileAdapter extends RecyclerView.Adapter<FileAdapter.RecyclerViewHolder> {

    private List<File> list;

    public FileAdapter(List<File> list) {
        this.list = list;
    }

    //Called to update the list when necessary.
    public void updateList(List<File> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    //Here we inflate the xml used for the "rows".
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.row_layout, viewGroup, false);

        return new RecyclerViewHolder(v);
    }

    @Override
    //here we access the Views held by the viewholder.
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int i) {

        viewHolder.getTextView().setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    ////////////////View holder for the RecyclerView////////////////
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView itemView;
        private CardView cardView;

        public RecyclerViewHolder(final View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(view.getContext(), "You clicked "
                            + String.valueOf(rv.getChildPosition(v)), Toast.LENGTH_LONG).show();
                }
            });
            itemView = (TextView) view.findViewById(R.id.tv);
            cardView = (CardView) view.findViewById(R.id.card_view);
            cardView.setRadius(15);
        }

        public TextView getTextView() {
            return itemView;
        }
    }

} //FileAdapter