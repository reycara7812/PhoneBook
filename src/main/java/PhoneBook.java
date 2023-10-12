import java.util.*;
public class PhoneBook {

    private final Map<String, List<String>> phonebook;


    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = new LinkedHashMap<>();
    }

    public PhoneBook() {
        this(null);
    }

    /**
     * If the phonebook already has a key(name) then we will retive that list from that name
     * and then we add the number to an existing list ELSE we are going to make a new list add the phone number and put
     * the name and the phone number into the hashmap
     *
     * @param name
     * @param phoneNumber
     */
    public void add(String name, String phoneNumber) {

        if (phonebook.containsKey(name)) {
            List<String> phoneNumbers = phonebook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phonebook.put(name, phoneNumbers);
        }

    }

    /*
    Check if the phonebook already contains a contact with the given name.
If the contact exists, retrieve the list of phone numbers associated with that contact.
Iterate over the phoneNumbers array and add each phone number to the list.
If the contact does not exist, create a new list of phone numbers.
Iterate over the phoneNumbers array and add each phone number to the new list.
Put the name and the list of phone numbers into the phonebook.
     */
    public void addAll(String name, String[] phoneNumbers) {
        if (phonebook.containsKey(name)) {
            List<String> allPhoneNumbers = phonebook.get(name);
            for (int i = 0; i < phoneNumbers.length; i++) {
                allPhoneNumbers.add(phoneNumbers[i]);
            }
        } else {
            List<String> allPhoneNumbers = new ArrayList<>();
            for (int i = 0; i < phoneNumbers.length; i++) {
                allPhoneNumbers.add(phoneNumbers[i]);
            }
            phonebook.put(name, allPhoneNumbers);

        }
    }

    /**
     * Check if the phonebook contains a contact with the given name using the containsKey method.
     * If the contact does not exist, print a message indicating that the name is not available.
     * If the contact exists, remove the contact from the phonebook using the remove method
     * @param name
     */
    public void remove(String name) {
        if (!phonebook.containsKey(name)) {
            System.out.println("The name is not available");

        } else {
            phonebook.remove(name);
        }

    }

    /**
     * Check if the phonebook does not contain the given name using the containsKey method.
     * If the name is not present, print a message indicating that the name is not there and return false.
     * If the name is present, return true.
     * @param name
     * @return
     */
    public Boolean hasEntry(String name) {
        if (!phonebook.containsKey(name)) {
            System.out.println("the name is not there");
            return false;
        }

        return true;
    }

    /**
     * he method checks if the phonebook map contains the given name as a key using the containsKey method.
     * If the name is found in the phonebook, the method retrieves the associated list of phone numbers using the get method.
     * The retrieved list of phone numbers is returned as the output.
     * If the name is not found in the phonebook, the method returns null.
     * @param name
     * @return
     */
    public List<String> lookup(String name) {
        if (phonebook.containsKey(name)) {
            return phonebook.get(name);
        }
        return null;
    }

    public String reverseLookup(String phoneNumber) {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            List<String> numberList = entry.getValue();
            for (int i = 0; i < numberList.size(); i++) {

                if (numberList.get(i).equals(phoneNumber)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }







   public List<String> getAllContactNames() {
        List<String> contactNames = new ArrayList<>(phonebook.keySet());
        return contactNames;}


    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }


}