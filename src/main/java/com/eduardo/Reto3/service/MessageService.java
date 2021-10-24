/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.Reto3.service;

import com.eduardo.Reto3.dao.MessageRepository;
import com.eduardo.Reto3.entities.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll() {return (List<Message>) messageRepository.getAll();};
  
    public Optional<Message> getMessage(int id) {return messageRepository.getMessage(id);};
  
    public Message save(Message message) { 
        if (message.getIdMessage()== null){
            return messageRepository.save(message);
        }else{
            Optional<Message> co = messageRepository.getMessage(message.getIdMessage());
            if (co.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
  
  public Message update (Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> me= messageRepository.getMessage(message.getIdMessage());
            if(!me.isEmpty()){
                if(message.getMessageText()!=null){
                    me.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(me.get());
                return me.get();
            }
        }
        return message;   
    }   
    
    public boolean deleteMessage(int messageId){
        Boolean aBoolean = getMessage(messageId).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
