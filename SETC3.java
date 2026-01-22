/*Using the concepts of thread synchronization create two threads as sender and
receiver. Sender thread will set a message to the receiver thread that will display the
message on console. The sender thread accepts the input message from console.
Continue this process until sender sets the message as “Good Bye Corona”.
*/
class Message {
    String msg;
    boolean empty = true;

    synchronized void send(String msg) {
        while (!empty) {
            try { wait(); } catch (Exception e) {}
        }
        empty = false;
        this.msg = msg;
        notify();
    }

    synchronized String receive() {
        while (empty) {
            try { wait(); } catch (Exception e) {}
        }
        empty = true;
        notify();
        return msg;
    }
}

class Sender extends Thread {
    Message m;
    String[] msgs = {"Hello", "How are you?", "Good Bye Corona"};

    Sender(Message m) { this.m = m; }

    public void run() {
        for (String s : msgs) {
            m.send(s);
        }
    }
}

class Receiver extends Thread {
    Message m;
    Receiver(Message m) { this.m = m; }

    public void run() {
        String msg;
        do {
            msg = m.receive();
            System.out.println("Received: " + msg);
        } while (!msg.equals("Good Bye Corona"));
    }
}

public class SenderReceiver {
    public static void main(String[] args) {
        Message m = new Message();
        new Sender(m).start();
        new Receiver(m).start();
    }
}
class Message {
    String msg;
    boolean empty = true;

    synchronized void send(String msg) {
        while (!empty) {
            try { wait(); } catch (Exception e) {}
        }
        empty = false;
        this.msg = msg;
        notify();
    }

    synchronized String receive() {
        while (empty) {
            try { wait(); } catch (Exception e) {}
        }
        empty = true;
        notify();
        return msg;
    }
}

class Sender extends Thread {
    Message m;
    String[] msgs = {"Hello", "How are you?", "Good Bye Corona"};

    Sender(Message m) { this.m = m; }

    public void run() {
        for (String s : msgs) {
            m.send(s);
        }
    }
}

class Receiver extends Thread {
    Message m;
    Receiver(Message m) { this.m = m; }

    public void run() {
        String msg;
        do {
            msg = m.receive();
            System.out.println("Received: " + msg);
        } while (!msg.equals("Good Bye Corona"));
    }
}

public class SenderReceiver {
    public static void main(String[] args) {
        Message m = new Message();
        new Sender(m).start();
        new Receiver(m).start();
    }
}
