package com.bigcorp.booking.service;

import com.bigcorp.booking.dao.spring.ClientDao;
import com.bigcorp.booking.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    private ClientDao clientDao;

    @Transactional
    public void save(Client client) {
        if (client.getNom() != "NOM") {
            this.clientDao.save(client);
            LOGGER.info("Client successfully saved!");
        } else LOGGER.info("Client couldn't be saved.");

    }

    @Transactional
    public void delete(int id) {
        if (id != 0) {
            this.clientDao.deleteById(id);
            LOGGER.info("Client successfully removed!");
        } else LOGGER.info("Client couldn't be removed.");
    }

    @Transactional
    public Client getById(int id) {
        if(id==0) return null;

        return this.clientDao.findById(id).orElse(null);
    }

    @Transactional
    public List<Client> getByName(String name) {
        if(name=="") return null;

        List<Client> clients = this.clientDao.findByName(name);

        return clients.isEmpty() ? null : clients;
    }
}
