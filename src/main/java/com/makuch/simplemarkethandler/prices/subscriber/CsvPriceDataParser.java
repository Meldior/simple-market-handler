package com.makuch.simplemarkethandler.prices.subscriber;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class CsvPriceDataParser implements PriceDataParser {
    public List<PriceData> parseMessage(String message){
        String[] lines = message.split(System.getProperty("line.separator"));
        return Arrays.stream(lines)
                .map(this::parsePriceDataLine)
                .collect(Collectors.toList());
    }

    private PriceData parsePriceDataLine(String line){
        // I am assuming the data will be in the format specified in the example, without any corrupted rows.
        String[] tokens = line.split(",");
        tokens = Arrays.stream(tokens)
                .map(String::trim).toArray(String[]::new);
        return PriceData.builder()
                .id(Long.parseLong(tokens[0]))
                .instrumentName(tokens[1])
                .bid(Double.parseDouble(tokens[2]))
                .ask(Double.parseDouble(tokens[3]))
                .reportedAt(LocalDateTime.parse(tokens[4], DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS")))
                .build();
    }
}
