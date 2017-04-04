public class WordReverse implements ICrypto 
{
	private static ICrypto m_instance;
	
	public static ICrypto getInstance()
	{
		if (m_instance == null)
			m_instance = new WordReverse();
		return m_instance;
	}
	
	private WordReverse(){ }

	@Override
	public String encrypt(String message) 
	{
		IMessageParser msgIn = Factory.getInstance().createParser(message);
		StringBuffer returnStr = new StringBuffer();
		
		for (int i = 0; i < msgIn.getWordCount(); i++)
		{
			String word = msgIn.getWord(i);
			word = reverse(word);
			returnStr.append(word + ' ');
		}
		return returnStr.toString().trim();
	}
	
	private String reverse(String s)
	{
		StringBuffer returnStr = new StringBuffer();
		for(int c = s.length() - 1; c >= 0; c--)
			returnStr.append(s.charAt(c));
		return returnStr.toString();
	}

	@Override
	public String decrypt(String message){ return encrypt(message); }
}
