package mum.edu.cs544.advice;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.apache.log4j.Logger;
import java.util.logging.Logger;

import org.springframework.scheduling.annotation.Scheduled;
//import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//import cs544.aspect.AllAdvice;

//import mum.edu.cs544.logging.Logger;

@Aspect
@Component
public class TraceAdvice {

	// final static Logger logger = Logger.getLogger(TraceAdvice.class);
	Logger logger = Logger.getLogger("MyLog");
	private FileHandler fh = null;

	public void messageLogSystem(String msg) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		try {

			// This block configure the logger with handler and formatter
			fh = new FileHandler("F:/MyLogFile//MyLogFile.log");
			logger.addHandler(fh);
			// logger.setLevel(Level.ALL);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			// the following statement is used to log any messages
			logger.info(msg + " at current time :" + dateFormat.format(date));

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After("execution(public * mum.edu.cs544.controller.BrandController.*(..)) ||execution(public * mum.edu.cs544.controller.CategoryController.*(..)) ||execution(public * mum.edu.cs544.controller.ProductController.*(..)) ")
	public void traceAfterMethod(JoinPoint joinpoint) throws IOException {
		String method = joinpoint.getSignature().getName();
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 * Date date = new Date();
		 */
		System.out.println("**************************************");

		messageLogSystem(method + " action has been performed for current store");// +
																					// dateFormat.format(date));
		/*
		 * try {
		 * 
		 * // This block configure the logger with handler and formatter fh =
		 * new FileHandler("F:/MyLogFile//MyLogFile.log");
		 * logger.addHandler(fh); // logger.setLevel(Level.ALL); SimpleFormatter
		 * formatter = new SimpleFormatter(); fh.setFormatter(formatter);
		 */
		// the following statement is used to log any messages

		// logger.info(method + " action has been performed for current store at
		// :" + dateFormat.format(date));

		/*
		 * } catch (SecurityException e) { e.printStackTrace(); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */

	}

	@Around("execution(public * mum.edu.cs544.controller.BrandController.*(..)) ||execution(public * mum.edu.cs544.controller.CategoryController.*(..)) ||execution(public * mum.edu.cs544.controller.ProductController.*(..)) ")
	public Object invoke(ProceedingJoinPoint call) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		// String method = joinpoint.getSignature().getName();

		/*
		 * try {
		 * 
		 * // This block configure the logger with handler and formatter fh =
		 * new FileHandler("F:/MyLogFile//MyLogFile.log");
		 * logger.addHandler(fh); // logger.setLevel(Level.ALL); SimpleFormatter
		 * formatter = new SimpleFormatter(); fh.setFormatter(formatter);
		 * 
		 * // the following statement is used to log any messages
		 */
		messageLogSystem("Time to execute (in Mili second) " + "is :" + totaltime);
		// logger.info("Time to execute (in Mili second) " + "is :" +
		// totaltime);

		/*
		 * } catch (SecurityException e) { e.printStackTrace(); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */
		// System.out.println("Time to execute save = " + totaltime);
		return retVal;
	}

	// The method will run on every hour.

	// @Scheduled(cron = "0/1 * * * * *")
	// @Scheduled(cron = "*/1 * * * * *")

	@Scheduled(cron = "0 0 */1 * * *")
	public void sendMailEveryHour() {

		try {

			messageLogSystem("Sending mail of product report to manager in very hour :");

		} catch (SecurityException e) {
			e.printStackTrace();
		}

	}
}
