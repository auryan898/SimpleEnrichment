package com.munvo.enrichment.parser;

import com.munvo.enrichment.model.Subscriber;

public class CsvReaderParser implements FileReaderParser {

    @Override
    public Subscriber parseSubscriber(String subLine) {
        String[] attr = subLine.split(",");
        int id = Integer.parseInt(attr[0]);
        String name = attr[1].replaceAll("^\"|\"$", "");
        String phone = attr[2].replaceAll("^\"|\"$", "");
        
        return new Subscriber(id, name, phone);
    }

}
