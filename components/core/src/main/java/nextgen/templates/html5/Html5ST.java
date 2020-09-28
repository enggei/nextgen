package nextgen.templates.html5;

public class Html5ST {

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
	.append("eom() ::= \"}\"\n")
	.append("gt() ::= \">\"\n")
	.append(_object.st + "\n")
	.append(A.st + "\n")
	.append(Abbr.st + "\n")
	.append(Acronym.st + "\n")
	.append(Address.st + "\n")
	.append(Applet.st + "\n")
	.append(Area.st + "\n")
	.append(Article.st + "\n")
	.append(Aside.st + "\n")
	.append(Audio.st + "\n")
	.append(B.st + "\n")
	.append(Base.st + "\n")
	.append(Basefont.st + "\n")
	.append(Bdi.st + "\n")
	.append(Bdo.st + "\n")
	.append(Big.st + "\n")
	.append(Block.st + "\n")
	.append(Blockquote.st + "\n")
	.append(Body.st + "\n")
	.append(Br.st + "\n")
	.append(Button.st + "\n")
	.append(Canvas.st + "\n")
	.append(Caption.st + "\n")
	.append(Center.st + "\n")
	.append(Cite.st + "\n")
	.append(Code.st + "\n")
	.append(Col.st + "\n")
	.append(Colgroup.st + "\n")
	.append(Comment.st + "\n")
	.append(Datalist.st + "\n")
	.append(Dd.st + "\n")
	.append(Del.st + "\n")
	.append(Details.st + "\n")
	.append(Dfn.st + "\n")
	.append(Dialog.st + "\n")
	.append(Dir.st + "\n")
	.append(Div.st + "\n")
	.append(Dl.st + "\n")
	.append(Dt.st + "\n")
	.append(Em.st + "\n")
	.append(Embed.st + "\n")
	.append(Fieldset.st + "\n")
	.append(Figcaption.st + "\n")
	.append(Figure.st + "\n")
	.append(Font.st + "\n")
	.append(Footer.st + "\n")
	.append(Form.st + "\n")
	.append(Frame.st + "\n")
	.append(Frameset.st + "\n")
	.append(H1.st + "\n")
	.append(H2.st + "\n")
	.append(H3.st + "\n")
	.append(H4.st + "\n")
	.append(H5.st + "\n")
	.append(H6.st + "\n")
	.append(Head.st + "\n")
	.append(Header.st + "\n")
	.append(Hgroup.st + "\n")
	.append(Hr.st + "\n")
	.append(I.st + "\n")
	.append(Iframe.st + "\n")
	.append(Img.st + "\n")
	.append(Input.st + "\n")
	.append(Ins.st + "\n")
	.append(Kbd.st + "\n")
	.append(Keygen.st + "\n")
	.append(Label.st + "\n")
	.append(Legend.st + "\n")
	.append(Li.st + "\n")
	.append(Link.st + "\n")
	.append(Main.st + "\n")
	.append(Map.st + "\n")
	.append(Mark.st + "\n")
	.append(Menu.st + "\n")
	.append(Menuitem.st + "\n")
	.append(Meta.st + "\n")
	.append(Meter.st + "\n")
	.append(MimeJson.st + "\n")
	.append(Nav.st + "\n")
	.append(Noframes.st + "\n")
	.append(Noscript.st + "\n")
	.append(Ol.st + "\n")
	.append(Optgroup.st + "\n")
	.append(Option.st + "\n")
	.append(Output.st + "\n")
	.append(P.st + "\n")
	.append(Page.st + "\n")
	.append(Param.st + "\n")
	.append(Pre.st + "\n")
	.append(Progress.st + "\n")
	.append(Q.st + "\n")
	.append(Rp.st + "\n")
	.append(Rt.st + "\n")
	.append(Ruby.st + "\n")
	.append(S.st + "\n")
	.append(Samp.st + "\n")
	.append(Script.st + "\n")
	.append(Section.st + "\n")
	.append(Select.st + "\n")
	.append(Small.st + "\n")
	.append(Source.st + "\n")
	.append(Span.st + "\n")
	.append(Strike.st + "\n")
	.append(Strong.st + "\n")
	.append(Style.st + "\n")
	.append(Sub.st + "\n")
	.append(Summary.st + "\n")
	.append(Sup.st + "\n")
	.append(Table.st + "\n")
	.append(Tbody.st + "\n")
	.append(Td.st + "\n")
	.append(Textarea.st + "\n")
	.append(Tfoot.st + "\n")
	.append(Th.st + "\n")
	.append(Thead.st + "\n")
	.append(Time.st + "\n")
	.append(Title.st + "\n")
	.append(Tr.st + "\n")
	.append(Track.st + "\n")
	.append(Tt.st + "\n")
	.append(U.st + "\n")
	.append(Ul.st + "\n")
	.append(Var.st + "\n")
	.append(Video.st + "\n")
	.append(Wbr.st + "\n")
	.toString()  ;

	public static org.stringtemplate.v4.STGroup decorate(final org.stringtemplate.v4.STGroup stGroup) {
		stGroup.registerRenderer(Object.class, new DefaultAttributeRenderer());
		stGroup.setListener(new org.stringtemplate.v4.STErrorListener() {
			@Override
			public void compileTimeError(org.stringtemplate.v4.misc.STMessage stMessage) {
				System.out.println("compileTimeError " + stMessage.toString());
			}

			@Override
			public void runTimeError(org.stringtemplate.v4.misc.STMessage stMessage) {
				final org.stringtemplate.v4.misc.STRuntimeMessage stRuntimeMessage = (org.stringtemplate.v4.misc.STRuntimeMessage) stMessage;
				System.out.println("runTimeError " + stMessage.self.getName() + " " + stRuntimeMessage.getSourceLocation());
			}

			@Override
			public void IOError(org.stringtemplate.v4.misc.STMessage stMessage) {
				System.out.println("IOError " + stMessage.toString());
			}

			@Override
			public void internalError(org.stringtemplate.v4.misc.STMessage stMessage) {
				System.out.println("internalError " + stMessage.toString());
			}
		});

		return stGroup;
	}

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("Html5ST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static _object new_object() {
		return new _object(stGroup);
	}  

	public static A newA() {
		return new A(stGroup);
	}  

	public static Abbr newAbbr() {
		return new Abbr(stGroup);
	}  

	public static Acronym newAcronym() {
		return new Acronym(stGroup);
	}  

	public static Address newAddress() {
		return new Address(stGroup);
	}  

	public static Applet newApplet() {
		return new Applet(stGroup);
	}  

	public static Area newArea() {
		return new Area(stGroup);
	}  

	public static Article newArticle() {
		return new Article(stGroup);
	}  

	public static Aside newAside() {
		return new Aside(stGroup);
	}  

	public static Audio newAudio() {
		return new Audio(stGroup);
	}  

	public static B newB() {
		return new B(stGroup);
	}  

	public static Base newBase() {
		return new Base(stGroup);
	}  

	public static Basefont newBasefont() {
		return new Basefont(stGroup);
	}  

	public static Bdi newBdi() {
		return new Bdi(stGroup);
	}  

	public static Bdo newBdo() {
		return new Bdo(stGroup);
	}  

	public static Big newBig() {
		return new Big(stGroup);
	}  

	public static Block newBlock() {
		return new Block(stGroup);
	}  

	public static Blockquote newBlockquote() {
		return new Blockquote(stGroup);
	}  

	public static Body newBody() {
		return new Body(stGroup);
	}  

	public static Br newBr() {
		return new Br(stGroup);
	}  

	public static Button newButton() {
		return new Button(stGroup);
	}  

	public static Canvas newCanvas() {
		return new Canvas(stGroup);
	}  

	public static Caption newCaption() {
		return new Caption(stGroup);
	}  

	public static Center newCenter() {
		return new Center(stGroup);
	}  

	public static Cite newCite() {
		return new Cite(stGroup);
	}  

	public static Code newCode() {
		return new Code(stGroup);
	}  

	public static Col newCol() {
		return new Col(stGroup);
	}  

	public static Colgroup newColgroup() {
		return new Colgroup(stGroup);
	}  

	public static Comment newComment() {
		return new Comment(stGroup);
	}  

	public static Datalist newDatalist() {
		return new Datalist(stGroup);
	}  

	public static Dd newDd() {
		return new Dd(stGroup);
	}  

	public static Del newDel() {
		return new Del(stGroup);
	}  

	public static Details newDetails() {
		return new Details(stGroup);
	}  

	public static Dfn newDfn() {
		return new Dfn(stGroup);
	}  

	public static Dialog newDialog() {
		return new Dialog(stGroup);
	}  

	public static Dir newDir() {
		return new Dir(stGroup);
	}  

	public static Div newDiv() {
		return new Div(stGroup);
	}  

	public static Dl newDl() {
		return new Dl(stGroup);
	}  

	public static Dt newDt() {
		return new Dt(stGroup);
	}  

	public static Em newEm() {
		return new Em(stGroup);
	}  

	public static Embed newEmbed() {
		return new Embed(stGroup);
	}  

	public static Fieldset newFieldset() {
		return new Fieldset(stGroup);
	}  

	public static Figcaption newFigcaption() {
		return new Figcaption(stGroup);
	}  

	public static Figure newFigure() {
		return new Figure(stGroup);
	}  

	public static Font newFont() {
		return new Font(stGroup);
	}  

	public static Footer newFooter() {
		return new Footer(stGroup);
	}  

	public static Form newForm() {
		return new Form(stGroup);
	}  

	public static Frame newFrame() {
		return new Frame(stGroup);
	}  

	public static Frameset newFrameset() {
		return new Frameset(stGroup);
	}  

	public static H1 newH1() {
		return new H1(stGroup);
	}  

	public static H2 newH2() {
		return new H2(stGroup);
	}  

	public static H3 newH3() {
		return new H3(stGroup);
	}  

	public static H4 newH4() {
		return new H4(stGroup);
	}  

	public static H5 newH5() {
		return new H5(stGroup);
	}  

	public static H6 newH6() {
		return new H6(stGroup);
	}  

	public static Head newHead() {
		return new Head(stGroup);
	}  

	public static Header newHeader() {
		return new Header(stGroup);
	}  

	public static Hgroup newHgroup() {
		return new Hgroup(stGroup);
	}  

	public static Hr newHr() {
		return new Hr(stGroup);
	}  

	public static I newI() {
		return new I(stGroup);
	}  

	public static Iframe newIframe() {
		return new Iframe(stGroup);
	}  

	public static Img newImg() {
		return new Img(stGroup);
	}  

	public static Input newInput() {
		return new Input(stGroup);
	}  

	public static Ins newIns() {
		return new Ins(stGroup);
	}  

	public static Kbd newKbd() {
		return new Kbd(stGroup);
	}  

	public static Keygen newKeygen() {
		return new Keygen(stGroup);
	}  

	public static Label newLabel() {
		return new Label(stGroup);
	}  

	public static Legend newLegend() {
		return new Legend(stGroup);
	}  

	public static Li newLi() {
		return new Li(stGroup);
	}  

	public static Link newLink() {
		return new Link(stGroup);
	}  

	public static Main newMain() {
		return new Main(stGroup);
	}  

	public static Map newMap() {
		return new Map(stGroup);
	}  

	public static Mark newMark() {
		return new Mark(stGroup);
	}  

	public static Menu newMenu() {
		return new Menu(stGroup);
	}  

	public static Menuitem newMenuitem() {
		return new Menuitem(stGroup);
	}  

	public static Meta newMeta() {
		return new Meta(stGroup);
	}  

	public static Meter newMeter() {
		return new Meter(stGroup);
	}  

	public static MimeJson newMimeJson() {
		return new MimeJson(stGroup);
	}  

	public static Nav newNav() {
		return new Nav(stGroup);
	}  

	public static Noframes newNoframes() {
		return new Noframes(stGroup);
	}  

	public static Noscript newNoscript() {
		return new Noscript(stGroup);
	}  

	public static Ol newOl() {
		return new Ol(stGroup);
	}  

	public static Optgroup newOptgroup() {
		return new Optgroup(stGroup);
	}  

	public static Option newOption() {
		return new Option(stGroup);
	}  

	public static Output newOutput() {
		return new Output(stGroup);
	}  

	public static P newP() {
		return new P(stGroup);
	}  

	public static Page newPage() {
		return new Page(stGroup);
	}  

	public static Param newParam() {
		return new Param(stGroup);
	}  

	public static Pre newPre() {
		return new Pre(stGroup);
	}  

	public static Progress newProgress() {
		return new Progress(stGroup);
	}  

	public static Q newQ() {
		return new Q(stGroup);
	}  

	public static Rp newRp() {
		return new Rp(stGroup);
	}  

	public static Rt newRt() {
		return new Rt(stGroup);
	}  

	public static Ruby newRuby() {
		return new Ruby(stGroup);
	}  

	public static S newS() {
		return new S(stGroup);
	}  

	public static Samp newSamp() {
		return new Samp(stGroup);
	}  

	public static Script newScript() {
		return new Script(stGroup);
	}  

	public static Section newSection() {
		return new Section(stGroup);
	}  

	public static Select newSelect() {
		return new Select(stGroup);
	}  

	public static Small newSmall() {
		return new Small(stGroup);
	}  

	public static Source newSource() {
		return new Source(stGroup);
	}  

	public static Span newSpan() {
		return new Span(stGroup);
	}  

	public static Strike newStrike() {
		return new Strike(stGroup);
	}  

	public static Strong newStrong() {
		return new Strong(stGroup);
	}  

	public static Style newStyle() {
		return new Style(stGroup);
	}  

	public static Sub newSub() {
		return new Sub(stGroup);
	}  

	public static Summary newSummary() {
		return new Summary(stGroup);
	}  

	public static Sup newSup() {
		return new Sup(stGroup);
	}  

	public static Table newTable() {
		return new Table(stGroup);
	}  

	public static Tbody newTbody() {
		return new Tbody(stGroup);
	}  

	public static Td newTd() {
		return new Td(stGroup);
	}  

	public static Textarea newTextarea() {
		return new Textarea(stGroup);
	}  

	public static Tfoot newTfoot() {
		return new Tfoot(stGroup);
	}  

	public static Th newTh() {
		return new Th(stGroup);
	}  

	public static Thead newThead() {
		return new Thead(stGroup);
	}  

	public static Time newTime() {
		return new Time(stGroup);
	}  

	public static Title newTitle() {
		return new Title(stGroup);
	}  

	public static Tr newTr() {
		return new Tr(stGroup);
	}  

	public static Track newTrack() {
		return new Track(stGroup);
	}  

	public static Tt newTt() {
		return new Tt(stGroup);
	}  

	public static U newU() {
		return new U(stGroup);
	}  

	public static Ul newUl() {
		return new Ul(stGroup);
	}  

	public static Var newVar() {
		return new Var(stGroup);
	}  

	public static Video newVideo() {
		return new Video(stGroup);
	}  

	public static Wbr newWbr() {
		return new Wbr(stGroup);
	}  

	private static final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

		@Override
		public String toString(Object o, String formatString, java.util.Locale locale) {

			final String text = o.toString();
			if (formatString == null) return text;

			final String s = text.length() > 1 ? text.substring(1) : "";

			switch (formatString) {
				case "capitalize":
					return Character.toUpperCase(text.charAt(0)) + s;
				case "toUpper":
					return text.toUpperCase();
				case "lowFirst":
					return Character.toLowerCase(text.charAt(0)) + s;
				case "toLower":
					return text.toLowerCase();
				case "dotToCap":
					final StringBuilder formatted = new StringBuilder();
					final char[] chars = o.toString().toCharArray();
					for (int i = 0; i < chars.length; i++)
            		if (chars[i] != '.')
							formatted.append(i == 0 || chars[i - 1] == '.' ? Character.toUpperCase(chars[i]) : chars[i]);
					return formatted.toString().trim();
				default:
					return o.toString();
			}
		}
	}
}  