package com.jersson.arrivasplata.swtvap.api.review.mapper;

import com.jersson.arrivasplata.swtvap.api.review.model.Comment;
import com.jersson.arrivasplata.swtvap.api.review.model.CommentRequest;
import com.jersson.arrivasplata.swtvap.api.review.model.CommentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    //@Mapping(target = "id", ignore = true)
    Comment commentRequestToComment(CommentRequest commentRequest);

    CommentRequest commentToCommentRequest(Comment comment);

    @Mapping(target = "type", source = "comment.type")
    @Mapping(target = "name", source = "comment.name")
    @Mapping(target = "status", source = "comment.status")
    CommentResponse commentToCommentResponse(Comment comment);

    List<CommentResponse> mapCommentsToResponses(List<Comment> comments);
}

