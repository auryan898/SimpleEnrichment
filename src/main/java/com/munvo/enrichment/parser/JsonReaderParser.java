package com.munvo.enrichment.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.munvo.enrichment.model.Subscriber;


public class JsonReaderParser implements FileReaderParser{

    @Override
    public Subscriber parseSubscriber(String subLine) {
        // Each pattern is separated for readability, although it could be one long pattern
        Pattern idPattern = Pattern.compile("\\\"id\\\"\\s*:\\s*(\\d+)");
        Pattern namePattern = Pattern.compile("\\\"name\\\"\\s*:\\s*\\\"([\\w]*)\\\"");
        Pattern phonePattern = Pattern.compile("\\\"phone\\\"\\s*:\\s*\\\"([\\w\\-]*)\\\"");
        
        Matcher idMatch = idPattern.matcher(subLine);
        Matcher nameMatch = namePattern.matcher(subLine);
        Matcher phoneMatch = phonePattern.matcher(subLine);
        
        if ( !(idMatch.find() && nameMatch.find() && phoneMatch.find()) ) {
            return null;
        }
        
        int id = Integer.parseInt(idMatch.group(1));
        String name = nameMatch.group(1);
        String phone = phoneMatch.group(1);
        return new Subscriber(id, name, phone);
    }

}
