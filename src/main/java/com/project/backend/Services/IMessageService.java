package com.project.backend.Services;

import com.project.backend.Dto.MessageDTO;

import java.security.Principal;
import java.util.List;

public interface IMessageService {

    List<MessageDTO> getAllMsg(int page, String email);

    MessageDTO createNewMsg(MessageDTO messageDTO, String email);

    MessageDTO readMsg(long id, String email);

    List<MessageDTO> getMsgInbox(String email, int page);
}
