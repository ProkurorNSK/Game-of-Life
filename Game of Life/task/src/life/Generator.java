package life;

public class Generator {
    Universe universe;
    boolean[][] currentField;
    boolean[][] nextField;
    private int size;

    public Generator(Universe universe) {
        this.universe = universe;
        this.size = universe.getSize();
    }

    void generate() {
        currentField = universe.getField();
        nextField = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (currentField[j][i]) {
                    if (countNeighbors(j, i) == 3 || countNeighbors(j, i) == 2) {
                        nextField[j][i] = true;
                    }
                } else {
                    if (countNeighbors(j, i) == 3) {
                        nextField[j][i] = true;
                    }
                }
            }
        }
        universe.setField(nextField);
    }

    private int countNeighbors(int j, int i) {
        int result = 0;
        if (currentField[j - 1 < 0 ? size - 1 : j - 1][i - 1 < 0 ? size - 1 : i - 1]) result++;
        if (currentField[j - 1 < 0 ? size - 1 : j - 1][i]) result++;
        if (currentField[j - 1 < 0 ? size - 1 : j - 1][i + 1 < size ? i + 1 : 0]) result++;
        if (currentField[j][i - 1 < 0 ? size - 1 : i - 1]) result++;
        if (currentField[j][i + 1 < size ? i + 1 : 0]) result++;
        if (currentField[j + 1 < size ? j + 1 : 0][i - 1 < 0 ? size - 1 : i - 1]) result++;
        if (currentField[j + 1 < size ? j + 1 : 0][i]) result++;
        if (currentField[j + 1 < size ? j + 1 : 0][i + 1 < size ? i + 1 : 0]) result++;
        return result;
    }
}