package com.jersson.arrivasplata.swtvap.api.relationship.expose;

import com.jersson.arrivasplata.swtvap.api.common.model.ClientRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.ClientResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientController {
    Flux<ClientResponse> getAllClients();
    Mono<ClientResponse> getClientById(Long id);
    Mono<ClientResponse> createClient(ClientRequest clientRequest);
    Mono<ClientResponse> updateClient(Long id, ClientRequest clientRequest);
    Mono<Void> deleteClient(Long id);
    Mono<ResponseEntity<String>> performUsefulOperationWithResponse();
}
