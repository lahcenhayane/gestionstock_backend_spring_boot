package com.project.backend.Services;

import com.project.backend.Dto.CommandeDTO;
import com.project.backend.Factory.DtoPage.CommandeDtoPage;

import java.security.Principal;

public interface ICommandeService {
    CommandeDtoPage getAllOrders(int page, long id);

    CommandeDTO createNewOrider(CommandeDTO commandeDTO, Principal principal);

    long getCountOrders();
}
