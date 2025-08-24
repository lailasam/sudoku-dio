package model;
import java.util.ArrayList;
import java.util.List;

public class Game {
private List<List<Spaces>> board;
private GameStatus status;
private boolean hasErrors;

public Game(GameStatus status, boolean hasErrors) {
    this.board = new ArrayList<>();
    this.status = status;
    this.hasErrors = hasErrors;
}

public List<List<Spaces>> getBoard() {
    return board;
}
public void setBoard(List<List<Spaces>> board) {
    this.board = board;
}
public GameStatus getStatus() {
    return status;
}
public void setStatus(GameStatus status) {
    this.status = status;
}
public boolean isHasErrors() {
    return hasErrors;
}
public void setHasErrors(boolean hasErrors) {
    this.hasErrors = hasErrors;
}
}