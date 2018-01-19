package com.ghost.busters.common.enums;

import java.util.HashMap;
import java.util.Map;

import static com.ghost.busters.common.enums.ErrorCodes.OK;
import static com.ghost.busters.common.enums.ErrorCodes.REG_USER_ALREADY_EXISTS;

public class ErrorCodeMap {
    public static Map<ErrorCodes, String> errors = new HashMap<>();
    static {
        errors = new HashMap<>();
        errors.put(REG_USER_ALREADY_EXISTS, "Пользователь с таким именем уже существует");
        errors.put(OK, "");
    }
}
