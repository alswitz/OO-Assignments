public class Builder
{
	private static Builder instance;
	private Builder() {}
	
	public IDecision buildWizard() 
	{
		// Decisions for Snowboarding
		IDecision d1 = new Decision("Do you want to buy a snowboard?");
		IDecision d2 = new Decision("Have you snowboarded before?");
		IDecision d3 = new Decision("Are you an expert?");
		IDecision d4 = new Decision("Do you like to go fast?");
		IDecision s1 = new Decision("Do you want to buy downhill skis?");
		IDecision s2 = new Decision("Have you gone skiing before?");
		IDecision s3 = new Decision("Are you an expert?");
		IDecision s4 = new Decision("Do you like to jump?");
		
		//First set. If they say yes then go to snowboards. Otherwise, off to ski!
		d1.setYes(d2);
		d1.setNo(s1);
		
		//If the answer is Yes, lets do Snowboards first.
		d2.setYes(d3);
		d2.setNoTerminal("Buy the XG100 model.");
		
		d3.setYes(d4);
		d3.setNoTerminal("Buy the XG200 model.");
		
		d4.setYesTerminal("Buy the XG300 model.");
		d4.setNoTerminal("Buy the XG200 model.");
		
		//If the answer is No, lets do Skis instead.
		s1.setYes(s2);
		s1.setNoTerminal("Buy the Z100 model.");
		
		s2.setYes(s3);
		s2.setNoTerminal("Buy the Z200 model.");
		
		s3.setYes(s4);
		s3.setNoTerminal("Buy the Z200 model.");
		
		s4.setYesTerminal("Buy the Z300 model.");
		s4.setNoTerminal("Buy the Z200 model.");
		
		return d1; // Return to our initial starting point.
	}

	public static Builder getInstance() 
	{
		if(instance == null)
			instance = new Builder();
			
		return instance;
	}
}
