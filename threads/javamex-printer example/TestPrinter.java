public class TestPrinter {

	public static void main(String[] args) throws InterruptedException {
		
		MessagePrinter printer = new MessagePrinter("seckin seckin olalala", 2000L);
		int i = 0;
		Thread t1 = new Thread(printer, "t1");
		t1.start();
		
		while(i<2){
			Thread.sleep(5000);
			System.out.println("I slept for 5 sec");
			Thread.sleep(3000);
			System.out.println("I slept for 3 sec");
			i++;
		}

		printer.stopTheThread();
	}

}