package org.dmace.demo.batch.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.dmace.demo.batch.GoogleCSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static GoogleCSVReader reader = new GoogleCSVReader();

    public static void main(String[] args) throws IOException {

//        Path path = Paths.get("/home/david/Downloads", "contacts (2).csv");
//        reader.parse(path);
        try (
            Reader reader = Files.newBufferedReader(Paths.get("/home/david/Downloads", "contacts (1).csv"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        ) {

            Map<String, Integer> headerMap = csvParser.getHeaderMap();
            Map<Integer, String> headerNumMap = new HashMap<>(headerMap.size());
            headerMap.forEach((k, v) -> headerNumMap.put(v, k));

            for(CSVRecord record: csvParser) {
                System.out.println(" Contact Nº " + record.getRecordNumber());
                System.out.println("---------------");

                for(int i=0; i<record.size(); i++)
                    System.out.printf("%-25s : %s%n", headerNumMap.get(i), record.get(i));


                System.out.println("---------------\n\n");
            }

        }
    }

}
