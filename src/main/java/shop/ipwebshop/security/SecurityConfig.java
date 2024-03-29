package shop.ipwebshop.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import shop.ipwebshop.constants.SecurityConsts;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthEntryPoint authEntryPoint;

    @Autowired
    public SecurityConfig(JwtAuthEntryPoint authEntryPoint) {
        this.authEntryPoint = authEntryPoint;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/users/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/comments/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/photos/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/products/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/product-attribute/**").permitAll()
                .requestMatchers("/users/**").hasAnyAuthority(SecurityConsts.USER, SecurityConsts.ADMIN)
                .requestMatchers("/comments/**").hasAnyAuthority(SecurityConsts.USER, SecurityConsts.ADMIN)
                .requestMatchers(HttpMethod.POST,"/photos/**").hasAnyAuthority(SecurityConsts.USER, SecurityConsts.ADMIN)
                .requestMatchers("/products/**").hasAnyAuthority(SecurityConsts.USER, SecurityConsts.ADMIN)
                .requestMatchers("/categories/**").permitAll()
                .and()
                .httpBasic();
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public  JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
}
