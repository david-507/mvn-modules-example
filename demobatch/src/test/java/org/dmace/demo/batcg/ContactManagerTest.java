package org.dmace.demo.batcg;

import ezvcard.Ezvcard;
import ezvcard.VCard;
import org.dmace.demo.batch.vcard.VCardMapper;
import org.dmace.demo.model.Contact;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class ContactManagerTest {

    @Test
    public void simpleTest() {

        String str =
                "BEGIN:VCARD\r\n" +
                "VERSION:3.0\r\n" +
                "N:Doe;Jonathan;;Mr;\r\n" +
                "FN:John Doe\r\n" +
                "EMAIL;TYPE=INTERNET:john@doe.com\r\n" +
                "TEL;TYPE=CELL:637808854\r\n" +
                "END:VCARD\r\n";

        VCard vcard = Ezvcard.parse(str).first();
        VCardMapper mapper = new VCardMapper(vcard);
        Contact contact = mapper.map();

        Assert.assertEquals("John Doe", contact.getFullname());
        Assert.assertEquals("Jonathan", contact.getName());
        Assert.assertEquals("Doe", contact.getLastName());
        Assert.assertEquals("john@doe.com", contact.getEmail());
        Assert.assertEquals("637808854", contact.getPhone());

    }

    @Test
    public void fullContactTest() {
        String str =
                "BEGIN:VCARD\n" +
                "VERSION:3.0\n" +
                "FN:Mr. John Doe\n" +
                "N:Doe;John;;Mr.;\n" +
                "NICKNAME:nick\n" +
                "X-PHONETIC-FIRST-NAME:phonetic 1\n" +
                "X-PHONETIC-MIDDLE-NAME:phonetic2\n" +
                "X-PHONETIC-LAST-NAME:phonetic3\n" +
                "item1.EMAIL;TYPE=INTERNET:jdoe@desjardins.com\n" +
                "item1.X-ABLabel:Test\n" +
                "EMAIL;TYPE=INTERNET:jdoe@personal.com\n" +
                "item2.X-YAHOO:chat\n" +
                "item2.X-ABLabel:\n" +
                "TEL;TYPE=HOME:9312234567\n" +
                "TEL;TYPE=WORK:931 23 45 67\n" +
                "TEL;TYPE=CELL:612 34 56 78\n" +
                "item3.ADR:;;Carrer de la Diputació\\, 255;Barcelona;Barcelona;08007;ES\n" +
                "item3.X-ABLabel:\n" +
                "item4.ORG:Desjardins;Company department\n" +
                "item4.X-ABLabel:\n" +
                "item5.TITLE:lead developer\n" +
                "item5.X-ABLabel:\n" +
                "BDAY:19871125\n" +
                "X-ABDATE:20190825\n" +
                "item6.X-ABRELATEDNAMES:relation\n" +
                "item6.X-ABLabel:referredBy\n" +
                "NOTE:Random notes...\n" +
                "PHOTO:https://lh3.googleusercontent.com/-L4AYogwn2oo/XWj82tMM1RI/AAAAAAAAAAA/rnAJdAtwyRQwHz6rrPI27sBnSk9LgOA3wCOQCEAE/photo.jpg\n" +
                "END:VCARD";

        VCard vcard = Ezvcard.parse(str).first();

        VCardMapper mapper = new VCardMapper(vcard);
        Contact contact = mapper.map();

        Assert.assertEquals("John", contact.getName());
        Assert.assertEquals("Doe", contact.getLastName());
        Assert.assertEquals("Mr. John Doe", contact.getFullname());
        Assert.assertEquals("Random notes...", contact.getComments());
        Assert.assertEquals(LocalDate.of(1987, 11, 25), contact.getDob());
        Assert.assertEquals("9312234567", contact.getPhone());
        Assert.assertEquals("jdoe@desjardins.com", contact.getEmail());
    }

}
