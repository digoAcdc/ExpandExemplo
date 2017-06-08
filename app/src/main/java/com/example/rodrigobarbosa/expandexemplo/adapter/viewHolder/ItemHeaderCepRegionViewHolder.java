package com.example.rodrigobarbosa.expandexemplo.adapter.viewHolder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.example.rodrigobarbosa.expandexemplo.R;

/**
 * Created by rodrigobarbosa on 08/06/17.
 */

public class ItemHeaderCepRegionViewHolder extends ParentViewHolder {
    public CheckBox ckbHeader;
    public TextView tvTextoHeader;
    public TextView tvIdRegion;


    public ItemHeaderCepRegionViewHolder(View itemView) {
        super(itemView);
        ckbHeader = (CheckBox) itemView.findViewById(R.id.ckbHeader);
        tvTextoHeader = (TextView) itemView.findViewById(R.id.tvTextoHeader);
        tvIdRegion = (TextView) itemView.findViewById(R.id.tvIdRegion);
    }
}