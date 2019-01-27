import static by.gsu.epamlab.constants.Constants.INPUT_CSV_3;

import by.gsu.epamlab.ResultsLoader;
import by.gsu.epamlab.RunnerLogic;
import by.gsu.epamlab.factory.HalfMarkFactory;
import by.gsu.epamlab.factory.MarkFactory;
import by.gsu.epamlab.impl.ResultImplCsv;
import by.gsu.epamlab.interfaces.IResultDAO;

public class Runner3 {
	public static void main(String[] args) {
		MarkFactory markFactory = new HalfMarkFactory();
		IResultDAO reader = new ResultImplCsv(INPUT_CSV_3, markFactory);
		ResultsLoader.loadResults(reader);
		RunnerLogic.execute(reader, markFactory);
	}
}
