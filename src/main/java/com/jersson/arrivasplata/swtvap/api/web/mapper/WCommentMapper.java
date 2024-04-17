package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.WComment;
import com.jersson.arrivasplata.swtvap.api.web.model.WCommentRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WCommentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WCommentMapper {
    WCommentMapper INSTANCE = Mappers.getMapper(WCommentMapper.class);

    //@Mapping(target = "id", ignore = true)
    WComment commentRequestToComment(WCommentRequest commentRequest);

    WCommentRequest commentToCommentRequest(WComment comment);

    @Mapping(target = "type", source = "comment.type")
    @Mapping(target = "name", source = "comment.name")
    WCommentResponse commentToCommentResponse(WComment comment);

    List<WCommentResponse> mapCommentsToResponses(List<WComment> comments);
}

