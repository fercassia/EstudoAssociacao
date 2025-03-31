package entities.enums;

public enum WorkerLevel {
    JUNIOR (0),
    MID_LEVEL (1),
    SENIOR (2);

    private final int workerNivel;

    WorkerLevel(int nivel) {
        workerNivel = nivel;
    }

    public int getWorkerNivel() {
        return workerNivel;
    }
}
