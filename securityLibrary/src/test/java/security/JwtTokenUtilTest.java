package security;

import com.group.an.dataLibrary.models.Role;
import com.group.an.securityLibrary.JwtTokenUtil;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.Key;

import static org.junit.jupiter.api.Assertions.*;

class JwtTokenUtilTest {

    private JwtTokenUtil jwtTokenUtil;
    private Key signingKey;

    @BeforeEach
    void setUp() {
        jwtTokenUtil = new JwtTokenUtil();
        signingKey = Keys.hmacShaKeyFor("s3cUr3K3y_1234567890abcdefghijklmnopqrstuvwxyz".getBytes(StandardCharsets.UTF_8));
    }

    @Test
    void testGenerateToken() {
        String token = jwtTokenUtil.generateToken(1, Role.CUSTOMER);
        assertNotNull(token);
    }

    @Test
    void testGetUserIdFromToken() {
        String token = jwtTokenUtil.generateToken(1, Role.CUSTOMER);
        Integer userId = jwtTokenUtil.getUserIdFromToken(token);
        assertEquals(1, userId);
    }

    @Test
    void testGetRoleFromToken() {
        String token = jwtTokenUtil.generateToken(1, Role.CUSTOMER);
        Role role = jwtTokenUtil.getRoleFromToken(token);
        assertEquals(Role.CUSTOMER, role);
    }



    @Test
    void testValidateToken() {
        String token = jwtTokenUtil.generateToken(1, Role.CUSTOMER);
        assertTrue(jwtTokenUtil.validateToken(token, 1));
    }


}