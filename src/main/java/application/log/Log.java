package application.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

public class Log {
	Calendar cal = Calendar.getInstance();

	private String logTime() {
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		String time = "[" + hour + ":" + minute + ":" + second + "] ";

		return time;
	}

	private String makeOutputMessage(String className, String methodName, String message) {
		String outputMessage = this.logTime() + "[" + className + "] [" + methodName + "] " + message;
		return outputMessage;

	}

	private String makeFileName() {
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		String fileName = "log/Alchemist_" + year + "_" + month + "_" + date + "_" + hour + ".log";

		return fileName;
	}

	private void printLogStackTrace(Exception e, BufferedWriter writer) throws Exception {
		StackTraceElement[] lists = e.getStackTrace();
		for (StackTraceElement list : lists) {
			writer.newLine();
			writer.append(
					"\tat " + list.getClassName() + "(" + list.getMethodName() + ":" + list.getLineNumber() + ")");
		}
	}

	public void write(String className, String methodName, String message) {
		new Thread(() -> {
			// 메세지 생성

			String outputMessage = makeOutputMessage(className, methodName, message);

			// 파일생성

			String fileName = makeFileName();

			File file = new File("log");
			file.mkdirs();
			BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter(fileName, true));
				writer.append(outputMessage);
				writer.newLine();
				writer.close();
			} catch (Exception e) {
				throw new RuntimeException("file을 생성할수없거나 찾지 못합니다.", e);
			}

		}).start();
	}

	public void write(String className, String methodName, String message, Exception e) {
		new Thread(() -> {
			// 메세지 생성

			String outputMessage = makeOutputMessage(className, methodName, message);

			// 파일생성

			try {
				String fileName = makeFileName();

				File file = new File("log");
				file.mkdirs();
				BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

				writer.append(outputMessage);

				if (e != null) {
					printLogStackTrace(e, writer);
				}
				writer.newLine();
				writer.close();

			} catch (Exception e1) {
				throw new RuntimeException("file을 생성할수없거나 찾지 못합니다.", e1);
			}

		}).start();
		;

	}

}
