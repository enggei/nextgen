package com.generator.generators.chromeBookmarks;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'ChromeBookmarks.stg' file<br/>
 */
public final class ChromeBookmarksGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public ChromeBookmarksGroup() {
		this(new STGroupString(stg));
   }

   public ChromeBookmarksGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public ChromeBookmarksGroup(java.io.File templateFile) {
   	this.stGroup = new org.stringtemplate.v4.STGroupFile(templateFile.getAbsolutePath());
	   this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
	   this.delimiter = stGroup.delimiterStartChar;
	}

   public STGroup getSTGroup() {
      return stGroup;
   }

   public char getDelimiter() {
      return delimiter;
   }

	public interface ChromeBookmarksGroupTemplate {

	}

   public BookmarkST newBookmark() {
      return new BookmarkST(stGroup);
   }

   public BookmarkGroupST newBookmarkGroup() {
      return new BookmarkGroupST(stGroup);
   }

   public BookmarkPageST newBookmarkPage() {
      return new BookmarkPageST(stGroup);
   }

   public final class BookmarkST implements ChromeBookmarksGroupTemplate {

      private Object _date;
      private Object _href;
      private Object _icon;
      private Object _name;

      private final ST template;

      private BookmarkST(STGroup group) {
   		template = group.getInstanceOf("Bookmark");
   	}

      public BookmarkST setDate(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._date == null) {
            this._date = value;
         	template.add("date", value);
         }

      	return this;
      }

      public String getDate() {
      	return (String) this._date;
      }

      public BookmarkST setHref(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._href == null) {
            this._href = value;
         	template.add("href", value);
         }

      	return this;
      }

      public String getHref() {
      	return (String) this._href;
      }

      public BookmarkST setIcon(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._icon == null) {
            this._icon = value;
         	template.add("icon", value);
         }

      	return this;
      }

      public String getIcon() {
      	return (String) this._icon;
      }

      public BookmarkST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class BookmarkGroupST implements ChromeBookmarksGroupTemplate {

      private java.util.Set<Object> _bookmarks = new java.util.LinkedHashSet<>();
      private Object _date;
      private Object _lastModified;
      private Object _name;

      private final ST template;

      private BookmarkGroupST(STGroup group) {
   		template = group.getInstanceOf("BookmarkGroup");
   	}

      public BookmarkGroupST addBookmarksValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._bookmarks.add(value);
      	template.add("bookmarks", value);

         return this;
      }

      public java.util.Set<Object> getBookmarksValues() {
      	return this._bookmarks;
      }

      public BookmarkGroupST setDate(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._date == null) {
            this._date = value;
         	template.add("date", value);
         }

      	return this;
      }

      public String getDate() {
      	return (String) this._date;
      }

      public BookmarkGroupST setLastModified(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._lastModified == null) {
            this._lastModified = value;
         	template.add("lastModified", value);
         }

      	return this;
      }

      public String getLastModified() {
      	return (String) this._lastModified;
      }

      public BookmarkGroupST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class BookmarkPageST implements ChromeBookmarksGroupTemplate {

      private java.util.Set<Object> _groups = new java.util.LinkedHashSet<>();

      private final ST template;

      private BookmarkPageST(STGroup group) {
   		template = group.getInstanceOf("BookmarkPage");
   	}

      public BookmarkPageST addGroupsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._groups.add(value);
      	template.add("groups", value);

         return this;
      }

      public java.util.Set<Object> getGroupsValues() {
      	return this._groups;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

	static boolean tryToSetListProperty(ST template, Object value, AtomicBoolean alreadySet, String name) {
		if (value == null || value.toString().length() == 0) return true;
		alreadySet.set(true);
		template.add(name, value);
		return false;
	}

	private enum FormatCode {
	      capitalize, toUpper, lowFirst, toLower, humpToCap, camelHump, splitCamelHump, singlify, packageToPath
	   }

	   private final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

	      @Override
	      public String toString(Object o, String formatString, java.util.Locale locale) {

	         final String text = o.toString();

	         if (formatString == null) return text;

	         switch (FormatCode.valueOf(formatString)) {
	            case capitalize:
	               return capitalize(text);
	            case toUpper:
	               return toUpper(text);
	            case lowFirst:
	               return lowFirst(text);
	            case toLower:
	               return text.toLowerCase();
	            case humpToCap:
	               return humpToCap(text);
	            case camelHump:
	               return camelHump(text);
	            case splitCamelHump:
	               return splitCamelHump(text);
	            case singlify:
	               String s = toUpper(text).substring(0, 1) + text.substring(1);
	               if (s.toLowerCase().endsWith("ies")) return s.substring(0, s.length() - 3) + "y";
	               else if (s.toLowerCase().endsWith("es") || s.toLowerCase().endsWith("nts")) return s.substring(0, s.length() - 1);
	               else if (s.toLowerCase().endsWith("ions") || s.toLowerCase().endsWith("mns"))
	                  return s.substring(0, s.length() - 1);
	               return s;
	            case packageToPath:
	               return packageToPath((text));
	            default:
	               return o.toString();
	         }
	      }

	      private String capitalize(String string) {
	         if (string == null || string.length() == 0) return "";
	         return Character.toUpperCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
	      }

	      private String lowFirst(String string) {
	         if (string == null || string.length() == 0) return "";
	         return Character.toLowerCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
	      }

	      private String toUpper(String text) {
	         return text.toUpperCase();
	      }

	      private String humpToCap(String text) {
	         final char[] chars = text.toCharArray();
	         final StringBuilder out = new StringBuilder();
	         boolean first = true;
	         for (int i = 0; i < chars.length; i++) {
	            char aChar = chars[i];
	            if (!first && Character.isUpperCase(aChar) && (i < chars.length - 2 && Character.isLowerCase(chars[i + 1]))) {
	               out.append("_");
	            }
	            first = false;
	            out.append(Character.toUpperCase(aChar));
	         }
	         return out.toString();
	      }

	      private String camelHump(String text) {
	         final char[] chars = text.toCharArray();
	         final StringBuilder out = new StringBuilder();
	         boolean capitalize = true;
	         for (char aChar : chars) {
	            if (Character.isWhitespace(aChar)) {
	               capitalize = true;
	               continue;
	            }
	            out.append(capitalize ? Character.toUpperCase(aChar) : aChar);
	            capitalize = false;
	         }
	         return out.toString();
	      }

	      private String splitCamelHump(String text) {
	         final char[] chars = text.toCharArray();
	         final StringBuilder out = new StringBuilder();
	         boolean first = true;
	         for (char aChar : chars) {
	            if (Character.isUpperCase(aChar)) out.append(" ");
	            out.append(first ? Character.toUpperCase(aChar) : Character.toLowerCase(aChar));
	            first = false;
	         }
	         return out.toString();
	      }

	      private String packageToPath(String packageName) {
	          return (packageName == null ? "" : (packageName.replaceAll("[.]", "/") + java.io.File.separator));
	      }
	   }

	public String list(String delimiter, Object... elements) {
		final StringBuilder list = new StringBuilder();
		boolean first = true;
		for (Object element : elements) {
			if (!first) list.append(delimiter);
			list.append(element);
			first = false;
		}
		return list.toString() + delimiter;
	}

	public static void toSTGFile(java.io.File dir) throws java.io.IOException {
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "ChromeBookmarksGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("Bookmark(date,href,icon,name) ::= <<<DT><A HREF=\"~href~\" ADD_DATE=\"~date~\"~if(icon)~ ICON=\"~icon~\"~endif~>~name~</A> >>\n")
			.append("BookmarkGroup(bookmarks,date,lastModified,name) ::= <<<DT><H3 ADD_DATE=\"~date~\" LAST_MODIFIED=\"~lastModified~\">~name~</H3>\n" + 
		"	<DL><p>\n" + 
		"   	~bookmarks:{it|~it~};separator=\"\\n\"~\n" + 
		"   </DL><p>\n" + 
		"<DT> >>\n")
			.append("BookmarkPage(groups) ::= <<<!DOCTYPE NETSCAPE-Bookmark-file-1>\n" + 
		"<!-- This is an automatically generated file.\n" + 
		"     It will be read and overwritten.\n" + 
		"     DO NOT EDIT! -->\n" + 
		"<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\">\n" + 
		"<TITLE>Bookmarks</TITLE>\n" + 
		"<H1>Bookmarks</H1>\n" + 
		"<DL><p>\n" + 
		"    <--todo: remove this -->\n" + 
		"    <DT><H3 ADD_DATE=\"0\" LAST_MODIFIED=\"1313267859\" PERSONAL_TOOLBAR_FOLDER=\"true\">Bokmerkerad</H3>\n" + 
		"    <DL><p>\n" + 
		"        ~groups:{it|~it~};separator=\"\\n\"~\n" + 
		"    </DL><p>\n" + 
		"</DL><p> >>\n")
		.toString();
}