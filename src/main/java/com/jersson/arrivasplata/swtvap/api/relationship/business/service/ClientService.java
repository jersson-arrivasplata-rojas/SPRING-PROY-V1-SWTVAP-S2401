package com.jersson.arrivasplata.swtvap.api.relationship.business.service;

import com.jersson.arrivasplata.swtvap.api.common.model.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
    Flux<Client> getAllClients();
    Mono<Client> getClientById(Long id);
    Mono<Client> createClient(Client client);
    Mono<Client> updateClient(Client client);
    Mono<Void> deleteClientById(Long id);
}
