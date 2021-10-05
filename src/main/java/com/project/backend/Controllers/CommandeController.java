package com.project.backend.Controllers;


import com.project.backend.Dto.CommandeDTO;
import com.project.backend.Dto.CommandeProduitDTO;
import com.project.backend.Factory.DtoPage.CommandeDtoPage;
import com.project.backend.Factory.Page;
import com.project.backend.Factory.PageFactory;
import com.project.backend.Factory.PageStateEnum;
import com.project.backend.Factory.ResponsePage.CommandeResponsePage;
import com.project.backend.Factory.ResponsePage.CommandeUsersResponsePage;
import com.project.backend.Repositories.CommandeProduitRepository;
import com.project.backend.Repositories.CommandeRepository;
import com.project.backend.Requests.CommandeRequest;
import com.project.backend.Responses.CmdOrders.CommandeUsersResponse;
import com.project.backend.Responses.CommandeResponse;
import com.project.backend.Services.ICommandeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class CommandeController {
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ICommandeService commandeService;
    @Autowired
    private CommandeRepository commandeRepository;


    @GetMapping("/count")
    public long getCountOrders(){
        return commandeService.getCountOrders();
    }

    @GetMapping
    public ResponseEntity<Page> getAllOrders(@RequestParam(value = "page", defaultValue = "0") int page,
                                             @RequestParam(value = "id", defaultValue = "0") long id){
        CommandeDtoPage commandeDtoPage = commandeService.getAllOrders(page, id);
        CommandeUsersResponsePage commandeResponsePage =
                new CommandeUsersResponsePage(MapDtoToResponse(commandeDtoPage.getList()), commandeDtoPage.getTotalPage(), commandeDtoPage.getTotalRow());
        return new ResponseEntity<>(PageFactory.getPage(PageStateEnum.CommandeUsersResponsePage, commandeResponsePage), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CommandeResponse> createNewOrders(@RequestBody CommandeRequest request, Principal principal){
        CommandeDTO commandeDTO = modelMapper.map(request, CommandeDTO.class);
        Set<CommandeProduitDTO> list = request.getProduits().stream().map(row->modelMapper.map(row, CommandeProduitDTO.class )).collect(Collectors.toSet());
        commandeDTO.setCommandeProduit(list);
        CommandeDTO Dto = commandeService.createNewOrider(commandeDTO, principal);

        CommandeResponse commandeResponse = modelMapper.map(Dto, CommandeResponse.class);
        commandeResponse.getProduits().stream().map(row->modelMapper.map(row, CommandeResponse.class));
        return new ResponseEntity<>(commandeResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable long id){
        commandeRepository.delete(commandeRepository.findById(id).get());
    }

    List<CommandeUsersResponse> MapDtoToResponse(List<CommandeDTO> list){
        return list.stream().map(row->modelMapper.map(row, CommandeUsersResponse.class)).collect(Collectors.toList());
    }
}
