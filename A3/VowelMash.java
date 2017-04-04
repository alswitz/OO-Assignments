public class VowelMash implements ICrypto 
{
	private static ICrypto m_instance;
	
	public static ICrypto getInstance()
	{
		if (m_instance == null)
		{
			m_instance = new VowelMash();
		}
		return m_instance;
	}
	
	private VowelMash(){ }
	
	@Override 
	public String encrypt(String message)
	{
		StringBuffer returnChar = new StringBuffer();
		IMessageParser parser = Factory.getInstance().createParser(message);
		for(int i = 0; i < parser.getCharCount(); i++)
		{
			if(parser.getChar(i) == 'A')
				returnChar.append('E');
			else if(parser.getChar(i) == 'E')
				returnChar.append('I');
			else if(parser.getChar(i) == 'I')
				returnChar.append('O');
			else if(parser.getChar(i) == 'O')
				returnChar.append('U');
			else if(parser.getChar(i) == 'U')
				returnChar.append('A');
			else
				returnChar.append(parser.getChar(i));
		}
		return returnChar.toString();
	}

	@Override
	public String decrypt(String message){ return encrypt(message); }
	
	public String reverse(String s) 
	{
		StringBuffer returnStr = new StringBuffer();
		for(int c = s.length() - 1; c >= 0; c--)
		{
			returnStr.append(s.charAt(c));
		}
		return returnStr.toString();
	}
}
