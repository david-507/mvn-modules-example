package org.dmace.demo.batch.vcard;

import ezvcard.VCard;
import ezvcard.io.scribe.ScribeIndex;
import ezvcard.io.scribe.VCardPropertyScribe;
import ezvcard.io.text.WriteContext;
import ezvcard.property.*;
import org.dmace.demo.model.Contact;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * Immutable class used to map Vcards
 *
 */
public class VCardMapper {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    private final VCard vcard;

    public VCardMapper(final VCard vcard) {
        if( vcard==null ) throw new NullPointerException("vcard");
        this.vcard = vcard;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ScribeIndex scribeIndex = new ScribeIndex();
        WriteContext context = new WriteContext(vcard.getVersion(), null, false);

        for (VCardProperty property : vcard) {
            VCardPropertyScribe scribe = scribeIndex.getPropertyScribe(property);
            String name = scribe.getPropertyName();
            String value = scribe.writeText(property, context);
            sb.append(name).append(" = ").append(value).append("\n");
        }

        return sb.toString();
    }

    public Contact map() {
        Contact contact = new Contact();

        contact.setEmail(email());
        contact.setDob(extractDOB());
        contact.setPhone(phone());
        contact.setName(vcard.getStructuredName().getGiven());
        contact.setLastName(vcard.getStructuredName().getFamily());
        contact.setFullname(vcard.getFormattedName().getValue());
        contact.setComments(notes());
        contact.setAddress(address());

       return contact;
    }

    public String address() {
        StringBuilder address = new StringBuilder();
        List<Address> addresses = vcard.getAddresses();
        if( addresses!=null && addresses.size()>0 ){
            Address a = addresses.get(0);
            address.append(a.getStreetAddressFull());
            if (a.getPostalCode()!=null)
                address.append(" ").append(a.getPostalCode());

            if (a.getLocality()!=null)
                address.append(" ").append(a.getLocality());

            if (a.getCountry()!=null)
                address.append(" ").append(a.getCountry());
        }

        return address.toString();
    }

    public String notes() {
        StringBuilder sb = new StringBuilder();
        List<Note> notes = vcard.getNotes();

        for (Note note : notes) {
            sb.append(note.getValue());
        }

        return sb.toString();
    }

    public String photo() {
        String url = "";
        List<Photo> photos = vcard.getPhotos();

        if(photos!=null && photos.size()>0) {
            Photo p = photos.get(0);
            url = p.getUrl();
        }

        return url;
    }


    /**
     * Extract phone from vcard
     * TODO:
     *
     * @return
     */
    private String phone() {
        String phone = null;
        List<Telephone> telephones = vcard.getTelephoneNumbers();

        if( telephones!=null || telephones.size()>0 ){
            Telephone t = telephones.get(0);
            phone = t.getText();
        }
        return phone;
    }

    /**
     * Extract phone from vcard
     * TODO:
     *
     * @return
     */
    private String email() {
        String mail = null;
        List<Email> emails = vcard.getEmails();

        if( emails!=null && emails.size()>0 ){
            Email e = emails.get(0);
            mail = e.getValue();
        }

        return mail;
    }

    private LocalDate extractDOB() {
        LocalDate dob = null;
        Birthday b = vcard.getBirthday();

        if(b!=null && b.getDate()!=null)
            dob = toLocalDate(b.getDate());

        return dob;
    }

    private LocalDate toLocalDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

}
