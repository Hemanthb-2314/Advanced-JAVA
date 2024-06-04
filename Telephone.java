import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class MissedCalls {
    public static void main(String args[]) {
        ArrayList<Contacts> contacts = new ArrayList<>();
        ArrayList<MissCall> mc = new ArrayList<MissCall>();
        contacts.add(new Contacts(1576241361L, "P1"));
        contacts.add(new Contacts(1576241364L, "P2"));
        contacts.add(new Contacts(1576241375L, "P3"));
        contacts.add(new Contacts(1576241312L, "P4"));
        contacts.add(new Contacts(1576241398L, "P5"));
        System.out.println(contacts);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select 1 - add missed calls, 2-display, 3- delete, 4-exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter phone number");
                    long num = scanner.nextLong();
                    mc.add(new MissCall(num, new Date()));
                    if (mc.size() > 10)
                        mc.remove(0);
                    break;
                case 2:
                    int x = 0;
                    for (MissCall m : mc) {
                        boolean found = false;
                        for (Contacts c : contacts) {
                            if (m.number == c.number) {
                                System.out.println("Name: " + c.name + "\nNumber: " + m.number + "\nDate: " + m.date);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Name: private caller\nNumber: " + m.number + "\nDate: " + m.date);
                        }
                    }
                    break;
                case 3:
                    System.out.println("1. Delete by index, 2. Delete by number");
                    int d = scanner.nextInt();
                    switch (d) {
                        case 1:
                            int i = 1;
                            for (MissCall m : mc) {
                                System.out.println(i++ + ":" + m.number);
                            }
                            System.out.println("Enter the index to be deleted");
                            int ch = scanner.nextInt();
                            mc.remove(ch - 1);
                            break;
                        case 2:
                            System.out.println("Enter the number to be deleted");
                            long n = scanner.nextLong();
                            Iterator<MissCall> it = mc.iterator();
                            while (it.hasNext()) {
                                MissCall m = it.next();
                                if (m.number == n) {
                                    it.remove();
                                }
                            }
                            break;
                    }
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}

class Contacts {
    long number;
    String name;

    public Contacts(long number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return number + ":" + name;
    }
}

class MissCall {
    long number;
    Date date;

    public MissCall(long number, Date date) {
        this.number = number;
        this.date = date;
    }

    @Override
    public String toString() {
        return "number=" + number + "\n date=" + date;
    }
}
