package cl.grupopi.ecommerce.security.filter;
import cl.grupopi.ecommerce.entities.dto.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static cl.grupopi.ecommerce.security.TokenJwtSecurityConfig.*;
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String username = null;
        String password = null;

        try {
            cl.grupopi.ecommerce.entities.User user = new ObjectMapper().readValue(request.getInputStream(), cl.grupopi.ecommerce.entities.User.class);
            username = user.getUsername();
            password = user.getPassword();
        } catch (IOException e) {
            e.printStackTrace();
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User userAuthenticated = (User) authResult.getPrincipal();
        Collection<? extends GrantedAuthority> roles = authResult.getAuthorities();

        Claims claims = Jwts.claims().add("authorities", new ObjectMapper().writeValueAsString(roles)).build();

        String token = Jwts.builder()
                .subject(userAuthenticated.getUsername())
                .claims(claims)
                .expiration(new Date(System.currentTimeMillis() + 3600000))
                .issuedAt(new Date())
                .signWith(SECRET_KEY)
                .compact();

        response.addHeader(HEADER_AUTHORIZATION,PREFIX_TOKEN + token);

        Map<String, String> body = new HashMap<>();
        body.put("token",token);
        body.put("username", String.valueOf(userAuthenticated.getUsername()));
        ResponseDTO<Map<String, String>> responseDTO = new ResponseDTO();
        responseDTO.setStatus(200);
        responseDTO.setMessage(String.format("Se ha iniciado sesión con el usuario %s", userAuthenticated.getUsername()));
        responseDTO.setData(body);
        response.getWriter().write(new ObjectMapper().writeValueAsString(responseDTO));
        response.setContentType(CONTENT_TYPE);
        response.setStatus(200);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        Map<String, String> body = new HashMap<>();
        body.put("message","Error al autenticarse, usuario o contraseña incorrecta");
        body.put("error", failed.getMessage());

        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(401);
        response.setContentType(CONTENT_TYPE);
    }
}
