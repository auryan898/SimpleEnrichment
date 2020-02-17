package com.munvo.enrichment.parser;

public class FileReaderParserFactory {
    
    /**
     * Instantiates a FileReaderParser based on value of "type" given 
     * in the Configuration class.
     * 
     * @param type either "JSON" or "CSV"
     * @return a FileReaderParser instance
     */
    public static FileReaderParser getParser(String type) {
        if (type == null) {
            return null;
        } 
        
        if (type.equalsIgnoreCase("JSON")) {
            return new JsonReaderParser();
        } else if (type.equalsIgnoreCase("CSV")) {
            return new CsvReaderParser();
        }
        return null;
    }
}
