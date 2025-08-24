package service;

import java.util.List;

import Exceptions.PosicaoIndisponivelException;
import Exceptions.TabuleiroVazioException;
import model.Game;
import model.GameStatus;
import model.Spaces;

public class SpacesMannager {
private Game game;
public void initializeGame(){
     game = new Game(GameStatus.NaoIniciado, false);
}
public List<List<Spaces>> verifyGame() {
    if(game.getBoard().isEmpty()){
        throw new IllegalArgumentException("O tabuleiro não pode ser nulo ou vazio.");
    }
    return game.getBoard();
}

private void isGameEmpty() throws TabuleiroVazioException  {
    if (game.getBoard() == null) {
        throw new TabuleiroVazioException("O tabuleiro nao pode ser nulo.");
    }
}

public boolean addNumber(int row, int column, Integer number)throws PosicaoIndisponivelException{
if(game.getBoard().get(row).get(column).isFixed() || game.getBoard().get(row).get(column).getNumber() != null){
    throw new PosicaoIndisponivelException("Posição indisponível para inserção.");
}
game.getBoard().get(row).get(column).setNumber(number);
return true;
}
public boolean removeNumber(int row, int column)throws PosicaoIndisponivelException{
if (game.getBoard().get(row).get(column).isFixed()){
    throw new PosicaoIndisponivelException("Posição fixa, não pode ser removida.");
}
game.getBoard().get(row).get(column).setNumber(null);
return true;
}
public GameStatus gameStatus() throws TabuleiroVazioException{
    isGameEmpty();
    GameStatus status;
    boolean hasEmptyNonFixed = game.getBoard().stream()
        .flatMap(List::stream)
        .anyMatch(s -> s.getNumber() == null && !s.isFixed());
    boolean nonInitialized = game.getBoard().stream()
        .flatMap(List::stream)
        .allMatch(s -> s.getNumber() == null || (!s.isFixed() && s.getNumber() == null));
    if (hasEmptyNonFixed) {
        status = GameStatus.Incompleto;
    }
    
    else if (nonInitialized) {
        status = GameStatus.NaoIniciado;
    }
    else {
        status = GameStatus.Completo;
    }
    game.setStatus(status);
    return status;
}
public boolean containsErrors() throws TabuleiroVazioException{
   isGameEmpty();
    return game.getBoard().stream()
        .flatMap(List::stream)
        .anyMatch(s -> s.getNumber() != null && !s.getNumber().equals(s.getExpectedNumber()) && !s.isFixed());
     
}
public void clearGame() throws TabuleiroVazioException{
    isGameEmpty();
    game.getBoard().stream()
        .flatMap(List::stream)
        .filter(s -> !s.isFixed())
        .forEach(s -> s.setNumber(null));
    game.setStatus(GameStatus.NaoIniciado);
}
public boolean finalizeGame() throws TabuleiroVazioException{
    boolean finalizado = false;
    isGameEmpty();
    if(game.getStatus().equals(GameStatus.Completo)){
       finalizado = true;
    }
    return finalizado;
}
}
