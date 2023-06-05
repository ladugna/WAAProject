package miu.edu.cs.cs545.Lab1.logging;

import org.springframework.stereotype.Service;

@Service
public class Logger implements ILogger{

	public void log(String logstring) {
		java.util.logging.Logger.getLogger("MyLogging").info(logstring);
	}

}
