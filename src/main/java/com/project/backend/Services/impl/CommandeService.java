package com.project.backend.Services.impl;

import com.project.backend.Dto.CommandeDTO;
import com.project.backend.Dto.ProduitDTO;
import com.project.backend.Entities.*;
import com.project.backend.Exceptions.UtilisateurException;
import com.project.backend.Factory.DtoPage.CommandeDtoPage;
import com.project.backend.Repositories.*;
import com.project.backend.Services.ICommandeService;
import com.project.backend.Utils.GlobalVariable;
import com.project.backend.Utils.Roles;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommandeService implements ICommandeService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CommandeProduitRepository commandeProduitRepository;


    @Override
    public CommandeDtoPage getAllOrders(int page, long id) {
        if (page>0) page--;
        Pageable pageable = PageRequest.of(page, GlobalVariable.SIZE);
        Page<CommandesEntity> commandesEntityPage = null;
        if (id == 0){
            commandesEntityPage = commandeRepository.findAll(pageable);
        }else{
            commandesEntityPage = commandeRepository.findByIdContians(pageable, id);
        }

        List<CommandeDTO> commandeDTOs = commandesEntityPage.stream().map(row->modelMapper.map(row, CommandeDTO.class)).collect(Collectors.toList());

        return new CommandeDtoPage(commandeDTOs, commandesEntityPage.getTotalPages(), commandesEntityPage.getTotalElements());
    }

    @Transactional
    @Override
    public CommandeDTO createNewOrider(CommandeDTO commandeDTO, Principal principal) {
        CommandesEntity commandesEntity = modelMapper.map(commandeDTO, CommandesEntity.class);
        if (commandesEntity.getClients() != null){commandesEntity.setClients(clientRepository.findById(commandesEntity.getClients().getId()).get());}
        UtilisateursEntity utilisateurs = utilisateurRepository.findByEmail(principal.getName());
        if (utilisateurs.getRole() == Roles.Admin) commandesEntity.setAdmins(utilisateurs.getAdmin());
        if (utilisateurs.getRole() == Roles.Employee) commandesEntity.setEmployes(utilisateurs.getEmployee());
        if (commandesEntity.getEmployes() != null) commandesEntity.setEmployes(employeeRepository.findById(commandesEntity.getEmployes().getId()).get());
        CommandesEntity saveOrder = commandeRepository.save(commandesEntity);
        commandesEntity.getCommandeProduit().stream().forEach(
            row->{
                CommandeProduitEntity commandeProduitEntity = new CommandeProduitEntity();
                commandeProduitEntity.setCommandes(saveOrder);
                ProduitsEntity produit = productRepository.findById(row.getProduits().getId()).get();
                if (produit == null) throw new RuntimeException("Product Not Found.");
                commandeProduitEntity.setProduits(produit);
                commandeProduitEntity.setQuantute(row.getQuantute());
                commandeProduitRepository.save(commandeProduitEntity);
            }
        );
        CommandeDTO dto =modelMapper.map(commandesEntity, CommandeDTO.class);
        dto.getCommandeProduit().stream().forEach(row->row.setProduits(productRepository.findById(row.getProduits().getId()).get()));
        return dto;
    }

    @Override
    public long getCountOrders() {
        return commandeRepository.count();
    }



}
