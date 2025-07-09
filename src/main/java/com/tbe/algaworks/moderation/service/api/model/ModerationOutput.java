package com.tbe.algaworks.moderation.service.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModerationOutput {
    private String reason;
    private boolean approved;
}
