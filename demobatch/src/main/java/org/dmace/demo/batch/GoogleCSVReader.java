package org.dmace.demo.batch;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * This Class reads google csv contacts file
 *
 */
public class GoogleCSVReader {

    private static final List<String> DEFAULT_HEADERS = Arrays.asList("Name", "Given Name", "Additional Name", "Family Name", "Yomi Name", "Given Name Yomi", "Additional Name Yomi", "Family Name Yomi", "Name Prefix", "Name Suffix", "Initials", "Nickname", "Short Name", "Maiden Name", "Birthday", "Gender", "Location", "Billing Information", "Directory Server", "Mileage", "Occupation", "Hobby", "Sensitivity", "Priority", "Subject", "Notes", "Language", "Photo", "Group Membership", "E-mail 1 - Type", "E-mail 1 - Value", "E-mail 2 - Type", "E-mail 2 - Value", "IM 1 - Type", "IM 1 - Service", "IM 1 - Value", "Phone 1 - Type", "Phone 1 - Value", "Phone 2 - Type", "Phone 2 - Value", "Phone 3 - Type", "Phone 3 - Value", "Address 1 - Type", "Address 1 - Formatted", "Address 1 - Street", "Address 1 - City", "Address 1 - PO Box", "Address 1 - Region", "Address 1 - Postal Code", "Address 1 - Country", "Address 1 - Extended Address", "Organization 1 - Type", "Organization 1 - Name", "Organization 1 - Yomi Name", "Organization 1 - Title", "Organization 1 - Department", "Organization 1 - Symbol", "Organization 1 - Location", "Organization 1 - Job Description", "Relation 1 - Type", "Relation 1 - Value", "Event 1 - Type", "Event 1 - Value", "Custom Field 1 - Type", "Custom Field 1 - Value");
    private static final String DEFAULT_CSV_SEPARATOR = ",";
    private List<String> headers = new ArrayList<>(DEFAULT_HEADERS.size());


    public GoogleCSVReader() {}


    public void parse(Path path) throws IOException {

        if( path==null ) throw new NullPointerException("expected a non null existing path");

        if( !Files.isRegularFile(path) || !Files.isReadable(path) ) throw new IllegalArgumentException("Given path is not readable: " + path.toString());

        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        String first = lines.get(0);
        headers.addAll( Arrays.asList(first.split(DEFAULT_CSV_SEPARATOR)) );
        if(!DEFAULT_HEADERS.equals(headers)) {
            System.out.println("Strange google headers detected...");
            headers.forEach(header -> System.out.printf("\"%s\", ", header));
        }

        lines.stream()
                .skip(1)
                .forEach((String line) -> {
                    String[] rows = line.split(DEFAULT_CSV_SEPARATOR);
                    if(!(rows.length==headers.size())){
                        System.out.println("line with unexpected rows:");
                        System.out.println(line);
                    } else {
                        Arrays.stream(rows, 0, rows.length)
                                .forEach(System.out::println);
                    }
                });


    }


}
