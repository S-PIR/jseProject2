
import by.gsu.epamlab.ResultsLoader;
import by.gsu.epamlab.RunnerLogic;
import by.gsu.epamlab.factory.MarkFactory;
import by.gsu.epamlab.impl.ResultImplCsv;
import by.gsu.epamlab.interfaces.IResultDAO;

import static by.gsu.epamlab.constants.Constants.INPUT_CSV;

public class Runner1 {
	public static void main(String[] args) {
		MarkFactory markFactory = new MarkFactory();
		IResultDAO reader = new ResultImplCsv(INPUT_CSV, markFactory);
		ResultsLoader.loadResults(reader);
		RunnerLogic.execute(reader, markFactory);
		
		

	}
}
