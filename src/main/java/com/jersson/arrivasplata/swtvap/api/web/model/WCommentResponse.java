package com.jersson.arrivasplata.swtvap.api.web.model;

import com.jersson.arrivasplata.swtvap.api.web.enums.Type;
import lombok.Data;

import java.time.LocalDate;

@Data
public class WCommentResponse {
    private Long commentId;
    private Long productId;
    private Long replyCommentId;
    private String comment;
    private Type type;
    private String name;
    private LocalDate commentAt;
}
