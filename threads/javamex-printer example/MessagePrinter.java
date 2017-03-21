import java.text.SimpleDateFormat;
import java.util.Date;

public class MessagePrinter implements Runnable {

	private final String message;
	private final long interval;
	private volatile boolean continue_ops = true;

	public MessagePrinter(String message, Long interval) {
		this.message = message;
		this.interval = interval;
	}

	@Override
	public void run() {
		while (continue_ops) {
			try {
				System.out.println(Thread.currentThread().getName() + " / " + getDateTimeNow() + ":  " + message);
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String getDateTimeNow() {
		long yourmilliseconds = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
		Date resultdate = new Date(yourmilliseconds);
		return sdf.format(resultdate);
	}

	public void stopTheThread() {
		System.out.println(Thread.currentThread().getName() + " is stopping the operation");
		continue_ops = false;
	}

}