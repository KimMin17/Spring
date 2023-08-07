package Spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberListPrinter {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberSummaryPrinter printer;
	
	public MemberListPrinter() {
	}
	
	public MemberListPrinter(MemberDao memberDao, MemberSummaryPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll() {
		Collection<Spring.Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}
}