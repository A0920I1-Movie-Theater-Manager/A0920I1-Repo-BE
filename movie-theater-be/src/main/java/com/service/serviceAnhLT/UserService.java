package com.service.serviceAnhLT;

import com.dto.dtoAnhLT.LocalUser;
import com.dto.dtoAnhLT.SignUpRequest;
import com.exceptionAnhLT.UserAlreadyExistAuthenticationException;
import com.model.entity.Account;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import java.util.Map;
import java.util.Optional;

/**
 * @author Chinna
 * @since 26/3/18
 */
public interface UserService {

	Account registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException;

	Account findUserByEmail(String email);

	Optional<Account> findUserById(Long id);

	LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
}
