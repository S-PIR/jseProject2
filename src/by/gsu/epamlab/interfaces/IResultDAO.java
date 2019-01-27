package by.gsu.epamlab.interfaces;

import by.gsu.epamlab.beans.Result;

public interface IResultDAO {
	  Result nextResult(); 
	  boolean hasResult();
	  void closeReader();
}	
