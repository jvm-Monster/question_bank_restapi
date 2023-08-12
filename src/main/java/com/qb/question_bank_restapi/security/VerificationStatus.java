package com.qb.question_bank_restapi.security;

public enum VerificationStatus {
    USER_FOUND,
    USER_NOT_FOUND,
    PASSWORD_MATCH,
    PASSWORD_MISMATCH,
    DATABASE_ERROR
}
