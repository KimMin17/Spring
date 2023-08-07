package assembler;

import Spring.ChangePasswordService;
import Spring.MemberDao;
import Spring.MemberRegisterService;

public class Assembler {
	
	private MemberDao memberDao;
	private ChangePasswordService pwdSvc;
	private MemberRegisterService regSvc;
	
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}

	public MemberRegisterService getRegSvc() {
		return regSvc;
	}	
}
