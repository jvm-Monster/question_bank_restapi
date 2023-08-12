package com.qb.question_bank_restapi.security;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.qb.question_bank_restapi.database.DatabaseUtil;
import com.qb.question_bank_restapi.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QbPasswordVerifier extends QbPassword{
    private static final Logger logger = LogManager.getLogger(QbPassword.class);

    public QbPasswordVerifier(){

    }
    @Override
    void hashPassword() {
        //the hashing is not done here as this class is only used for verifying the password
    }

    @Override
    public VerificationStatus verifyPassword(User user) throws SQLException {
        String sql = "SELECT * FROM qb_users WHERE user_name=?"; // sql statement to get the data of the user

        Connection connection = DatabaseUtil.getConnection();//Getting a database connection from the Connection Pool;

        //It is better to use a try resource and catch, to automatically close every connection, though I implemented the final block.
        try(PreparedStatement preparedStatement= connection.prepareStatement(sql)){
            preparedStatement.setString(1,user.getUserName());//gets the user data based on the user unique name in the database.
            ResultSet resultSet = preparedStatement.executeQuery();//Executes the sql statement and stores the data in the result-set object,
            // though it stores a preparedStatement object with a result, this is because the ResultSet is an interface and I think the PreparedStatement implements it
            //using an if-block-statement, if there are still more data in the result set by using the .next() method from the ResultSet interface which returns a boolean
            if(resultSet.next()){
                String hashedPasswordFromDB = resultSet.getString("user_password");//gets the value of the user_password column in the database.

                //Verify the hash with the text which then return a boolean value, using BCrypt
                if(BCrypt.verifyer().verify(user.getUserPassword().toCharArray(),hashedPasswordFromDB).verified){
                    return VerificationStatus.PASSWORD_MATCH;// If the password matches it returns this.
                }else{
                    return VerificationStatus.PASSWORD_MISMATCH;//Not match it returns this.
                }
            }else {
                return VerificationStatus.USER_NOT_FOUND;//If a user isn't found at all, returns this.
            }

        }catch (SQLException sqlException){

            logger.error("Error while verifying password for user: "+ user.getUserName(),sqlException);//logs the exception and the username the exception occurred on.
            return VerificationStatus.DATABASE_ERROR;//Returns this, meaning there is a database error.
        }finally {
            DatabaseUtil.close(connection);//finally at the end weather all went smoothly or not it will definitely close the connection
        }

    }
}
