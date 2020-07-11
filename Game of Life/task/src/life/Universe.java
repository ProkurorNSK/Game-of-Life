package life;

import java.util.Random;

public class Universe {
    private boolean[][] field;
    private final int size;

    public Universe(int size) {
        this.size = size;
        field = new boolean[size][size];
        init();
    }

    public void setField(boolean[][] field) {
        this.field = field;
    }

    public boolean[][] getField() {
        return field;
    }

    public int getSize() {
        return size;
    }

    private void init() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[j][i] = random.nextBoolean();
            }
        }
    }

    int getAlive() {
        int result = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[j][i]) result++;
            }
        }
        return result;
    }
}