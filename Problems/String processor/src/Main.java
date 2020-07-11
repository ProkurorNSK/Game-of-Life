import java.util.Objects;
import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        while (true) {
            String line = scanner.nextLine();
            String lineUp = line.toUpperCase();
            if (Objects.equals(line, lineUp)) {
                System.out.println("FINISHED");
                break;
            } else {
                System.out.println(lineUp);
            }
        }
    }
}