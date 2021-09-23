package com.project.backend.Factory.DtoPage;

import com.project.backend.Dto.CategorieDTO;
import com.project.backend.Factory.Page;

import java.util.List;

public class CategorieDtoPage extends Page<CategorieDTO> {
    public CategorieDtoPage(List<CategorieDTO> list, int totalPage, long totalRow) {
        super(list, totalPage, totalRow);
    }

    @Override
    public List<CategorieDTO> getList() {
        return super.getList();
    }

    @Override
    public void setList(List<CategorieDTO> list) {
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
