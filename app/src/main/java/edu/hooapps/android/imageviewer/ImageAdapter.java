package edu.hooapps.android.imageviewer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private final List<String> urls = new ArrayList<String>();
    private static final int SIZE = 600;
    private Context context;

    public ImageAdapter(Context context) {
        Collections.addAll(urls, Data.URLS);
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // Standard ViewHolder pattern
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_dou_item, parent, false);
            holder = new ViewHolder();
            holder.bgImage = (ImageView) view.findViewById(R.id.item_bg_image);
            holder.bgText = (TextView) view.findViewById(R.id.item_bg_text);
            holder.image = (ImageView) view.findViewById(R.id.item_image);
            holder.text = (TextView) view.findViewById(R.id.item_name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.url = getItem(position);
        holder.text.setText(holder.url);
        holder.bgText.setText(String.valueOf(position));

        Picasso.with(context).load(holder.url).resize(SIZE, SIZE).into(holder.image);
        Picasso.with(context).load(holder.url).resize(SIZE, SIZE).into(holder.bgImage);

        return view;
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override public String getItem(int position) {
        return urls.get(position);
    }

    @Override public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        ImageView bgImage;
        ImageView image;
        TextView bgText;
        TextView text;
        String url;
    }
}