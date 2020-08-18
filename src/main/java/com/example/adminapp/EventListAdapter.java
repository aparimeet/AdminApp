package com.example.adminapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.adminapp.R;
import com.example.adminapp.ScheduledEvents;

import java.util.List;


public class EventListAdapter extends BaseAdapter {
    private List<ScheduledEvents> scheduledEvents;
    private LayoutInflater inflater;
    EventListAdapter(Context context, List<ScheduledEvents> scheduledEvents){
        this.scheduledEvents = scheduledEvents;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return scheduledEvents.size();
    }

    @Override
    public Object getItem(int i) {
        return scheduledEvents.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EventHolder eventHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.event_view_layout, parent, false);
            eventHolder = new EventHolder(convertView);
            convertView.setTag(eventHolder);
        } else {
            eventHolder = (EventHolder) convertView.getTag();
        }
        ScheduledEvents scheduledEvents = (ScheduledEvents) getItem(position);

        eventHolder.eventTitle.setText(scheduledEvents.getEventSummery());
        eventHolder.eventDes.setText(scheduledEvents.getDescription());
        eventHolder.eventAttendee.setText(scheduledEvents.getAttendees());
        eventHolder.eventStart.setText(scheduledEvents.getStartDate());
        eventHolder.eventEnd.setText(scheduledEvents.getEndDate());
        eventHolder.eventLocation.setText(scheduledEvents.getLocation());

        return convertView;
    }
    private class EventHolder {
        TextView eventTitle, eventDes, eventAttendee, eventStart, eventEnd, eventLocation;

        private EventHolder(View item) {
            eventTitle = item.findViewById(R.id.eventTitle);
            eventDes = item.findViewById(R.id.eventDes);
            eventAttendee = item.findViewById(R.id.eventAttendee);
            eventStart = item.findViewById(R.id.eventStart);
            eventEnd = item.findViewById(R.id.eventEnd);
            eventLocation = item.findViewById(R.id.eventLocation);
        }
    }
}
