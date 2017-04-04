public class WordReverse implements ICrypto 
{
	private static ICrypto m_instance;
	
	public static ICrypto getInstance()
	{
		if (m_instance == null)
		{
			m_instance = new WordReverse();
		}
		return m_instance;
	}
	
	private WordReverse(){ }

	@Override
	public String encrypt(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decrypt(String message){ return encrypt(message); }
	
	
	
}
