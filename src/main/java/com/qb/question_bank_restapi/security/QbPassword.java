package com.qb.question_bank_restapi.security;
import com.qb.question_bank_restapi.model.User;
import java.sql.SQLException;

public abstract class QbPassword {

    abstract void hashPassword();

    public abstract VerificationStatus verifyPassword(User user) throws SQLException;

}
