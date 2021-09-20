package com.project.backend.Factory.ResponsePage;

import com.project.backend.Factory.Page;
import com.project.backend.Responses.UtilisateurResponse;

import java.util.List;

public class UtilisateurResponsePage extends Page<UtilisateurResponse> {

    public UtilisateurResponsePage(List<UtilisateurResponse> list, int totalPage, long totalRow) {
        super(list, totalPage, totalRow);
    }

    @Override
    public List<UtilisateurResponse> getList() {
        return super.getList();
    }

    @Override
    public void setList(List<UtilisateurResponse> list) {
        super.setList(list);
    }

    @Override
    public int getTotalPage() {
        return super.getTotalPage();
    }

    @Override
    public void setTotalPage(int totalPage) {
        super.setTotalPage(totalPage);
    }

    @Override
    public long getTotalRow() {
        return super.getTotalRow();
    }

    @Override
    public void setTotalRow(long totalRow) {
        super.setTotalRow(totalRow);
    }
}
