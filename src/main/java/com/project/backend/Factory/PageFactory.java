package com.project.backend.Factory;

import com.project.backend.Factory.ResponsePage.CategorieResponsePage;
import com.project.backend.Factory.ResponsePage.ProductResponsePage;
import com.project.backend.Factory.ResponsePage.UtilisateurResponsePage;
import org.modelmapper.ModelMapper;


public class PageFactory {
    private ModelMapper modelMapper = new ModelMapper();

    public static Page getPage(PageStateEnum type, Page page){
        switch (type){
            case UtilisateurResponsePage:{
                return new UtilisateurResponsePage(page.getList(), page.getTotalPage(), page.getTotalRow());
            }
            case ProductResponsePage:{
                return new ProductResponsePage(page.getList(), page.getTotalPage(), page.getTotalRow());
            }
            case CategorieResponsePage:{
                return new CategorieResponsePage(page.getList(), page.getTotalPage(), page.getTotalRow());
            }
            default:{
                throw new RuntimeException("Type "+type+" is not correct.");
            }
        }
    }


}
