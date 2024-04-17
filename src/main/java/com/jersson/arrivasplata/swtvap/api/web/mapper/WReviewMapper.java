package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.WReview;
import com.jersson.arrivasplata.swtvap.api.web.model.WReviewRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WReviewResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WReviewMapper {
    WReviewMapper INSTANCE = Mappers.getMapper(WReviewMapper.class);

    //@Mapping(target = "id", ignore = true)
    WReview reviewRequestToReview(WReviewRequest reviewRequest);

    WReviewRequest reviewToReviewRequest(WReview review);

    WReviewResponse reviewToReviewResponse(WReview review);

    List<WReviewResponse> mapReviewsToResponses(List<WReview> reviews);
}
