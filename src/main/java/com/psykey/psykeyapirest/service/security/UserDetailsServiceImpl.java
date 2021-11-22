package com.psykey.psykeyapirest.service.security;

import com.psykey.psykeyapirest.repository.model.access.Access;
import com.psykey.psykeyapirest.service.access.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Objects;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccessService accessService;

    @Autowired
    public UserDetailsServiceImpl(final AccessService accessService) {
        this.accessService = accessService;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Access access = this.accessService.findAccessByUsername(username);
        if (Objects.nonNull(access)) {
            return this.userBuilder(username, access.getPassword());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    private User userBuilder(final String username, final String password) {
        return new User(username,
                password,
                true,
                true,
                true,
                true,
                Collections.emptyList());
    }
}
