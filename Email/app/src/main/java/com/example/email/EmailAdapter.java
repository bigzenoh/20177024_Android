package com.example.email;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EmailAdapter extends BaseAdapter {
    List<EmailModel> items;

    public EmailAdapter(List<EmailModel> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_email_item, parent,false);

            viewHolder = new ViewHolder();
            viewHolder.letter = convertView.findViewById(R.id.text_letter);
            viewHolder.name = convertView.findViewById(R.id.text_name);
            viewHolder.subject = convertView.findViewById(R.id.text_subject);
            viewHolder.content = convertView.findViewById(R.id.text_content);
            viewHolder.time = convertView.findViewById(R.id.text_time);
            viewHolder.imageFavourite = convertView.findViewById(R.id.image_favourite);
            convertView.setTag(viewHolder);
        }
        else
            viewHolder = (ViewHolder)convertView.getTag();

        final EmailModel item = items.get(position);
        viewHolder.letter.setText(item.getLetter());
        viewHolder.name.setText(item.getName());
        viewHolder.subject.setText(item.getSubject());
        viewHolder.content.setText(item.getContent());
        viewHolder.time.setText(item.getTime());

        viewHolder.imageFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isFavourite = items.get(position).isIsfavourite();
                items.get(position).setIsfavourite(!isFavourite);
                notifyDataSetChanged();
            }
        });

        if(item.isIsfavourite())
            viewHolder.imageFavourite.setImageResource(R.drawable.ic_star_favourite);
        else
            viewHolder.imageFavourite.setImageResource(R.drawable.ic_star_normal);

        return convertView;
    }



    class ViewHolder {
        TextView letter;
        TextView name;
        TextView subject;
        TextView content;
        TextView time;
        ImageView imageFavourite;


    }

    public void filtered(List<EmailModel> filterList){
        items = filterList;
        notifyDataSetChanged();
    }
}
