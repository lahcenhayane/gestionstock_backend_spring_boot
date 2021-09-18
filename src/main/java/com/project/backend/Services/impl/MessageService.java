package com.project.backend.Services.impl;

import com.project.backend.Dto.MessageDTO;
import com.project.backend.Entities.MessagesEntity;
import com.project.backend.Entities.UtilisateursEntity;
import com.project.backend.Exceptions.MessageExceprion;
import com.project.backend.Exceptions.UtilisateurException;
import com.project.backend.Repositories.MessageRepository;
import com.project.backend.Repositories.UtilisateurRepository;
import com.project.backend.Services.IMessageService;
import com.project.backend.Utils.GlobalVariable;
import com.sun.security.auth.UserPrincipal;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MessageService implements IMessageService {

    private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;


    /**
     * Get All Messages
     * @param page
     * @return List<MessageDTO>
     */
    @Override
    public List<MessageDTO> getAllMsg(int page, String email) {
        if (page > 0){page--;}else{page *= -1;}
        UtilisateursEntity user = findUserByEmail(email);
        Page<MessagesEntity> messagesEntity = messageRepository.findByUtilisateur(user, PageRequest.of(page, GlobalVariable.SIZE));
        return messagesEntity.stream().map(row -> modelMapper.map(row, MessageDTO.class)).collect(Collectors.toList());
    }


    /**
     * Send New Message
     * @param messageDTO
     * @param email
     * @return
     */
    @Override
    public MessageDTO createNewMsg(MessageDTO messageDTO, String email) {
        UtilisateursEntity user = findUserByEmail(email);
        messageDTO.setLire(false);
        MessagesEntity messagesEntity = modelMapper.map(messageDTO, MessagesEntity.class);
        messagesEntity.setUtilisateur(user);
        MessagesEntity saveMsg = messageRepository.save(messagesEntity);
        return modelMapper.map(saveMsg, MessageDTO.class);
    }


    /**
     * Read Message
     * @param id
     * @param email
     * @return
     */
    @Override
    public MessageDTO readMsg(long id, String email) {
        MessagesEntity messagesEntity = messageRepository.findById(id).get();
        if (messagesEntity == null) throw new MessageExceprion("Message Not Found.");

        String emailMsg = messagesEntity.getUtilisateur().getEmail();
        if (emailMsg != email) throw new MessageExceprion("You Cannot Read This Msg.");

        messagesEntity.setLire(true);
        MessagesEntity saveMsg = messageRepository.save(messagesEntity);
        return modelMapper.map(saveMsg, MessageDTO.class);
    }


    /**
     * Get Messages Inbox
     * @param email
     * @return
     */
    @Override
    public List<MessageDTO> getMsgInbox(String email, int page) {
        Page<MessagesEntity> msgList = messageRepository.findByEmail(email, PageRequest.of(page, GlobalVariable.SIZE));
        if (msgList.getSize() <= 0) throw new MessageExceprion("You Dont Have Any Msg.");

        return msgList.stream().map(row -> modelMapper.map(row, MessageDTO.class)).collect(Collectors.toList());
    }


    /**
     * Find User By Email.
     * @param email
     * @return
     */
    private UtilisateursEntity findUserByEmail(String email) {
        UtilisateursEntity user = utilisateurRepository.findByEmail(email);
        if (user == null) throw new UtilisateurException("User Not Found");
        return user;
    }

}
