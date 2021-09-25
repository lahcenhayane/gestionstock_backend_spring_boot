package com.project.backend.Factory.ResponsePage;

import com.project.backend.Factory.Page;
import com.project.backend.Responses.CmdOrders.CommandeUsersResponse;

import java.util.List;

public class CommandeUsersResponsePage extends Page<CommandeUsersResponse> {
    public CommandeUsersResponsePage(List<CommandeUsersResponse> list, int totalPage, long totalRow) {
        super(list, totalPage, totalRow);
    }

    @Override
    public List<CommandeUsersResponse> getList() {
        return super.getList();
    }

    @Override
    public void setList(List<CommandeUsersResponse> list) {
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
