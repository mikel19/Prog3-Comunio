package ud.prog3.Comunio;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;



public class AppendableOutputStream extends ObjectOutputStream
{

	public AppendableOutputStream (OutputStream out) throws IOException
	{
		super(out);
	}

	@Override
	protected void writeStreamHeader() throws IOException {
		// TODO Auto-generated method stub
		reset();
	}
	
	


}
