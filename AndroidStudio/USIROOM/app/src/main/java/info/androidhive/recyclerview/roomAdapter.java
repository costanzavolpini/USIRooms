package info.androidhive.recyclerview;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.usirooms.usirooms.R;
import com.usirooms.usirooms.singleRoom;

import java.util.List;
/**
 * Room adapter to show how the card looks.
 */
public class roomAdapter extends RecyclerView.Adapter<roomAdapter.MyViewHolder> {

    private List<roomData> roomList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView roomNumber;

        public MyViewHolder(final View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.card_view);
            roomNumber = (TextView) view.findViewById(R.id.room_number);
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view1){
                    view.getContext().startActivity(new Intent(view.getContext(),singleRoom.class));
                }
            });
        }
    }


    public roomAdapter(List<roomData> roomList) {
        this.roomList = roomList;
    }

    @Override
    public roomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.room_list_row, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(roomAdapter.MyViewHolder holder, int position) {
        roomData room = roomList.get(position);
        holder.roomNumber.setText(room.getRoomNumber());
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
