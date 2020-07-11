package life;

public class Game implements Runnable {

    private Universe universe;
    private Generator generator;
    private final GameOfLife gameOfLife;
    private boolean isRun;

    public Game(int size, GameOfLife gameOfLife) {
        init(size);
        this.gameOfLife = gameOfLife;
        isRun = true;
    }

    public void init(int size) {
        universe = new Universe(size);
        generator = new Generator(universe);
    }

    public boolean isRun() {
        return isRun;
    }

    public void setRun(boolean isRun) {
        this.isRun = isRun;
    }

    @Override
    public void run() {
        int generation = 0;
        while (true){
            if (isRun()) {
                gameOfLife.setGeneration(generation);
                gameOfLife.setAlive(universe.getAlive());

                gameOfLife.setField(universe);

                generator.generate();
                generation++;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }
    }
}