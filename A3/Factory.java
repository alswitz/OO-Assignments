public class Factory 
{
	private static Factory m_instance;
	
	public static Factory getInstance()
	{
		if (m_instance == null)
		{
			m_instance = new Factory();
		}
		return m_instance;
	}
	
	private Factory(){ }
	
	public IMessageParser createParser(String text){ return new MessageParser(text); }
}
