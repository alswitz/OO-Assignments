import java.util.*;
public class Decision implements IDecision
{
	//Initializing our instance values to be set.
	public String m_question;
	private IDecision m_yes;
	private IDecision m_no;
	private String m_yesTerminal;
	private String m_noTerminal;
	private static Scanner input = new Scanner(System.in);
	
	//Setting values based on their states using the interface.
	public Decision(String question) { m_question = question; }
	public void setYes(IDecision yes) { m_yes = yes; }
	public void setNo(IDecision no) { m_no = no; }
	public void setYesTerminal(String terminal){ m_yesTerminal = terminal; }
	public void setNoTerminal(String terminal) {  m_noTerminal = terminal; }
	public IDecision ask() // Ask our question.
	{
		System.out.println(m_question);
		String userInput = input.nextLine().toLowerCase();
		
		if (userInput.equals("yes"))
		{
			if (m_yes == null)
				System.out.println(m_yesTerminal);
			
			return m_yes;
		}

		else if (userInput.equals("no"))
		{
			if (m_no == null)
				System.out.println(m_noTerminal);
			
			return m_no;
		}
		return null;
	}
}
