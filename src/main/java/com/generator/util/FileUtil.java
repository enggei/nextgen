package com.generator.util;

import org.w3c.dom.Document;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.*;
import java.util.List;
import java.util.zip.*;

/**
 * Date: 23.aug.2007
 * Time: 13:52:28
 */
public final class FileUtil {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private static final boolean isWindows;

	public interface ExecutionHandler {

		void handle(String line);
	}

	public static void unzip(File zipFile, File root) throws IOException {

		ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
		ZipEntry ze = zis.getNextEntry();

		root = tryToCreateDirIfNotExists(new File(root, zipFile.getName().substring(0, zipFile.getName().indexOf("."))));

		byte[] buffer = new byte[1024];
		while (ze != null) {
			String fileName = ze.getName();
			File newFile = new File(root, fileName);
			System.out.println("file unzip : " + newFile.getAbsoluteFile());
			if (newFile.isDirectory())
				tryToCreateDirIfNotExists(newFile);
			else {
				tryToCreateFileIfNotExists(newFile);

				try {
					FileOutputStream fos = new FileOutputStream(newFile);
					int len;
					while ((len = zis.read(buffer)) > 0)
						fos.write(buffer, 0, len);
					fos.close();
				} catch (IOException e) {
					System.err.println("wtf: " + e.getMessage() + "\n\t" + newFile.getAbsolutePath());
				}
			}
			ze = zis.getNextEntry();
		}

		zis.closeEntry();
		zis.close();
	}

	public static String read(File file) {
		if (!file.exists()) return "";
		try {
			final StringBuilder content = new StringBuilder();
			final BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) content.append(line);
			in.close();
			return content.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return "ERROR: " + e.getMessage();
		}
	}

	public static String readIntact(File file) {
		try {
			return readStringIntact(file);
		} catch (IOException e) {
			return "[ERROR]";
		}
	}

	public static void write(Object content, File file) {
		if (content == null) return;
		tryToCreateFileIfNotExists(file);
		try {
			final BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write(content.toString());
			out.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static long copyFile(File file, BufferedOutputStream out, int from, long length) throws IOException {

		final RandomAccessFile raf = new RandomAccessFile(file, "r");
		raf.skipBytes(from);

		final int bufSize = 2048;
		byte[] buf = new byte[bufSize];
		int len;
		long read = 0L;
		while ((len = raf.read(buf)) > 0) {
			out.write(buf, 0, len);
			read += len;
			if (read >= length) break;
		}
		raf.close();
		out.close();
		return read;
	}


	public static long calculateFileChecksum(File file) {
		try {
			CheckedInputStream check = new CheckedInputStream(new FileInputStream(file), new CRC32());
			BufferedInputStream in = new BufferedInputStream(check);
			while (in.read() != -1) {
			}
			return check.getChecksum().getValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static boolean removeFilesUnderIncluding(String path) {
		final File file = new File(path);

		if (!file.exists()) return true;

		if (file.isDirectory()) {
			final File[] files = file.listFiles();
			if (files != null)
				for (File subDir : files)
					if (!removeFilesUnderIncluding(subDir.getAbsolutePath())) return false;
		}

		return file.delete();
	}

	public static void removeAllFoldersNamed(String name, String path) {
		final File file = new File(path);

		if (!file.exists()) return;

		if (file.getName().equals(name)) {
			remove(file);
			return;
		}

		if (file.isDirectory()) {
			for (File subDir : file.listFiles()) {
				removeAllFoldersNamed(name, subDir.getAbsolutePath());
			}
		}
	}

	public static boolean remove(File file) {
		if (!file.exists()) return true;

		if (file.isDirectory()) {
			for (File subDir : file.listFiles()) {
				if (!remove(subDir)) return false;
			}
		}

		return file.delete();
	}

	public static boolean removeFilesUnder(String path) {
		final File file = new File(path);

		if (!file.exists()) return true;

		if (file.isDirectory()) {
			for (File subDir : file.listFiles()) {
				if (!removeFilesUnder(subDir.getAbsolutePath())) return false;
			}
		} else {
			return file.delete();
		}
		return true;
	}

	public static String createRelativePathFrom(File dir, File file) {

		final String rootPath = dir.getAbsolutePath();
		final String filePath = file.getAbsolutePath();

		return rootPath.length() > filePath.length() ? file.getName() : filePath.substring(rootPath.length());
	}

	static {
		String tmp = System.getProperty("os.name");
		isWindows = (tmp != null && tmp.toLowerCase().startsWith("windows"));
	}

	public static Process exec(File file) throws IOException {

		if (isWindows) {
			String path = escapeNameWindows(file.getAbsolutePath());
			String command = "rundll32 url.dll,FileProtocolHandler " + path;
			return Runtime.getRuntime().exec(command);
		} else {
			String[] cmd_Str = {"/bin/bash", "-c", "/usr/bin/open " + escapeNameUnix(file.getAbsolutePath())};
			return Runtime.getRuntime().exec(cmd_Str);
		}
	}

	public static void splitBy(String file, String delims, final TokenHandler handler) throws IOException {

		final Set<Character> deliminators = new LinkedHashSet<>();
		for (char del : delims.toCharArray()) deliminators.add(del);

		FileUtil.readString(file, new FileUtil.LineHandler() {

			StringBuilder w = new StringBuilder();

			@Override
			public boolean handleLine(String line) {
				for (char c : line.toCharArray()) {
					if (deliminators.contains(c)) {
						if (w != null) handler.handleToken(c, w.toString());
						w = new StringBuilder();
					} else {
						w.append(c);
					}
				}
				return false;
			}
		});
	}

	public static String getSimpleName(File file) {
		final String path = file == null ? "" : file.getPath();
		if (path.length() == 0) return "";
		if (path.lastIndexOf(".") == -1) return path;
		return path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
	}

	public static String toString(Collection<String> set) {
		final StringBuilder out = new StringBuilder();

		boolean first = true;
		for (String s : set) {
			if (!first) out.append(",");
			out.append(s.trim().length() == 0 ? " " : s.trim());
			first = false;
		}
		return "[" + out.toString() + "]";
	}

	public static void copyFolder(File src, File dest) throws IOException {

		if (src.isDirectory() && dest.isFile())
			throw new IOException("cannot copy: src.dir: " + src.getAbsolutePath() + "\n dst.file: " + dest.getAbsolutePath());

		if (dest.isDirectory() && src.isFile())
			throw new IOException("cannot copy: dest.dir: " + src.getAbsolutePath() + "\n src.file: " + dest.getAbsolutePath());

		if (src.isDirectory()) {

			//list all the directory contents
			String files[] = src.list();
			if (files != null) {
				for (String file : files) {
					//construct the src and dest file structure
					File srcFile = new File(src, file);
					if (srcFile.isDirectory()) {
						copyFolder(srcFile, FileUtil.tryToCreateDirIfNotExists(new File(dest, file)));
						continue;
					}

					//recursive copy
					copyFolder(srcFile, FileUtil.tryToCreateFileIfNotExists(new File(dest, file)));
				}
			}

		} else {

			//if file, then copy it
			//Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			//copy the file content in bytes
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
			System.out.println("File copied from " + src + " to " + dest);
		}
	}


	public static final class ProcessStreamHandler extends Thread {

		private InputStream processStream;

		public void setProcessStream(InputStream processStream) {
			this.processStream = processStream;
		}

		@Override
		public void run() {
			try {
				InputStreamReader isr = new InputStreamReader(processStream);
				BufferedReader br = new BufferedReader(isr);
				String line;
				while ((line = br.readLine()) != null) System.out.println(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	public static Process execute(String command, ProcessStreamHandler outputHandler, ProcessStreamHandler errorHandler) {
		try {
			final Process process = Runtime.getRuntime().exec(command);

			outputHandler.setProcessStream(process.getErrorStream());
			errorHandler.setProcessStream(process.getErrorStream());

			outputHandler.start();
			errorHandler.start();

			return process;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Process open(File file) throws IOException {

		if (isWindows) {
			String path = escapeNameWindows(file.getAbsolutePath());
			String command = "rundll32 url.dll,FileProtocolHandler " + path;
			return Runtime.getRuntime().exec(command);
		} else {
			String[] cmd_Str = {"/bin/bash", "-c", "/usr/bin/open " + escapeNameUnix(file.getAbsolutePath())};
			return Runtime.getRuntime().exec(cmd_Str);
		}
	}

	private static String escapeNameWindows(String name) {

		if (name.indexOf(' ') >= 0) {
			name = "\"" + name + "\"";
		}
		return name;
	}

	private static String escapeNameUnix(String name) {

		Character delimit = '\'';
		String res = "";

		for (int ind = name.indexOf('\''); ind >= 0; ind = name.indexOf('\'')) {

			res += name.substring(0, ind) + "'\\''";
			name = name.substring(ind + 1);
		}

		return delimit.toString() + res + name + delimit.toString();
	}

	public static BufferedWriter prepareFileForWriting(final String filename) {
		try {
			return new BufferedWriter(new FileWriter(tryToCreateFileIfNotExists(new File(filename))));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		long length = file.length();
		if (length > Integer.MAX_VALUE) {
			throw new IOException("FileToLarge");
		}

		byte[] bytes = new byte[(int) length];

		int offset = 0;
		int numRead;
		while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		if (offset < bytes.length) {
			throw new IOException("Could not completely read file " + file.getName());
		}

		is.close();
		return bytes;
	}

	public static void writeBytesToFile(byte[] bytes, File file) {
		boolean append = false;
		try {
			tryToCreateFileIfNotExists(file);
			FileChannel wChannel = new FileOutputStream(file, append).getChannel();
			wChannel.write(ByteBuffer.wrap(bytes));
			wChannel.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void writeToFile(InputStream in, File f) throws IOException {
		tryToCreateFileIfNotExists(f);
		BufferedInputStream bin = new BufferedInputStream(in);
		FileOutputStream fout = new FileOutputStream(f);
		int len;
		byte[] buf = new byte[1024];
		while ((len = bin.read(buf)) > 0) fout.write(buf, 0, len);
		fout.flush();
		fout.close();
	}

	public static File tryToCreateDirIfNotExists(File f) {
		if (!f.exists()) {
			if (f.getParentFile() != null && !f.getParentFile().exists() && !f.getParentFile().mkdirs())
				throw new RuntimeException("Could not create parent dirs for " + f.getAbsolutePath());
			if (!f.mkdir()) throw new RuntimeException("Could not create directory " + f.getName());
		}
		return f;
	}

	public static File tryToCreateFileIfNotExists(File f) {
		if (!f.exists()) {

			tryToCreateDirIfNotExists(f.getParentFile());

			try {
				if (!f.createNewFile()) throw new RuntimeException("Could not create file " + f.getName());
			} catch (IOException e) {
				throw new RuntimeException("Could not create file " + f.getName());
			}
		}
		return f;
	}

	public static File tryToCreateTempFile(String prefix, String suffix) {
		try {
			return File.createTempFile(prefix, suffix);
		} catch (IOException e) {
			throw new RuntimeException("Could not create temp file: " + e.getMessage());
		}
	}

	public static void writeString(String string, File file, String encoding) throws IOException {
		tryToCreateFileIfNotExists(file);
		final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding));
		out.write(string);
		out.close();
	}

	public static void writeString(String string, String file) throws IOException {
		writeString(string, new File(file));
	}

	public static void writeString(String string, File file) throws IOException {
		tryToCreateFileIfNotExists(file);
		final BufferedWriter out = new BufferedWriter(new FileWriter(file));
		out.write(string);
		out.close();
	}

	public static void writeFile(Object string, File file) throws IOException {
		tryToCreateFileIfNotExists(file);
		final BufferedWriter out = new BufferedWriter(new FileWriter(file));
		out.write(string == null ? "" : string.toString());
		out.close();
	}

	public static String readString(String file) throws IOException {
		return readString(new File(file));
	}

	public static String readStringIntact(String file) {
		try {
			return readStringIntact(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String readString(String file, String encoding) throws IOException {
		return readString(new File(file), encoding);
	}

	private static String readString(File file, String encoding) throws IOException {
		final StringBuilder string = new StringBuilder();
		final BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
		String line;
		while ((line = in.readLine()) != null) string.append(line);
		in.close();
		return string.toString();
	}

	public static String readString(String file, LineHandler handler, String encoding) throws IOException {
		return readString(new File(file), handler, encoding);
	}

	public static void filterString(String file, LineHandler handler, String encoding) throws IOException {
		filterString(new File(file), handler, encoding);
	}

	public static void filterString(File file, LineHandler handler, String encoding) throws IOException {

		final BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
		try {
			String line;
			while ((line = in.readLine()) != null) {
				if (handler.handleLine(line)) return;
			}
		} finally {
			in.close();
		}
	}

	private static String readString(File file, LineHandler handler, String encoding) throws IOException {
		final BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
		String line;
		while ((line = in.readLine()) != null) handler.handleLine(line);
		in.close();
		return handler.toString();
	}

	public static String readString(String file, LineHandler handler) throws IOException {
		return readString(new File(file), handler);
	}

	public static String readString(File file, LineHandler handler) throws IOException {
		final BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		boolean stop = false;
		while (!stop && (line = in.readLine()) != null) stop = handler.handleLine(line);
		in.close();

		return handler.toString();
	}

	public static File[] list(String dir, String postfix) {
		final String s = postfix.toLowerCase();
		return new File(dir).listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				return pathname.getAbsolutePath().toLowerCase().endsWith(s);
			}
		});
	}

	public static File[] listDirs(String dir) {
		return new File(dir).listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		});
	}

	public static File[] list(String dir, final boolean includeDirs) {
		return new File(dir).listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				if (pathname.isDirectory()) return includeDirs;
				return true;
			}
		});
	}

	public static File[] list(String dir) {
		return new File(dir).listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				return true;
			}
		});
	}

	public static void close(Writer writer) {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public interface TokenHandler {

		boolean handleToken(Character token, String line);

	}

	public interface LineHandler {

		boolean handleLine(String line);


	}

	public static final class DefaultLineHandler implements LineHandler {

		final StringBuilder content = new StringBuilder();


		@Override
		public boolean handleLine(String line) {
			content.append(line).append(LINE_SEPARATOR);
			return false;
		}


		@Override
		public String toString() {
			return content.toString();
		}

	}


	public static String readString(File file) throws IOException {
		if (!file.exists()) return "";
		final StringBuilder string = new StringBuilder();
		final BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) string.append(line);
		in.close();
		return string.toString();
	}

	public static String readStringIntact(File file) throws IOException {
		if (!file.exists()) return "";
		final StringBuilder string = new StringBuilder();
		final BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) string.append(line).append("\r\n");
		in.close();
		return string.toString();
	}

	public static String tryToReadStringIntact(File file) {
		try {
			return readStringIntact(file);
		} catch (IOException e) {
			return "[Error: " + e.getMessage() + "]";
		}
	}

	/**
	 * Opens filechooser in open- mode
	 *
	 * @param parent the parent of the filechooser dialog
	 * @param file   if null: uses 'user.home', if file: uses parent directory, if directory uses directory
	 * @return selected file or null
	 */
	public static File openFile(Component parent, File file) {
		final String currentDirectoryPath = file == null ? System.getProperty("user.home") : (file.isDirectory() ? file.getAbsolutePath() : file.getParent());
		final JFileChooser chooser = new JFileChooser(currentDirectoryPath);
		final int res = chooser.showOpenDialog(parent);
		return JFileChooser.APPROVE_OPTION == res ? chooser.getSelectedFile() : null;
	}

	public static File selectDirectory(Component parent, File file) {
		final String currentDirectoryPath = file == null ? System.getProperty("user.home") : (file.isDirectory() ? file.getAbsolutePath() : file.getParent());
		final JFileChooser chooser = new JFileChooser(currentDirectoryPath);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		final int res = chooser.showOpenDialog(parent);
		return JFileChooser.APPROVE_OPTION == res ? chooser.getSelectedFile() : null;
	}

	public static File saveFile(Component parent, File file) {
		final String currentDirectoryPath = file == null ? System.getProperty("user.home") : (file.isDirectory() ? file.getAbsolutePath() : file.getParent());
		final JFileChooser chooser = new JFileChooser(currentDirectoryPath);
		final int res = chooser.showSaveDialog(parent);
		return JFileChooser.APPROVE_OPTION == res ? chooser.getSelectedFile() : null;
	}

	public static void saveDocument(Document doc, File file) throws Exception {
		writeXmlFile(doc, file.getAbsolutePath());
	}

	public static void saveDocument(Document doc, String file) throws Exception {
		writeXmlFile(doc, file);
	}

	public static void writeXmlFile(Document doc, String file) throws Exception {
		final Source source = new DOMSource(doc);
		final Result result = new StreamResult(new File(file).toURI().getPath());
		final Transformer xformer = TransformerFactory.newInstance().newTransformer();
		xformer.setOutputProperty(OutputKeys.METHOD, "xml");
		xformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		xformer.setOutputProperty(OutputKeys.VERSION, "1.0");
		xformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		xformer.setOutputProperty(OutputKeys.INDENT, "yes");
		xformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		xformer.transform(source, result);
	}

	public static void writeToFile(Object data, File file) throws IOException {

		if (data == null) throw new IllegalArgumentException("data cannot be null");

		final BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(data.toString());
		writer.close();
	}

	private static File createDirectory(File parent, String filename) {
		final File newFile = new File(parent, filename);
		if (!newFile.exists() && !newFile.mkdirs()) return null;
		return newFile;
	}

	public static File createPackageDirectory(File parent, String parentName) {
		return createDirectory(parent, replace('.', File.separator, parentName));
	}

	private static String replace(char old, String with, String s) {
		final StringBuilder sb = new StringBuilder();
		final char[] chars = s.toCharArray();
		for (char aChar : chars) {
			if (aChar == old) sb.append(with);
			else sb.append(aChar);
		}
		return sb.toString();
	}

	public static Document parseXmlFile(File file) throws Exception {
		return parseXmlFile(file.getAbsolutePath());
	}

	public static Document parseXmlFile(String filename) throws Exception {
		return parseXmlFile(filename, false);
	}

	public static Document parseXmlFile(String filename, boolean validating) throws Exception {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(validating);
		return factory.newDocumentBuilder().parse(new File(filename));
	}

	public static File saveFile(Component component, String startDir) {
		final JFileChooser fc = startDir == null || startDir.length() == 0 ? new JFileChooser() : new JFileChooser(startDir);
		int result = fc.showSaveDialog(component);
		if (JFileChooser.APPROVE_OPTION == result) {
			final File newFile = fc.getSelectedFile();
			if (newFile == null) return null;
			try {
				createFileAndParents(newFile);
			} catch (Exception e) {
				return null;
			}
			return newFile;
		}
		return null;
	}

	public static void createFileAndParents(File newFile) throws Exception {
		if (!newFile.exists()) {
			if (!newFile.getParentFile().exists() && newFile.getParentFile().mkdirs())
				throw new Exception("Could not create parent dirs");
			if (!newFile.createNewFile()) {
				throw new Exception("Could not create file");
			}
		}
	}

	public static void copy(File src, File dst) throws IOException {
		tryToCreateFileIfNotExists(dst);
		FileChannel srcChannel = new FileInputStream(src).getChannel();
		FileChannel dstChannel = new FileOutputStream(dst).getChannel();
		dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
		srcChannel.close();
		dstChannel.close();
	}

	public static List<File> findAllFilesWhichEndsWith(String path, String extension) {
		final List<File> list = new LinkedList<File>();

		final File file = new File(path);
		if (!file.exists()) {
			return list;
		} else if (file.isDirectory()) {
			for (File subDir : file.listFiles()) {
				list.addAll(findAllFilesWhichEndsWith(subDir.getAbsolutePath(), extension));
			}
		} else if (file.getAbsolutePath().toLowerCase().endsWith(extension.toLowerCase())) {
			list.add(file);
		}
		return list;
	}

	public static List<File> findAllFilesWhichEndsWithInDir(String path, String extension) {
		final List<File> list = new LinkedList<File>();

		final File file = new File(path);
		for (File child : file.listFiles()) {
			if (child.isDirectory()) continue;
			if (!child.getAbsolutePath().toLowerCase().endsWith(extension.toLowerCase())) continue;
			list.add(child);
		}
		return list;
	}

	public interface LineProcessor {
		/**
		 * process the line
		 *
		 * @param lineNo the line number (0-based)
		 * @param line   the line
		 * @return true if you want to continue to next line, false if you want to stop processing the remaining lines
		 * @throws Exception if any exception is thrown. This will ensure file- handling cleanup
		 */
		boolean processLine(int lineNo, String line) throws Exception;

		void processEnd() throws IOException;
	}

	public static void copy(InputStream in, OutputStream out) throws IOException {
		final int bufSize = 2048;
		byte[] buf = new byte[bufSize];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}

	public static void process(String sourceFile, LineProcessor handler) {

		final BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(sourceFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		String line;
		try {
			int lineNo = -1;
			while ((line = in.readLine()) != null) {
				lineNo++;
				try {
					if (!handler.processLine(lineNo, line)) break;
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}
			}

			handler.processEnd();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static File findFile(String dir, String filename) throws Exception {
		final File file = new File(dir, filename);
		if (!file.exists() || !file.isFile()) throw new Exception("cannot find " + file.getAbsolutePath());
		return file;
	}

	public static void extractStreamFromPdf(String pdfFile, LineProcessor handler) throws IOException {

		final File file = new File(pdfFile);
		final RandomAccessFile raf = new RandomAccessFile(file, "rw");

		int toRead = -1;
		String s = raf.readLine();
		while (s != null) {

			final String startStream = "/Filter /FlateDecode /Length";
			if (s.contains(startStream)) {
				final String tmp = s.substring(s.indexOf(startStream) + startStream.length() + 1);
				toRead = Integer.parseInt(tmp.substring(0, tmp.indexOf(" ")));
				raf.readLine();   //skip 'stream'

				byte[] streamBytes = new byte[toRead];
				raf.read(streamBytes);
				for (int i = 0; i < streamBytes.length; i++) {
					byte streamByte = streamBytes[i];
					System.out.print(streamByte);
				}
				System.out.println(new String(streamBytes, "UTF-8"));
				System.out.println(new String(zipByteArray(streamBytes), "ISO-8859-1"));
			}

			s = raf.readLine();
		}
		raf.close();
	}

	private static final class PdfStreamProcessor implements LineProcessor {

		boolean isStream = false;
		private final LineProcessor handler;

		private ByteBuffer buffer;
		private boolean done = false;

		private PdfStreamProcessor(LineProcessor handler) {
			this.handler = handler;
		}

		@Override
		public boolean processLine(int lineNo, String line) throws Exception {

			if (line.toLowerCase().contains("endstream")) {
				isStream = false;
				byte[] dst = new byte[buffer.position()];
				buffer.get(dst);
				done = handler.processLine(lineNo, new String(zipByteArray(dst)));
				buffer.clear();
				return true;
			}

			if (line.toLowerCase().contains("stream")) {
				isStream = true;
				buffer = ByteBuffer.allocateDirect(1024 * 1024);
				return true;
			}

			if (isStream) {
				System.out.println("adding " + line);
				buffer.put(line.getBytes());
			}

			return !done;
		}

		@Override
		public void processEnd() throws IOException {

		}
	}

	public static byte[] zipByteArray(byte[] file) throws IOException {
		byte[] byReturn = null;
		Deflater oDeflate = new Deflater(Deflater.DEFLATED, false);
		oDeflate.setInput(file);
		oDeflate.finish();
		ByteArrayOutputStream oZipStream = new ByteArrayOutputStream();
		try {
			while (!oDeflate.finished()) {
				byte[] byRead = new byte[1024 * 1024];
				int iBytesRead = oDeflate.deflate(byRead);
				if (iBytesRead == byRead.length) {
					oZipStream.write(byRead);
				} else {
					oZipStream.write(byRead, 0, iBytesRead);
				}
			}
			oDeflate.end();
			byReturn = oZipStream.toByteArray();
		} finally {
			oZipStream.close();
		}
		return byReturn;
	}

	public static String removePostfix(File file) {
		return removePostfix(file.getName());
	}


	public static String removePostfix(String filename) {
		int indx = filename.lastIndexOf(".");
		return filename.substring(0, indx);
	}

	private static void recursiveFileSearch(File[] files) {
		if (files == null) return;

		for (File file : files) {
			if (file.isDirectory()) recursiveFileSearch(file.listFiles(pdfFilter()));
			else {
				System.out.println(file.getAbsolutePath());
			}
		}
	}

	private static FileFilter pdfFilter() {
		return new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory() || pathname.getName().toLowerCase().contains(".pdf");
			}
		};
	}
}