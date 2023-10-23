package es.hexagonalTest.prueba.infraestructure.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
	/*
	@Value("${prueba.tecnica.usuario}")
	private String user;
	
	@Value("${prueba.tecnica.password}")
	private String pass;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector)
			throws Exception {
		MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
		http.authorizeHttpRequests((authorize) -> {
			authorize.requestMatchers(mvcMatcherBuilder.pattern("/swagger-ui/**")).anonymous()
					.requestMatchers(mvcMatcherBuilder.pattern("/v3/**")).anonymous()
					.requestMatchers(mvcMatcherBuilder.pattern("/h2-console/**")).anonymous()
					.anyRequest().authenticated();
		}).httpBasic(Customizer.withDefaults());
		return http.build();
	}

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails admin = User.builder().username(user).password(passwordEncoder().encode(pass)).roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }*/
}