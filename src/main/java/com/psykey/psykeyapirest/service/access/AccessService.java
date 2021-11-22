package com.psykey.psykeyapirest.service.access;

import com.psykey.psykeyapirest.model.converter.access.AccessToAccessResponseConverter;
import com.psykey.psykeyapirest.model.security.AccessRequest;
import com.psykey.psykeyapirest.model.security.AccessResponse;
import com.psykey.psykeyapirest.repository.AccessRepository;
import com.psykey.psykeyapirest.repository.model.access.Access;
import com.psykey.psykeyapirest.repository.model.security.Rol;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class AccessService {

    private final AccessRepository accessRepository;
    private final AccessToAccessResponseConverter accessToAccessResponseConverter;

    @Autowired
    public AccessService(final AccessRepository accessRepository,
                         final AccessToAccessResponseConverter accessToAccessResponseConverter) {
        this.accessRepository = accessRepository;
        this.accessToAccessResponseConverter = accessToAccessResponseConverter;
    }

    public AccessResponse saveUser(final AccessRequest accessRequest, final String username, final String fullName, final String userType) {
        final Access access = new Access();
        final Rol rol = new Rol();
        if (Objects.nonNull(accessRequest)) {
            access.setUsername(accessRequest.getUsername());
            access.setPassword(this.encryptPassword(accessRequest.getPassword()));
            access.setFulName(accessRequest.getUserFullName());
            rol.setId(accessRequest.getRolId());
        } else {
            access.setUsername(username);
            access.setPassword(this.generateEncryptedPassword(username));
            access.setFulName(fullName);
            rol.setId(userType.equals("employee") ? 3L : 4L);
        }
        access.setRol(rol);
        return this.accessToAccessResponseConverter.convert(this.accessRepository.save(access));
    }

    public AccessResponse getAccessResponseByUsername(final String username) {
        return this.accessToAccessResponseConverter.convert(this.findAccessByUsername(username));
    }

    public Access findAccessByUsername(final String username) {
        return this.accessRepository.findAccessByUsername(username);
    }

    private String generateEncryptedPassword(final String username) {
        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(StringUtils.join("u", username));
    }

    private String encryptPassword(final String password) {
        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
