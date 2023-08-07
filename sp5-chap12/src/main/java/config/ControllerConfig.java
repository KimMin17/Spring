package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.RegisterController;
import controller.RestMemberController;
import controller.LoginController;
import controller.LogoutController;
import controller.ChangePwdController;
import controller.MemberListController;
import controller.MemberDetailController;

import spring.MemberRegisterService;
import spring.AuthService;
import spring.ChangePasswordService;
import spring.MemberDao;

import survey.SurveyController;

@Configuration
public class ControllerConfig {

	@Autowired
	private MemberRegisterService memberRegSvc;
	@Autowired
	private AuthService authService;
	@Autowired
	private ChangePasswordService changePasswordService;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberRegisterService memberRegisterService;
	
	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegSvc);
		return controller;
	}
	
	@Bean
	SurveyController surveyController() {
		return new SurveyController();
	}
	
	@Bean
	public LoginController loginController() {
		LoginController controller = new LoginController();
		controller.setAuthService(authService);
		return controller;
	}
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	
	@Bean
	public ChangePwdController changePwdController() {
		ChangePwdController changePwdController = new ChangePwdController();
		changePwdController.setChangePasswordService(changePasswordService);
		return changePwdController;
	}
	
	@Bean
	public MemberListController memberListController() {
		MemberListController memberListController = new MemberListController();
		memberListController.setMemberDao(memberDao);
		return memberListController;
	}
	
	@Bean
	public MemberDetailController memberDetailController() {
		MemberDetailController memberDetailController = new MemberDetailController();
		memberDetailController.setMemberDao(memberDao);
		return memberDetailController;
	}
	
	@Bean
	public RestMemberController restApi() {
		RestMemberController restMemberController = new RestMemberController();
		restMemberController.setMemberDao(memberDao);
		restMemberController.setRegisterService(memberRegisterService);
		return restMemberController;
	}
}
