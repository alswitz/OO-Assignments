import java.util.ArrayList;
import java.util.List;

public class MessageParser implements IMessageParser 
{
	private List<String> m_words;
	private String m_text;
	
	public MessageParser(String text)
	{
		m_text = text.trim();
		text = text.trim() + ' ';
		
		m_words = new ArrayList<String>();
		
		int index = 0;
		for (int i = 0; i < text.length(); i++)
		{
			if (text.charAt(i) == ' ')
			{
				String word = text.substring(index, i);
				m_words.add(word);
				index = i + 1;
			}
		}
	}
	
	@Override
	public int getCharCount(){ return m_text.length(); }
	@Override
	public int getWordCount(){ return m_words.size(); }
	@Override
	public char getChar(int i){ return m_text.charAt(i); }
	@Override
	public String getWord(int i){ return m_words.get(i); }
}
