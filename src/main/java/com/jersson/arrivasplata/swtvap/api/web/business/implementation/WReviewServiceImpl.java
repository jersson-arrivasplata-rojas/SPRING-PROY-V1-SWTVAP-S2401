package com.jersson.arrivasplata.swtvap.api.web.business.implementation;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WReviewService;
import com.jersson.arrivasplata.swtvap.api.web.model.WReview;
import com.jersson.arrivasplata.swtvap.api.web.repository.WReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WReviewServiceImpl implements WReviewService {
    private final WReviewRepository WReviewRepository;

    @Autowired
    public WReviewServiceImpl(WReviewRepository WReviewRepository) {
        this.WReviewRepository = WReviewRepository;
    }

    public WReview createReview(WReview review) {
        return WReviewRepository.save(review);
    }

}