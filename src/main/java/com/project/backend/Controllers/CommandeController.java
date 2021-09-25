package com.project.backend.Controllers;


import com.project.backend.Dto.CommandeDTO;
import com.project.backend.Factory.DtoPage.CommandeDtoPage;
import com.project.backend.Factory.Page;
import com.project.backend.Factory.PageFactory;
import com.project.backend.Factory.PageStateEnum;
import com.project.backend.Factory.ResponsePage.CommandeResponsePage;
import com.project.backend.Factory.ResponsePage.CommandeUsersResponsePage;
import com.project.backend.Requests.CommandeRequest;
import com.project.backend.Responses.CmdOrders.CommandeUsersResponse;
import com.project.backend.Responses.CommandeResponse;
import com.project.backend.Services.ICommandeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class CommandeController {
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ICommandeService commandeService;

    @GetMapping
    public ResponseEntity<Page> getAllOrders(@RequestParam(value = "page", defaultValue = "0") int page){
        CommandeDtoPage commandeDtoPage = commandeService.getAllOrders(page);
        CommandeUsersResponsePage commandeResponsePage =
                new CommandeUsersResponsePage(MapDtoToResponse(commandeDtoPage.getList()), commandeDtoPage.getTotalPage(), commandeDtoPage.getTotalRow());
        return new ResponseEntity<>(PageFactory.getPage(PageStateEnum.CommandeUsersResponsePage, commandeResponsePage), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CommandeResponse> createNewOrders(@RequestBody CommandeRequest request){
        CommandeDTO commandeDTO = modelMapper.map(request, CommandeDTO.class);
        CommandeDTO Dto = commandeService.createNewOrider(commandeDTO);
        return new ResponseEntity<>(modelMapper.map(Dto, CommandeResponse.class), HttpStatus.CREATED);
    }


    List<CommandeUsersResponse> MapDtoToResponse(List<CommandeDTO> list){
        return list.stream().map(row->modelMapper.map(row, CommandeUsersResponse.class)).collect(Collectors.toList());
    }
}
