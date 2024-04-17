package com.jersson.arrivasplata.swtvap.api.web.business.implementation;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WCommentService;
import com.jersson.arrivasplata.swtvap.api.web.model.WComment;
import com.jersson.arrivasplata.swtvap.api.web.repository.WCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WCommentServiceImpl implements WCommentService {
    private final WCommentRepository WCommentRepository;

    @Autowired
    public WCommentServiceImpl(WCommentRepository WCommentRepository) {
        this.WCommentRepository = WCommentRepository;
    }

    public WComment createComment(WComment comment) {
        return WCommentRepository.save(comment);
    }

}