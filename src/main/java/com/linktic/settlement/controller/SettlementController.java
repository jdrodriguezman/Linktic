package com.linktic.settlement.controller;

import com.linktic.settlement.dto.InsuredRequest;
import com.linktic.settlement.dto.SettlementResponse;
import com.linktic.settlement.service.SettlementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid; import java.util.List;

@RestController
@RequestMapping("/api/settlement")
@RequiredArgsConstructor
public class SettlementController {
    private final SettlementService settlementService;

    @Validated
    @PostMapping("/calculate")
    @Operation(summary = "Calculate Settlement", description = "Calculates the settlement based on the provided request.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Calculation successful"),
            @ApiResponse(responseCode = "500", description = "Internal server error") })
    public ResponseEntity<List<SettlementResponse>> calculateSettlement(@RequestBody @Valid List<InsuredRequest> request) {
        List<SettlementResponse> response = settlementService.calculateSettlement(request);
        return ResponseEntity.ok(response);
    }
}