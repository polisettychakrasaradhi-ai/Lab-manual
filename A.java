import java.util.Scanner;

// Base class
abstract class ChessPiece {
    private String color;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract void move();
}

// Inheritance
class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public void move() {
        System.out.println(getColor() + " King moves one square in any direction.");
    }
}

class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public void move() {
        System.out.println(getColor() + " Queen moves any number of squares in any direction.");
    }
}

class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public void move() {
        System.out.println(getColor() + " Rook moves horizontally or vertically.");
    }
}

class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public void move() {
        System.out.println(getColor() + " Bishop moves diagonally.");
    }
}

class Knight extends ChessPiece {
    public Knight(String color) {
        super(color);
    }

    @Override
    public void move() {
        System.out.println(getColor() + " Knight moves in an L-shape.");
    }
}

class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public void move() {
        System.out.println(getColor() + " Pawn moves one square forward.");
    }
}

// Main Class
public class ChessGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Chess Game =====");
            System.out.println("1. King");
            System.out.println("2. Queen");
            System.out.println("3. Rook");
            System.out.println("4. Bishop");
            System.out.println("5. Knight");
            System.out.println("6. Pawn");
            System.out.println("7. Exit");
            System.out.print("Choose a Chess Piece: ");

            int choice = sc.nextInt();

            ChessPiece piece = null;

            switch (choice) {
                case 1:
                    piece = new King("White");
                    break;
                case 2:
                    piece = new Queen("White");
                    break;
                case 3:
                    piece = new Rook("White");
                    break;
                case 4:
                    piece = new Bishop("White");
                    break;
                case 5:
                    piece = new Knight("White");
                    break;
                case 6:
                    piece = new Pawn("White");
                    break;
                case 7:
                    System.out.println("Game Ended.");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }

            if (piece != null) {
                piece.move();   // Polymorphism
            }
        }
    }
}
