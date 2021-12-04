import java.util.*;

// впервые не стал реализовывать задание со звездочкой, в общем и целом суть хранения сортированного списка
// и бинарный поиск по списку понятны, но мне категорически нравится HashSet для хранения контактов,
// т.к. позволяет исключать дубли :)

public class PhoneBook {
    Set<Contact> contactList;
    List<String> groupList = new ArrayList<>(3);
    Map<String, Set<Contact>> groupedContacts = new HashMap<>(5);

    public void addContactAndGroup(List<String> group, Contact contact)  {
        for (int i = 0; i < group.size(); i++) {
            if (groupedContacts.get(groupList.get(Integer.parseInt(group.get(i)) - 1)) == null) {
                contactList = new HashSet<>();
                contactList.add(contact);
                groupedContacts.put(groupList.get(Integer.parseInt(group.get(i)) - 1), contactList);
            } else {
                groupedContacts.get(groupList.get(Integer.parseInt(group.get(i)) - 1)).add(contact);
            }
        }
    }

    public void addGroup(String group) {
        groupList.add(group);
//        System.out.println(groupList);
    }

    public void getAll() {
        for (Map.Entry<String, Set<Contact>> entry : groupedContacts.entrySet()) {
            System.out.println("- " + entry.getKey());
            for (Contact value : entry.getValue()) {
                System.out.println("  -- " + value.toString());
            }
        }
    }

    public void printGroup() {
        for (int i = 0; i < groupList.size(); i++) {
            System.out.println((i + 1) + " " + groupList.get(i));
        }
    }
}
