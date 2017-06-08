package com.example.rodrigobarbosa.expandexemplo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.rodrigobarbosa.expandexemplo.R;
import com.example.rodrigobarbosa.expandexemplo.adapter.viewHolder.ItemContentCepViewHolder;
import com.example.rodrigobarbosa.expandexemplo.adapter.viewHolder.ItemHeaderCepRegionViewHolder;
import com.example.rodrigobarbosa.expandexemplo.model.ItemContentCepRegion;
import com.example.rodrigobarbosa.expandexemplo.model.ItemHeaderCepRegion;

import java.util.List;

/**
 * Created by rodrigobarbosa on 08/06/17.
 */

public class CepRegionAdapter extends com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter<ItemHeaderCepRegionViewHolder, ItemContentCepViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private List<ParentObject> parentItemList;
    private CepRegionAdapter.CkbCepOnClickListener onClickListener;
    private CepRegionAdapter.CkbChildCepOnClickListener onClickChildListener;

    public interface CkbCepOnClickListener {

        void OnClickCkbCepOnClickListener(View view);

    }

    public interface CkbChildCepOnClickListener {
        void OnClickCkbChildCepOnClickListener(View view, boolean isView);
    }

    public CepRegionAdapter(Context context, List<ParentObject> parentItemList, CepRegionAdapter.CkbCepOnClickListener onClickListener, CepRegionAdapter.CkbChildCepOnClickListener onClickChildListener) {
        super(context, parentItemList);

        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.parentItemList = parentItemList;
        this.onClickListener = onClickListener;
        this.onClickChildListener = onClickChildListener;
    }

    @Override
    public ItemHeaderCepRegionViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.item_header_cep_region, viewGroup, false);
        return new ItemHeaderCepRegionViewHolder(view);
    }

    @Override
    public ItemContentCepViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.item_content_cep_region, viewGroup, false);
        return new ItemContentCepViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(final ItemHeaderCepRegionViewHolder itemHeaderCepRegionViewHolder, int i, Object o) {
        ItemHeaderCepRegion item = (ItemHeaderCepRegion) o;
        itemHeaderCepRegionViewHolder.tvTextoHeader.setText(item.getHeader());
        itemHeaderCepRegionViewHolder.tvIdRegion.setText(String.valueOf(item.getIdRegion()));
        itemHeaderCepRegionViewHolder.ckbHeader.setChecked(item.isChecked());


        if (onClickListener != null) {

            itemHeaderCepRegionViewHolder.ckbHeader.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.OnClickCkbCepOnClickListener(itemHeaderCepRegionViewHolder.itemView);
                }
            });
        }
    }

    @Override
    public void onBindChildViewHolder(final ItemContentCepViewHolder itemContentCepViewHolder, int i, Object o) {
        ItemContentCepRegion item = (ItemContentCepRegion) o;
        itemContentCepViewHolder.tvTextoContent.setText(item.getDescritionContent());
        itemContentCepViewHolder.tvIdRegion.setText(String.valueOf(item.getIdRegion()));
        itemContentCepViewHolder.tvIdZone.setText(String.valueOf(item.getIdZone()));
        itemContentCepViewHolder.ckContent.setChecked(item.isChecked());

        if (onClickChildListener != null) {

            itemContentCepViewHolder.ckContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickChildListener.OnClickCkbChildCepOnClickListener(itemContentCepViewHolder.itemView, false);
                }
            });
            itemContentCepViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickChildListener.OnClickCkbChildCepOnClickListener(itemContentCepViewHolder.itemView, true);
                }
            });
        }
    }

    public List<ParentObject> getAll() {
        return parentItemList;
    }


    public void atualiza(int idRegion, boolean ischeckd) {
        for (ParentObject p : parentItemList) {
            ItemHeaderCepRegion header = (ItemHeaderCepRegion) p;

            if (header.getIdRegion() == idRegion) {
                header.setChecked(ischeckd);

                for (Object i : header.getItens()) {
                    ItemContentCepRegion item = (ItemContentCepRegion) i;
                    item.setChecked(ischeckd);
                }
            }
        }

        notifyDataSetChanged();
    }

    public void atualizaChild(int idRegion, int idZone, boolean ischeckd) {
        for (ParentObject p : parentItemList) {
            ItemHeaderCepRegion header = (ItemHeaderCepRegion) p;

            if (header.getIdRegion() == idRegion) {
                for (Object i : header.getItens()) {
                    ItemContentCepRegion item = (ItemContentCepRegion) i;
                    if (item.getIdZone() == idZone)
                        item.setChecked(ischeckd);
                }
            }
        }

        notifyDataSetChanged();
    }

    public boolean verifyIsSomeChecked() {
        boolean ret = false;

        for (ParentObject p : parentItemList) {
            ItemHeaderCepRegion header = (ItemHeaderCepRegion) p;
            if (header.isChecked())
                ret = true;

            for (Object i : header.getItens()) {
                ItemContentCepRegion item = (ItemContentCepRegion) i;
                if (item.isChecked())
                    ret = true;

            }

        }


        return ret;
    }
}

