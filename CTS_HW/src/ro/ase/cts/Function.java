package ro.ase.cts;

public class Function {

	public static String concatenateStrings(String first,String second) throws EmptyStringsException, SQLCommandException {
		if(first!=null&&second!=null&&!first.isEmpty()&&!second.isEmpty()) {
			if(first.contains("SELECT")||second.contains("SELECT")) {
				throw new SQLCommandException("No SQL Statements allowed,hackerman!");

			}
			
			else
				return first+second;
		}
		
		else {
			throw new EmptyStringsException("Invalid Strings");

		}


	}

}
