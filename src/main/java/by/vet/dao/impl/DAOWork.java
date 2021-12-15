package by.vet.dao.impl;

import by.vet.dao.exception.DAOConnectEx;
import by.vet.dao.exception.DAONotAddedUserExeption;
import by.vet.dao.exception.DaoUserExistException;
import by.vet.dto.*;
import by.vet.entity.Role;
import by.vet.entity.Status;
import lombok.Data;

import java.sql.*;

@Data
public class DAOWork {
    private Connection connection;
    private String url;
    private String log;
    private String pass;

    private final String ADD_NEW_USER = "INSERT INTO user (`login_tel`, `mail`) VALUES(?,?)";
    private final String ENTER_USER = "SELECT * FROM user JOIN userinfo ON id=user_id where login_tel=? and pass=?";
    private final String ADD_USER_DETAILS_BY_ID =
            "INSERT INTO userinfo (`user_id`, `name`, `surname`,`pass`,`role`,`status`) VALUES(?,?,?,?,?,?)";
    private final String ADD_NEW_PET ="INSERT INTO pet (`name`, `type`, `sex`) VALUES(?,?,?)";
    private final String ADD_PET_DETAILS_BY_ID = "INSERT INTO pet_history (`pet_idpet`, `idUserDoc`, `idUserCustomer`,`date_inn`," +
            "`conditions`,`status`) VALUES(?,?,?,?,?,?)";


    public DAOWork(String url, String log, String pass) throws SQLException {
        this.url = url;
        this.log = log;
        this.pass = pass;
    }

    public Connection connect() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(url, log, pass);
        } catch (SQLException e) {
            try {
                throw new DAOConnectEx("...not connected...");
            } catch (DAOConnectEx ex) {
                ex.printStackTrace();
            }


        }
        return connect;
    }

    public UserDataDTO addNewUser(RegUserDataDTO user) {

        UserDataDTO userDataDTO=new UserDataDTO();
        try {
            connection = connect();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getLogin_tel());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                userDataDTO.setId(resultSet.getLong(1));
                preparedStatement = connection.prepareStatement(ADD_USER_DETAILS_BY_ID);
                preparedStatement.setLong(1, userDataDTO.getId());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getSurname());
                preparedStatement.setString(4, user.getPass());
                preparedStatement.setString(5, String.valueOf(user.getRole()));
                preparedStatement.setString(6, String.valueOf(Status.ACTIVE));
                preparedStatement.executeUpdate();
            }
            connection.commit();
            // connection.close();
        }             //-

        // ошибка.. пользователь существует
        catch (SQLIntegrityConstraintViolationException exception) {
            try {
                throw new DaoUserExistException(".......user is not exist");       // - нету
            } catch (DaoUserExistException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {

            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            try {
                throw new DAONotAddedUserExeption("User not added");
            } catch (DAONotAddedUserExeption ex) {
                ex.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    try {
                        throw new DAOConnectEx("Somethig wrong");
                    } catch (DAOConnectEx exc) {
                        exc.printStackTrace();
                    }
                }
            }
        }
        return userDataDTO;
    }


    public UserDataDTO enter (EnterDTO user) {
        UserDataDTO userDataDTO=new UserDataDTO();

        System.out.println(user.getLogin() + "   " + user.getPass());

        try {
            connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(ENTER_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPass());
            ResultSet resultSet =preparedStatement.executeQuery();

            if (resultSet.next()) {
                userDataDTO.setId(resultSet.getLong(1));
                userDataDTO.setLogin(resultSet.getString(2));
                userDataDTO.setRole(Role.valueOf(resultSet.getString(8)));
                userDataDTO.setStatus(Status.valueOf(resultSet.getString(9)));
            }

            // connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  userDataDTO;
    }

    public PetDataDTO addNewPet(RegPetDataDTO regpet) {

       PetDataDTO petDataDTO = new PetDataDTO();
        try {
            connection = connect();
            connection.setAutoCommit(false);

            System.out.println(regpet);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_PET, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, regpet.getName());
            preparedStatement.setString(2, regpet.getType());
            preparedStatement.setString(3, regpet.getSex());

            preparedStatement.execute();




            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                petDataDTO.setIdPet(resultSet.getLong(1));
                preparedStatement = connection.prepareStatement(ADD_PET_DETAILS_BY_ID);
                preparedStatement.setLong(1, petDataDTO.getIdPet());
                preparedStatement.setLong(2, 0);
                preparedStatement.setLong(3, regpet.getIdCustomer());
                preparedStatement.setString(4, regpet.getDateInn());
                preparedStatement.setString(5, regpet.getCondition());
                preparedStatement.setString(6, String.valueOf(Status.ACTIVE));
                preparedStatement.executeUpdate();
            }
            connection.commit();
            // connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return petDataDTO;


    }
}