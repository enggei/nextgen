package xledger;

import com.generator.util.FileUtil;
import com.generator.util.StringUtil;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

import static com.generator.util.FileUtil.*;

/**
 * goe on 6/20/16.
 */
public class CSVFixer {

	private String account = null;

	public CSVFixer(String arg) throws IOException {
		System.out.println("Processing " + arg);

		final File src = new File(arg);

		// check if bank or master-card csv file:
		final BufferedReader tmpReader = new BufferedReader(new FileReader(src));
		String line;
		while ((line = tmpReader.readLine()) != null) {
			if (line.contains("Account Statement")) {
				tmpReader.close();
				parseMasterCardFile(src);
				return;
			}
		}

		tmpReader.close();
		parseAccountFile(src);
	}

	private void parseMasterCardFile(File src) throws IOException {

		final BufferedWriter directWriter = createOutputWriter(src);

		final String masterCardAccount = "5563620000236219";

		final AtomicInteger lineCount = new AtomicInteger(-1);
		readString(src, line -> {

			lineCount.incrementAndGet();

			// assuming this line-format:
			// 05/05/2016,06/05/2016,05206656127033450243455,HOTELS COM129467503230,UK HOTELS COM UNK FRA,118.27
			if (line.length() <= 10) {
				System.out.println("\tignoring '" + line + "'");
				return false;
			}

			if (line.contains("\"")) {
				// clean these 2 patterns which may occur: (both escapes ',' by enclosing ''
				// thousand-delimiter is a ','
				// 27/05/2016,27/05/2016,,FASTER PAYMENT RECEIVED- THANK YOU,,"(1,500.00)"
				// text may contain ','
				// 23/05/2016,24/05/2016,05230656145300075421602,CROWN RIVERS,"Hounslow, HeE UNK GBR",27.90
				String tmp = line;
				final String[] match = StringUtil.match("\"(.*)\"", line, 0);
				for (String m : match)
					tmp = tmp.replace(m, m.replaceAll("\"", "").replaceAll(",", " "));   // remove " and replace , with [space]
				line = tmp;
			}

			final String[] t = line.split(",");

			try {

				final String tryToGetDate = transformMasterCardDate(t[1]);

				// A account
				directWriter.write(masterCardAccount);
				directWriter.write(";");

				// t[1] = Posting date (used in both columns, as instructed by xLedger)
				// t[2] = Interest date
				// B  PostedBank (date)

				directWriter.write(tryToGetDate);
				directWriter.write(";");

				// C  InterestDate (date)
				directWriter.write(tryToGetDate);
				directWriter.write(";");

				// D  Text
				directWriter.write(getText(t[4] + " " + t[3]));
				directWriter.write(";");

				// E  PayRef
				directWriter.write("");
				directWriter.write(";");

				// F  Reference
				directWriter.write("");
				directWriter.write(";");

				// G Amount
				final String amount = (t[5].contains("(")) ? (t[5].replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", "")) : ("-" + t[5].replaceAll(" ", ""));
				directWriter.write(amount);
				directWriter.newLine();

			} catch (Throwable e) {
				System.out.println("\tignoring '" + line + "'");
			}

			return false;
		});

		directWriter.close();
	}

	private static String getText(String text) {
		return text.substring(0, Math.min(45, text.length()));
	}

	private void parseAccountFile(File src) throws IOException {

		final BufferedWriter directWriter = createOutputWriter(src);

		final AtomicInteger lineCount = new AtomicInteger(-1);
		readString(src, line -> {

			lineCount.incrementAndGet();

			final String[] t = line.split(",");
			if (lineCount.get() == 0) {
				account = t[3];   // get account from first line

			} else {

				if (t[0].contains("99") || line.contains("End of File")) {
					return true;
				}

				if (t[5].length() == 0 && t[6].length() == 0) {
					// ignoring line
					System.out.println("\tignoring '" + line + "'");
					return false;
				}

				try {

					// A account
					directWriter.write(account);
					directWriter.write(";");

					// B  PostedBank (date)
					directWriter.write(transformDate(t[1]));
					directWriter.write(";");

					// C  InterestDate (date)
					if (t[2].length() == 10)
						directWriter.write(transformDate(t[2]));
					else
						directWriter.write(transformDate(t[1]));
					directWriter.write(";");

					// D  Text
					directWriter.write(getText(t[3]));
					directWriter.write(";");

					// E  PayRef
					directWriter.write("");
					directWriter.write(";");

					// F  Reference
					directWriter.write("");
					directWriter.write(";");

					// G Amount
					if (t[5].length() > 2)
						directWriter.write("-" + t[5]);
					else
						directWriter.write(t[6]);
					directWriter.newLine();

				} catch (Throwable e) {
					System.out.println("\tignoring '" + line + "'");
				}
			}

			return false;
		});

		directWriter.close();
	}

	private static BufferedWriter createOutputWriter(File src) throws IOException {
		final File direct = new File(src.getParent(), removePostfix(src) + ".direct.csv");

		final BufferedWriter directWriter = new BufferedWriter(new FileWriter(tryToCreateFileIfNotExists(direct)));
		directWriter.write("BankAccount;PostedBank;InterestDate;Text;PayRef;Reference;Amount");
		directWriter.newLine();
		return directWriter;
	}

	private static String transformDate(String s) throws Throwable {
		return s.substring(6, 10) + s.substring(3, 5) + s.substring(0, 2);
	}

	private static String transformMasterCardDate(String s) throws Throwable {
		// 4/5/2016
		final String[] t = s.split("/");
		return t[2] + (t[1].length() == 1 ? ("0" + t[1]) : t[1]) + (t[0].length() == 1 ? ("0" + t[0]) : t[0]);
	}

	public static void main(String[] args) throws IOException {

		final File currentDir = new File(args.length == 0 ? "." : args[0]);
		final File[] list = FileUtil.list(currentDir.getAbsolutePath(), ".out.txt");
		if (list == null || list.length == 0) {
			System.out.println("Could not find any '.out.txt' files in '" + currentDir.getAbsolutePath() + "'");
			return;
		}

		for (File file : list) {
			if (file.getName().contains(".direct.")) continue;   // ignore existing files
			new CSVFixer(file.getAbsolutePath());
		}
	}
}