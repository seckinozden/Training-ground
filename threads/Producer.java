import java.util.ArrayList;
import java.util.List;

public class Producer implements Runnable {

	static final int MAXQUEUE = 5;
	private List<String> messages = new ArrayList<String>();

	public void run() {
		while (true) {
			putMessage();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	// called by Producer internally
	private synchronized void putMessage() {
		while (messages.size() >= MAXQUEUE) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		messages.add("Message time: " + new java.util.Date().toString());
		notify();
	}

	// called by Consumer externally
	public synchronized String getMessage() {
		while (messages.size() == 0)
			try {
				notify();
				wait();
			} catch (InterruptedException e) {
			}
		String message = (String) messages.remove(0);
		notify();
		return message;
	}

}
