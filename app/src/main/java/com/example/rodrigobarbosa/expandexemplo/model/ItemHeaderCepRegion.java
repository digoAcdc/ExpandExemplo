package com.example.rodrigobarbosa.expandexemplo.model;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

/**
 * Created by rodrigobarbosa on 08/06/17.
 */

public class ItemHeaderCepRegion implements ParentObject {

    private String header;
    private Long idRegion;
    private boolean checked;
    private List<Object> itens;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<Object> getItens() {
        return itens;
    }

    public void setItens(List<Object> itens) {
        this.itens = itens;
    }

    @Override
    public List<Object> getChildObjectList() {
        return itens;
    }

    @Override
    public void setChildObjectList(List<Object> list) {
        this.itens = list;
    }
}

