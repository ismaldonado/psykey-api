package com.psykey.psykeyapirest.service.user;

import com.psykey.psykeyapirest.model.user.SearchRequest;
import com.psykey.psykeyapirest.repository.UserRepository;
import com.psykey.psykeyapirest.repository.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPersistenceService {

    private final UserRepository userRepository;

    @Autowired
    UserPersistenceService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(final User user) {
        return this.userRepository.save(user);
    }

    public List<User> findAllByFilter(final SearchRequest searchRequest, final String userLogged) {
        return this.userRepository.findUserByFilter(searchRequest, userLogged);
    }

    public Optional<User> findUserById(final Long id) {
        return this.userRepository.findById(id);
    }

	public List<User> findUserByUserTypeAndTherapyType(final String therapyType) {
		return this.userRepository.findUserByUserTypeAndTherapyType("employee", therapyType);
	}
}
