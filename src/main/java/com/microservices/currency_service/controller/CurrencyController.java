package com.microservices.currency_service.controller;

import com.microservices.currency_service.model.CurrencyDto;
import com.microservices.currency_service.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("currency")
@Tag(name = "Currency", description = "Endpoint for managing currencies")
//@RequiredArgsConstructor
public class CurrencyController {
    
   @Autowired
   private CurrencyService service;
    
    @GetMapping(value = "/{amount}/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "None for now",
            summary = "None for now", responses = {
            @ApiResponse(description = "SUCCESS", responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = CurrencyDto.class))}),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
//            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
//            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
    public CurrencyDto getCurrency(@PathVariable("amount") BigDecimal amount, @PathVariable("from") String from,
                                   @PathVariable("to") String to) {
        
        return service.getConvertedCurrency(amount, from, to);
    }
}
