import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int duration = scanner.nextInt();
        int costFood = scanner.nextInt();
        int costFlight = scanner.nextInt();
        int costHotel = scanner.nextInt();
        System.out.println(costFlight * 2 + costHotel * (duration - 1) + costFood * duration);
    }
}