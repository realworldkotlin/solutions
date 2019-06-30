

public class Ship {

    private final Direction direction;
    private final int length;
    private final int row;
    private final int column;
    private final boolean destroyed;

    public Ship(Direction direction, int length, int row, int column, boolean destroyed) {
        this.direction = direction;
        this.length = length;
        this.row = row;
        this.column = column;
        this.destroyed = destroyed;
    }

    public Ship(Direction direction, int length) {
        this(direction, length, 0, 0, false);
    }

    public Direction getDirection() {
        return direction;
    }

    public int getLength() {
        return length;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public Ship destroy() {
        return new Ship(direction, length, row, column, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship ship = (Ship) o;

        if (length != ship.length) return false;
        if (row != ship.row) return false;
        if (column != ship.column) return false;
        if (destroyed != ship.destroyed) return false;
        return direction == ship.direction;
    }

    @Override
    public int hashCode() {
        int result = direction != null ? direction.hashCode() : 0;
        result = 31 * result + length;
        result = 31 * result + row;
        result = 31 * result + column;
        result = 31 * result + (destroyed ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ship(" +
            "direction=" + direction +
            ", length=" + length +
            ", row=" + row +
            ", column=" + column +
            ", destroyed=" + destroyed +
            ')';
    }
}
