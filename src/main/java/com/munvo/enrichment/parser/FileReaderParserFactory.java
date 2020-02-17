package com.munvo.enrichment.parser;

public class FileReaderParserFactory {
    
    /**
     * Instantiates a FileReaderParser based on the value of "type" (case insensitive).  
     * Gives a CsvReaderParser if given "csv", and a JsonReaderParser is given "json".
     * 
     * @param type either "JSON" or "CSV"
     * @return a FileReaderParser instance, null if type is not "json" or "csv"
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
