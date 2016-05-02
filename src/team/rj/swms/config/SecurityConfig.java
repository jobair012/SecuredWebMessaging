package team.rj.swms.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enabled from user where username=?")
				.authoritiesByUsernameQuery("select username, role from user where username=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/home/**").access("hasRole('ROLE_USER')")
			.and()
				.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/home/inbox")
					.failureUrl("/login?error")
					
					.usernameParameter("username")
					.passwordParameter("password")
			.and()
				.logout()
					.logoutSuccessUrl("/")
					
			.and()
				.csrf();
		
//			.and()
//				.rememberMe().tokenRepository(persistentTokenRepository())
//				.tokenValiditySeconds(60);					
	}
	
	// @Bean
	// public PersistentTokenRepository persistentTokenRepository(){
	//
	// JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
	// db.setDataSource(dataSource);
	// return db;
	// }
}
