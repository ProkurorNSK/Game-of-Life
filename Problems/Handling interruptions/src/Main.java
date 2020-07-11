class CounterThread extends Thread {

    @Override
    public void run() {
        long counter = 0;

        while (true) {
            if (!isInterrupted()) {
                counter++;
            } else {
                System.out.println("It was interrupted");
                break;
            }
        }
    }
}