package by.vet.dao.impl;
import by.vet.entity.Pet;
import by.vet.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
@Data
@AllArgsConstructor
public class DAOWork {
    private Connection connection;
    private String url;
    private String login;
    private String password;

    private final String ADD_NEW_USER =
            "INSERT INTO user (`login_tel`, `mail`) VALUES(?,?)";
    private final String GEI_USER_BY_ID =
            "SELECT * FROM user WHERE id=";
    private final String GEI_PET_BY_ID =
            "SELECT * FROM pet WHERE id=";

    private final String ENTER_USER =
            "SELECT * FROM user JOIN userinfo ON id=user_id where login_tel=? and pass=?";
    private final String ADD_USER_DETAILS_BY_ID =
            "INSERT INTO userinfo (`user_id`, `name`, `surname`,`pass`,`role`,`status`) VALUES(?,?,?,?,?,?)";
    private final String ADD_PET
            ="INSERT INTO pet (`name`, `type`, `sex`) VALUES(?,?,?)";
    private final String ADD_PET_DETAILS_BY_ID
            = "INSERT INTO pet_history (`pet_idpet`, `idUserDoc`, `idUserCustomer`,`date_inn`," +
            "`conditions`,`status`) VALUES(?,?,?,?,?,?)";
    private final String GET_PETS_ZERO
            = "SELECT * FROM pet_history join pet on pet_idpet=idpet where idUserDoc=0 and status=ACTIVE"; // чекнуть
    private final String SET_DOC_TO_PET
            = "UPDATE pet_history Set idUserDoc=? WHERE pet_idpet=? AND idUserDoc=0 AND status=ACTIVE"; //чекнуть - добавить id хистори

    private final String GET_USERS_QUERY =
            "SELECT * FROM user";
    private final String GET_PETS_QUERY =
            "SELECT * FROM pet";



    private  JdbcTemplate jdbcTemplate;
    public DAOWork() {}

    @Autowired
    public DAOWork(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAllUsers(){
        return jdbcTemplate.query(GET_USERS_QUERY,new BeanPropertyRowMapper<>(User.class));
 }
 public List<Pet> getAllPets(){
     return jdbcTemplate.query(GET_PETS_QUERY,new BeanPropertyRowMapper<>(Pet.class));
 }

 public User getUserById(long id){
        String sql=GEI_USER_BY_ID+id;
     return (User) jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
 }

   public User addUser(User userRegData) throws SQLException {
       System.out.println(" reg  " + userRegData);
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection->
        {
            PreparedStatement ps=connection.prepareStatement(ADD_NEW_USER,new String[]{"ID"});
            ps.setString(1, userRegData.getTel());
            ps.setString(2, userRegData.getMail());
            return ps;}, keyHolder);
        Number key=keyHolder.getKey();
       if (key == null) throw new AssertionError();
       return getUserById(key.longValue());
   }
    public Pet addPet(Pet petRegData) throws SQLException {
        System.out.println(" reg  " + petRegData);
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection->
        {
            PreparedStatement ps=connection.prepareStatement(ADD_PET,new String[]{"IDPET"});
            ps.setString(1, petRegData.getName());
            ps.setString(2, petRegData.getType());
            ps.setString(3, petRegData.getSex());
            return ps;}, keyHolder);
        Number key=keyHolder.getKey();
        if (key == null) throw new AssertionError();
        return getPetById(key.longValue());
    }

    public Pet getPetById(long id){
        String sql=GEI_PET_BY_ID+id;
        return (Pet) jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Pet.class));
    }



/* public Connection connect() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            try {
                throw new DAOConnectEx("...not connected...");
            } catch (DAOConnectEx ex) {
                ex.printStackTrace();
            }
        }
        return connect;
    }*/


/*
    public UserDataDTO addNewUser(RegUserDataDTO user) throws DaoUserExistException, DAOConnectEx {

        UserDataDTO userDataDTO=new UserDataDTO();
        try {

           // connection.setAutoCommit(false);

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


          //  connection.commit();
            // connection.close();
        }

        // ошибка.. пользователь существует
        catch (SQLIntegrityConstraintViolationException exception) {
        throw new DaoUserExistException(".......user is  exist");       // - нету

        }
        catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new DAOConnectEx("...rollback false");
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

*/






   /*




    public UserDataDTO enter (EnterDTO user) {
        UserDataDTO userDataDTO=new UserDataDTO();

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

           // System.out.println(regpet);
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
        }
*/
     /*   catch (SQLIntegrityConstraintViolationException exception) {
            try {
                throw new DaoUserExistException(".......pet is  exist");       // - нету
            } catch (DaoUserExistException e) {
                e.printStackTrace();
            }
        }*/



    /*
        catch (SQLException e) {

            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            try {
                throw new DAONotAddedUserExeption("Pet not added");
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
        return petDataDTO;
    }








    public ArrayList<Pet> getPets(UserDataDTO userDataDTO){
        ArrayList<Pet> ar= new ArrayList<>();
        Pet pet=new Pet();


        try {
            connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PETS_ZERO);
           // preparedStatement.setLong(1, userDataDTO.getId());
            ResultSet resultSet =preparedStatement.executeQuery();


            if (resultSet.next()) {
                pet.setIdpet(resultSet.getLong(1));
                pet.setName(resultSet.getString(1));
                pet.setType(resultSet.getString(1));
                pet.setSex(resultSet.getString(1));
                ar.add(pet);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ar;
    }


    public ArrayList<Pet> getZPets(){
        ArrayList<Pet> ar= new ArrayList<>();
        Pet pet=new Pet();


        try {
            connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PETS_ZERO);
            ResultSet resultSet =preparedStatement.executeQuery();


            while (resultSet.next()) {
                pet.setIdpet(resultSet.getLong(1));
                pet.setName(resultSet.getString(8));
                pet.setType(resultSet.getString(9));
                pet.setSex(resultSet.getString(10));
                ar.add(pet);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ar;

    }



    public PetDataDTO getDocToPet (long iddoc, long idpet){
        PetDataDTO pet = new PetDataDTO();
        pet=null;


        try {
            connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(SET_DOC_TO_PET);
            preparedStatement.setLong(1, iddoc);
            preparedStatement.setLong(2, idpet);

            ResultSet resultSet =preparedStatement.executeQuery();


            while (resultSet.next()) {
                pet.setIdPet(resultSet.getLong(1));
                pet.setName(resultSet.getString(8));
                pet.setType(resultSet.getString(9));
                pet.setSex(resultSet.getString(10));

            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pet;

    }

*/


}




