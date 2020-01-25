package com.example.demo.controllers;

import com.example.demo.models.Session;
import com.example.demo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//tell that responds to incoming and outcomming as json endpoint
@RestController
//map the url to respond to
@RequestMapping("/api/v1/sessions")
public class SessionsController {
//    to wired to the repository
    @Autowired
    private SessionRepository sessionRepository;

//    retrieve all sessions
//    route the requestMapping of the class to this method
    @GetMapping
    public List<Session> list() {
        return sessionRepository.findAll();
    }

//    retrieve a session with the id
    @GetMapping
//    Add id to the url of the class
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Session get(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }

//    add a session
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

//    delete a session
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
//        todo: implement the check of foreign key before deleting
        sessionRepository.deleteById(id);
    }

//    modify a session
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session){
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }

}
