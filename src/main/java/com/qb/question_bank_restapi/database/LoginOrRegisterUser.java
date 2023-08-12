package com.qb.question_bank_restapi.database;

import com.qb.question_bank_restapi.model.User;
import com.qb.question_bank_restapi.security.QbPasswordHasher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginOrRegisterUser {

    private final User user;

    public LoginOrRegisterUser(User user) {
        this.user = user;
    }

    public boolean registerUser() {


        // Check if the username already exists
        if (usernameExists(user.getUserName())) {
            return false; // Return false if the username is already taken
        }

        String sql = "INSERT INTO qb_users (user_name, user_password, user_level, date_created) VALUES (?, ?, ?, NOW())";

        Connection connection = null;
        try {
            connection = DatabaseUtil.getConnection();
            connection.setAutoCommit(false); // Start a transaction

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getUserName());
                  // Hash and salt the password before storing it
                String hashedPassword = hashAndSaltPassword(user.getUserPassword());
                preparedStatement.setString(2, hashedPassword);
                preparedStatement.setString(3, user.getUserLevel());
                preparedStatement.executeUpdate();

              }
            connection.commit(); // Commit the transaction
            return  true;
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback the transaction if an error occurs
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace();
                }
            }

            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // Reset auto-commit mode
                    connection.close();
                } catch (SQLException closeException) {
                    closeException.printStackTrace();
                }
            }
        }
    }

    private boolean usernameExists(String username) {
        String sql = "SELECT COUNT(*) FROM qb_users WHERE user_name = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Return true if the username exists
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false; // Return false if an error occurs
    }

    // Implement password hashing and salting here
    private String hashAndSaltPassword(String password) {
        //Using BCrypt to hash the password from the PasswordHashing Class
        // Returns the hashed and salted password
        QbPasswordHasher passwordHashing = new QbPasswordHasher(password);
        password= passwordHashing.getHashedPasswordPass();
        return password;
    }
}
