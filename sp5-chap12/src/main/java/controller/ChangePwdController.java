package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import spring.*;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {
	
	private ChangePasswordService changePasswordService;

	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}
	
	@GetMapping
	public String form(@ModelAttribute("command") ChangePwdCommand pwdCmd, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		if(authInfo == null) return "redirect:/login";
		return "edit/changePwdForm";
	}
	
	@PostMapping
	public String submit(@ModelAttribute("command") ChangePwdCommand pwdCmd,
			Errors errors, HttpSession session) {
		new ChangePwdValidator().validate(pwdCmd, errors);
		if(errors.hasErrors()) return "edit/changePwdForm";
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		try {
			changePasswordService.changePassword(authInfo.getEmail(), pwdCmd.getCurrentPassword(),
					pwdCmd.getNewPassword());
			return "edit/changedPwd";
		} catch(WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "notMatching");
			return "edit/changePwdForm";
		}
	}
	
}
