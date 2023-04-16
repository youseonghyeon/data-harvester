package com.settlement.dataharvester.domain.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SettlementReportController {

    private File findFile(String path, String fileName) {
        File file = new File(path + fileName);
        if (file.exists()) {
            return file;
        }
        return null;
    }



}
