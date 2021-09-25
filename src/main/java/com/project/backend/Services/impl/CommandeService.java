package com.project.backend.Services.impl;

import com.project.backend.Dto.CommandeDTO;
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


    @Override
    public CommandeDtoPage getAllOrders(int page) {
        if (page>0) page--;
        Pageable pageable = PageRequest.of(page, GlobalVariable.SIZE);
        Page<CommandesEntity> commandesEntityPage = commandesEntityPage = commandeRepository.findAll(pageable);
        List<CommandeDTO> commandeDTOs = commandesEntityPage.stream().map(row->modelMapper.map(row, CommandeDTO.class)).collect(Collectors.toList());

        return new CommandeDtoPage(commandeDTOs, commandesEntityPage.getTotalPages(), commandesEntityPage.getTotalElements());
    }

    @Transactional
    @Override
    public CommandeDTO createNewOrider(CommandeDTO commandeDTO) {

        CommandesEntity commandesEntity = modelMapper.map(commandeDTO, CommandesEntity.class);

        if (commandesEntity.getAdmins() != null){
            AdminsEntity admin = adminRepository.findById(commandesEntity.getAdmins().getId()).get();
            if (admin == null) throw new UtilisateurException("Client Not Found.");
            commandesEntity.setAdmins(admin);
        }

        ClientsEntity client = null;
        if (commandesEntity.getClients() != null){
            client = clientRepository.findById(commandesEntity.getClients().getId()).get();
            if (client == null) throw new UtilisateurException("Client Not Found.");
            commandesEntity.setClients(client);
        }
        EmployeesEntity employee = null;
        if (commandesEntity.getEmployes() != null){
            employee = employeeRepository.findById(commandesEntity.getEmployes().getId()).get();
            if (employee == null) throw new UtilisateurException("Client Not Found.");
            commandesEntity.setEmployes(employee);
        }

        Set<ProduitsEntity> produitsEntitySet = commandesEntity.getProduits().stream()
                .map(product->productRepository.findById(product.getId()).get()).collect(Collectors.toSet());
        commandesEntity.setProduits(produitsEntitySet);


        CommandesEntity saveCommande = commandeRepository.save(commandesEntity);
        CommandeDTO dto = modelMapper.map(saveCommande, CommandeDTO.class);
        return dto;
    }
}
