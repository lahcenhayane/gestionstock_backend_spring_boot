package com.project.backend.Services;

import com.project.backend.Dto.CommandeDTO;
import com.project.backend.Factory.DtoPage.CommandeDtoPage;

public interface ICommandeService {
    CommandeDtoPage getAllOrders(int page);

    CommandeDTO createNewOrider(CommandeDTO commandeDTO);
}
