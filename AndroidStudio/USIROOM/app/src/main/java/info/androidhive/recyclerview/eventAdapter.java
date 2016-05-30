package info.androidhive.recyclerview;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.usirooms.usirooms.R;
import com.usirooms.usirooms.singleEvent;
import com.usirooms.usirooms.singleRoom;

import java.util.List;
/**
 * Room adapter to show how the card looks.
 */
public class eventAdapter extends RecyclerView.Adapter<eventAdapter.MyViewHolder> {

    private List<eventData> eventList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView eventType;

        public MyViewHolder(final View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.card_view_event);
            eventType = (TextView) view.findViewById(R.id.event_type);
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view1){
                    view.getContext().startActivity(new Intent(view.getContext(),singleEvent.class));
                }
            });
        }
    }


    public eventAdapter(List<eventData> eventList) {
        this.eventList = eventList;
    }

    @Override
    public eventAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_list_row, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(eventAdapter.MyViewHolder holder, int position) {
        eventData event = eventList.get(position);
        holder.eventType.setText(event.getEventType());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
