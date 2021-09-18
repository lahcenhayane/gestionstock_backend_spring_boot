package com.project.backend.Controllers;


import com.project.backend.Dto.MessageDTO;
import com.project.backend.Entities.MessagesEntity;
import com.project.backend.Requests.MessageRequest;
import com.project.backend.Responses.MessageResponse;
import com.project.backend.Services.IMessageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/messages")
public class MessageController {

    private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private IMessageService messageService;

    @GetMapping(value = "/sent")
    public ResponseEntity<List<MessageResponse>> getAllMessage(@RequestParam(value = "page", defaultValue = "0") int page,
                                                               Principal principal){
        List<MessageDTO> messageDTOList = messageService.getAllMsg(page, principal.getName());
        List<MessageResponse> response = messageDTOList.stream().map(row -> modelMapper.map(row, MessageResponse.class)).collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/inbox")
    public ResponseEntity<List<MessageResponse>> getMsgInbox(Principal principal,
                                                             @RequestParam(value = "page", defaultValue = "0") int page){
        List<MessageDTO> inbox = messageService.getMsgInbox(principal.getName(), page);
        List<MessageResponse> responses = inbox.stream().map(row -> modelMapper.map(row, MessageResponse.class)).collect(Collectors.toList());
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> createNewMsg(@RequestBody MessageRequest request, Principal principal){
        MessageDTO messageDTO = modelMapper.map(request, MessageDTO.class);
        MessageDTO saveMsg = messageService.createNewMsg(messageDTO, principal.getName());
        MessageResponse response = modelMapper.map(saveMsg, MessageResponse.class);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<MessageResponse> ReadMessage(@PathVariable long id, Principal principal){
        MessageDTO messageDTO = messageService.readMsg(id, principal.getName());
        MessageResponse response = modelMapper.map(messageDTO, MessageResponse.class);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
