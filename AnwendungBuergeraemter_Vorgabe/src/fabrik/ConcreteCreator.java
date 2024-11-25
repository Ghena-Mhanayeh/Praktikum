package fabrik;

public class ConcreteCreator extends Creator {

	@Override
	public Product fabricMethod(String type) {
		// TODO Auto-generated method stub
		
		if (type == "csv") {
			
			return new ConcreteProduct();
		}
		
		else return new ConcreteProductB();
	}

}
