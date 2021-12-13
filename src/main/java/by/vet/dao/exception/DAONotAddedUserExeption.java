package by.vet.dao.exception;

public class DAONotAddedUserExeption extends Exception{
    public DAONotAddedUserExeption(String message, DAOConnectEx e) {
        super(message);
    }
}
