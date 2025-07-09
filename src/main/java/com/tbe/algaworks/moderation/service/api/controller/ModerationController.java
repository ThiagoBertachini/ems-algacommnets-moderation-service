package com.tbe.algaworks.moderation.service.api.controller;

import com.tbe.algaworks.moderation.service.api.common.ModerationImpl;
import com.tbe.algaworks.moderation.service.api.model.ModerationInput;
import com.tbe.algaworks.moderation.service.api.model.ModerationOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.tbe.algaworks.moderation.service.api.common.ModerationImpl.*;

@Slf4j
@RestController
@RequestMapping("/api/moderate")
@RequiredArgsConstructor
public class ModerationController {

    private final ModerationImpl moderation;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ModerationOutput moderateComment(@RequestBody ModerationInput commentInput) {
        if (moderation.containsProhibitedWords(commentInput.getText())) {
            return getModerationOutput(false, REJECTED_REASON);
        }

        return getModerationOutput(true, APPROVED_REASON);
    }

    private static ModerationOutput getModerationOutput(boolean approved, String reason) {
        return ModerationOutput
                .builder()
                .approved(approved)
                .reason(reason)
                .build();
    }

}
