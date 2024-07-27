package com.sandoval.tokenizerservice.infrastructure.in.web;

import com.sandoval.tokenizerservice.application.port.in.TokenizationService;
import com.sandoval.tokenizerservice.domain.model.Token;
import com.sandoval.tokenizerservice.application.dto.CardDto;
import com.sandoval.tokenizerservice.application.dto.TokenDto;
import com.sandoval.tokenizerservice.application.dto.mapper.CardDtoMapper;
import com.sandoval.tokenizerservice.application.dto.mapper.TokenDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tokens")
public class TokenController {

    private final TokenizationService tokenizationService;

    @PostMapping
    public TokenDto tokenizeCard(@RequestBody CardDto cardDto) {
        Token token = tokenizationService.tokenizeCard(CardDtoMapper.INSTANCE.toCard(cardDto));
        return TokenDtoMapper.INSTANCE.toTokenDto(token);
    }
}
