package info.androidhive.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.usirooms.usirooms.R;

import java.util.List;
/**
 * Created by michelelustro on 24/05/16.
 */
public class roomAdapter extends RecyclerView.Adapter<roomAdapter.MyViewHolder> {

    private List<roomData> roomList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView roomNumber;

        public MyViewHolder(View view) {
            super(view);
            roomNumber = (TextView) view.findViewById(R.id.room_number);
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
}
