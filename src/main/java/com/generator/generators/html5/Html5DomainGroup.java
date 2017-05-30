package com.generator.generators.html5;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'html5.stg' file<br/>
 */
public final class Html5DomainGroup {
   // old html5
   private final STGroup stGroup;
   private final char delimiter;

	public Html5DomainGroup() {
		final String generatorPath = System.getProperty("generator.path");

        if (generatorPath != null) {
        	this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "html5" + java.io.File.separator + "html5.stg");
        	this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
        	this.delimiter = stGroup.delimiterStartChar;
        } else {
        	this.stGroup = new org.stringtemplate.v4.STGroupFile(Html5DomainGroup.class.getResource("/com/generator/generators/html5/html5.stg"), "UTF-8", '~', '~');
        	this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
        	this.delimiter = stGroup.delimiterStartChar;
        }
   }

   public Html5DomainGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public Html5DomainGroup(java.io.File templateFile) {
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

	public interface Html5DomainGroupTemplate {

	}

   public eomST neweom() {
      return new eomST(stGroup);
   }

   public gtST newgt() {
      return new gtST(stGroup);
   }

   public aST newa() {
      return new aST(stGroup);
   }

   public abbrST newabbr() {
      return new abbrST(stGroup);
   }

   public acronymST newacronym() {
      return new acronymST(stGroup);
   }

   public addressST newaddress() {
      return new addressST(stGroup);
   }

   public appletST newapplet() {
      return new appletST(stGroup);
   }

   public areaST newarea() {
      return new areaST(stGroup);
   }

   public articleST newarticle() {
      return new articleST(stGroup);
   }

   public asideST newaside() {
      return new asideST(stGroup);
   }

   public audioST newaudio() {
      return new audioST(stGroup);
   }

   public bST newb() {
      return new bST(stGroup);
   }

   public baseST newbase() {
      return new baseST(stGroup);
   }

   public basefontST newbasefont() {
      return new basefontST(stGroup);
   }

   public bdiST newbdi() {
      return new bdiST(stGroup);
   }

   public bdoST newbdo() {
      return new bdoST(stGroup);
   }

   public bigST newbig() {
      return new bigST(stGroup);
   }

   public blockST newblock() {
      return new blockST(stGroup);
   }

   public blockquoteST newblockquote() {
      return new blockquoteST(stGroup);
   }

   public bodyST newbody() {
      return new bodyST(stGroup);
   }

   public brST newbr() {
      return new brST(stGroup);
   }

   public buttonST newbutton() {
      return new buttonST(stGroup);
   }

   public canvasST newcanvas() {
      return new canvasST(stGroup);
   }

   public captionST newcaption() {
      return new captionST(stGroup);
   }

   public centerST newcenter() {
      return new centerST(stGroup);
   }

   public citeST newcite() {
      return new citeST(stGroup);
   }

   public codeST newcode() {
      return new codeST(stGroup);
   }

   public colST newcol() {
      return new colST(stGroup);
   }

   public colgroupST newcolgroup() {
      return new colgroupST(stGroup);
   }

   public commentST newcomment() {
      return new commentST(stGroup);
   }

   public datalistST newdatalist() {
      return new datalistST(stGroup);
   }

   public ddST newdd() {
      return new ddST(stGroup);
   }

   public delST newdel() {
      return new delST(stGroup);
   }

   public detailsST newdetails() {
      return new detailsST(stGroup);
   }

   public dfnST newdfn() {
      return new dfnST(stGroup);
   }

   public dialogST newdialog() {
      return new dialogST(stGroup);
   }

   public dirST newdir() {
      return new dirST(stGroup);
   }

   public divST newdiv() {
      return new divST(stGroup);
   }

   public dlST newdl() {
      return new dlST(stGroup);
   }

   public dtST newdt() {
      return new dtST(stGroup);
   }

   public emST newem() {
      return new emST(stGroup);
   }

   public embedST newembed() {
      return new embedST(stGroup);
   }

   public fieldsetST newfieldset() {
      return new fieldsetST(stGroup);
   }

   public figcaptionST newfigcaption() {
      return new figcaptionST(stGroup);
   }

   public figureST newfigure() {
      return new figureST(stGroup);
   }

   public fontST newfont() {
      return new fontST(stGroup);
   }

   public footerST newfooter() {
      return new footerST(stGroup);
   }

   public formST newform() {
      return new formST(stGroup);
   }

   public frameST newframe() {
      return new frameST(stGroup);
   }

   public framesetST newframeset() {
      return new framesetST(stGroup);
   }

   public h1ST newh1() {
      return new h1ST(stGroup);
   }

   public h2ST newh2() {
      return new h2ST(stGroup);
   }

   public h3ST newh3() {
      return new h3ST(stGroup);
   }

   public h4ST newh4() {
      return new h4ST(stGroup);
   }

   public h5ST newh5() {
      return new h5ST(stGroup);
   }

   public h6ST newh6() {
      return new h6ST(stGroup);
   }

   public headST newhead() {
      return new headST(stGroup);
   }

   public headerST newheader() {
      return new headerST(stGroup);
   }

   public hgroupST newhgroup() {
      return new hgroupST(stGroup);
   }

   public hrST newhr() {
      return new hrST(stGroup);
   }

   public iST newi() {
      return new iST(stGroup);
   }

   public iframeST newiframe() {
      return new iframeST(stGroup);
   }

   public imgST newimg() {
      return new imgST(stGroup);
   }

   public inputST newinput() {
      return new inputST(stGroup);
   }

   public insST newins() {
      return new insST(stGroup);
   }

   public kbdST newkbd() {
      return new kbdST(stGroup);
   }

   public keygenST newkeygen() {
      return new keygenST(stGroup);
   }

   public labelST newlabel() {
      return new labelST(stGroup);
   }

   public legendST newlegend() {
      return new legendST(stGroup);
   }

   public liST newli() {
      return new liST(stGroup);
   }

   public linkST newlink() {
      return new linkST(stGroup);
   }

   public mainST newmain() {
      return new mainST(stGroup);
   }

   public mapST newmap() {
      return new mapST(stGroup);
   }

   public markST newmark() {
      return new markST(stGroup);
   }

   public menuST newmenu() {
      return new menuST(stGroup);
   }

   public menuitemST newmenuitem() {
      return new menuitemST(stGroup);
   }

   public metaST newmeta() {
      return new metaST(stGroup);
   }

   public meterST newmeter() {
      return new meterST(stGroup);
   }

   public mimeJsonST newmimeJson() {
      return new mimeJsonST(stGroup);
   }

   public navST newnav() {
      return new navST(stGroup);
   }

   public noframesST newnoframes() {
      return new noframesST(stGroup);
   }

   public noscriptST newnoscript() {
      return new noscriptST(stGroup);
   }

   public objectST newobject() {
      return new objectST(stGroup);
   }

   public olST newol() {
      return new olST(stGroup);
   }

   public optgroupST newoptgroup() {
      return new optgroupST(stGroup);
   }

   public optionST newoption() {
      return new optionST(stGroup);
   }

   public outputST newoutput() {
      return new outputST(stGroup);
   }

   public pST newp() {
      return new pST(stGroup);
   }

   public pageST newpage() {
      return new pageST(stGroup);
   }

   public paramST newparam() {
      return new paramST(stGroup);
   }

   public preST newpre() {
      return new preST(stGroup);
   }

   public progressST newprogress() {
      return new progressST(stGroup);
   }

   public qST newq() {
      return new qST(stGroup);
   }

   public rpST newrp() {
      return new rpST(stGroup);
   }

   public rtST newrt() {
      return new rtST(stGroup);
   }

   public rubyST newruby() {
      return new rubyST(stGroup);
   }

   public sST news() {
      return new sST(stGroup);
   }

   public sampST newsamp() {
      return new sampST(stGroup);
   }

   public scriptST newscript() {
      return new scriptST(stGroup);
   }

   public sectionST newsection() {
      return new sectionST(stGroup);
   }

   public selectST newselect() {
      return new selectST(stGroup);
   }

   public smallST newsmall() {
      return new smallST(stGroup);
   }

   public sourceST newsource() {
      return new sourceST(stGroup);
   }

   public spanST newspan() {
      return new spanST(stGroup);
   }

   public strikeST newstrike() {
      return new strikeST(stGroup);
   }

   public strongST newstrong() {
      return new strongST(stGroup);
   }

   public styleST newstyle() {
      return new styleST(stGroup);
   }

   public subST newsub() {
      return new subST(stGroup);
   }

   public summaryST newsummary() {
      return new summaryST(stGroup);
   }

   public supST newsup() {
      return new supST(stGroup);
   }

   public tableST newtable() {
      return new tableST(stGroup);
   }

   public tbodyST newtbody() {
      return new tbodyST(stGroup);
   }

   public tdST newtd() {
      return new tdST(stGroup);
   }

   public textareaST newtextarea() {
      return new textareaST(stGroup);
   }

   public tfootST newtfoot() {
      return new tfootST(stGroup);
   }

   public thST newth() {
      return new thST(stGroup);
   }

   public theadST newthead() {
      return new theadST(stGroup);
   }

   public timeST newtime() {
      return new timeST(stGroup);
   }

   public titleST newtitle() {
      return new titleST(stGroup);
   }

   public trST newtr() {
      return new trST(stGroup);
   }

   public trackST newtrack() {
      return new trackST(stGroup);
   }

   public ttST newtt() {
      return new ttST(stGroup);
   }

   public uST newu() {
      return new uST(stGroup);
   }

   public ulST newul() {
      return new ulST(stGroup);
   }

   public varST newvar() {
      return new varST(stGroup);
   }

   public videoST newvideo() {
      return new videoST(stGroup);
   }

   public wbrST newwbr() {
      return new wbrST(stGroup);
   }

   public final class eomST implements Html5DomainGroupTemplate {

      private final ST template;

      private eomST(STGroup group) {
   		template = group.getInstanceOf("eom");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class gtST implements Html5DomainGroupTemplate {

      private final ST template;

      private gtST(STGroup group) {
   		template = group.getInstanceOf("gt");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class aST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean downloadIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hrefIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hreflangIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean mediaIsSet = new AtomicBoolean(false);
      private final AtomicBoolean relIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean targetIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private aST(STGroup group) {
   		template = group.getInstanceOf("a");
   	}

      public aST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public aST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public aST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public aST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public aST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public aST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public aST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public aST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public aST setDownload(Object value) {
      	tryToSetStringProperty(template, value, downloadIsSet, "download");   
         return this;
      }
      public aST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public aST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public aST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public aST setHref(Object value) {
      	tryToSetStringProperty(template, value, hrefIsSet, "href");   
         return this;
      }
      public aST setHreflang(Object value) {
      	tryToSetStringProperty(template, value, hreflangIsSet, "hreflang");   
         return this;
      }
      public aST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public aST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public aST setMedia(Object value) {
      	tryToSetStringProperty(template, value, mediaIsSet, "media");   
         return this;
      }
      public aST setRel(Object value) {
      	tryToSetStringProperty(template, value, relIsSet, "rel");   
         return this;
      }
      public aST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public aST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public aST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public aST setTarget(Object value) {
      	tryToSetStringProperty(template, value, targetIsSet, "target");   
         return this;
      }
      public aST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public aST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public aST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class abbrST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private abbrST(STGroup group) {
   		template = group.getInstanceOf("abbr");
   	}

      public abbrST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public abbrST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public abbrST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public abbrST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public abbrST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public abbrST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public abbrST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public abbrST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public abbrST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public abbrST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public abbrST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public abbrST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public abbrST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public abbrST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public abbrST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public abbrST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public abbrST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public abbrST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class acronymST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private acronymST(STGroup group) {
   		template = group.getInstanceOf("acronym");
   	}

      public acronymST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public acronymST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public acronymST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public acronymST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public acronymST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public acronymST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public acronymST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public acronymST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public acronymST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public acronymST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public acronymST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public acronymST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public acronymST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public acronymST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public acronymST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public acronymST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public acronymST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public acronymST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class addressST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private addressST(STGroup group) {
   		template = group.getInstanceOf("address");
   	}

      public addressST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public addressST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public addressST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public addressST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public addressST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public addressST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public addressST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public addressST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public addressST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public addressST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public addressST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public addressST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public addressST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public addressST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public addressST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public addressST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public addressST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public addressST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class appletST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean alignIsSet = new AtomicBoolean(false);
      private final AtomicBoolean altIsSet = new AtomicBoolean(false);
      private final AtomicBoolean archiveIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean codeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean codebaseIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean heightIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hspaceIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean objectIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean vspaceIsSet = new AtomicBoolean(false);
      private final AtomicBoolean widthIsSet = new AtomicBoolean(false);
      private final ST template;

      private appletST(STGroup group) {
   		template = group.getInstanceOf("applet");
   	}

      public appletST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public appletST setAlign(Object value) {
      	tryToSetStringProperty(template, value, alignIsSet, "align");   
         return this;
      }
      public appletST setAlt(Object value) {
      	tryToSetStringProperty(template, value, altIsSet, "alt");   
         return this;
      }
      public appletST setArchive(Object value) {
      	tryToSetStringProperty(template, value, archiveIsSet, "archive");   
         return this;
      }
      public appletST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public appletST setCode(Object value) {
      	tryToSetStringProperty(template, value, codeIsSet, "code");   
         return this;
      }
      public appletST setCodebase(Object value) {
      	tryToSetStringProperty(template, value, codebaseIsSet, "codebase");   
         return this;
      }
      public appletST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public appletST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public appletST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public appletST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public appletST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public appletST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public appletST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public appletST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public appletST setHeight(Object value) {
      	tryToSetStringProperty(template, value, heightIsSet, "height");   
         return this;
      }
      public appletST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public appletST setHspace(Object value) {
      	tryToSetStringProperty(template, value, hspaceIsSet, "hspace");   
         return this;
      }
      public appletST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public appletST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public appletST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public appletST setObject(Object value) {
      	tryToSetStringProperty(template, value, objectIsSet, "object");   
         return this;
      }
      public appletST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public appletST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public appletST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public appletST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public appletST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public appletST setVspace(Object value) {
      	tryToSetStringProperty(template, value, vspaceIsSet, "vspace");   
         return this;
      }
      public appletST setWidth(Object value) {
      	tryToSetStringProperty(template, value, widthIsSet, "width");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class areaST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean altIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean coordsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean downloadIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hrefIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hreflangIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean mediaIsSet = new AtomicBoolean(false);
      private final AtomicBoolean relIsSet = new AtomicBoolean(false);
      private final AtomicBoolean shapeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean targetIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private areaST(STGroup group) {
   		template = group.getInstanceOf("area");
   	}

      public areaST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public areaST setAlt(Object value) {
      	tryToSetStringProperty(template, value, altIsSet, "alt");   
         return this;
      }
      public areaST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public areaST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public areaST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public areaST setCoords(Object value) {
      	tryToSetStringProperty(template, value, coordsIsSet, "coords");   
         return this;
      }
      public areaST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public areaST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public areaST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public areaST setDownload(Object value) {
      	tryToSetStringProperty(template, value, downloadIsSet, "download");   
         return this;
      }
      public areaST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public areaST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public areaST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public areaST setHref(Object value) {
      	tryToSetStringProperty(template, value, hrefIsSet, "href");   
         return this;
      }
      public areaST setHreflang(Object value) {
      	tryToSetStringProperty(template, value, hreflangIsSet, "hreflang");   
         return this;
      }
      public areaST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public areaST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public areaST setMedia(Object value) {
      	tryToSetStringProperty(template, value, mediaIsSet, "media");   
         return this;
      }
      public areaST setRel(Object value) {
      	tryToSetStringProperty(template, value, relIsSet, "rel");   
         return this;
      }
      public areaST setShape(Object value) {
      	tryToSetStringProperty(template, value, shapeIsSet, "shape");   
         return this;
      }
      public areaST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public areaST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public areaST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public areaST setTarget(Object value) {
      	tryToSetStringProperty(template, value, targetIsSet, "target");   
         return this;
      }
      public areaST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public areaST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public areaST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class articleST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private articleST(STGroup group) {
   		template = group.getInstanceOf("article");
   	}

      public articleST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public articleST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public articleST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public articleST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public articleST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public articleST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public articleST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public articleST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public articleST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public articleST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public articleST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public articleST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public articleST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public articleST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public articleST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public articleST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public articleST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public articleST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class asideST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private asideST(STGroup group) {
   		template = group.getInstanceOf("aside");
   	}

      public asideST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public asideST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public asideST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public asideST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public asideST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public asideST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public asideST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public asideST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public asideST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public asideST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public asideST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public asideST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public asideST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public asideST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public asideST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public asideST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public asideST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public asideST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class audioST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean autoplayIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean controlsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean loopIsSet = new AtomicBoolean(false);
      private final AtomicBoolean mutedIsSet = new AtomicBoolean(false);
      private final AtomicBoolean preloadIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean srcIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private audioST(STGroup group) {
   		template = group.getInstanceOf("audio");
   	}

      public audioST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public audioST setAutoplay(Object value) {
      	tryToSetStringProperty(template, value, autoplayIsSet, "autoplay");   
         return this;
      }
      public audioST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public audioST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public audioST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public audioST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public audioST setControls(Object value) {
      	tryToSetStringProperty(template, value, controlsIsSet, "controls");   
         return this;
      }
      public audioST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public audioST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public audioST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public audioST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public audioST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public audioST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public audioST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public audioST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public audioST setLoop(Object value) {
      	tryToSetStringProperty(template, value, loopIsSet, "loop");   
         return this;
      }
      public audioST setMuted(Object value) {
      	tryToSetStringProperty(template, value, mutedIsSet, "muted");   
         return this;
      }
      public audioST setPreload(Object value) {
      	tryToSetStringProperty(template, value, preloadIsSet, "preload");   
         return this;
      }
      public audioST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public audioST setSrc(Object value) {
      	tryToSetStringProperty(template, value, srcIsSet, "src");   
         return this;
      }
      public audioST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public audioST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public audioST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public audioST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class bST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private bST(STGroup group) {
   		template = group.getInstanceOf("b");
   	}

      public bST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public bST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public bST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public bST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public bST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public bST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public bST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public bST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public bST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public bST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public bST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public bST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public bST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public bST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public bST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public bST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public bST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public bST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class baseST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hrefIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean targetIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private baseST(STGroup group) {
   		template = group.getInstanceOf("base");
   	}

      public baseST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public baseST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public baseST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public baseST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public baseST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public baseST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public baseST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public baseST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public baseST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public baseST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public baseST setHref(Object value) {
      	tryToSetStringProperty(template, value, hrefIsSet, "href");   
         return this;
      }
      public baseST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public baseST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public baseST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public baseST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public baseST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public baseST setTarget(Object value) {
      	tryToSetStringProperty(template, value, targetIsSet, "target");   
         return this;
      }
      public baseST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public baseST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class basefontST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private basefontST(STGroup group) {
   		template = group.getInstanceOf("basefont");
   	}

      public basefontST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public basefontST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public basefontST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public basefontST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public basefontST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public basefontST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public basefontST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public basefontST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public basefontST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public basefontST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public basefontST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public basefontST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public basefontST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public basefontST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public basefontST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public basefontST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public basefontST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public basefontST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class bdiST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private bdiST(STGroup group) {
   		template = group.getInstanceOf("bdi");
   	}

      public bdiST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public bdiST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public bdiST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public bdiST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public bdiST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public bdiST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public bdiST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public bdiST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public bdiST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public bdiST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public bdiST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public bdiST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public bdiST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public bdiST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public bdiST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public bdiST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public bdiST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public bdiST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class bdoST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private bdoST(STGroup group) {
   		template = group.getInstanceOf("bdo");
   	}

      public bdoST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public bdoST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public bdoST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public bdoST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public bdoST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public bdoST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public bdoST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public bdoST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public bdoST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public bdoST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public bdoST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public bdoST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public bdoST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public bdoST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public bdoST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public bdoST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public bdoST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public bdoST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class bigST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private bigST(STGroup group) {
   		template = group.getInstanceOf("big");
   	}

      public bigST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public bigST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public bigST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public bigST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public bigST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public bigST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public bigST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public bigST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public bigST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public bigST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public bigST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public bigST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public bigST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public bigST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public bigST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public bigST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public bigST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public bigST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class blockST implements Html5DomainGroupTemplate {

      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final ST template;

      private blockST(STGroup group) {
   		template = group.getInstanceOf("block");
   	}

      public blockST addContentValue(Object value) {
      	tryToSetListProperty(template, value, contentIsSet, "content");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class blockquoteST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean citeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private blockquoteST(STGroup group) {
   		template = group.getInstanceOf("blockquote");
   	}

      public blockquoteST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public blockquoteST setCite(Object value) {
      	tryToSetStringProperty(template, value, citeIsSet, "cite");   
         return this;
      }
      public blockquoteST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public blockquoteST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public blockquoteST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public blockquoteST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public blockquoteST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public blockquoteST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public blockquoteST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public blockquoteST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public blockquoteST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public blockquoteST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public blockquoteST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public blockquoteST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public blockquoteST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public blockquoteST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public blockquoteST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public blockquoteST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public blockquoteST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class bodyST implements Html5DomainGroupTemplate {

      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final ST template;

      private bodyST(STGroup group) {
   		template = group.getInstanceOf("body");
   	}

      public bodyST addContentValue(Object value) {
      	tryToSetListProperty(template, value, contentIsSet, "content");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class brST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private brST(STGroup group) {
   		template = group.getInstanceOf("br");
   	}

      public brST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public brST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public brST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public brST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public brST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public brST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public brST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public brST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public brST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public brST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public brST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public brST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public brST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public brST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public brST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public brST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public brST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class buttonST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean autofocusIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean disabledIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formactionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formenctypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formmethodIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formnovalidateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formtargetIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private buttonST(STGroup group) {
   		template = group.getInstanceOf("button");
   	}

      public buttonST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public buttonST setAutofocus(Object value) {
      	tryToSetStringProperty(template, value, autofocusIsSet, "autofocus");   
         return this;
      }
      public buttonST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public buttonST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public buttonST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public buttonST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public buttonST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public buttonST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public buttonST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public buttonST setDisabled(Object value) {
      	tryToSetStringProperty(template, value, disabledIsSet, "disabled");   
         return this;
      }
      public buttonST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public buttonST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public buttonST setForm(Object value) {
      	tryToSetStringProperty(template, value, formIsSet, "form");   
         return this;
      }
      public buttonST setFormaction(Object value) {
      	tryToSetStringProperty(template, value, formactionIsSet, "formaction");   
         return this;
      }
      public buttonST setFormenctype(Object value) {
      	tryToSetStringProperty(template, value, formenctypeIsSet, "formenctype");   
         return this;
      }
      public buttonST setFormmethod(Object value) {
      	tryToSetStringProperty(template, value, formmethodIsSet, "formmethod");   
         return this;
      }
      public buttonST setFormnovalidate(Object value) {
      	tryToSetStringProperty(template, value, formnovalidateIsSet, "formnovalidate");   
         return this;
      }
      public buttonST setFormtarget(Object value) {
      	tryToSetStringProperty(template, value, formtargetIsSet, "formtarget");   
         return this;
      }
      public buttonST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public buttonST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public buttonST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public buttonST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public buttonST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public buttonST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public buttonST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public buttonST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public buttonST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public buttonST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      }
      public buttonST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class canvasST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean heightIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean widthIsSet = new AtomicBoolean(false);
      private final ST template;

      private canvasST(STGroup group) {
   		template = group.getInstanceOf("canvas");
   	}

      public canvasST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public canvasST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public canvasST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public canvasST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public canvasST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public canvasST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public canvasST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public canvasST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public canvasST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public canvasST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public canvasST setHeight(Object value) {
      	tryToSetStringProperty(template, value, heightIsSet, "height");   
         return this;
      }
      public canvasST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public canvasST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public canvasST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public canvasST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public canvasST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public canvasST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public canvasST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public canvasST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public canvasST setWidth(Object value) {
      	tryToSetStringProperty(template, value, widthIsSet, "width");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class captionST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private captionST(STGroup group) {
   		template = group.getInstanceOf("caption");
   	}

      public captionST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public captionST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public captionST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public captionST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public captionST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public captionST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public captionST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public captionST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public captionST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public captionST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public captionST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public captionST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public captionST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public captionST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public captionST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public captionST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public captionST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public captionST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class centerST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private centerST(STGroup group) {
   		template = group.getInstanceOf("center");
   	}

      public centerST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public centerST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public centerST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public centerST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public centerST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public centerST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public centerST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public centerST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public centerST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public centerST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public centerST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public centerST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public centerST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public centerST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public centerST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public centerST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public centerST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public centerST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class citeST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private citeST(STGroup group) {
   		template = group.getInstanceOf("cite");
   	}

      public citeST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public citeST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public citeST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public citeST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public citeST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public citeST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public citeST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public citeST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public citeST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public citeST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public citeST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public citeST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public citeST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public citeST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public citeST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public citeST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public citeST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public citeST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class codeST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private codeST(STGroup group) {
   		template = group.getInstanceOf("code");
   	}

      public codeST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public codeST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public codeST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public codeST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public codeST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public codeST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public codeST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public codeST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public codeST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public codeST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public codeST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public codeST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public codeST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public codeST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public codeST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public codeST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public codeST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public codeST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class colST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spanIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private colST(STGroup group) {
   		template = group.getInstanceOf("col");
   	}

      public colST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public colST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public colST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public colST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public colST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public colST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public colST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public colST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public colST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public colST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public colST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public colST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public colST setSpan(Object value) {
      	tryToSetStringProperty(template, value, spanIsSet, "span");   
         return this;
      }
      public colST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public colST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public colST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public colST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public colST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class colgroupST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spanIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private colgroupST(STGroup group) {
   		template = group.getInstanceOf("colgroup");
   	}

      public colgroupST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public colgroupST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public colgroupST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public colgroupST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public colgroupST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public colgroupST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public colgroupST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public colgroupST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public colgroupST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public colgroupST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public colgroupST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public colgroupST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public colgroupST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public colgroupST setSpan(Object value) {
      	tryToSetStringProperty(template, value, spanIsSet, "span");   
         return this;
      }
      public colgroupST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public colgroupST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public colgroupST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public colgroupST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public colgroupST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class commentST implements Html5DomainGroupTemplate {

      private final AtomicBoolean commentIsSet = new AtomicBoolean(false);
      private final ST template;

      private commentST(STGroup group) {
   		template = group.getInstanceOf("comment");
   	}

      public commentST setComment(Object value) {
      	tryToSetStringProperty(template, value, commentIsSet, "comment");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class datalistST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private datalistST(STGroup group) {
   		template = group.getInstanceOf("datalist");
   	}

      public datalistST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public datalistST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public datalistST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public datalistST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public datalistST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public datalistST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public datalistST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public datalistST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public datalistST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public datalistST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public datalistST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public datalistST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public datalistST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public datalistST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public datalistST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public datalistST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public datalistST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public datalistST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class ddST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private ddST(STGroup group) {
   		template = group.getInstanceOf("dd");
   	}

      public ddST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public ddST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public ddST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public ddST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public ddST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public ddST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public ddST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public ddST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public ddST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public ddST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public ddST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public ddST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public ddST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public ddST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public ddST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public ddST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public ddST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public ddST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class delST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean citeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean datetimeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private delST(STGroup group) {
   		template = group.getInstanceOf("del");
   	}

      public delST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public delST setCite(Object value) {
      	tryToSetStringProperty(template, value, citeIsSet, "cite");   
         return this;
      }
      public delST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public delST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public delST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public delST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public delST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public delST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public delST setDatetime(Object value) {
      	tryToSetStringProperty(template, value, datetimeIsSet, "datetime");   
         return this;
      }
      public delST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public delST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public delST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public delST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public delST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public delST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public delST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public delST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public delST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public delST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public delST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class detailsST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean openIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private detailsST(STGroup group) {
   		template = group.getInstanceOf("details");
   	}

      public detailsST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public detailsST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public detailsST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public detailsST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public detailsST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public detailsST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public detailsST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public detailsST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public detailsST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public detailsST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public detailsST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public detailsST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public detailsST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public detailsST setOpen(Object value) {
      	tryToSetStringProperty(template, value, openIsSet, "open");   
         return this;
      }
      public detailsST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public detailsST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public detailsST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public detailsST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public detailsST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class dfnST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private dfnST(STGroup group) {
   		template = group.getInstanceOf("dfn");
   	}

      public dfnST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public dfnST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public dfnST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public dfnST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public dfnST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public dfnST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public dfnST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public dfnST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public dfnST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public dfnST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public dfnST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public dfnST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public dfnST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public dfnST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public dfnST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public dfnST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public dfnST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public dfnST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class dialogST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean openIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private dialogST(STGroup group) {
   		template = group.getInstanceOf("dialog");
   	}

      public dialogST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public dialogST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public dialogST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public dialogST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public dialogST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public dialogST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public dialogST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public dialogST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public dialogST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public dialogST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public dialogST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public dialogST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public dialogST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public dialogST setOpen(Object value) {
      	tryToSetStringProperty(template, value, openIsSet, "open");   
         return this;
      }
      public dialogST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public dialogST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public dialogST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public dialogST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public dialogST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class dirST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private dirST(STGroup group) {
   		template = group.getInstanceOf("dir");
   	}

      public dirST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public dirST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public dirST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public dirST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public dirST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public dirST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public dirST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public dirST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public dirST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public dirST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public dirST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public dirST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public dirST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public dirST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public dirST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public dirST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public dirST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public dirST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class divST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private divST(STGroup group) {
   		template = group.getInstanceOf("div");
   	}

      public divST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public divST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public divST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public divST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public divST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public divST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public divST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public divST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public divST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public divST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public divST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public divST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public divST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public divST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public divST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public divST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public divST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public divST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class dlST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private dlST(STGroup group) {
   		template = group.getInstanceOf("dl");
   	}

      public dlST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public dlST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public dlST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public dlST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public dlST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public dlST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public dlST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public dlST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public dlST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public dlST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public dlST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public dlST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public dlST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public dlST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public dlST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public dlST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public dlST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public dlST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class dtST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private dtST(STGroup group) {
   		template = group.getInstanceOf("dt");
   	}

      public dtST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public dtST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public dtST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public dtST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public dtST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public dtST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public dtST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public dtST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public dtST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public dtST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public dtST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public dtST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public dtST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public dtST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public dtST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public dtST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public dtST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public dtST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class emST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private emST(STGroup group) {
   		template = group.getInstanceOf("em");
   	}

      public emST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public emST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public emST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public emST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public emST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public emST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public emST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public emST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public emST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public emST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public emST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public emST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public emST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public emST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public emST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public emST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public emST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public emST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class embedST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean heightIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean srcIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean widthIsSet = new AtomicBoolean(false);
      private final ST template;

      private embedST(STGroup group) {
   		template = group.getInstanceOf("embed");
   	}

      public embedST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public embedST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public embedST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public embedST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public embedST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public embedST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public embedST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public embedST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public embedST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public embedST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public embedST setHeight(Object value) {
      	tryToSetStringProperty(template, value, heightIsSet, "height");   
         return this;
      }
      public embedST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public embedST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public embedST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public embedST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public embedST setSrc(Object value) {
      	tryToSetStringProperty(template, value, srcIsSet, "src");   
         return this;
      }
      public embedST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public embedST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public embedST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public embedST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public embedST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      }
      public embedST setWidth(Object value) {
      	tryToSetStringProperty(template, value, widthIsSet, "width");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class fieldsetST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean disabledIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private fieldsetST(STGroup group) {
   		template = group.getInstanceOf("fieldset");
   	}

      public fieldsetST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public fieldsetST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public fieldsetST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public fieldsetST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public fieldsetST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public fieldsetST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public fieldsetST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public fieldsetST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public fieldsetST setDisabled(Object value) {
      	tryToSetStringProperty(template, value, disabledIsSet, "disabled");   
         return this;
      }
      public fieldsetST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public fieldsetST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public fieldsetST setForm(Object value) {
      	tryToSetStringProperty(template, value, formIsSet, "form");   
         return this;
      }
      public fieldsetST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public fieldsetST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public fieldsetST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public fieldsetST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public fieldsetST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public fieldsetST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public fieldsetST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public fieldsetST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public fieldsetST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class figcaptionST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private figcaptionST(STGroup group) {
   		template = group.getInstanceOf("figcaption");
   	}

      public figcaptionST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public figcaptionST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public figcaptionST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public figcaptionST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public figcaptionST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public figcaptionST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public figcaptionST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public figcaptionST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public figcaptionST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public figcaptionST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public figcaptionST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public figcaptionST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public figcaptionST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public figcaptionST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public figcaptionST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public figcaptionST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public figcaptionST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public figcaptionST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class figureST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private figureST(STGroup group) {
   		template = group.getInstanceOf("figure");
   	}

      public figureST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public figureST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public figureST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public figureST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public figureST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public figureST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public figureST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public figureST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public figureST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public figureST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public figureST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public figureST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public figureST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public figureST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public figureST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public figureST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public figureST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public figureST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class fontST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private fontST(STGroup group) {
   		template = group.getInstanceOf("font");
   	}

      public fontST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public fontST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public fontST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public fontST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public fontST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public fontST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public fontST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public fontST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public fontST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public fontST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public fontST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public fontST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public fontST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public fontST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public fontST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public fontST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public fontST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public fontST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class footerST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private footerST(STGroup group) {
   		template = group.getInstanceOf("footer");
   	}

      public footerST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public footerST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public footerST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public footerST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public footerST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public footerST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public footerST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public footerST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public footerST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public footerST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public footerST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public footerST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public footerST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public footerST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public footerST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public footerST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public footerST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public footerST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class formST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accept_charsetIsSet = new AtomicBoolean(false);
      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean actionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean autocompleteIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean enctypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean methodIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean novalidateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean targetIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private formST(STGroup group) {
   		template = group.getInstanceOf("form");
   	}

      public formST setAccept_charset(Object value) {
      	tryToSetStringProperty(template, value, accept_charsetIsSet, "accept_charset");   
         return this;
      }
      public formST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public formST setAction(Object value) {
      	tryToSetStringProperty(template, value, actionIsSet, "action");   
         return this;
      }
      public formST setAutocomplete(Object value) {
      	tryToSetStringProperty(template, value, autocompleteIsSet, "autocomplete");   
         return this;
      }
      public formST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public formST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public formST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public formST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public formST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public formST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public formST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public formST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public formST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public formST setEnctype(Object value) {
      	tryToSetStringProperty(template, value, enctypeIsSet, "enctype");   
         return this;
      }
      public formST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public formST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public formST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public formST setMethod(Object value) {
      	tryToSetStringProperty(template, value, methodIsSet, "method");   
         return this;
      }
      public formST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public formST setNovalidate(Object value) {
      	tryToSetStringProperty(template, value, novalidateIsSet, "novalidate");   
         return this;
      }
      public formST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public formST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public formST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public formST setTarget(Object value) {
      	tryToSetStringProperty(template, value, targetIsSet, "target");   
         return this;
      }
      public formST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public formST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class frameST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private frameST(STGroup group) {
   		template = group.getInstanceOf("frame");
   	}

      public frameST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public frameST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public frameST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public frameST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public frameST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public frameST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public frameST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public frameST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public frameST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public frameST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public frameST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public frameST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public frameST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public frameST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public frameST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public frameST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public frameST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class framesetST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private framesetST(STGroup group) {
   		template = group.getInstanceOf("frameset");
   	}

      public framesetST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public framesetST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public framesetST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public framesetST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public framesetST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public framesetST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public framesetST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public framesetST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public framesetST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public framesetST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public framesetST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public framesetST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public framesetST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public framesetST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public framesetST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public framesetST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public framesetST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public framesetST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class h1ST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private h1ST(STGroup group) {
   		template = group.getInstanceOf("h1");
   	}

      public h1ST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public h1ST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public h1ST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public h1ST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public h1ST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public h1ST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public h1ST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public h1ST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public h1ST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public h1ST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public h1ST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public h1ST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public h1ST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public h1ST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public h1ST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public h1ST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public h1ST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public h1ST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class h2ST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private h2ST(STGroup group) {
   		template = group.getInstanceOf("h2");
   	}

      public h2ST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public h2ST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public h2ST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public h2ST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public h2ST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public h2ST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public h2ST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public h2ST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public h2ST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public h2ST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public h2ST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public h2ST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public h2ST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public h2ST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public h2ST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public h2ST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public h2ST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public h2ST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class h3ST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private h3ST(STGroup group) {
   		template = group.getInstanceOf("h3");
   	}

      public h3ST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public h3ST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public h3ST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public h3ST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public h3ST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public h3ST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public h3ST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public h3ST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public h3ST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public h3ST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public h3ST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public h3ST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public h3ST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public h3ST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public h3ST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public h3ST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public h3ST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public h3ST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class h4ST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private h4ST(STGroup group) {
   		template = group.getInstanceOf("h4");
   	}

      public h4ST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public h4ST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public h4ST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public h4ST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public h4ST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public h4ST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public h4ST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public h4ST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public h4ST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public h4ST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public h4ST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public h4ST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public h4ST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public h4ST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public h4ST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public h4ST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public h4ST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public h4ST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class h5ST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private h5ST(STGroup group) {
   		template = group.getInstanceOf("h5");
   	}

      public h5ST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public h5ST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public h5ST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public h5ST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public h5ST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public h5ST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public h5ST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public h5ST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public h5ST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public h5ST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public h5ST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public h5ST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public h5ST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public h5ST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public h5ST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public h5ST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public h5ST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public h5ST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class h6ST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private h6ST(STGroup group) {
   		template = group.getInstanceOf("h6");
   	}

      public h6ST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public h6ST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public h6ST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public h6ST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public h6ST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public h6ST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public h6ST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public h6ST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public h6ST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public h6ST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public h6ST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public h6ST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public h6ST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public h6ST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public h6ST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public h6ST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public h6ST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public h6ST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class headST implements Html5DomainGroupTemplate {

      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final ST template;

      private headST(STGroup group) {
   		template = group.getInstanceOf("head");
   	}

      public headST addContentValue(Object value) {
      	tryToSetListProperty(template, value, contentIsSet, "content");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class headerST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private headerST(STGroup group) {
   		template = group.getInstanceOf("header");
   	}

      public headerST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public headerST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public headerST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public headerST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public headerST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public headerST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public headerST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public headerST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public headerST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public headerST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public headerST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public headerST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public headerST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public headerST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public headerST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public headerST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public headerST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public headerST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class hgroupST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private hgroupST(STGroup group) {
   		template = group.getInstanceOf("hgroup");
   	}

      public hgroupST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public hgroupST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public hgroupST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public hgroupST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public hgroupST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public hgroupST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public hgroupST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public hgroupST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public hgroupST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public hgroupST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public hgroupST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public hgroupST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public hgroupST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public hgroupST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public hgroupST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public hgroupST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public hgroupST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public hgroupST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class hrST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private hrST(STGroup group) {
   		template = group.getInstanceOf("hr");
   	}

      public hrST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public hrST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public hrST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public hrST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public hrST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public hrST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public hrST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public hrST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public hrST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public hrST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public hrST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public hrST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public hrST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public hrST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public hrST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public hrST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public hrST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class iST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private iST(STGroup group) {
   		template = group.getInstanceOf("i");
   	}

      public iST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public iST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public iST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public iST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public iST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public iST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public iST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public iST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public iST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public iST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public iST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public iST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public iST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public iST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public iST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public iST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public iST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public iST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class iframeST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean heightIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean sandboxIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean srcIsSet = new AtomicBoolean(false);
      private final AtomicBoolean srcdocIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean widthIsSet = new AtomicBoolean(false);
      private final ST template;

      private iframeST(STGroup group) {
   		template = group.getInstanceOf("iframe");
   	}

      public iframeST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public iframeST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public iframeST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public iframeST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public iframeST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public iframeST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public iframeST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public iframeST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public iframeST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public iframeST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public iframeST setHeight(Object value) {
      	tryToSetStringProperty(template, value, heightIsSet, "height");   
         return this;
      }
      public iframeST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public iframeST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public iframeST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public iframeST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public iframeST setSandbox(Object value) {
      	tryToSetStringProperty(template, value, sandboxIsSet, "sandbox");   
         return this;
      }
      public iframeST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public iframeST setSrc(Object value) {
      	tryToSetStringProperty(template, value, srcIsSet, "src");   
         return this;
      }
      public iframeST setSrcdoc(Object value) {
      	tryToSetStringProperty(template, value, srcdocIsSet, "srcdoc");   
         return this;
      }
      public iframeST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public iframeST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public iframeST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public iframeST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public iframeST setWidth(Object value) {
      	tryToSetStringProperty(template, value, widthIsSet, "width");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class imgST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean altIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean crossoriginIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean heightIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean ismapIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean longdescIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean srcIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean usemapIsSet = new AtomicBoolean(false);
      private final AtomicBoolean widthIsSet = new AtomicBoolean(false);
      private final ST template;

      private imgST(STGroup group) {
   		template = group.getInstanceOf("img");
   	}

      public imgST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public imgST setAlt(Object value) {
      	tryToSetStringProperty(template, value, altIsSet, "alt");   
         return this;
      }
      public imgST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public imgST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public imgST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public imgST setCrossorigin(Object value) {
      	tryToSetStringProperty(template, value, crossoriginIsSet, "crossorigin");   
         return this;
      }
      public imgST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public imgST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public imgST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public imgST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public imgST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public imgST setHeight(Object value) {
      	tryToSetStringProperty(template, value, heightIsSet, "height");   
         return this;
      }
      public imgST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public imgST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public imgST setIsmap(Object value) {
      	tryToSetStringProperty(template, value, ismapIsSet, "ismap");   
         return this;
      }
      public imgST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public imgST setLongdesc(Object value) {
      	tryToSetStringProperty(template, value, longdescIsSet, "longdesc");   
         return this;
      }
      public imgST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public imgST setSrc(Object value) {
      	tryToSetStringProperty(template, value, srcIsSet, "src");   
         return this;
      }
      public imgST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public imgST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public imgST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public imgST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public imgST setUsemap(Object value) {
      	tryToSetStringProperty(template, value, usemapIsSet, "usemap");   
         return this;
      }
      public imgST setWidth(Object value) {
      	tryToSetStringProperty(template, value, widthIsSet, "width");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class inputST implements Html5DomainGroupTemplate {

      private final AtomicBoolean acceptIsSet = new AtomicBoolean(false);
      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean altIsSet = new AtomicBoolean(false);
      private final AtomicBoolean autocompleteIsSet = new AtomicBoolean(false);
      private final AtomicBoolean autofocusIsSet = new AtomicBoolean(false);
      private final AtomicBoolean checkedIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean disabledIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formactionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formenctypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formmethodIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formnovalidateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formtargetIsSet = new AtomicBoolean(false);
      private final AtomicBoolean heightIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean listIsSet = new AtomicBoolean(false);
      private final AtomicBoolean maxIsSet = new AtomicBoolean(false);
      private final AtomicBoolean maxlengthIsSet = new AtomicBoolean(false);
      private final AtomicBoolean minIsSet = new AtomicBoolean(false);
      private final AtomicBoolean multipleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean patternIsSet = new AtomicBoolean(false);
      private final AtomicBoolean placeholderIsSet = new AtomicBoolean(false);
      private final AtomicBoolean readonlyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean requiredIsSet = new AtomicBoolean(false);
      private final AtomicBoolean sizeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean srcIsSet = new AtomicBoolean(false);
      private final AtomicBoolean stepIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final AtomicBoolean widthIsSet = new AtomicBoolean(false);
      private final ST template;

      private inputST(STGroup group) {
   		template = group.getInstanceOf("input");
   	}

      public inputST setAccept(Object value) {
      	tryToSetStringProperty(template, value, acceptIsSet, "accept");   
         return this;
      }
      public inputST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public inputST setAlt(Object value) {
      	tryToSetStringProperty(template, value, altIsSet, "alt");   
         return this;
      }
      public inputST setAutocomplete(Object value) {
      	tryToSetStringProperty(template, value, autocompleteIsSet, "autocomplete");   
         return this;
      }
      public inputST setAutofocus(Object value) {
      	tryToSetStringProperty(template, value, autofocusIsSet, "autofocus");   
         return this;
      }
      public inputST setChecked(Object value) {
      	tryToSetStringProperty(template, value, checkedIsSet, "checked");   
         return this;
      }
      public inputST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public inputST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public inputST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public inputST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public inputST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public inputST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public inputST setDisabled(Object value) {
      	tryToSetStringProperty(template, value, disabledIsSet, "disabled");   
         return this;
      }
      public inputST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public inputST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public inputST setForm(Object value) {
      	tryToSetStringProperty(template, value, formIsSet, "form");   
         return this;
      }
      public inputST setFormaction(Object value) {
      	tryToSetStringProperty(template, value, formactionIsSet, "formaction");   
         return this;
      }
      public inputST setFormenctype(Object value) {
      	tryToSetStringProperty(template, value, formenctypeIsSet, "formenctype");   
         return this;
      }
      public inputST setFormmethod(Object value) {
      	tryToSetStringProperty(template, value, formmethodIsSet, "formmethod");   
         return this;
      }
      public inputST setFormnovalidate(Object value) {
      	tryToSetStringProperty(template, value, formnovalidateIsSet, "formnovalidate");   
         return this;
      }
      public inputST setFormtarget(Object value) {
      	tryToSetStringProperty(template, value, formtargetIsSet, "formtarget");   
         return this;
      }
      public inputST setHeight(Object value) {
      	tryToSetStringProperty(template, value, heightIsSet, "height");   
         return this;
      }
      public inputST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public inputST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public inputST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public inputST setList(Object value) {
      	tryToSetStringProperty(template, value, listIsSet, "list");   
         return this;
      }
      public inputST setMax(Object value) {
      	tryToSetStringProperty(template, value, maxIsSet, "max");   
         return this;
      }
      public inputST setMaxlength(Object value) {
      	tryToSetStringProperty(template, value, maxlengthIsSet, "maxlength");   
         return this;
      }
      public inputST setMin(Object value) {
      	tryToSetStringProperty(template, value, minIsSet, "min");   
         return this;
      }
      public inputST setMultiple(Object value) {
      	tryToSetStringProperty(template, value, multipleIsSet, "multiple");   
         return this;
      }
      public inputST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public inputST setPattern(Object value) {
      	tryToSetStringProperty(template, value, patternIsSet, "pattern");   
         return this;
      }
      public inputST setPlaceholder(Object value) {
      	tryToSetStringProperty(template, value, placeholderIsSet, "placeholder");   
         return this;
      }
      public inputST setReadonly(Object value) {
      	tryToSetStringProperty(template, value, readonlyIsSet, "readonly");   
         return this;
      }
      public inputST setRequired(Object value) {
      	tryToSetStringProperty(template, value, requiredIsSet, "required");   
         return this;
      }
      public inputST setSize(Object value) {
      	tryToSetStringProperty(template, value, sizeIsSet, "size");   
         return this;
      }
      public inputST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public inputST setSrc(Object value) {
      	tryToSetStringProperty(template, value, srcIsSet, "src");   
         return this;
      }
      public inputST setStep(Object value) {
      	tryToSetStringProperty(template, value, stepIsSet, "step");   
         return this;
      }
      public inputST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public inputST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public inputST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public inputST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public inputST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      }
      public inputST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      }
      public inputST setWidth(Object value) {
      	tryToSetStringProperty(template, value, widthIsSet, "width");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class insST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean citeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean datetimeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private insST(STGroup group) {
   		template = group.getInstanceOf("ins");
   	}

      public insST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public insST setCite(Object value) {
      	tryToSetStringProperty(template, value, citeIsSet, "cite");   
         return this;
      }
      public insST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public insST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public insST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public insST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public insST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public insST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public insST setDatetime(Object value) {
      	tryToSetStringProperty(template, value, datetimeIsSet, "datetime");   
         return this;
      }
      public insST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public insST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public insST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public insST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public insST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public insST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public insST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public insST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public insST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public insST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public insST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class kbdST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private kbdST(STGroup group) {
   		template = group.getInstanceOf("kbd");
   	}

      public kbdST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public kbdST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public kbdST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public kbdST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public kbdST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public kbdST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public kbdST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public kbdST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public kbdST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public kbdST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public kbdST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public kbdST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public kbdST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public kbdST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public kbdST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public kbdST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public kbdST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public kbdST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class keygenST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean autofocusIsSet = new AtomicBoolean(false);
      private final AtomicBoolean challengeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean disabledIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean keytypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private keygenST(STGroup group) {
   		template = group.getInstanceOf("keygen");
   	}

      public keygenST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public keygenST setAutofocus(Object value) {
      	tryToSetStringProperty(template, value, autofocusIsSet, "autofocus");   
         return this;
      }
      public keygenST setChallenge(Object value) {
      	tryToSetStringProperty(template, value, challengeIsSet, "challenge");   
         return this;
      }
      public keygenST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public keygenST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public keygenST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public keygenST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public keygenST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public keygenST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public keygenST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public keygenST setDisabled(Object value) {
      	tryToSetStringProperty(template, value, disabledIsSet, "disabled");   
         return this;
      }
      public keygenST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public keygenST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public keygenST setForm(Object value) {
      	tryToSetStringProperty(template, value, formIsSet, "form");   
         return this;
      }
      public keygenST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public keygenST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public keygenST setKeytype(Object value) {
      	tryToSetStringProperty(template, value, keytypeIsSet, "keytype");   
         return this;
      }
      public keygenST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public keygenST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public keygenST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public keygenST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public keygenST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public keygenST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public keygenST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class labelST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean forIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private labelST(STGroup group) {
   		template = group.getInstanceOf("label");
   	}

      public labelST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public labelST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public labelST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public labelST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public labelST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public labelST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public labelST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public labelST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public labelST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public labelST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public labelST setFor(Object value) {
      	tryToSetStringProperty(template, value, forIsSet, "for");   
         return this;
      }
      public labelST setForm(Object value) {
      	tryToSetStringProperty(template, value, formIsSet, "form");   
         return this;
      }
      public labelST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public labelST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public labelST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public labelST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public labelST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public labelST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public labelST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public labelST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class legendST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private legendST(STGroup group) {
   		template = group.getInstanceOf("legend");
   	}

      public legendST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public legendST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public legendST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public legendST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public legendST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public legendST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public legendST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public legendST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public legendST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public legendST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public legendST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public legendST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public legendST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public legendST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public legendST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public legendST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public legendST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public legendST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class liST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private liST(STGroup group) {
   		template = group.getInstanceOf("li");
   	}

      public liST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public liST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public liST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public liST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public liST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public liST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public liST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public liST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public liST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public liST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public liST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public liST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public liST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public liST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public liST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public liST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public liST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public liST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public liST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class linkST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean crossoriginIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hrefIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hreflangIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean mediaIsSet = new AtomicBoolean(false);
      private final AtomicBoolean relIsSet = new AtomicBoolean(false);
      private final AtomicBoolean sizesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private linkST(STGroup group) {
   		template = group.getInstanceOf("link");
   	}

      public linkST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public linkST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public linkST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public linkST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public linkST setCrossorigin(Object value) {
      	tryToSetStringProperty(template, value, crossoriginIsSet, "crossorigin");   
         return this;
      }
      public linkST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public linkST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public linkST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public linkST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public linkST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public linkST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public linkST setHref(Object value) {
      	tryToSetStringProperty(template, value, hrefIsSet, "href");   
         return this;
      }
      public linkST setHreflang(Object value) {
      	tryToSetStringProperty(template, value, hreflangIsSet, "hreflang");   
         return this;
      }
      public linkST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public linkST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public linkST setMedia(Object value) {
      	tryToSetStringProperty(template, value, mediaIsSet, "media");   
         return this;
      }
      public linkST setRel(Object value) {
      	tryToSetStringProperty(template, value, relIsSet, "rel");   
         return this;
      }
      public linkST setSizes(Object value) {
      	tryToSetStringProperty(template, value, sizesIsSet, "sizes");   
         return this;
      }
      public linkST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public linkST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public linkST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public linkST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public linkST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public linkST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class mainST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private mainST(STGroup group) {
   		template = group.getInstanceOf("main");
   	}

      public mainST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public mainST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public mainST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public mainST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public mainST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public mainST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public mainST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public mainST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public mainST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public mainST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public mainST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public mainST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public mainST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public mainST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public mainST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public mainST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public mainST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public mainST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class mapST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private mapST(STGroup group) {
   		template = group.getInstanceOf("map");
   	}

      public mapST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public mapST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public mapST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public mapST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public mapST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public mapST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public mapST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public mapST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public mapST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public mapST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public mapST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public mapST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public mapST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public mapST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public mapST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public mapST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public mapST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public mapST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public mapST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class markST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private markST(STGroup group) {
   		template = group.getInstanceOf("mark");
   	}

      public markST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public markST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public markST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public markST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public markST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public markST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public markST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public markST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public markST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public markST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public markST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public markST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public markST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public markST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public markST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public markST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public markST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public markST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class menuST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean labelIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private menuST(STGroup group) {
   		template = group.getInstanceOf("menu");
   	}

      public menuST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public menuST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public menuST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public menuST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public menuST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public menuST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public menuST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public menuST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public menuST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public menuST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public menuST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public menuST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public menuST setLabel(Object value) {
      	tryToSetStringProperty(template, value, labelIsSet, "label");   
         return this;
      }
      public menuST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public menuST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public menuST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public menuST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public menuST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public menuST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public menuST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class menuitemST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean checkedIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean commandIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean default_IsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean disabledIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean iconIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean labelIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean radiogroupIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private menuitemST(STGroup group) {
   		template = group.getInstanceOf("menuitem");
   	}

      public menuitemST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public menuitemST setChecked(Object value) {
      	tryToSetStringProperty(template, value, checkedIsSet, "checked");   
         return this;
      }
      public menuitemST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public menuitemST setCommand(Object value) {
      	tryToSetStringProperty(template, value, commandIsSet, "command");   
         return this;
      }
      public menuitemST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public menuitemST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public menuitemST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public menuitemST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public menuitemST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public menuitemST setDefault_(Object value) {
      	tryToSetStringProperty(template, value, default_IsSet, "default_");   
         return this;
      }
      public menuitemST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public menuitemST setDisabled(Object value) {
      	tryToSetStringProperty(template, value, disabledIsSet, "disabled");   
         return this;
      }
      public menuitemST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public menuitemST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public menuitemST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public menuitemST setIcon(Object value) {
      	tryToSetStringProperty(template, value, iconIsSet, "icon");   
         return this;
      }
      public menuitemST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public menuitemST setLabel(Object value) {
      	tryToSetStringProperty(template, value, labelIsSet, "label");   
         return this;
      }
      public menuitemST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public menuitemST setRadiogroup(Object value) {
      	tryToSetStringProperty(template, value, radiogroupIsSet, "radiogroup");   
         return this;
      }
      public menuitemST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public menuitemST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public menuitemST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public menuitemST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public menuitemST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public menuitemST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class metaST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean charsetIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean http_equivIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private metaST(STGroup group) {
   		template = group.getInstanceOf("meta");
   	}

      public metaST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public metaST setCharset(Object value) {
      	tryToSetStringProperty(template, value, charsetIsSet, "charset");   
         return this;
      }
      public metaST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public metaST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public metaST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public metaST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public metaST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public metaST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public metaST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public metaST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public metaST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public metaST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public metaST setHttp_equiv(Object value) {
      	tryToSetStringProperty(template, value, http_equivIsSet, "http_equiv");   
         return this;
      }
      public metaST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public metaST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public metaST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public metaST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public metaST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public metaST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public metaST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public metaST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class meterST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean highIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean lowIsSet = new AtomicBoolean(false);
      private final AtomicBoolean maxIsSet = new AtomicBoolean(false);
      private final AtomicBoolean minIsSet = new AtomicBoolean(false);
      private final AtomicBoolean optimumIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private meterST(STGroup group) {
   		template = group.getInstanceOf("meter");
   	}

      public meterST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public meterST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public meterST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public meterST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public meterST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public meterST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public meterST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public meterST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public meterST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public meterST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public meterST setForm(Object value) {
      	tryToSetStringProperty(template, value, formIsSet, "form");   
         return this;
      }
      public meterST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public meterST setHigh(Object value) {
      	tryToSetStringProperty(template, value, highIsSet, "high");   
         return this;
      }
      public meterST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public meterST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public meterST setLow(Object value) {
      	tryToSetStringProperty(template, value, lowIsSet, "low");   
         return this;
      }
      public meterST setMax(Object value) {
      	tryToSetStringProperty(template, value, maxIsSet, "max");   
         return this;
      }
      public meterST setMin(Object value) {
      	tryToSetStringProperty(template, value, minIsSet, "min");   
         return this;
      }
      public meterST setOptimum(Object value) {
      	tryToSetStringProperty(template, value, optimumIsSet, "optimum");   
         return this;
      }
      public meterST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public meterST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public meterST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public meterST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public meterST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public meterST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class mimeJsonST implements Html5DomainGroupTemplate {

      private final ST template;

      private mimeJsonST(STGroup group) {
   		template = group.getInstanceOf("mimeJson");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class navST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private navST(STGroup group) {
   		template = group.getInstanceOf("nav");
   	}

      public navST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public navST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public navST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public navST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public navST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public navST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public navST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public navST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public navST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public navST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public navST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public navST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public navST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public navST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public navST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public navST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public navST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public navST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class noframesST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private noframesST(STGroup group) {
   		template = group.getInstanceOf("noframes");
   	}

      public noframesST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public noframesST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public noframesST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public noframesST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public noframesST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public noframesST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public noframesST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public noframesST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public noframesST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public noframesST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public noframesST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public noframesST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public noframesST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public noframesST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public noframesST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public noframesST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public noframesST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public noframesST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class noscriptST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private noscriptST(STGroup group) {
   		template = group.getInstanceOf("noscript");
   	}

      public noscriptST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public noscriptST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public noscriptST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public noscriptST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public noscriptST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public noscriptST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public noscriptST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public noscriptST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public noscriptST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public noscriptST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public noscriptST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public noscriptST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public noscriptST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public noscriptST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public noscriptST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public noscriptST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public noscriptST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public noscriptST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class objectST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formIsSet = new AtomicBoolean(false);
      private final AtomicBoolean heightIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean usemapIsSet = new AtomicBoolean(false);
      private final AtomicBoolean widthIsSet = new AtomicBoolean(false);
      private final ST template;

      private objectST(STGroup group) {
   		template = group.getInstanceOf("object");
   	}

      public objectST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public objectST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public objectST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public objectST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public objectST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public objectST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public objectST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public objectST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public objectST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public objectST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public objectST setForm(Object value) {
      	tryToSetStringProperty(template, value, formIsSet, "form");   
         return this;
      }
      public objectST setHeight(Object value) {
      	tryToSetStringProperty(template, value, heightIsSet, "height");   
         return this;
      }
      public objectST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public objectST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public objectST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public objectST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public objectST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public objectST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public objectST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public objectST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public objectST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public objectST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      }
      public objectST setUsemap(Object value) {
      	tryToSetStringProperty(template, value, usemapIsSet, "usemap");   
         return this;
      }
      public objectST setWidth(Object value) {
      	tryToSetStringProperty(template, value, widthIsSet, "width");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class olST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean reversedIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean startIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private olST(STGroup group) {
   		template = group.getInstanceOf("ol");
   	}

      public olST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public olST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public olST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public olST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public olST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public olST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public olST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public olST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public olST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public olST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public olST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public olST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public olST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public olST setReversed(Object value) {
      	tryToSetStringProperty(template, value, reversedIsSet, "reversed");   
         return this;
      }
      public olST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public olST setStart(Object value) {
      	tryToSetStringProperty(template, value, startIsSet, "start");   
         return this;
      }
      public olST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public olST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public olST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public olST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public olST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class optgroupST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean disabledIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean labelIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private optgroupST(STGroup group) {
   		template = group.getInstanceOf("optgroup");
   	}

      public optgroupST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public optgroupST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public optgroupST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public optgroupST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public optgroupST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public optgroupST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public optgroupST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public optgroupST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public optgroupST setDisabled(Object value) {
      	tryToSetStringProperty(template, value, disabledIsSet, "disabled");   
         return this;
      }
      public optgroupST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public optgroupST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public optgroupST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public optgroupST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public optgroupST setLabel(Object value) {
      	tryToSetStringProperty(template, value, labelIsSet, "label");   
         return this;
      }
      public optgroupST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public optgroupST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public optgroupST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public optgroupST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public optgroupST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public optgroupST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class optionST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean disabledIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean labelIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean selectedIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private optionST(STGroup group) {
   		template = group.getInstanceOf("option");
   	}

      public optionST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public optionST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public optionST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public optionST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public optionST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public optionST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public optionST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public optionST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public optionST setDisabled(Object value) {
      	tryToSetStringProperty(template, value, disabledIsSet, "disabled");   
         return this;
      }
      public optionST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public optionST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public optionST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public optionST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public optionST setLabel(Object value) {
      	tryToSetStringProperty(template, value, labelIsSet, "label");   
         return this;
      }
      public optionST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public optionST setSelected(Object value) {
      	tryToSetStringProperty(template, value, selectedIsSet, "selected");   
         return this;
      }
      public optionST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public optionST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public optionST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public optionST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public optionST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public optionST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class outputST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean forIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private outputST(STGroup group) {
   		template = group.getInstanceOf("output");
   	}

      public outputST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public outputST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public outputST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public outputST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public outputST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public outputST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public outputST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public outputST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public outputST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public outputST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public outputST setFor(Object value) {
      	tryToSetStringProperty(template, value, forIsSet, "for");   
         return this;
      }
      public outputST setForm(Object value) {
      	tryToSetStringProperty(template, value, formIsSet, "form");   
         return this;
      }
      public outputST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public outputST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public outputST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public outputST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public outputST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public outputST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public outputST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public outputST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public outputST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class pST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private pST(STGroup group) {
   		template = group.getInstanceOf("p");
   	}

      public pST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public pST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public pST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public pST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public pST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public pST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public pST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public pST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public pST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public pST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public pST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public pST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public pST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public pST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public pST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public pST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public pST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public pST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class pageST implements Html5DomainGroupTemplate {

      private final AtomicBoolean bodyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean headIsSet = new AtomicBoolean(false);
      private final ST template;

      private pageST(STGroup group) {
   		template = group.getInstanceOf("page");
   	}

      public pageST setBody(Object value) {
      	tryToSetStringProperty(template, value, bodyIsSet, "body");   
         return this;
      }
      public pageST setHead(Object value) {
      	tryToSetStringProperty(template, value, headIsSet, "head");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class paramST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private paramST(STGroup group) {
   		template = group.getInstanceOf("param");
   	}

      public paramST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public paramST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public paramST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public paramST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public paramST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public paramST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public paramST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public paramST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public paramST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public paramST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public paramST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public paramST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public paramST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public paramST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public paramST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public paramST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public paramST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public paramST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public paramST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class preST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private preST(STGroup group) {
   		template = group.getInstanceOf("pre");
   	}

      public preST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public preST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public preST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public preST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public preST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public preST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public preST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public preST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public preST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public preST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public preST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public preST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public preST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public preST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public preST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public preST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public preST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public preST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class progressST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean maxIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private progressST(STGroup group) {
   		template = group.getInstanceOf("progress");
   	}

      public progressST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public progressST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public progressST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public progressST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public progressST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public progressST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public progressST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public progressST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public progressST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public progressST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public progressST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public progressST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public progressST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public progressST setMax(Object value) {
      	tryToSetStringProperty(template, value, maxIsSet, "max");   
         return this;
      }
      public progressST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public progressST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public progressST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public progressST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public progressST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public progressST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class qST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean citeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private qST(STGroup group) {
   		template = group.getInstanceOf("q");
   	}

      public qST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public qST setCite(Object value) {
      	tryToSetStringProperty(template, value, citeIsSet, "cite");   
         return this;
      }
      public qST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public qST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public qST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public qST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public qST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public qST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public qST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public qST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public qST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public qST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public qST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public qST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public qST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public qST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public qST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public qST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public qST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class rpST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private rpST(STGroup group) {
   		template = group.getInstanceOf("rp");
   	}

      public rpST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public rpST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public rpST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public rpST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public rpST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public rpST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public rpST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public rpST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public rpST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public rpST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public rpST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public rpST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public rpST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public rpST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public rpST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public rpST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public rpST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public rpST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class rtST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private rtST(STGroup group) {
   		template = group.getInstanceOf("rt");
   	}

      public rtST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public rtST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public rtST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public rtST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public rtST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public rtST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public rtST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public rtST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public rtST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public rtST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public rtST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public rtST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public rtST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public rtST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public rtST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public rtST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public rtST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public rtST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class rubyST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private rubyST(STGroup group) {
   		template = group.getInstanceOf("ruby");
   	}

      public rubyST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public rubyST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public rubyST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public rubyST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public rubyST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public rubyST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public rubyST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public rubyST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public rubyST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public rubyST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public rubyST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public rubyST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public rubyST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public rubyST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public rubyST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public rubyST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public rubyST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public rubyST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class sST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private sST(STGroup group) {
   		template = group.getInstanceOf("s");
   	}

      public sST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public sST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public sST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public sST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public sST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public sST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public sST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public sST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public sST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public sST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public sST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public sST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public sST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public sST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public sST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public sST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public sST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public sST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class sampST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private sampST(STGroup group) {
   		template = group.getInstanceOf("samp");
   	}

      public sampST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public sampST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public sampST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public sampST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public sampST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public sampST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public sampST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public sampST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public sampST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public sampST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public sampST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public sampST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public sampST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public sampST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public sampST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public sampST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public sampST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public sampST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class scriptST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean asyncIsSet = new AtomicBoolean(false);
      private final AtomicBoolean charsetIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean deferIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean srcIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private scriptST(STGroup group) {
   		template = group.getInstanceOf("script");
   	}

      public scriptST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public scriptST setAsync(Object value) {
      	tryToSetStringProperty(template, value, asyncIsSet, "async");   
         return this;
      }
      public scriptST setCharset(Object value) {
      	tryToSetStringProperty(template, value, charsetIsSet, "charset");   
         return this;
      }
      public scriptST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public scriptST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public scriptST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public scriptST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public scriptST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public scriptST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public scriptST setDefer(Object value) {
      	tryToSetStringProperty(template, value, deferIsSet, "defer");   
         return this;
      }
      public scriptST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public scriptST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public scriptST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public scriptST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public scriptST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public scriptST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public scriptST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public scriptST setSrc(Object value) {
      	tryToSetStringProperty(template, value, srcIsSet, "src");   
         return this;
      }
      public scriptST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public scriptST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public scriptST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public scriptST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public scriptST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class sectionST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private sectionST(STGroup group) {
   		template = group.getInstanceOf("section");
   	}

      public sectionST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public sectionST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public sectionST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public sectionST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public sectionST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public sectionST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public sectionST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public sectionST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public sectionST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public sectionST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public sectionST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public sectionST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public sectionST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public sectionST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public sectionST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public sectionST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public sectionST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public sectionST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class selectST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean autofocusIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean disabledIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean multipleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean requiredIsSet = new AtomicBoolean(false);
      private final AtomicBoolean sizeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private selectST(STGroup group) {
   		template = group.getInstanceOf("select");
   	}

      public selectST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public selectST setAutofocus(Object value) {
      	tryToSetStringProperty(template, value, autofocusIsSet, "autofocus");   
         return this;
      }
      public selectST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public selectST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public selectST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public selectST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public selectST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public selectST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public selectST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public selectST setDisabled(Object value) {
      	tryToSetStringProperty(template, value, disabledIsSet, "disabled");   
         return this;
      }
      public selectST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public selectST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public selectST setForm(Object value) {
      	tryToSetStringProperty(template, value, formIsSet, "form");   
         return this;
      }
      public selectST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public selectST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public selectST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public selectST setMultiple(Object value) {
      	tryToSetStringProperty(template, value, multipleIsSet, "multiple");   
         return this;
      }
      public selectST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public selectST setRequired(Object value) {
      	tryToSetStringProperty(template, value, requiredIsSet, "required");   
         return this;
      }
      public selectST setSize(Object value) {
      	tryToSetStringProperty(template, value, sizeIsSet, "size");   
         return this;
      }
      public selectST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public selectST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public selectST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public selectST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public selectST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class smallST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private smallST(STGroup group) {
   		template = group.getInstanceOf("small");
   	}

      public smallST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public smallST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public smallST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public smallST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public smallST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public smallST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public smallST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public smallST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public smallST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public smallST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public smallST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public smallST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public smallST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public smallST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public smallST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public smallST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public smallST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public smallST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class sourceST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean mediaIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean srcIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private sourceST(STGroup group) {
   		template = group.getInstanceOf("source");
   	}

      public sourceST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public sourceST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public sourceST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public sourceST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public sourceST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public sourceST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public sourceST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public sourceST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public sourceST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public sourceST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public sourceST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public sourceST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public sourceST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public sourceST setMedia(Object value) {
      	tryToSetStringProperty(template, value, mediaIsSet, "media");   
         return this;
      }
      public sourceST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public sourceST setSrc(Object value) {
      	tryToSetStringProperty(template, value, srcIsSet, "src");   
         return this;
      }
      public sourceST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public sourceST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public sourceST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public sourceST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public sourceST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class spanST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private spanST(STGroup group) {
   		template = group.getInstanceOf("span");
   	}

      public spanST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public spanST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public spanST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public spanST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public spanST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public spanST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public spanST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public spanST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public spanST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public spanST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public spanST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public spanST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public spanST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public spanST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public spanST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public spanST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public spanST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public spanST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class strikeST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private strikeST(STGroup group) {
   		template = group.getInstanceOf("strike");
   	}

      public strikeST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public strikeST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public strikeST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public strikeST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public strikeST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public strikeST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public strikeST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public strikeST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public strikeST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public strikeST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public strikeST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public strikeST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public strikeST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public strikeST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public strikeST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public strikeST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public strikeST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public strikeST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class strongST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private strongST(STGroup group) {
   		template = group.getInstanceOf("strong");
   	}

      public strongST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public strongST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public strongST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public strongST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public strongST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public strongST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public strongST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public strongST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public strongST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public strongST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public strongST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public strongST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public strongST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public strongST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public strongST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public strongST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public strongST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public strongST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class styleST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean mediaIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopedIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private styleST(STGroup group) {
   		template = group.getInstanceOf("style");
   	}

      public styleST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public styleST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public styleST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public styleST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public styleST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public styleST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public styleST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public styleST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public styleST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public styleST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public styleST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public styleST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public styleST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public styleST setMedia(Object value) {
      	tryToSetStringProperty(template, value, mediaIsSet, "media");   
         return this;
      }
      public styleST setScoped(Object value) {
      	tryToSetStringProperty(template, value, scopedIsSet, "scoped");   
         return this;
      }
      public styleST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public styleST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public styleST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public styleST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public styleST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public styleST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class subST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private subST(STGroup group) {
   		template = group.getInstanceOf("sub");
   	}

      public subST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public subST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public subST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public subST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public subST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public subST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public subST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public subST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public subST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public subST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public subST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public subST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public subST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public subST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public subST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public subST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public subST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public subST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class summaryST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private summaryST(STGroup group) {
   		template = group.getInstanceOf("summary");
   	}

      public summaryST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public summaryST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public summaryST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public summaryST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public summaryST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public summaryST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public summaryST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public summaryST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public summaryST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public summaryST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public summaryST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public summaryST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public summaryST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public summaryST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public summaryST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public summaryST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public summaryST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public summaryST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class supST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private supST(STGroup group) {
   		template = group.getInstanceOf("sup");
   	}

      public supST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public supST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public supST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public supST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public supST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public supST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public supST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public supST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public supST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public supST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public supST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public supST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public supST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public supST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public supST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public supST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public supST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public supST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class tableST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean sortableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private tableST(STGroup group) {
   		template = group.getInstanceOf("table");
   	}

      public tableST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public tableST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public tableST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public tableST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public tableST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public tableST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public tableST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public tableST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public tableST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public tableST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public tableST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public tableST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public tableST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public tableST setSortable(Object value) {
      	tryToSetStringProperty(template, value, sortableIsSet, "sortable");   
         return this;
      }
      public tableST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public tableST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public tableST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public tableST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public tableST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class tbodyST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private tbodyST(STGroup group) {
   		template = group.getInstanceOf("tbody");
   	}

      public tbodyST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public tbodyST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public tbodyST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public tbodyST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public tbodyST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public tbodyST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public tbodyST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public tbodyST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public tbodyST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public tbodyST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public tbodyST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public tbodyST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public tbodyST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public tbodyST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public tbodyST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public tbodyST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public tbodyST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public tbodyST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class tdST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean colspanIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean headersIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean rowspanIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private tdST(STGroup group) {
   		template = group.getInstanceOf("td");
   	}

      public tdST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public tdST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public tdST setColspan(Object value) {
      	tryToSetStringProperty(template, value, colspanIsSet, "colspan");   
         return this;
      }
      public tdST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public tdST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public tdST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public tdST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public tdST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public tdST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public tdST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public tdST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public tdST setHeaders(Object value) {
      	tryToSetStringProperty(template, value, headersIsSet, "headers");   
         return this;
      }
      public tdST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public tdST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public tdST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public tdST setRowspan(Object value) {
      	tryToSetStringProperty(template, value, rowspanIsSet, "rowspan");   
         return this;
      }
      public tdST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public tdST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public tdST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public tdST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public tdST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class textareaST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean autofocusIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean colsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean disabledIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean formIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean maxlengthIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean placeholderIsSet = new AtomicBoolean(false);
      private final AtomicBoolean readonlyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean requiredIsSet = new AtomicBoolean(false);
      private final AtomicBoolean rowsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean wrapIsSet = new AtomicBoolean(false);
      private final ST template;

      private textareaST(STGroup group) {
   		template = group.getInstanceOf("textarea");
   	}

      public textareaST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public textareaST setAutofocus(Object value) {
      	tryToSetStringProperty(template, value, autofocusIsSet, "autofocus");   
         return this;
      }
      public textareaST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public textareaST setCols(Object value) {
      	tryToSetStringProperty(template, value, colsIsSet, "cols");   
         return this;
      }
      public textareaST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public textareaST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public textareaST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public textareaST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public textareaST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public textareaST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public textareaST setDisabled(Object value) {
      	tryToSetStringProperty(template, value, disabledIsSet, "disabled");   
         return this;
      }
      public textareaST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public textareaST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public textareaST setForm(Object value) {
      	tryToSetStringProperty(template, value, formIsSet, "form");   
         return this;
      }
      public textareaST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public textareaST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public textareaST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public textareaST setMaxlength(Object value) {
      	tryToSetStringProperty(template, value, maxlengthIsSet, "maxlength");   
         return this;
      }
      public textareaST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public textareaST setPlaceholder(Object value) {
      	tryToSetStringProperty(template, value, placeholderIsSet, "placeholder");   
         return this;
      }
      public textareaST setReadonly(Object value) {
      	tryToSetStringProperty(template, value, readonlyIsSet, "readonly");   
         return this;
      }
      public textareaST setRequired(Object value) {
      	tryToSetStringProperty(template, value, requiredIsSet, "required");   
         return this;
      }
      public textareaST setRows(Object value) {
      	tryToSetStringProperty(template, value, rowsIsSet, "rows");   
         return this;
      }
      public textareaST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public textareaST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public textareaST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public textareaST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public textareaST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public textareaST setWrap(Object value) {
      	tryToSetStringProperty(template, value, wrapIsSet, "wrap");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class tfootST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private tfootST(STGroup group) {
   		template = group.getInstanceOf("tfoot");
   	}

      public tfootST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public tfootST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public tfootST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public tfootST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public tfootST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public tfootST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public tfootST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public tfootST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public tfootST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public tfootST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public tfootST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public tfootST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public tfootST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public tfootST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public tfootST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public tfootST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public tfootST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public tfootST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class thST implements Html5DomainGroupTemplate {

      private final AtomicBoolean abbrIsSet = new AtomicBoolean(false);
      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean colspanIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean headersIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean rowspanIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean sortedIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private thST(STGroup group) {
   		template = group.getInstanceOf("th");
   	}

      public thST setAbbr(Object value) {
      	tryToSetStringProperty(template, value, abbrIsSet, "abbr");   
         return this;
      }
      public thST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public thST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public thST setColspan(Object value) {
      	tryToSetStringProperty(template, value, colspanIsSet, "colspan");   
         return this;
      }
      public thST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public thST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public thST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public thST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public thST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public thST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public thST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public thST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public thST setHeaders(Object value) {
      	tryToSetStringProperty(template, value, headersIsSet, "headers");   
         return this;
      }
      public thST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public thST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public thST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public thST setRowspan(Object value) {
      	tryToSetStringProperty(template, value, rowspanIsSet, "rowspan");   
         return this;
      }
      public thST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      }
      public thST setSorted(Object value) {
      	tryToSetStringProperty(template, value, sortedIsSet, "sorted");   
         return this;
      }
      public thST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public thST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public thST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public thST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public thST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class theadST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private theadST(STGroup group) {
   		template = group.getInstanceOf("thead");
   	}

      public theadST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public theadST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public theadST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public theadST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public theadST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public theadST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public theadST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public theadST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public theadST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public theadST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public theadST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public theadST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public theadST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public theadST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public theadST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public theadST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public theadST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public theadST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class timeST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean datetimeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private timeST(STGroup group) {
   		template = group.getInstanceOf("time");
   	}

      public timeST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public timeST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public timeST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public timeST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public timeST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public timeST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public timeST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public timeST setDatetime(Object value) {
      	tryToSetStringProperty(template, value, datetimeIsSet, "datetime");   
         return this;
      }
      public timeST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public timeST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public timeST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public timeST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public timeST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public timeST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public timeST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public timeST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public timeST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public timeST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public timeST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class titleST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private titleST(STGroup group) {
   		template = group.getInstanceOf("title");
   	}

      public titleST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public titleST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public titleST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public titleST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public titleST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public titleST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public titleST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public titleST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public titleST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public titleST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public titleST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public titleST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public titleST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public titleST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public titleST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public titleST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public titleST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public titleST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class trST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private trST(STGroup group) {
   		template = group.getInstanceOf("tr");
   	}

      public trST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public trST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public trST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public trST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public trST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public trST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public trST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public trST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public trST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public trST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public trST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public trST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public trST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public trST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public trST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public trST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public trST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public trST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class trackST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean default_IsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean kindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean labelIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean srcIsSet = new AtomicBoolean(false);
      private final AtomicBoolean srclangIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private trackST(STGroup group) {
   		template = group.getInstanceOf("track");
   	}

      public trackST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public trackST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public trackST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public trackST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public trackST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public trackST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public trackST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public trackST setDefault_(Object value) {
      	tryToSetStringProperty(template, value, default_IsSet, "default_");   
         return this;
      }
      public trackST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public trackST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public trackST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public trackST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public trackST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public trackST setKind(Object value) {
      	tryToSetStringProperty(template, value, kindIsSet, "kind");   
         return this;
      }
      public trackST setLabel(Object value) {
      	tryToSetStringProperty(template, value, labelIsSet, "label");   
         return this;
      }
      public trackST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public trackST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public trackST setSrc(Object value) {
      	tryToSetStringProperty(template, value, srcIsSet, "src");   
         return this;
      }
      public trackST setSrclang(Object value) {
      	tryToSetStringProperty(template, value, srclangIsSet, "srclang");   
         return this;
      }
      public trackST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public trackST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public trackST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public trackST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class ttST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private ttST(STGroup group) {
   		template = group.getInstanceOf("tt");
   	}

      public ttST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public ttST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public ttST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public ttST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public ttST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public ttST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public ttST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public ttST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public ttST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public ttST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public ttST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public ttST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public ttST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public ttST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public ttST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public ttST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public ttST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public ttST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class uST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private uST(STGroup group) {
   		template = group.getInstanceOf("u");
   	}

      public uST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public uST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public uST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public uST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public uST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public uST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public uST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public uST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public uST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public uST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public uST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public uST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public uST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public uST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public uST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public uST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public uST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public uST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class ulST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private ulST(STGroup group) {
   		template = group.getInstanceOf("ul");
   	}

      public ulST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public ulST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public ulST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public ulST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public ulST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public ulST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public ulST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public ulST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public ulST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public ulST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public ulST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public ulST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public ulST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public ulST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public ulST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public ulST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public ulST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public ulST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class varST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private varST(STGroup group) {
   		template = group.getInstanceOf("var");
   	}

      public varST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public varST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public varST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public varST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public varST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public varST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public varST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public varST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public varST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public varST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public varST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public varST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public varST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public varST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public varST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public varST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public varST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public varST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class videoST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean autoplayIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean controlsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean heightIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean loopIsSet = new AtomicBoolean(false);
      private final AtomicBoolean mutedIsSet = new AtomicBoolean(false);
      private final AtomicBoolean posterIsSet = new AtomicBoolean(false);
      private final AtomicBoolean preloadIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean srcIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean widthIsSet = new AtomicBoolean(false);
      private final ST template;

      private videoST(STGroup group) {
   		template = group.getInstanceOf("video");
   	}

      public videoST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public videoST setAutoplay(Object value) {
      	tryToSetStringProperty(template, value, autoplayIsSet, "autoplay");   
         return this;
      }
      public videoST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public videoST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public videoST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public videoST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public videoST setControls(Object value) {
      	tryToSetStringProperty(template, value, controlsIsSet, "controls");   
         return this;
      }
      public videoST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public videoST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public videoST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public videoST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public videoST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public videoST setHeight(Object value) {
      	tryToSetStringProperty(template, value, heightIsSet, "height");   
         return this;
      }
      public videoST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public videoST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public videoST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public videoST setLoop(Object value) {
      	tryToSetStringProperty(template, value, loopIsSet, "loop");   
         return this;
      }
      public videoST setMuted(Object value) {
      	tryToSetStringProperty(template, value, mutedIsSet, "muted");   
         return this;
      }
      public videoST setPoster(Object value) {
      	tryToSetStringProperty(template, value, posterIsSet, "poster");   
         return this;
      }
      public videoST setPreload(Object value) {
      	tryToSetStringProperty(template, value, preloadIsSet, "preload");   
         return this;
      }
      public videoST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public videoST setSrc(Object value) {
      	tryToSetStringProperty(template, value, srcIsSet, "src");   
         return this;
      }
      public videoST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public videoST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public videoST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public videoST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }
      public videoST setWidth(Object value) {
      	tryToSetStringProperty(template, value, widthIsSet, "width");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class wbrST implements Html5DomainGroupTemplate {

      private final AtomicBoolean accesskeyIsSet = new AtomicBoolean(false);
      private final AtomicBoolean classIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contenteditableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contextmenuIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dataIsSet = new AtomicBoolean(false);
      private final AtomicBoolean databindIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dirIsSet = new AtomicBoolean(false);
      private final AtomicBoolean draggableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dropzoneIsSet = new AtomicBoolean(false);
      private final AtomicBoolean hiddenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean langIsSet = new AtomicBoolean(false);
      private final AtomicBoolean spellcheckIsSet = new AtomicBoolean(false);
      private final AtomicBoolean styleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tabindexIsSet = new AtomicBoolean(false);
      private final AtomicBoolean titleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean translateIsSet = new AtomicBoolean(false);
      private final ST template;

      private wbrST(STGroup group) {
   		template = group.getInstanceOf("wbr");
   	}

      public wbrST setAccesskey(Object value) {
      	tryToSetStringProperty(template, value, accesskeyIsSet, "accesskey");   
         return this;
      }
      public wbrST setClass(Object value) {
      	tryToSetStringProperty(template, value, classIsSet, "class");   
         return this;
      }
      public wbrST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      }
      public wbrST setContenteditable(Object value) {
      	tryToSetStringProperty(template, value, contenteditableIsSet, "contenteditable");   
         return this;
      }
      public wbrST setContextmenu(Object value) {
      	tryToSetStringProperty(template, value, contextmenuIsSet, "contextmenu");   
         return this;
      }
      public wbrST addDataValue(Object name_, Object value_) {
         dataIsSet.set(true);
         template.addAggr("data.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public wbrST setDatabind(Object value) {
      	tryToSetStringProperty(template, value, databindIsSet, "databind");   
         return this;
      }
      public wbrST setDir(Object value) {
      	tryToSetStringProperty(template, value, dirIsSet, "dir");   
         return this;
      }
      public wbrST setDraggable(Object value) {
      	tryToSetStringProperty(template, value, draggableIsSet, "draggable");   
         return this;
      }
      public wbrST setDropzone(Object value) {
      	tryToSetStringProperty(template, value, dropzoneIsSet, "dropzone");   
         return this;
      }
      public wbrST setHidden(Object value) {
      	tryToSetStringProperty(template, value, hiddenIsSet, "hidden");   
         return this;
      }
      public wbrST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      }
      public wbrST setLang(Object value) {
      	tryToSetStringProperty(template, value, langIsSet, "lang");   
         return this;
      }
      public wbrST setSpellcheck(Object value) {
      	tryToSetStringProperty(template, value, spellcheckIsSet, "spellcheck");   
         return this;
      }
      public wbrST setStyle(Object value) {
      	tryToSetStringProperty(template, value, styleIsSet, "style");   
         return this;
      }
      public wbrST setTabindex(Object value) {
      	tryToSetStringProperty(template, value, tabindexIsSet, "tabindex");   
         return this;
      }
      public wbrST setTitle(Object value) {
      	tryToSetStringProperty(template, value, titleIsSet, "title");   
         return this;
      }
      public wbrST setTranslate(Object value) {
      	tryToSetStringProperty(template, value, translateIsSet, "translate");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

	static void tryToSetStringProperty(ST template, Object value, AtomicBoolean alreadySet, String name) {
		if (alreadySet.get()) return;
		if (value == null || value.toString().length() == 0) return;
		alreadySet.set(true);
		template.add(name, value);
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
}