package com.example.picscan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;


public class ScanListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Scan> scansList;

    public ScanListAdapter(Context context, int layout, ArrayList<Scan> scansList) {
        this.context = context;
        this.layout = layout;
        this.scansList = scansList;
    }

    @Override
    public int getCount() {
        return scansList.size();
    }

    @Override
    public Object getItem(int position) {
        return scansList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imgscan;
        TextView txtTextScan ;
        RatingBar ratingBar ;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtTextScan = (TextView) row.findViewById(R.id.txtTextScan);
            holder.imgscan = (ImageView) row.findViewById(R.id.imgscan);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Scan scan = scansList.get(position);

        holder.txtTextScan.setText(scan.getTtsText());


        byte[] scanImage = scan.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(scanImage, 0, scanImage.length);
        holder.imgscan.setImageBitmap(bitmap);

        return row;
    }
}
