package com.project.backend.Services.impl;

import com.project.backend.Dto.CommandeProduitDTO;
import com.project.backend.Entities.CommandeProduitEntity;
import com.project.backend.Entities.CommandesEntity;
import com.project.backend.Repositories.CommandeProduitRepository;
import com.project.backend.Services.ICommandeProduitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommandeProduitServices implements ICommandeProduitService {

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private CommandeProduitRepository commandeProduitRepository;


    @Transactional
    @Override
    public CommandeProduitDTO createNewOrders(CommandeProduitDTO commandeProduitDTO) {
        CommandeProduitEntity commandeProduit = modelMapper.map(commandeProduitDTO, CommandeProduitEntity.class);


        CommandesEntity commandesEntity = new CommandesEntity();


        return null;
    }
}
