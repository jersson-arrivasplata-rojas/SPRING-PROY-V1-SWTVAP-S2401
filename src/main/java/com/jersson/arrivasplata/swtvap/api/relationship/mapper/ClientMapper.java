package com.jersson.arrivasplata.swtvap.api.relationship.mapper;

import com.jersson.arrivasplata.swtvap.api.common.model.Client;
import com.jersson.arrivasplata.swtvap.api.common.model.ClientRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
   // @Mapping(target = "id", ignore = true)
    @Mapping(source = "clientId", target = "clientId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "cellphone", target = "cellphone")
    @Mapping(source = "countryCode", target = "countryCode")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "whatsapp", target = "whatsapp")
    @Mapping(source = "details", target = "details")
    @Mapping(source = "otherDetails", target = "otherDetails")
    @Mapping(source = "sourceAggregate", target = "sourceAggregate")
    Client clientRequestToClient(ClientRequest clientRequest);

    ClientRequest clientToClientRequest(Client client);
    @Mapping(source = "clientId", target = "clientId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "cellphone", target = "cellphone")
    @Mapping(source = "countryCode", target = "countryCode")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "whatsapp", target = "whatsapp")
    @Mapping(source = "details", target = "details")
    @Mapping(source = "otherDetails", target = "otherDetails")
    @Mapping(source = "sourceAggregate", target = "sourceAggregate")
    ClientResponse clientToClientResponse(Client client);
    List<ClientResponse> mapClientsToResponses(List<Client> clients);

}
