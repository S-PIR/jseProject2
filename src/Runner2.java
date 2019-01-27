import static by.gsu.epamlab.constants.Constants.XML_FILE_NAME;

import by.gsu.epamlab.ResultsLoader;
import by.gsu.epamlab.RunnerLogic;
import by.gsu.epamlab.factory.DecimalMarkFactory;
import by.gsu.epamlab.factory.MarkFactory;
import by.gsu.epamlab.impl.ResultImplXml;
import by.gsu.epamlab.interfaces.IResultDAO;

public class Runner2 {

	public static void main(String[] args) {
		IResultDAO reader = new ResultImplXml(XML_FILE_NAME);
		MarkFactory markFactory = new DecimalMarkFactory();
		ResultsLoader.loadResults(reader);
		RunnerLogic.execute(reader, markFactory);
	}

}
