package com.psykey.psykeyapirest.repository;

import com.psykey.psykeyapirest.model.user.SearchRequest;
import com.psykey.psykeyapirest.repository.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUserByUserTypeAndTherapyType(final String userType, final String therapyType);

    @Query(value = "SELECT * FROM user user"
            + " LEFT JOIN user Employee ON user.employee = Employee.id "
            + " WHERE (:#{#searchRequest.dni} IS NULL OR user.dni = :#{#searchRequest.dni})"
            + " AND (:#{#searchRequest.name} IS NULL OR user.name LIKE CONCAT('%', :#{#searchRequest.name}, '%')) "
            + " AND (:#{#searchRequest.surname} IS NULL OR user.surname LIKE CONCAT('%', :#{#searchRequest.surname}, '%')) "
            + " AND (:#{#searchRequest.therapyType} IS NULL OR user.therapy_type = :#{#searchRequest.therapyType}) "
            + " AND (:#{#searchRequest.userType} IS NULL OR user.user_type = :#{#searchRequest.userType}) "
            + " AND (:#{#userLogged} IS NULL OR Employee.username = :#{#userLogged}) "
            + " AND user.user_type != 'client' "
            + " AND user.active = true ", nativeQuery = true)
    List<User> findUserByFilter(@Param("searchRequest") final SearchRequest searchRequest, final String userLogged);
}
