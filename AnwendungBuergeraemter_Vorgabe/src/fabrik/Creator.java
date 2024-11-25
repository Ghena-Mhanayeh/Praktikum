package fabrik;

import java.io.IOException;

public abstract class Creator {
	
	public abstract Product fabricMethod(String type ) throws IOException;

}
