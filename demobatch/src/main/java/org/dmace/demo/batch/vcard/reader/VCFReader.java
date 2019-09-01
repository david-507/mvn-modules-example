package org.dmace.demo.batch.vcard.reader;

import com.github.mangstadt.vinnie.io.SyntaxRules;
import ezvcard.Ezvcard;
import ezvcard.VCard;
import org.dmace.demo.batch.vcard.VCardMapper;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class VCFReader {

//    private static final Path EXAMPLE_VCARD = Paths.get("/home/david/Downloads", "test.vcf");
//    private static final Path EXAMPLE_VCARD = Paths.get("/home/david/Documents/contactes", "contactes.vcf");
    private static final Path EXAMPLE_VCARD = Paths.get("/home/david/Downloads", "contacts.vcf");

    public static void main(String[] args) {

        try ( Reader br = Files.newBufferedReader(EXAMPLE_VCARD) ){

            List<VCard> vcards = Ezvcard.parse(br).all();

            int index = 1;
            for (VCard vcard : vcards) {
                System.out.println(" Contact Nº " + index++);
                System.out.println("---------------");

                VCardMapper mapper = new VCardMapper(vcard);
                System.out.println(mapper);

                System.out.println("emails: " + vcard.getEmails().size());
                System.out.println("phones: " + vcard.getTelephoneNumbers().size() );
                System.out.println("---------------\n\n");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
