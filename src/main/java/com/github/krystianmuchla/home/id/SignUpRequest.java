package com.github.krystianmuchla.home.id;

import com.github.krystianmuchla.home.api.RequestBody;
import com.github.krystianmuchla.home.error.exception.validation.ValidationError;
import com.github.krystianmuchla.home.error.exception.validation.ValidationException;
import com.github.krystianmuchla.home.id.accessdata.Login;
import com.github.krystianmuchla.home.id.accessdata.Password;
import com.github.krystianmuchla.home.util.MultiValueHashMap;

public record SignUpRequest(String login, String password, String token) implements RequestBody {
    @Override
    public void validate() {
        final var errors = new MultiValueHashMap<String, ValidationError>();
        final var loginError = Login.Validator.validate(login);
        if (loginError != null) {
            errors.add("login", loginError);
        }
        final var passwordErrors = Password.Validator.validate(password);
        if (!Password.Validator.validate(password).isEmpty()) {
            errors.addAll("password", passwordErrors);
        }
        if (token == null) {
            errors.add("token", ValidationError.nullValue());
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}