package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Spring.MemberDao;
import Spring.MemberPrinter;

@Configuration
public class AppConf1 {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
}
