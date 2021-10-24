/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.Reto3.service;

import com.eduardo.Reto3.entities.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Eduardo
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins= "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageController {
    @Autowired
    private MessageService messageService;
    
    @GetMapping("/all")
    public List<Message> getMessages() {
        return messageService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int idMessage) {
        return messageService.getMessage(idMessage);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message) {
        return messageService.save(message);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message){
        return messageService.update(message);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId){
        return messageService.deleteMessage(messageId);
    }
}
