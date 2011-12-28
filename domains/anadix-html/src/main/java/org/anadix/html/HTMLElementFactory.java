/*
 * Copyright 2011 Tomas Schlosser
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.anadix.html;

import java.math.BigInteger;
import java.util.Properties;

import org.anadix.impl.AbstractElementFactory;
import org.drools.runtime.StatefulKnowledgeSession;


/**
 * Factory class for HTML 4.01 Transitional domain.
 *
 * @author tomason
 * @version $Id: $
 */
public class HTMLElementFactory extends AbstractElementFactory {

	/**
	 * Constructor
	 *
	 * @param ksession knowledge session to insert elements to
	 */
	public HTMLElementFactory(StatefulKnowledgeSession ksession) {
		super(ksession);
	}

	/**
	 * Inserts HtmlElement using this ElementFactory
	 *
	 * @param element HtmlElement to insert
	 */
	public void insertElement(HtmlElement element) {
		super.insertElement(element);
	}

	/**
	 * Creates new &gt;A&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;A&lt; tag
	 */
	public ATag createATag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new ATag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;ABBR&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;ABBR&lt; tag
	 */
	public AbbrTag createAbbrTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new AbbrTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;ACRONYM&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;ACRONYM&lt; tag
	 */
	public AcronymTag createAcronymTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new AcronymTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;ADDRESS&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;ADDRESS&lt; tag
	 */
	public AddressTag createAddressTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new AddressTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;APPLET&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;APPLET&lt; tag
	 */
	public AppletTag createAppletTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new AppletTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;AREA&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;AREA&lt; tag
	 */
	public AreaTag createAreaTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new AreaTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;B&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;B&lt; tag
	 */
	public BTag createBTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new BTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;BASE&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;BASE&lt; tag
	 */
	public BaseTag createBaseTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new BaseTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;BASEFONT&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;BASEFONT&lt; tag
	 */
	public BasefontTag createBasefontTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new BasefontTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;BDO&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;BDO&lt; tag
	 */
	public BdoTag createBdoTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new BdoTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;BIG&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;BIG&lt; tag
	 */
	public BigTag createBigTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new BigTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;BLOCKQUOTE&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;BLOCKQUOTE&lt; tag
	 */
	public BlockquoteTag createBlockquoteTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new BlockquoteTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;BODY&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;BODY&lt; tag
	 */
	public BodyTag createBodyTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new BodyTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;BR&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;BR&lt; tag
	 */
	public BrTag createBrTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new BrTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;BUTTON&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;BUTTON&lt; tag
	 */
	public ButtonTag createButtonTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new ButtonTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;CAPTION&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;CAPTION&lt; tag
	 */
	public CaptionTag createCaptionTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new CaptionTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;CENTER&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;CENTER&lt; tag
	 */
	public CenterTag createCenterTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new CenterTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;CITE&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;CITE&lt; tag
	 */
	public CiteTag createCiteTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new CiteTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;CODE&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;CODE&lt; tag
	 */
	public CodeTag createCodeTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new CodeTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;COL&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;COL&lt; tag
	 */
	public ColTag createColTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new ColTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;COLGROUP&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;COLGROUP&lt; tag
	 */
	public ColgroupTag createColgroupTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new ColgroupTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;DD&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;DD&lt; tag
	 */
	public DdTag createDdTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new DdTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;DEL&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;DEL&lt; tag
	 */
	public DelTag createDelTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new DelTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;DFN&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;DFN&lt; tag
	 */
	public DfnTag createDfnTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new DfnTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;DIR&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;DIR&lt; tag
	 */
	public DirTag createDirTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new DirTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;DIV&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;DIV&lt; tag
	 */
	public DivTag createDivTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new DivTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;DL&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;DL&lt; tag
	 */
	public DlTag createDlTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new DlTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;DT&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;DT&lt; tag
	 */
	public DtTag createDtTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new DtTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;EM&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;EM&lt; tag
	 */
	public EmTag createEmTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new EmTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;FIELDSET&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;FIELDSET&lt; tag
	 */
	public FieldsetTag createFieldsetTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new FieldsetTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;FONT&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;FONT&lt; tag
	 */
	public FontTag createFontTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new FontTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;FORM&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;FORM&lt; tag
	 */
	public FormTag createFormTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new FormTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;FRAME&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;FRAME&lt; tag
	 */
	public FrameTag createFrameTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new FrameTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;FRAMESET&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;FRAMESET&lt; tag
	 */
	public FramesetTag createFramesetTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new FramesetTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;H1&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;H1&lt; tag
	 */
	public H1Tag createH1Tag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new H1Tag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;H2&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;H2&lt; tag
	 */
	public H2Tag createH2Tag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new H2Tag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;H3&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;A&lt; tag
	 */
	public H3Tag createH3Tag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new H3Tag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;H4&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;H4&lt; tag
	 */
	public H4Tag createH4Tag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new H4Tag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;H5&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;H5&lt; tag
	 */
	public H5Tag createH5Tag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new H5Tag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;H6&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;H6&lt; tag
	 */
	public H6Tag createH6Tag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new H6Tag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;HEAD&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;HEAD&lt; tag
	 */
	public HeadTag createHeadTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new HeadTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;HR&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;HR&lt; tag
	 */
	public HrTag createHrTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new HrTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;HTML&lt; tag
	 *
	 * @param id id of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;HTML&lt; tag
	 */
	public HtmlTag createHtmlTag(BigInteger id, Properties attributes) {
		return new HtmlTag(id, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;I&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;I&lt; tag
	 */
	public ITag createITag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new ITag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;IFRAME&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;IFRAME&lt; tag
	 */
	public IframeTag createIframeTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new IframeTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;IMG&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;IMG&lt; tag
	 */
	public ImgTag createImgTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new ImgTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;INPUT&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;INPUT&lt; tag
	 */
	public InputTag createInputTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new InputTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;INS&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;INS&lt; tag
	 */
	public InsTag createInsTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new InsTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;ISINDEX&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;ISINDEX&lt; tag
	 */
	public IsindexTag createIsindexTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new IsindexTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;KBD&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;KBD&lt; tag
	 */
	public KbdTag createKbdTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new KbdTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;LABEL&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;LABEL&lt; tag
	 */
	public LabelTag createLabelTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new LabelTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;LINK&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;LINK&lt; tag
	 */
	public LinkTag createLinkTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new LinkTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;LI&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;LI&lt; tag
	 */
	public LiTag createLiTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new LiTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;MAP&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;MAP&lt; tag
	 */
	public MapTag createMapTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new MapTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;MENU&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;MENU&lt; tag
	 */
	public MenuTag createMenuTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new MenuTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;META&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;META&lt; tag
	 */
	public MetaTag createMetaTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new MetaTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;NOFRAMES&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;NOFRAMES&lt; tag
	 */
	public NoframesTag createNoframesTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new NoframesTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;NOSCRIPT&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;NOSCRIPT&lt; tag
	 */
	public NoscriptTag createNoscriptTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new NoscriptTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;OBJECT&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;OBJECT&lt; tag
	 */
	public ObjectTag createObjectTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new ObjectTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;OL&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;OL&lt; tag
	 */
	public OlTag createOlTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new OlTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;OPTGROUP&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;OPTGROUP&lt; tag
	 */
	public OptgroupTag createOptgroupTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new OptgroupTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;OPTION&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;OPTION&lt; tag
	 */
	public OptionTag createOptionTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new OptionTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;P&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;P&lt; tag
	 */
	public PTag createPTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new PTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;PARAM&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;PARAM&lt; tag
	 */
	public ParamTag createParamTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new ParamTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;PRE&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;PRE&lt; tag
	 */
	public PreTag createPreTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new PreTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;Q&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;Q&lt; tag
	 */
	public QTag createQTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new QTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;S&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;S&lt; tag
	 */
	public STag createSTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new STag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;SAMP&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;SAMP&lt; tag
	 */
	public SampTag createSampTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new SampTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;SCRIPT&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;SCRIPT&lt; tag
	 */
	public ScriptTag createScriptTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new ScriptTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;SELECT&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;SELECT&lt; tag
	 */
	public SelectTag createSelectTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new SelectTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;SMALL&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;SMALL&lt; tag
	 */
	public SmallTag createSmallTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new SmallTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;SPAN&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;SPAN&lt; tag
	 */
	public SpanTag createSpanTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new SpanTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;STRIKE&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;STRIKE&lt; tag
	 */
	public StrikeTag createStrikeTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new StrikeTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;STRONG&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;STRONG&lt; tag
	 */
	public StrongTag createStrongTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new StrongTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;STYLE&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;STYLE&lt; tag
	 */
	public StyleTag createStyleTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new StyleTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;SUB&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;SUB&lt; tag
	 */
	public SubTag createSubTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new SubTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;SUP&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;SUP&lt; tag
	 */
	public SupTag createSupTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new SupTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;TABLE&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;TABLE&lt; tag
	 */
	public TableTag createTableTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new TableTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;TBODY&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;TBODY&lt; tag
	 */
	public TbodyTag createTbodyTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new TbodyTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;TD&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;TD&lt; tag
	 */
	public TdTag createTdTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new TdTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;TEXTAREA&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;TEXTAREA&lt; tag
	 */
	public TextareaTag createTextareaTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new TextareaTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;TFOOT&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;TFOOT&lt; tag
	 */
	public TfootTag createTfootTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new TfootTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;THEAD&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;THEAD&lt; tag
	 */
	public TheadTag createTheadTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new TheadTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;TH&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;TH&lt; tag
	 */
	public ThTag createThTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new ThTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;TITLE&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;TITLE&lt; tag
	 */
	public TitleTag createTitleTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new TitleTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;TR&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;TR&lt; tag
	 */
	public TrTag createTrTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new TrTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;TT&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;TT&lt; tag
	 */
	public TtTag createTtTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new TtTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;U&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;U&lt; tag
	 */
	public UTag createUTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new UTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;UL&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;UL&lt; tag
	 */
	public UlTag createUlTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new UlTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates new &gt;VAR&lt; tag
	 *
	 * @param id id of the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new &gt;VAR&lt; tag
	 */
	public VarTag createVarTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new VarTag(id, parent, new Attributes(attributes));
	}

	/**
	 * Creates a generic tag if none of previous is applicable
	 *
	 * @param id id of the tag
	 * @param name a the tag
	 * @param parent parent of the tag
	 * @param attributes attributes of the tag
	 * @return new tag
	 */
	public HtmlElement createTag(BigInteger id, String name, HtmlElement parent, Properties attributes) {
		return new DefaultElement(id, name, parent, new Attributes(attributes));
	}

	public static class DefaultElement extends HtmlElement {
		public DefaultElement(BigInteger id, String name, HtmlElement parent, Attributes attributes) {
			super(id, name, parent, attributes);
		}
	}
}
