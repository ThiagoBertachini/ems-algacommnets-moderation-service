package com.tbe.algaworks.moderation.service.api.common;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ModerationImpl implements Moderation {

    protected static final String APPROVED_REASON = "NON PROHIBITED WORDS FOUND";
    protected static final String REJECTED_REASON = "PROHIBITED WORDS FOUND";
    protected static final List<String> PROHIBITED_WORDS = Arrays.asList("ódio", "xingamento");

    @Override
    public boolean containsProhibitedWords(String text) {
        return PROHIBITED_WORDS.stream().anyMatch(text::contains);
    }
}
