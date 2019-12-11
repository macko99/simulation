public class Position {

     int x;
     int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Position add(Position other) {
        return new Position(other.x+this.x, other.y+this.y);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if(!(other instanceof Position))
            return false;
        Position vector = (Position) other;
        return vector.x == this.x && vector.y == this.y;
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 17;
        return hash;
    }

}
