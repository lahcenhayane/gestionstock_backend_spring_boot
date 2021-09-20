package com.project.backend.Factory.DtoPage;

import com.project.backend.Dto.UtilisateurDTO;
import com.project.backend.Factory.Page;

import java.util.List;

public class UtilisateurDtoPage extends Page<UtilisateurDTO> {


    public UtilisateurDtoPage(List<UtilisateurDTO> list, int totalPage, long totalRow) {
        super(list, totalPage, totalRow);
    }

    @Override
    public List<UtilisateurDTO> getList() {
        return super.getList();
    }

    @Override
    public void setList(List<UtilisateurDTO> list) {
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
