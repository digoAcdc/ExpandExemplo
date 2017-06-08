package com.example.rodrigobarbosa.expandexemplo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.rodrigobarbosa.expandexemplo.adapter.CepRegionAdapter;
import com.example.rodrigobarbosa.expandexemplo.model.ItemContentCepRegion;
import com.example.rodrigobarbosa.expandexemplo.model.ItemHeaderCepRegion;
import com.example.rodrigobarbosa.expandexemplo.model.RegionCod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static CepRegionAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    @BindView(R.id.rvCepRegion)
    protected RecyclerView rvCepRegion;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        preencheLista(getData());

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private List<RegionCod> getData() {
        List<RegionCod> lst = new ArrayList<>();

        RegionCod r = new RegionCod();
        r.setZoneId(1);
        r.setZoneName("SP - Capital");
        r.setRegionId(1);
        r.setRegionName("Sudeste");

        lst.add(r);

        r = new RegionCod();
        r.setZoneId(2);
        r.setZoneName("SP - Interior");
        r.setRegionId(1);
        r.setRegionName("Sudeste");

        lst.add(r);

        r = new RegionCod();
        r.setZoneId(3);
        r.setZoneName("RJ - Capital");
        r.setRegionId(1);
        r.setRegionName("Sudeste");

        lst.add(r);

        r = new RegionCod();
        r.setZoneId(86);
        r.setZoneName("BA - Interior");
        r.setRegionId(4);
        r.setRegionName("Nordeste");

        lst.add(r);

        r = new RegionCod();
        r.setZoneId(87);
        r.setZoneName("SE - Capital");
        r.setRegionId(4);
        r.setRegionName("Nordeste");

        lst.add(r);

        return lst;
    }

    public void preencheLista(List<RegionCod> list) {
        ArrayList<ParentObject> parentObjects = new ArrayList<>();
        ArrayList<ItemHeaderCepRegion> listHeaderCep = new ArrayList<>();

        //ordena a lista
        Collections.sort(list, new Comparator<RegionCod>() {
            @Override
            public int compare(RegionCod o1, RegionCod o2) {
                return o1.getRegionId() < o2.getRegionId() ? -1 : (o1.getRegionId() > o2.getRegionId()) ? 1 : 0;
            }
        });

        long regionId = -1;


        for (RegionCod item : list) {
            if (item.getRegionId() != regionId) {
                ItemHeaderCepRegion header = new ItemHeaderCepRegion();
                header.setChecked(false);
                header.setHeader(item.getRegionName());
                header.setIdRegion(item.getRegionId());
                listHeaderCep.add(header);
                regionId = item.getRegionId();
            }
        }

        for (int i = 0; i < listHeaderCep.size(); i++) {
            ArrayList<Object> childList = new ArrayList<>();
            regionId = listHeaderCep.get(i).getIdRegion();
            for (RegionCod r : list) {
                if (regionId == r.getRegionId()) {
                    ItemContentCepRegion c = new ItemContentCepRegion();
                    c.setIdRegion(r.getRegionId());
                    c.setDescritionContent(r.getZoneName());
                    c.setIdZone(r.getZoneId());
                    c.setChecked(false);
                    childList.add(c);
                }
            }

            listHeaderCep.get(i).setChildObjectList(childList);

        }

        for (ItemHeaderCepRegion header : listHeaderCep) {
            parentObjects.add(header);
        }

        mAdapter = new CepRegionAdapter(this, parentObjects, onclick(), onclickChild());
        mAdapter.setCustomParentAnimationViewId(R.id.imgmore);
        mAdapter.setParentClickableViewAnimationDefaultDuration();
        mAdapter.setParentAndIconExpandOnClick(true);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvCepRegion.setLayoutManager(mLayoutManager);
        rvCepRegion.setLayoutManager(mLayoutManager);
        rvCepRegion.setNestedScrollingEnabled(false);
        rvCepRegion.setItemAnimator(new DefaultItemAnimator());
        rvCepRegion.setAdapter(mAdapter);


    }

    public CepRegionAdapter.CkbCepOnClickListener onclick() {
        return new CepRegionAdapter.CkbCepOnClickListener() {
            @Override
            public void OnClickCkbCepOnClickListener(View view) {

                CheckBox ckb = (CheckBox) view.findViewById(R.id.ckbHeader);
                TextView tvIdRegion = (TextView) view.findViewById(R.id.tvIdRegion);
                boolean ischecked = ckb.isChecked();
                int idRegiao = Integer.parseInt(tvIdRegion.getText().toString());

                mAdapter.atualiza(idRegiao, ischecked);
            }

        };
    }

    public CepRegionAdapter.CkbChildCepOnClickListener onclickChild() {
        return new CepRegionAdapter.CkbChildCepOnClickListener() {
            @Override
            public void OnClickCkbChildCepOnClickListener(View view, boolean isView) {
                TextView tvIdRegion = (TextView) view.findViewById(R.id.tvIdRegion);
                TextView tvIdZone = (TextView) view.findViewById(R.id.tvIdZone);
                CheckBox ckb = (CheckBox) view.findViewById(R.id.ckContent);

                boolean ischecked = false;

                if (isView)
                    ischecked = !ckb.isChecked();
                else
                    ischecked = ckb.isChecked();

                int idRegiao = Integer.parseInt(tvIdRegion.getText().toString());
                int idZone = Integer.parseInt(tvIdZone.getText().toString());

                mAdapter.atualizaChild(idRegiao, idZone, ischecked);

            }
        };
    }

}
