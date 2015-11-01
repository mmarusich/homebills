package com.homebills.web.login;

import com.homebills.entities.types.UserRole;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Maxim Marusich
 */
public class CustomUserDetailsService implements UserDetailsService {

    private static final String USER_FETCHING_SQL = "SELECT * FROM user WHERE username=?";
    private DataSource dataSource;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<CustomUserDetails> users = jdbcTemplate.query(USER_FETCHING_SQL, new UserMapper(), username);
        if(users.isEmpty()){
            throw new UsernameNotFoundException("User not found with username : " + username);
        }
        return users.get(0);
    }

    private Set<GrantedAuthority> getAuthorities(int role) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        UserRole userRole = UserRole.parse(role);
        authorities.add(new SimpleGrantedAuthority(userRole.name()));
        return authorities;
    }

    private class UserMapper implements ParameterizedRowMapper<CustomUserDetails> {

        @Override
        public CustomUserDetails mapRow(ResultSet rs, int arg1) throws SQLException {
            return new CustomUserDetails(rs.getLong("id"), getAuthorities(rs.getInt("role")), rs.getString("username"), rs.getString("password"), true, true, true,
                    rs.getBoolean("enabled"), rs.getString("first_name"), rs.getString("second_name"));
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
