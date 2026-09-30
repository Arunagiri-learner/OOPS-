class Ticket {
    int tickets = 3;

    synchronized void book(String name) {
        if (tickets > 0) {
            System.out.println(name + " booked ticket");
            tickets--;
        } else {
            System.out.println(name + " - No tickets");
        }
    }
}

class User extends Thread {
    Ticket t;
    String name;

    User(Ticket t, String name) {
        this.t = t;
        this.name = name;
    }

    public void run() {
        t.book(name);
    }
}

class User2 implements Runnable {
    Ticket t;
    String name;

    User2(Ticket t, String name) {
        this.t = t;
        this.name = name;
    }

    public void run() {
        t.book(name);
    }
}

public class Main {
    public static void main(String[] args) {

        Ticket t = new Ticket();

        User u1 = new User(t, "Arun");
        User u2 = new User(t, "Rahul");

        User2 u3 = new User2(t, "Kumar");
        User2 u4 = new User2(t, "Ajay");

        u1.start();
        u2.start();

        new Thread(u3).start();
        new Thread(u4).start();
    }
}
