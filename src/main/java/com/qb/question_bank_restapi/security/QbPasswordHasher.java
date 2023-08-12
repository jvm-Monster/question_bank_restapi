package com.qb.question_bank_restapi.security;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.qb.question_bank_restapi.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class QbPasswordHasher extends QbPassword {
    //instance class level variable to store the hashed password
    private String hashedPassword;
    private final String password;

    private final int workFactorOrCost;

    //Creating a logger that logs every error from this class
    private static final Logger logger = LogManager.getLogger(QbPassword.class);





    //This constructor is basically used to retrieve the password and workFactorOrCost, but the workFactorOrCost must be provided, not tightly coupled though.
    public QbPasswordHasher(String password, int workFactorOrCost) {
        this.password=password;
        this.workFactorOrCost=workFactorOrCost;
    }

    //This constructor is basically used to hash the password, while defining the cost or workFactorOrCost in a tightly coupled way
    public QbPasswordHasher(String password){
        this.password=password;
        this.workFactorOrCost=12;
    }
    @Override
    void hashPassword() {
        try {
            BCrypt.Hasher hasher = BCrypt.withDefaults();
            this.hashedPassword = hasher.hashToString(workFactorOrCost, password.toCharArray());
        } catch (Exception e) {
            // Handle exceptions gracefully
            logger.error("Error hashing the password ", e);
            throw new RuntimeException("Error hashing the password: " + e.getMessage(), e);
        }
    }

    @Override
    public VerificationStatus verifyPassword(User user) throws SQLException {
        // this method does not implement the verification check out the QbPasswordVerifier.
        return null;
    }

    //Used to get the hashed password when ready to be stored in the database
    public String getHashedPasswordPass() {
        return hashedPassword;
    }

    //Method to verify the user password from the database


}
