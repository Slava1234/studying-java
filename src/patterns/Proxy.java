package patterns;

public class Proxy {
    public void start() {

        // Использование

        Cell cells[][] = new Cell[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i + j % 2 == 0) {
                    cells[i][j] = new MineProxy(i, j);
                } else {
                    cells[i][j] = new EmptyProxy(i, j);
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j].open();
            }
        }
    }
}


/**
 * Абстрактный класс ячейки минного поля
 */
abstract class Cell {
    public static final int OPENED = 0;
    public static final int CLOSED = 1;

    protected int status;

    protected int left, top;

    public Cell(int left, int top) {
        super();

        this.left = left;
        this.top = top;
        this.status = Cell.CLOSED;
    }

    /**
     * Открыть данную ячейку. Будем считать, что в этой операции происходит некоторая
     * ресурсоемкая операция. Например, загрузка изображения, для отображения содержимого ячейки.
     */
    public void open() {
        this.status = Cell.OPENED;
    }

    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public int getStatus() {
        return status;
    }

    /**
     * Единственная абстрактная операция, возвращаяет количество очков за открытие данной ячейки.
     */
    public abstract int getPoints();
}

/**
 * Уточнение ячейки минного поля, в качестве пустой ячейки
 */
class Empty extends Cell {

    public Empty(int left, int top) {
        super(left, top);

        // загружаем тяжелое изображение пустой ячейки.
    }

    @Override
    public int getPoints() {
        return 10;  // 10 очков за открытую пустую ячейку
    }
}

/**
 * Уточнение ячейки, как ячейки с миной.
 */
class Mine extends Cell {

    public Mine(int left, int top) {
        super(left, top);

        // загружаем тяжелое изображение ячейки c миной
    }

    @Override
    public int getPoints() {
        return 100;   // 100 очков за открытую мину
    }
}

/**
 * Прокси для пустой ячейки
 */
class EmptyProxy extends Cell {
    private Empty proxy; // ссылка на пустую ячейку

    public EmptyProxy(int left, int top) {
        super(left, top);
        this.proxy = null;
    }

    /**
     * Ленивая инициализация пустой ячейки
     */
    @Override
    public void open() {
        if (proxy == null) {
            proxy = new Empty(left, top);
        }

        proxy.open();
    }

    @Override
    public int getLeft() {
        if (proxy == null) {
            return left;
        } else {
            return proxy.getLeft();
        }

    }

    @Override
    public int getTop() {
        if (proxy == null) {
            return top;
        } else {
            return proxy.getTop();
        }
    }

    @Override
    public int getStatus() {
        if (proxy == null) {
            return status;
        } else {
            return proxy.getStatus();
        }
    }

    @Override
    public int getPoints() {
        if (proxy == null) {
            return 10;
        } else {
            return proxy.getPoints();
        }
    }
}

/**
 * Прокси для ячейки с миной
 */
class MineProxy extends Cell {
    private Mine proxy;

    public MineProxy(int left, int top) {
        super(left, top);

        this.proxy = null;
    }

    /**
     * Ленивая инициализация ячейки с миной
     */
    @Override
    public void open() {
        if (proxy == null) {
            proxy = new Mine(left, top);
        }

        proxy.open();
    }

    @Override
    public int getLeft() {
        if (proxy == null) {
            return left;
        } else {
            return proxy.getLeft();
        }

    }

    @Override
    public int getTop() {
        if (proxy == null) {
            return top;
        } else {
            return proxy.getTop();
        }
    }

    @Override
    public int getStatus() {
        if (proxy == null) {
            return status;
        } else {
            return proxy.getStatus();
        }
    }

    @Override
    public int getPoints() {
        if (proxy == null) {
            return 100;
        } else {
            return proxy.getPoints();
        }
    }
}

