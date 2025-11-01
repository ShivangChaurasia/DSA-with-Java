// ContactManager.java
import java.io.*;
import java.util.*;

public class ContactManager {
    private final Trie trie = new Trie();
    private final Map<String, String> contactsMap = new HashMap<>();

    public void loadContacts(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    String number = parts[1].trim();
                    trie.insert(name, number);
                    contactsMap.put(name.toLowerCase(), number);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load contacts.");
        }
    }

    public void saveContact(String name, String number, String filePath) {
        if (!name.isEmpty()) {
            contactsMap.put(name.toLowerCase(), number);
        }
        rebuildTrie();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : contactsMap.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving contact.");
        }
    }

    public void deleteContact(String name) {
        contactsMap.remove(name.toLowerCase());
        rebuildTrie();
    }

    public List<String> search(String prefix) {
        return trie.search(prefix);
    }

    public List<String> searchByNumber(String number) {
        List<String> results = new ArrayList<>();
        for (Map.Entry<String, String> entry : contactsMap.entrySet()) {
            if (entry.getValue().startsWith(number)) {
                results.add(entry.getKey() + " : " + entry.getValue());
            }
        }
        return results;
    }

    public boolean contactExists(String name) {
        return contactsMap.containsKey(name.toLowerCase());
    }

    private void rebuildTrie() {
        trie.clear();
        for (Map.Entry<String, String> entry : contactsMap.entrySet()) {
            trie.insert(entry.getKey(), entry.getValue());
        }
    }
}