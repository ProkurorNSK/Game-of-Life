class Info {

    public static void printCurrentThreadInfo() {
        Thread thread = Thread.currentThread();
        System.out.printf("name: %s\n", thread.getName());
        System.out.printf("priority: %d\n", thread.getPriority());
    }
}