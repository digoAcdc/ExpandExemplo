package com.example.rodrigobarbosa.expandexemplo.adapter.viewHolder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.example.rodrigobarbosa.expandexemplo.R;

/**
 * Created by rodrigobarbosa on 08/06/17.
 */

public class ItemContentCepViewHolder extends ChildViewHolder {
    public CheckBox ckContent;
    public TextView tvTextoContent;
    public TextView tvIdRegion;
    public TextView tvIdZone;

    public ItemContentCepViewHolder(View itemView) {
        super(itemView);
        ckContent = (CheckBox) itemView.findViewById(R.id.ckContent);
        tvTextoContent = (TextView) itemView.findViewById(R.id.tvTextoContent);
        tvIdRegion = (TextView) itemView.findViewById(R.id.tvIdRegion);
        tvIdZone = (TextView) itemView.findViewById(R.id.tvIdZone);
    }
}
