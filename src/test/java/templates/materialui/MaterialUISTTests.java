package templates.materialui;

import static nextgen.templates.materialui.MaterialUIST.*;

/**
 * Tests for MaterialUIST
 **/
public class MaterialUISTTests {

	@org.junit.Test
	public void testAll() {
		testAccordion();
		testAccordionElement();
		testAccordionImport();
		testAccordionActions();
		testAccordionActionsElement();
		testAccordionActionsImport();
		testAccordionDetails();
		testAccordionDetailsElement();
		testAccordionDetailsImport();
		testAccordionSummary();
		testAccordionSummaryElement();
		testAccordionSummaryImport();
		testAlert();
		testAlertElement();
		testAlertImport();
		testAlertTitle();
		testAlertTitleElement();
		testAlertTitleImport();
		testAppBar();
		testAppBarElement();
		testAppBarImport();
		testAutocomplete();
		testAutocompleteElement();
		testAutocompleteImport();
		testAvatar();
		testAvatarElement();
		testAvatarImport();
		testAvatarGroup();
		testAvatarGroupElement();
		testAvatarGroupImport();
		testBackdrop();
		testBackdropElement();
		testBackdropImport();
		testBadge();
		testBadgeElement();
		testBadgeImport();
		testBottomNavigation();
		testBottomNavigationElement();
		testBottomNavigationImport();
		testBottomNavigationAction();
		testBottomNavigationActionElement();
		testBottomNavigationActionImport();
		testBox();
		testBoxElement();
		testBoxImport();
		testBreadcrumbs();
		testBreadcrumbsElement();
		testBreadcrumbsImport();
		testButton();
		testButtonElement();
		testButtonImport();
		testButtonBase();
		testButtonBaseElement();
		testButtonBaseImport();
		testButtonGroup();
		testButtonGroupElement();
		testButtonGroupImport();
		testCard();
		testCardElement();
		testCardImport();
		testCardActionArea();
		testCardActionAreaElement();
		testCardActionAreaImport();
		testCardActions();
		testCardActionsElement();
		testCardActionsImport();
		testCardContent();
		testCardContentElement();
		testCardContentImport();
		testCardHeader();
		testCardHeaderElement();
		testCardHeaderImport();
		testCardMedia();
		testCardMediaElement();
		testCardMediaImport();
		testCheckbox();
		testCheckboxElement();
		testCheckboxImport();
		testChip();
		testChipElement();
		testChipImport();
		testCircularProgress();
		testCircularProgressElement();
		testCircularProgressImport();
		testClickAwayListener();
		testClickAwayListenerElement();
		testClickAwayListenerImport();
		testCollapse();
		testCollapseElement();
		testCollapseImport();
		testContainer();
		testContainerElement();
		testContainerImport();
		testCssBaseline();
		testCssBaselineElement();
		testCssBaselineImport();
		testDialog();
		testDialogElement();
		testDialogImport();
		testDialogActions();
		testDialogActionsElement();
		testDialogActionsImport();
		testDialogContent();
		testDialogContentElement();
		testDialogContentImport();
		testDialogContentText();
		testDialogContentTextElement();
		testDialogContentTextImport();
		testDialogTitle();
		testDialogTitleElement();
		testDialogTitleImport();
		testDivider();
		testDividerElement();
		testDividerImport();
		testDrawer();
		testDrawerElement();
		testDrawerImport();
		testExpansionPanel();
		testExpansionPanelElement();
		testExpansionPanelImport();
		testExpansionPanelActions();
		testExpansionPanelActionsElement();
		testExpansionPanelActionsImport();
		testExpansionPanelDetails();
		testExpansionPanelDetailsElement();
		testExpansionPanelDetailsImport();
		testExpansionPanelSummary();
		testExpansionPanelSummaryElement();
		testExpansionPanelSummaryImport();
		testFab();
		testFabElement();
		testFabImport();
		testFade();
		testFadeElement();
		testFadeImport();
		testFilledInput();
		testFilledInputElement();
		testFilledInputImport();
		testFormControl();
		testFormControlElement();
		testFormControlImport();
		testFormControlLabel();
		testFormControlLabelElement();
		testFormControlLabelImport();
		testFormGroup();
		testFormGroupElement();
		testFormGroupImport();
		testFormHelperText();
		testFormHelperTextElement();
		testFormHelperTextImport();
		testFormLabel();
		testFormLabelElement();
		testFormLabelImport();
		testGrid();
		testGridElement();
		testGridImport();
		testGridList();
		testGridListElement();
		testGridListImport();
		testGridListTile();
		testGridListTileElement();
		testGridListTileImport();
		testGridListTileBar();
		testGridListTileBarElement();
		testGridListTileBarImport();
		testGrow();
		testGrowElement();
		testGrowImport();
		testHidden();
		testHiddenElement();
		testHiddenImport();
		testIcon();
		testIconElement();
		testIconImport();
		testIconButton();
		testIconButtonElement();
		testIconButtonImport();
		testInput();
		testInputElement();
		testInputImport();
		testInputAdornment();
		testInputAdornmentElement();
		testInputAdornmentImport();
		testInputBase();
		testInputBaseElement();
		testInputBaseImport();
		testInputLabel();
		testInputLabelElement();
		testInputLabelImport();
		testLinearProgress();
		testLinearProgressElement();
		testLinearProgressImport();
		testLink();
		testLinkElement();
		testLinkImport();
		testList();
		testListElement();
		testListImport();
		testListItem();
		testListItemElement();
		testListItemImport();
		testListItemAvatar();
		testListItemAvatarElement();
		testListItemAvatarImport();
		testListItemIcon();
		testListItemIconElement();
		testListItemIconImport();
		testListItemSecondaryAction();
		testListItemSecondaryActionElement();
		testListItemSecondaryActionImport();
		testListItemText();
		testListItemTextElement();
		testListItemTextImport();
		testListSubheader();
		testListSubheaderElement();
		testListSubheaderImport();
		testLockOutlinedIcon();
		testLockOutlinedIconElement();
		testLockOutlinedIconImport();
		testMaterialUIComponent();
		testStyleClass();
		testMenu();
		testMenuElement();
		testMenuImport();
		testMenuIcon();
		testMenuIconElement();
		testMenuIconImport();
		testMenuItem();
		testMenuItemElement();
		testMenuItemImport();
		testMenuList();
		testMenuListElement();
		testMenuListImport();
		testMobileStepper();
		testMobileStepperElement();
		testMobileStepperImport();
		testModal();
		testModalElement();
		testModalImport();
		testNativeSelect();
		testNativeSelectElement();
		testNativeSelectImport();
		testNoSsr();
		testNoSsrElement();
		testNoSsrImport();
		testOutlinedInput();
		testOutlinedInputElement();
		testOutlinedInputImport();
		testPagination();
		testPaginationElement();
		testPaginationImport();
		testPaginationItem();
		testPaginationItemElement();
		testPaginationItemImport();
		testPaper();
		testPaperElement();
		testPaperImport();
		testPopover();
		testPopoverElement();
		testPopoverImport();
		testPopper();
		testPopperElement();
		testPopperImport();
		testPortal();
		testPortalElement();
		testPortalImport();
		testRadio();
		testRadioElement();
		testRadioImport();
		testRadioGroup();
		testRadioGroupElement();
		testRadioGroupImport();
		testRating();
		testRatingElement();
		testRatingImport();
		testRootRef();
		testRootRefElement();
		testRootRefImport();
		testScopedCssBaseline();
		testScopedCssBaselineElement();
		testScopedCssBaselineImport();
		testSelect();
		testSelectElement();
		testSelectImport();
		testSkeleton();
		testSkeletonElement();
		testSkeletonImport();
		testSlide();
		testSlideElement();
		testSlideImport();
		testSlider();
		testSliderElement();
		testSliderImport();
		testSnackbar();
		testSnackbarElement();
		testSnackbarImport();
		testSnackbarContent();
		testSnackbarContentElement();
		testSnackbarContentImport();
		testSpeedDial();
		testSpeedDialElement();
		testSpeedDialImport();
		testSpeedDialAction();
		testSpeedDialActionElement();
		testSpeedDialActionImport();
		testSpeedDialIcon();
		testSpeedDialIconElement();
		testSpeedDialIconImport();
		testStep();
		testStepElement();
		testStepImport();
		testStepButton();
		testStepButtonElement();
		testStepButtonImport();
		testStepConnector();
		testStepConnectorElement();
		testStepConnectorImport();
		testStepContent();
		testStepContentElement();
		testStepContentImport();
		testStepIcon();
		testStepIconElement();
		testStepIconImport();
		testStepLabel();
		testStepLabelElement();
		testStepLabelImport();
		testStepper();
		testStepperElement();
		testStepperImport();
		testSvgIcon();
		testSvgIconElement();
		testSvgIconImport();
		testSwipeableDrawer();
		testSwipeableDrawerElement();
		testSwipeableDrawerImport();
		testSwitch();
		testSwitchElement();
		testSwitchImport();
		testTab();
		testTabElement();
		testTabImport();
		testTabContext();
		testTabContextElement();
		testTabContextImport();
		testTable();
		testTableElement();
		testTableImport();
		testTableBody();
		testTableBodyElement();
		testTableBodyImport();
		testTableCell();
		testTableCellElement();
		testTableCellImport();
		testTableContainer();
		testTableContainerElement();
		testTableContainerImport();
		testTableFooter();
		testTableFooterElement();
		testTableFooterImport();
		testTableHead();
		testTableHeadElement();
		testTableHeadImport();
		testTablePagination();
		testTablePaginationElement();
		testTablePaginationImport();
		testTableRow();
		testTableRowElement();
		testTableRowImport();
		testTableSortLabel();
		testTableSortLabelElement();
		testTableSortLabelImport();
		testTabList();
		testTabListElement();
		testTabListImport();
		testTabPanel();
		testTabPanelElement();
		testTabPanelImport();
		testTabs();
		testTabsElement();
		testTabsImport();
		testTabScrollButton();
		testTabScrollButtonElement();
		testTabScrollButtonImport();
		testTextareaAutosize();
		testTextareaAutosizeElement();
		testTextareaAutosizeImport();
		testTextField();
		testTextFieldElement();
		testTextFieldImport();
		testTimeline();
		testTimelineElement();
		testTimelineImport();
		testTimelineConnector();
		testTimelineConnectorElement();
		testTimelineConnectorImport();
		testTimelineContent();
		testTimelineContentElement();
		testTimelineContentImport();
		testTimelineDot();
		testTimelineDotElement();
		testTimelineDotImport();
		testTimelineItem();
		testTimelineItemElement();
		testTimelineItemImport();
		testTimelineOppositeContent();
		testTimelineOppositeContentElement();
		testTimelineOppositeContentImport();
		testTimelineSeparator();
		testTimelineSeparatorElement();
		testTimelineSeparatorImport();
		testToggleButton();
		testToggleButtonElement();
		testToggleButtonImport();
		testToggleButtonGroup();
		testToggleButtonGroupElement();
		testToggleButtonGroupImport();
		testToolbar();
		testToolbarElement();
		testToolbarImport();
		testTooltip();
		testTooltipElement();
		testTooltipImport();
		testTreeItem();
		testTreeItemElement();
		testTreeItemImport();
		testTreeView();
		testTreeViewElement();
		testTreeViewImport();
		testTypography();
		testTypographyElement();
		testTypographyImport();
		testUnstableTrapFocus();
		testUnstableTrapFocusElement();
		testUnstableTrapFocusImport();
		testZoom();
		testZoomElement();
		testZoomImport();
	}

	@org.junit.Test
	public void testAccordion() {
		System.out.println("Accordion:\n" + newAccordion());
	}  

	@org.junit.Test
	public void testAccordionElement() {
		System.out.println("AccordionElement:\n" + newAccordionElement());
	}  

	@org.junit.Test
	public void testAccordionImport() {
		System.out.println("AccordionImport:\n" + newAccordionImport());
	}  

	@org.junit.Test
	public void testAccordionActions() {
		System.out.println("AccordionActions:\n" + newAccordionActions());
	}  

	@org.junit.Test
	public void testAccordionActionsElement() {
		System.out.println("AccordionActionsElement:\n" + newAccordionActionsElement());
	}  

	@org.junit.Test
	public void testAccordionActionsImport() {
		System.out.println("AccordionActionsImport:\n" + newAccordionActionsImport());
	}  

	@org.junit.Test
	public void testAccordionDetails() {
		System.out.println("AccordionDetails:\n" + newAccordionDetails());
	}  

	@org.junit.Test
	public void testAccordionDetailsElement() {
		System.out.println("AccordionDetailsElement:\n" + newAccordionDetailsElement());
	}  

	@org.junit.Test
	public void testAccordionDetailsImport() {
		System.out.println("AccordionDetailsImport:\n" + newAccordionDetailsImport());
	}  

	@org.junit.Test
	public void testAccordionSummary() {
		System.out.println("AccordionSummary:\n" + newAccordionSummary());
	}  

	@org.junit.Test
	public void testAccordionSummaryElement() {
		System.out.println("AccordionSummaryElement:\n" + newAccordionSummaryElement());
	}  

	@org.junit.Test
	public void testAccordionSummaryImport() {
		System.out.println("AccordionSummaryImport:\n" + newAccordionSummaryImport());
	}  

	@org.junit.Test
	public void testAlert() {
		System.out.println("Alert:\n" + newAlert());
	}  

	@org.junit.Test
	public void testAlertElement() {
		System.out.println("AlertElement:\n" + newAlertElement());
	}  

	@org.junit.Test
	public void testAlertImport() {
		System.out.println("AlertImport:\n" + newAlertImport());
	}  

	@org.junit.Test
	public void testAlertTitle() {
		System.out.println("AlertTitle:\n" + newAlertTitle());
	}  

	@org.junit.Test
	public void testAlertTitleElement() {
		System.out.println("AlertTitleElement:\n" + newAlertTitleElement());
	}  

	@org.junit.Test
	public void testAlertTitleImport() {
		System.out.println("AlertTitleImport:\n" + newAlertTitleImport());
	}  

	@org.junit.Test
	public void testAppBar() {
		System.out.println("AppBar:\n" + newAppBar());
	}  

	@org.junit.Test
	public void testAppBarElement() {
		System.out.println("AppBarElement:\n" + newAppBarElement());
	}  

	@org.junit.Test
	public void testAppBarImport() {
		System.out.println("AppBarImport:\n" + newAppBarImport());
	}  

	@org.junit.Test
	public void testAutocomplete() {
		System.out.println("Autocomplete:\n" + newAutocomplete());
	}  

	@org.junit.Test
	public void testAutocompleteElement() {
		System.out.println("AutocompleteElement:\n" + newAutocompleteElement());
	}  

	@org.junit.Test
	public void testAutocompleteImport() {
		System.out.println("AutocompleteImport:\n" + newAutocompleteImport());
	}  

	@org.junit.Test
	public void testAvatar() {
		System.out.println("Avatar:\n" + newAvatar());
	}  

	@org.junit.Test
	public void testAvatarElement() {
		System.out.println("AvatarElement:\n" + newAvatarElement());
	}  

	@org.junit.Test
	public void testAvatarImport() {
		System.out.println("AvatarImport:\n" + newAvatarImport());
	}  

	@org.junit.Test
	public void testAvatarGroup() {
		System.out.println("AvatarGroup:\n" + newAvatarGroup());
	}  

	@org.junit.Test
	public void testAvatarGroupElement() {
		System.out.println("AvatarGroupElement:\n" + newAvatarGroupElement());
	}  

	@org.junit.Test
	public void testAvatarGroupImport() {
		System.out.println("AvatarGroupImport:\n" + newAvatarGroupImport());
	}  

	@org.junit.Test
	public void testBackdrop() {
		System.out.println("Backdrop:\n" + newBackdrop());
	}  

	@org.junit.Test
	public void testBackdropElement() {
		System.out.println("BackdropElement:\n" + newBackdropElement());
	}  

	@org.junit.Test
	public void testBackdropImport() {
		System.out.println("BackdropImport:\n" + newBackdropImport());
	}  

	@org.junit.Test
	public void testBadge() {
		System.out.println("Badge:\n" + newBadge());
	}  

	@org.junit.Test
	public void testBadgeElement() {
		System.out.println("BadgeElement:\n" + newBadgeElement());
	}  

	@org.junit.Test
	public void testBadgeImport() {
		System.out.println("BadgeImport:\n" + newBadgeImport());
	}  

	@org.junit.Test
	public void testBottomNavigation() {
		System.out.println("BottomNavigation:\n" + newBottomNavigation());
	}  

	@org.junit.Test
	public void testBottomNavigationElement() {
		System.out.println("BottomNavigationElement:\n" + newBottomNavigationElement());
	}  

	@org.junit.Test
	public void testBottomNavigationImport() {
		System.out.println("BottomNavigationImport:\n" + newBottomNavigationImport());
	}  

	@org.junit.Test
	public void testBottomNavigationAction() {
		System.out.println("BottomNavigationAction:\n" + newBottomNavigationAction());
	}  

	@org.junit.Test
	public void testBottomNavigationActionElement() {
		System.out.println("BottomNavigationActionElement:\n" + newBottomNavigationActionElement());
	}  

	@org.junit.Test
	public void testBottomNavigationActionImport() {
		System.out.println("BottomNavigationActionImport:\n" + newBottomNavigationActionImport());
	}  

	@org.junit.Test
	public void testBox() {
		System.out.println("Box:\n" + newBox());
	}  

	@org.junit.Test
	public void testBoxElement() {
		System.out.println("BoxElement:\n" + newBoxElement());
	}  

	@org.junit.Test
	public void testBoxImport() {
		System.out.println("BoxImport:\n" + newBoxImport());
	}  

	@org.junit.Test
	public void testBreadcrumbs() {
		System.out.println("Breadcrumbs:\n" + newBreadcrumbs());
	}  

	@org.junit.Test
	public void testBreadcrumbsElement() {
		System.out.println("BreadcrumbsElement:\n" + newBreadcrumbsElement());
	}  

	@org.junit.Test
	public void testBreadcrumbsImport() {
		System.out.println("BreadcrumbsImport:\n" + newBreadcrumbsImport());
	}  

	@org.junit.Test
	public void testButton() {
		System.out.println("Button:\n" + newButton());
	}  

	@org.junit.Test
	public void testButtonElement() {
		System.out.println("ButtonElement:\n" + newButtonElement());
	}  

	@org.junit.Test
	public void testButtonImport() {
		System.out.println("ButtonImport:\n" + newButtonImport());
	}  

	@org.junit.Test
	public void testButtonBase() {
		System.out.println("ButtonBase:\n" + newButtonBase());
	}  

	@org.junit.Test
	public void testButtonBaseElement() {
		System.out.println("ButtonBaseElement:\n" + newButtonBaseElement());
	}  

	@org.junit.Test
	public void testButtonBaseImport() {
		System.out.println("ButtonBaseImport:\n" + newButtonBaseImport());
	}  

	@org.junit.Test
	public void testButtonGroup() {
		System.out.println("ButtonGroup:\n" + newButtonGroup());
	}  

	@org.junit.Test
	public void testButtonGroupElement() {
		System.out.println("ButtonGroupElement:\n" + newButtonGroupElement());
	}  

	@org.junit.Test
	public void testButtonGroupImport() {
		System.out.println("ButtonGroupImport:\n" + newButtonGroupImport());
	}  

	@org.junit.Test
	public void testCard() {
		System.out.println("Card:\n" + newCard());
	}  

	@org.junit.Test
	public void testCardElement() {
		System.out.println("CardElement:\n" + newCardElement());
	}  

	@org.junit.Test
	public void testCardImport() {
		System.out.println("CardImport:\n" + newCardImport());
	}  

	@org.junit.Test
	public void testCardActionArea() {
		System.out.println("CardActionArea:\n" + newCardActionArea());
	}  

	@org.junit.Test
	public void testCardActionAreaElement() {
		System.out.println("CardActionAreaElement:\n" + newCardActionAreaElement());
	}  

	@org.junit.Test
	public void testCardActionAreaImport() {
		System.out.println("CardActionAreaImport:\n" + newCardActionAreaImport());
	}  

	@org.junit.Test
	public void testCardActions() {
		System.out.println("CardActions:\n" + newCardActions());
	}  

	@org.junit.Test
	public void testCardActionsElement() {
		System.out.println("CardActionsElement:\n" + newCardActionsElement());
	}  

	@org.junit.Test
	public void testCardActionsImport() {
		System.out.println("CardActionsImport:\n" + newCardActionsImport());
	}  

	@org.junit.Test
	public void testCardContent() {
		System.out.println("CardContent:\n" + newCardContent());
	}  

	@org.junit.Test
	public void testCardContentElement() {
		System.out.println("CardContentElement:\n" + newCardContentElement());
	}  

	@org.junit.Test
	public void testCardContentImport() {
		System.out.println("CardContentImport:\n" + newCardContentImport());
	}  

	@org.junit.Test
	public void testCardHeader() {
		System.out.println("CardHeader:\n" + newCardHeader());
	}  

	@org.junit.Test
	public void testCardHeaderElement() {
		System.out.println("CardHeaderElement:\n" + newCardHeaderElement());
	}  

	@org.junit.Test
	public void testCardHeaderImport() {
		System.out.println("CardHeaderImport:\n" + newCardHeaderImport());
	}  

	@org.junit.Test
	public void testCardMedia() {
		System.out.println("CardMedia:\n" + newCardMedia());
	}  

	@org.junit.Test
	public void testCardMediaElement() {
		System.out.println("CardMediaElement:\n" + newCardMediaElement());
	}  

	@org.junit.Test
	public void testCardMediaImport() {
		System.out.println("CardMediaImport:\n" + newCardMediaImport());
	}  

	@org.junit.Test
	public void testCheckbox() {
		System.out.println("Checkbox:\n" + newCheckbox());
	}  

	@org.junit.Test
	public void testCheckboxElement() {
		System.out.println("CheckboxElement:\n" + newCheckboxElement());
	}  

	@org.junit.Test
	public void testCheckboxImport() {
		System.out.println("CheckboxImport:\n" + newCheckboxImport());
	}  

	@org.junit.Test
	public void testChip() {
		System.out.println("Chip:\n" + newChip());
	}  

	@org.junit.Test
	public void testChipElement() {
		System.out.println("ChipElement:\n" + newChipElement());
	}  

	@org.junit.Test
	public void testChipImport() {
		System.out.println("ChipImport:\n" + newChipImport());
	}  

	@org.junit.Test
	public void testCircularProgress() {
		System.out.println("CircularProgress:\n" + newCircularProgress());
	}  

	@org.junit.Test
	public void testCircularProgressElement() {
		System.out.println("CircularProgressElement:\n" + newCircularProgressElement());
	}  

	@org.junit.Test
	public void testCircularProgressImport() {
		System.out.println("CircularProgressImport:\n" + newCircularProgressImport());
	}  

	@org.junit.Test
	public void testClickAwayListener() {
		System.out.println("ClickAwayListener:\n" + newClickAwayListener());
	}  

	@org.junit.Test
	public void testClickAwayListenerElement() {
		System.out.println("ClickAwayListenerElement:\n" + newClickAwayListenerElement());
	}  

	@org.junit.Test
	public void testClickAwayListenerImport() {
		System.out.println("ClickAwayListenerImport:\n" + newClickAwayListenerImport());
	}  

	@org.junit.Test
	public void testCollapse() {
		System.out.println("Collapse:\n" + newCollapse());
	}  

	@org.junit.Test
	public void testCollapseElement() {
		System.out.println("CollapseElement:\n" + newCollapseElement());
	}  

	@org.junit.Test
	public void testCollapseImport() {
		System.out.println("CollapseImport:\n" + newCollapseImport());
	}  

	@org.junit.Test
	public void testContainer() {
		System.out.println("Container:\n" + newContainer());
	}  

	@org.junit.Test
	public void testContainerElement() {
		System.out.println("ContainerElement:\n" + newContainerElement());
	}  

	@org.junit.Test
	public void testContainerImport() {
		System.out.println("ContainerImport:\n" + newContainerImport());
	}  

	@org.junit.Test
	public void testCssBaseline() {
		System.out.println("CssBaseline:\n" + newCssBaseline());
	}  

	@org.junit.Test
	public void testCssBaselineElement() {
		System.out.println("CssBaselineElement:\n" + newCssBaselineElement());
	}  

	@org.junit.Test
	public void testCssBaselineImport() {
		System.out.println("CssBaselineImport:\n" + newCssBaselineImport());
	}  

	@org.junit.Test
	public void testDialog() {
		System.out.println("Dialog:\n" + newDialog());
	}  

	@org.junit.Test
	public void testDialogElement() {
		System.out.println("DialogElement:\n" + newDialogElement());
	}  

	@org.junit.Test
	public void testDialogImport() {
		System.out.println("DialogImport:\n" + newDialogImport());
	}  

	@org.junit.Test
	public void testDialogActions() {
		System.out.println("DialogActions:\n" + newDialogActions());
	}  

	@org.junit.Test
	public void testDialogActionsElement() {
		System.out.println("DialogActionsElement:\n" + newDialogActionsElement());
	}  

	@org.junit.Test
	public void testDialogActionsImport() {
		System.out.println("DialogActionsImport:\n" + newDialogActionsImport());
	}  

	@org.junit.Test
	public void testDialogContent() {
		System.out.println("DialogContent:\n" + newDialogContent());
	}  

	@org.junit.Test
	public void testDialogContentElement() {
		System.out.println("DialogContentElement:\n" + newDialogContentElement());
	}  

	@org.junit.Test
	public void testDialogContentImport() {
		System.out.println("DialogContentImport:\n" + newDialogContentImport());
	}  

	@org.junit.Test
	public void testDialogContentText() {
		System.out.println("DialogContentText:\n" + newDialogContentText());
	}  

	@org.junit.Test
	public void testDialogContentTextElement() {
		System.out.println("DialogContentTextElement:\n" + newDialogContentTextElement());
	}  

	@org.junit.Test
	public void testDialogContentTextImport() {
		System.out.println("DialogContentTextImport:\n" + newDialogContentTextImport());
	}  

	@org.junit.Test
	public void testDialogTitle() {
		System.out.println("DialogTitle:\n" + newDialogTitle());
	}  

	@org.junit.Test
	public void testDialogTitleElement() {
		System.out.println("DialogTitleElement:\n" + newDialogTitleElement());
	}  

	@org.junit.Test
	public void testDialogTitleImport() {
		System.out.println("DialogTitleImport:\n" + newDialogTitleImport());
	}  

	@org.junit.Test
	public void testDivider() {
		System.out.println("Divider:\n" + newDivider());
	}  

	@org.junit.Test
	public void testDividerElement() {
		System.out.println("DividerElement:\n" + newDividerElement());
	}  

	@org.junit.Test
	public void testDividerImport() {
		System.out.println("DividerImport:\n" + newDividerImport());
	}  

	@org.junit.Test
	public void testDrawer() {
		System.out.println("Drawer:\n" + newDrawer());
	}  

	@org.junit.Test
	public void testDrawerElement() {
		System.out.println("DrawerElement:\n" + newDrawerElement());
	}  

	@org.junit.Test
	public void testDrawerImport() {
		System.out.println("DrawerImport:\n" + newDrawerImport());
	}  

	@org.junit.Test
	public void testExpansionPanel() {
		System.out.println("ExpansionPanel:\n" + newExpansionPanel());
	}  

	@org.junit.Test
	public void testExpansionPanelElement() {
		System.out.println("ExpansionPanelElement:\n" + newExpansionPanelElement());
	}  

	@org.junit.Test
	public void testExpansionPanelImport() {
		System.out.println("ExpansionPanelImport:\n" + newExpansionPanelImport());
	}  

	@org.junit.Test
	public void testExpansionPanelActions() {
		System.out.println("ExpansionPanelActions:\n" + newExpansionPanelActions());
	}  

	@org.junit.Test
	public void testExpansionPanelActionsElement() {
		System.out.println("ExpansionPanelActionsElement:\n" + newExpansionPanelActionsElement());
	}  

	@org.junit.Test
	public void testExpansionPanelActionsImport() {
		System.out.println("ExpansionPanelActionsImport:\n" + newExpansionPanelActionsImport());
	}  

	@org.junit.Test
	public void testExpansionPanelDetails() {
		System.out.println("ExpansionPanelDetails:\n" + newExpansionPanelDetails());
	}  

	@org.junit.Test
	public void testExpansionPanelDetailsElement() {
		System.out.println("ExpansionPanelDetailsElement:\n" + newExpansionPanelDetailsElement());
	}  

	@org.junit.Test
	public void testExpansionPanelDetailsImport() {
		System.out.println("ExpansionPanelDetailsImport:\n" + newExpansionPanelDetailsImport());
	}  

	@org.junit.Test
	public void testExpansionPanelSummary() {
		System.out.println("ExpansionPanelSummary:\n" + newExpansionPanelSummary());
	}  

	@org.junit.Test
	public void testExpansionPanelSummaryElement() {
		System.out.println("ExpansionPanelSummaryElement:\n" + newExpansionPanelSummaryElement());
	}  

	@org.junit.Test
	public void testExpansionPanelSummaryImport() {
		System.out.println("ExpansionPanelSummaryImport:\n" + newExpansionPanelSummaryImport());
	}  

	@org.junit.Test
	public void testFab() {
		System.out.println("Fab:\n" + newFab());
	}  

	@org.junit.Test
	public void testFabElement() {
		System.out.println("FabElement:\n" + newFabElement());
	}  

	@org.junit.Test
	public void testFabImport() {
		System.out.println("FabImport:\n" + newFabImport());
	}  

	@org.junit.Test
	public void testFade() {
		System.out.println("Fade:\n" + newFade());
	}  

	@org.junit.Test
	public void testFadeElement() {
		System.out.println("FadeElement:\n" + newFadeElement());
	}  

	@org.junit.Test
	public void testFadeImport() {
		System.out.println("FadeImport:\n" + newFadeImport());
	}  

	@org.junit.Test
	public void testFilledInput() {
		System.out.println("FilledInput:\n" + newFilledInput());
	}  

	@org.junit.Test
	public void testFilledInputElement() {
		System.out.println("FilledInputElement:\n" + newFilledInputElement());
	}  

	@org.junit.Test
	public void testFilledInputImport() {
		System.out.println("FilledInputImport:\n" + newFilledInputImport());
	}  

	@org.junit.Test
	public void testFormControl() {
		System.out.println("FormControl:\n" + newFormControl());
	}  

	@org.junit.Test
	public void testFormControlElement() {
		System.out.println("FormControlElement:\n" + newFormControlElement());
	}  

	@org.junit.Test
	public void testFormControlImport() {
		System.out.println("FormControlImport:\n" + newFormControlImport());
	}  

	@org.junit.Test
	public void testFormControlLabel() {
		System.out.println("FormControlLabel:\n" + newFormControlLabel());
	}  

	@org.junit.Test
	public void testFormControlLabelElement() {
		System.out.println("FormControlLabelElement:\n" + newFormControlLabelElement());
	}  

	@org.junit.Test
	public void testFormControlLabelImport() {
		System.out.println("FormControlLabelImport:\n" + newFormControlLabelImport());
	}  

	@org.junit.Test
	public void testFormGroup() {
		System.out.println("FormGroup:\n" + newFormGroup());
	}  

	@org.junit.Test
	public void testFormGroupElement() {
		System.out.println("FormGroupElement:\n" + newFormGroupElement());
	}  

	@org.junit.Test
	public void testFormGroupImport() {
		System.out.println("FormGroupImport:\n" + newFormGroupImport());
	}  

	@org.junit.Test
	public void testFormHelperText() {
		System.out.println("FormHelperText:\n" + newFormHelperText());
	}  

	@org.junit.Test
	public void testFormHelperTextElement() {
		System.out.println("FormHelperTextElement:\n" + newFormHelperTextElement());
	}  

	@org.junit.Test
	public void testFormHelperTextImport() {
		System.out.println("FormHelperTextImport:\n" + newFormHelperTextImport());
	}  

	@org.junit.Test
	public void testFormLabel() {
		System.out.println("FormLabel:\n" + newFormLabel());
	}  

	@org.junit.Test
	public void testFormLabelElement() {
		System.out.println("FormLabelElement:\n" + newFormLabelElement());
	}  

	@org.junit.Test
	public void testFormLabelImport() {
		System.out.println("FormLabelImport:\n" + newFormLabelImport());
	}  

	@org.junit.Test
	public void testGrid() {
		System.out.println("Grid:\n" + newGrid());
	}  

	@org.junit.Test
	public void testGridElement() {
		System.out.println("GridElement:\n" + newGridElement());
	}  

	@org.junit.Test
	public void testGridImport() {
		System.out.println("GridImport:\n" + newGridImport());
	}  

	@org.junit.Test
	public void testGridList() {
		System.out.println("GridList:\n" + newGridList());
	}  

	@org.junit.Test
	public void testGridListElement() {
		System.out.println("GridListElement:\n" + newGridListElement());
	}  

	@org.junit.Test
	public void testGridListImport() {
		System.out.println("GridListImport:\n" + newGridListImport());
	}  

	@org.junit.Test
	public void testGridListTile() {
		System.out.println("GridListTile:\n" + newGridListTile());
	}  

	@org.junit.Test
	public void testGridListTileElement() {
		System.out.println("GridListTileElement:\n" + newGridListTileElement());
	}  

	@org.junit.Test
	public void testGridListTileImport() {
		System.out.println("GridListTileImport:\n" + newGridListTileImport());
	}  

	@org.junit.Test
	public void testGridListTileBar() {
		System.out.println("GridListTileBar:\n" + newGridListTileBar());
	}  

	@org.junit.Test
	public void testGridListTileBarElement() {
		System.out.println("GridListTileBarElement:\n" + newGridListTileBarElement());
	}  

	@org.junit.Test
	public void testGridListTileBarImport() {
		System.out.println("GridListTileBarImport:\n" + newGridListTileBarImport());
	}  

	@org.junit.Test
	public void testGrow() {
		System.out.println("Grow:\n" + newGrow());
	}  

	@org.junit.Test
	public void testGrowElement() {
		System.out.println("GrowElement:\n" + newGrowElement());
	}  

	@org.junit.Test
	public void testGrowImport() {
		System.out.println("GrowImport:\n" + newGrowImport());
	}  

	@org.junit.Test
	public void testHidden() {
		System.out.println("Hidden:\n" + newHidden());
	}  

	@org.junit.Test
	public void testHiddenElement() {
		System.out.println("HiddenElement:\n" + newHiddenElement());
	}  

	@org.junit.Test
	public void testHiddenImport() {
		System.out.println("HiddenImport:\n" + newHiddenImport());
	}  

	@org.junit.Test
	public void testIcon() {
		System.out.println("Icon:\n" + newIcon());
	}  

	@org.junit.Test
	public void testIconElement() {
		System.out.println("IconElement:\n" + newIconElement());
	}  

	@org.junit.Test
	public void testIconImport() {
		System.out.println("IconImport:\n" + newIconImport());
	}  

	@org.junit.Test
	public void testIconButton() {
		System.out.println("IconButton:\n" + newIconButton());
	}  

	@org.junit.Test
	public void testIconButtonElement() {
		System.out.println("IconButtonElement:\n" + newIconButtonElement());
	}  

	@org.junit.Test
	public void testIconButtonImport() {
		System.out.println("IconButtonImport:\n" + newIconButtonImport());
	}  

	@org.junit.Test
	public void testInput() {
		System.out.println("Input:\n" + newInput());
	}  

	@org.junit.Test
	public void testInputElement() {
		System.out.println("InputElement:\n" + newInputElement());
	}  

	@org.junit.Test
	public void testInputImport() {
		System.out.println("InputImport:\n" + newInputImport());
	}  

	@org.junit.Test
	public void testInputAdornment() {
		System.out.println("InputAdornment:\n" + newInputAdornment());
	}  

	@org.junit.Test
	public void testInputAdornmentElement() {
		System.out.println("InputAdornmentElement:\n" + newInputAdornmentElement());
	}  

	@org.junit.Test
	public void testInputAdornmentImport() {
		System.out.println("InputAdornmentImport:\n" + newInputAdornmentImport());
	}  

	@org.junit.Test
	public void testInputBase() {
		System.out.println("InputBase:\n" + newInputBase());
	}  

	@org.junit.Test
	public void testInputBaseElement() {
		System.out.println("InputBaseElement:\n" + newInputBaseElement());
	}  

	@org.junit.Test
	public void testInputBaseImport() {
		System.out.println("InputBaseImport:\n" + newInputBaseImport());
	}  

	@org.junit.Test
	public void testInputLabel() {
		System.out.println("InputLabel:\n" + newInputLabel());
	}  

	@org.junit.Test
	public void testInputLabelElement() {
		System.out.println("InputLabelElement:\n" + newInputLabelElement());
	}  

	@org.junit.Test
	public void testInputLabelImport() {
		System.out.println("InputLabelImport:\n" + newInputLabelImport());
	}  

	@org.junit.Test
	public void testLinearProgress() {
		System.out.println("LinearProgress:\n" + newLinearProgress());
	}  

	@org.junit.Test
	public void testLinearProgressElement() {
		System.out.println("LinearProgressElement:\n" + newLinearProgressElement());
	}  

	@org.junit.Test
	public void testLinearProgressImport() {
		System.out.println("LinearProgressImport:\n" + newLinearProgressImport());
	}  

	@org.junit.Test
	public void testLink() {
		System.out.println("Link:\n" + newLink());
	}  

	@org.junit.Test
	public void testLinkElement() {
		System.out.println("LinkElement:\n" + newLinkElement());
	}  

	@org.junit.Test
	public void testLinkImport() {
		System.out.println("LinkImport:\n" + newLinkImport());
	}  

	@org.junit.Test
	public void testList() {
		System.out.println("List:\n" + newList());
	}  

	@org.junit.Test
	public void testListElement() {
		System.out.println("ListElement:\n" + newListElement());
	}  

	@org.junit.Test
	public void testListImport() {
		System.out.println("ListImport:\n" + newListImport());
	}  

	@org.junit.Test
	public void testListItem() {
		System.out.println("ListItem:\n" + newListItem());
	}  

	@org.junit.Test
	public void testListItemElement() {
		System.out.println("ListItemElement:\n" + newListItemElement());
	}  

	@org.junit.Test
	public void testListItemImport() {
		System.out.println("ListItemImport:\n" + newListItemImport());
	}  

	@org.junit.Test
	public void testListItemAvatar() {
		System.out.println("ListItemAvatar:\n" + newListItemAvatar());
	}  

	@org.junit.Test
	public void testListItemAvatarElement() {
		System.out.println("ListItemAvatarElement:\n" + newListItemAvatarElement());
	}  

	@org.junit.Test
	public void testListItemAvatarImport() {
		System.out.println("ListItemAvatarImport:\n" + newListItemAvatarImport());
	}  

	@org.junit.Test
	public void testListItemIcon() {
		System.out.println("ListItemIcon:\n" + newListItemIcon());
	}  

	@org.junit.Test
	public void testListItemIconElement() {
		System.out.println("ListItemIconElement:\n" + newListItemIconElement());
	}  

	@org.junit.Test
	public void testListItemIconImport() {
		System.out.println("ListItemIconImport:\n" + newListItemIconImport());
	}  

	@org.junit.Test
	public void testListItemSecondaryAction() {
		System.out.println("ListItemSecondaryAction:\n" + newListItemSecondaryAction());
	}  

	@org.junit.Test
	public void testListItemSecondaryActionElement() {
		System.out.println("ListItemSecondaryActionElement:\n" + newListItemSecondaryActionElement());
	}  

	@org.junit.Test
	public void testListItemSecondaryActionImport() {
		System.out.println("ListItemSecondaryActionImport:\n" + newListItemSecondaryActionImport());
	}  

	@org.junit.Test
	public void testListItemText() {
		System.out.println("ListItemText:\n" + newListItemText());
	}  

	@org.junit.Test
	public void testListItemTextElement() {
		System.out.println("ListItemTextElement:\n" + newListItemTextElement());
	}  

	@org.junit.Test
	public void testListItemTextImport() {
		System.out.println("ListItemTextImport:\n" + newListItemTextImport());
	}  

	@org.junit.Test
	public void testListSubheader() {
		System.out.println("ListSubheader:\n" + newListSubheader());
	}  

	@org.junit.Test
	public void testListSubheaderElement() {
		System.out.println("ListSubheaderElement:\n" + newListSubheaderElement());
	}  

	@org.junit.Test
	public void testListSubheaderImport() {
		System.out.println("ListSubheaderImport:\n" + newListSubheaderImport());
	}  

	@org.junit.Test
	public void testLockOutlinedIcon() {
		System.out.println("LockOutlinedIcon:\n" + newLockOutlinedIcon());
	}  

	@org.junit.Test
	public void testLockOutlinedIconElement() {
		System.out.println("LockOutlinedIconElement:\n" + newLockOutlinedIconElement());
	}  

	@org.junit.Test
	public void testLockOutlinedIconImport() {
		System.out.println("LockOutlinedIconImport:\n" + newLockOutlinedIconImport());
	}  

	@org.junit.Test
	public void testMaterialUIComponent() {
		System.out.println("MaterialUIComponent:\n" + newMaterialUIComponent());
	}  

	@org.junit.Test
	public void testStyleClass() {
		System.out.println("StyleClass:\n" + newStyleClass());
	}  

	@org.junit.Test
	public void testMenu() {
		System.out.println("Menu:\n" + newMenu());
	}  

	@org.junit.Test
	public void testMenuElement() {
		System.out.println("MenuElement:\n" + newMenuElement());
	}  

	@org.junit.Test
	public void testMenuImport() {
		System.out.println("MenuImport:\n" + newMenuImport());
	}  

	@org.junit.Test
	public void testMenuIcon() {
		System.out.println("MenuIcon:\n" + newMenuIcon());
	}  

	@org.junit.Test
	public void testMenuIconElement() {
		System.out.println("MenuIconElement:\n" + newMenuIconElement());
	}  

	@org.junit.Test
	public void testMenuIconImport() {
		System.out.println("MenuIconImport:\n" + newMenuIconImport());
	}  

	@org.junit.Test
	public void testMenuItem() {
		System.out.println("MenuItem:\n" + newMenuItem());
	}  

	@org.junit.Test
	public void testMenuItemElement() {
		System.out.println("MenuItemElement:\n" + newMenuItemElement());
	}  

	@org.junit.Test
	public void testMenuItemImport() {
		System.out.println("MenuItemImport:\n" + newMenuItemImport());
	}  

	@org.junit.Test
	public void testMenuList() {
		System.out.println("MenuList:\n" + newMenuList());
	}  

	@org.junit.Test
	public void testMenuListElement() {
		System.out.println("MenuListElement:\n" + newMenuListElement());
	}  

	@org.junit.Test
	public void testMenuListImport() {
		System.out.println("MenuListImport:\n" + newMenuListImport());
	}  

	@org.junit.Test
	public void testMobileStepper() {
		System.out.println("MobileStepper:\n" + newMobileStepper());
	}  

	@org.junit.Test
	public void testMobileStepperElement() {
		System.out.println("MobileStepperElement:\n" + newMobileStepperElement());
	}  

	@org.junit.Test
	public void testMobileStepperImport() {
		System.out.println("MobileStepperImport:\n" + newMobileStepperImport());
	}  

	@org.junit.Test
	public void testModal() {
		System.out.println("Modal:\n" + newModal());
	}  

	@org.junit.Test
	public void testModalElement() {
		System.out.println("ModalElement:\n" + newModalElement());
	}  

	@org.junit.Test
	public void testModalImport() {
		System.out.println("ModalImport:\n" + newModalImport());
	}  

	@org.junit.Test
	public void testNativeSelect() {
		System.out.println("NativeSelect:\n" + newNativeSelect());
	}  

	@org.junit.Test
	public void testNativeSelectElement() {
		System.out.println("NativeSelectElement:\n" + newNativeSelectElement());
	}  

	@org.junit.Test
	public void testNativeSelectImport() {
		System.out.println("NativeSelectImport:\n" + newNativeSelectImport());
	}  

	@org.junit.Test
	public void testNoSsr() {
		System.out.println("NoSsr:\n" + newNoSsr());
	}  

	@org.junit.Test
	public void testNoSsrElement() {
		System.out.println("NoSsrElement:\n" + newNoSsrElement());
	}  

	@org.junit.Test
	public void testNoSsrImport() {
		System.out.println("NoSsrImport:\n" + newNoSsrImport());
	}  

	@org.junit.Test
	public void testOutlinedInput() {
		System.out.println("OutlinedInput:\n" + newOutlinedInput());
	}  

	@org.junit.Test
	public void testOutlinedInputElement() {
		System.out.println("OutlinedInputElement:\n" + newOutlinedInputElement());
	}  

	@org.junit.Test
	public void testOutlinedInputImport() {
		System.out.println("OutlinedInputImport:\n" + newOutlinedInputImport());
	}  

	@org.junit.Test
	public void testPagination() {
		System.out.println("Pagination:\n" + newPagination());
	}  

	@org.junit.Test
	public void testPaginationElement() {
		System.out.println("PaginationElement:\n" + newPaginationElement());
	}  

	@org.junit.Test
	public void testPaginationImport() {
		System.out.println("PaginationImport:\n" + newPaginationImport());
	}  

	@org.junit.Test
	public void testPaginationItem() {
		System.out.println("PaginationItem:\n" + newPaginationItem());
	}  

	@org.junit.Test
	public void testPaginationItemElement() {
		System.out.println("PaginationItemElement:\n" + newPaginationItemElement());
	}  

	@org.junit.Test
	public void testPaginationItemImport() {
		System.out.println("PaginationItemImport:\n" + newPaginationItemImport());
	}  

	@org.junit.Test
	public void testPaper() {
		System.out.println("Paper:\n" + newPaper());
	}  

	@org.junit.Test
	public void testPaperElement() {
		System.out.println("PaperElement:\n" + newPaperElement());
	}  

	@org.junit.Test
	public void testPaperImport() {
		System.out.println("PaperImport:\n" + newPaperImport());
	}  

	@org.junit.Test
	public void testPopover() {
		System.out.println("Popover:\n" + newPopover());
	}  

	@org.junit.Test
	public void testPopoverElement() {
		System.out.println("PopoverElement:\n" + newPopoverElement());
	}  

	@org.junit.Test
	public void testPopoverImport() {
		System.out.println("PopoverImport:\n" + newPopoverImport());
	}  

	@org.junit.Test
	public void testPopper() {
		System.out.println("Popper:\n" + newPopper());
	}  

	@org.junit.Test
	public void testPopperElement() {
		System.out.println("PopperElement:\n" + newPopperElement());
	}  

	@org.junit.Test
	public void testPopperImport() {
		System.out.println("PopperImport:\n" + newPopperImport());
	}  

	@org.junit.Test
	public void testPortal() {
		System.out.println("Portal:\n" + newPortal());
	}  

	@org.junit.Test
	public void testPortalElement() {
		System.out.println("PortalElement:\n" + newPortalElement());
	}  

	@org.junit.Test
	public void testPortalImport() {
		System.out.println("PortalImport:\n" + newPortalImport());
	}  

	@org.junit.Test
	public void testRadio() {
		System.out.println("Radio:\n" + newRadio());
	}  

	@org.junit.Test
	public void testRadioElement() {
		System.out.println("RadioElement:\n" + newRadioElement());
	}  

	@org.junit.Test
	public void testRadioImport() {
		System.out.println("RadioImport:\n" + newRadioImport());
	}  

	@org.junit.Test
	public void testRadioGroup() {
		System.out.println("RadioGroup:\n" + newRadioGroup());
	}  

	@org.junit.Test
	public void testRadioGroupElement() {
		System.out.println("RadioGroupElement:\n" + newRadioGroupElement());
	}  

	@org.junit.Test
	public void testRadioGroupImport() {
		System.out.println("RadioGroupImport:\n" + newRadioGroupImport());
	}  

	@org.junit.Test
	public void testRating() {
		System.out.println("Rating:\n" + newRating());
	}  

	@org.junit.Test
	public void testRatingElement() {
		System.out.println("RatingElement:\n" + newRatingElement());
	}  

	@org.junit.Test
	public void testRatingImport() {
		System.out.println("RatingImport:\n" + newRatingImport());
	}  

	@org.junit.Test
	public void testRootRef() {
		System.out.println("RootRef:\n" + newRootRef());
	}  

	@org.junit.Test
	public void testRootRefElement() {
		System.out.println("RootRefElement:\n" + newRootRefElement());
	}  

	@org.junit.Test
	public void testRootRefImport() {
		System.out.println("RootRefImport:\n" + newRootRefImport());
	}  

	@org.junit.Test
	public void testScopedCssBaseline() {
		System.out.println("ScopedCssBaseline:\n" + newScopedCssBaseline());
	}  

	@org.junit.Test
	public void testScopedCssBaselineElement() {
		System.out.println("ScopedCssBaselineElement:\n" + newScopedCssBaselineElement());
	}  

	@org.junit.Test
	public void testScopedCssBaselineImport() {
		System.out.println("ScopedCssBaselineImport:\n" + newScopedCssBaselineImport());
	}  

	@org.junit.Test
	public void testSelect() {
		System.out.println("Select:\n" + newSelect());
	}  

	@org.junit.Test
	public void testSelectElement() {
		System.out.println("SelectElement:\n" + newSelectElement());
	}  

	@org.junit.Test
	public void testSelectImport() {
		System.out.println("SelectImport:\n" + newSelectImport());
	}  

	@org.junit.Test
	public void testSkeleton() {
		System.out.println("Skeleton:\n" + newSkeleton());
	}  

	@org.junit.Test
	public void testSkeletonElement() {
		System.out.println("SkeletonElement:\n" + newSkeletonElement());
	}  

	@org.junit.Test
	public void testSkeletonImport() {
		System.out.println("SkeletonImport:\n" + newSkeletonImport());
	}  

	@org.junit.Test
	public void testSlide() {
		System.out.println("Slide:\n" + newSlide());
	}  

	@org.junit.Test
	public void testSlideElement() {
		System.out.println("SlideElement:\n" + newSlideElement());
	}  

	@org.junit.Test
	public void testSlideImport() {
		System.out.println("SlideImport:\n" + newSlideImport());
	}  

	@org.junit.Test
	public void testSlider() {
		System.out.println("Slider:\n" + newSlider());
	}  

	@org.junit.Test
	public void testSliderElement() {
		System.out.println("SliderElement:\n" + newSliderElement());
	}  

	@org.junit.Test
	public void testSliderImport() {
		System.out.println("SliderImport:\n" + newSliderImport());
	}  

	@org.junit.Test
	public void testSnackbar() {
		System.out.println("Snackbar:\n" + newSnackbar());
	}  

	@org.junit.Test
	public void testSnackbarElement() {
		System.out.println("SnackbarElement:\n" + newSnackbarElement());
	}  

	@org.junit.Test
	public void testSnackbarImport() {
		System.out.println("SnackbarImport:\n" + newSnackbarImport());
	}  

	@org.junit.Test
	public void testSnackbarContent() {
		System.out.println("SnackbarContent:\n" + newSnackbarContent());
	}  

	@org.junit.Test
	public void testSnackbarContentElement() {
		System.out.println("SnackbarContentElement:\n" + newSnackbarContentElement());
	}  

	@org.junit.Test
	public void testSnackbarContentImport() {
		System.out.println("SnackbarContentImport:\n" + newSnackbarContentImport());
	}  

	@org.junit.Test
	public void testSpeedDial() {
		System.out.println("SpeedDial:\n" + newSpeedDial());
	}  

	@org.junit.Test
	public void testSpeedDialElement() {
		System.out.println("SpeedDialElement:\n" + newSpeedDialElement());
	}  

	@org.junit.Test
	public void testSpeedDialImport() {
		System.out.println("SpeedDialImport:\n" + newSpeedDialImport());
	}  

	@org.junit.Test
	public void testSpeedDialAction() {
		System.out.println("SpeedDialAction:\n" + newSpeedDialAction());
	}  

	@org.junit.Test
	public void testSpeedDialActionElement() {
		System.out.println("SpeedDialActionElement:\n" + newSpeedDialActionElement());
	}  

	@org.junit.Test
	public void testSpeedDialActionImport() {
		System.out.println("SpeedDialActionImport:\n" + newSpeedDialActionImport());
	}  

	@org.junit.Test
	public void testSpeedDialIcon() {
		System.out.println("SpeedDialIcon:\n" + newSpeedDialIcon());
	}  

	@org.junit.Test
	public void testSpeedDialIconElement() {
		System.out.println("SpeedDialIconElement:\n" + newSpeedDialIconElement());
	}  

	@org.junit.Test
	public void testSpeedDialIconImport() {
		System.out.println("SpeedDialIconImport:\n" + newSpeedDialIconImport());
	}  

	@org.junit.Test
	public void testStep() {
		System.out.println("Step:\n" + newStep());
	}  

	@org.junit.Test
	public void testStepElement() {
		System.out.println("StepElement:\n" + newStepElement());
	}  

	@org.junit.Test
	public void testStepImport() {
		System.out.println("StepImport:\n" + newStepImport());
	}  

	@org.junit.Test
	public void testStepButton() {
		System.out.println("StepButton:\n" + newStepButton());
	}  

	@org.junit.Test
	public void testStepButtonElement() {
		System.out.println("StepButtonElement:\n" + newStepButtonElement());
	}  

	@org.junit.Test
	public void testStepButtonImport() {
		System.out.println("StepButtonImport:\n" + newStepButtonImport());
	}  

	@org.junit.Test
	public void testStepConnector() {
		System.out.println("StepConnector:\n" + newStepConnector());
	}  

	@org.junit.Test
	public void testStepConnectorElement() {
		System.out.println("StepConnectorElement:\n" + newStepConnectorElement());
	}  

	@org.junit.Test
	public void testStepConnectorImport() {
		System.out.println("StepConnectorImport:\n" + newStepConnectorImport());
	}  

	@org.junit.Test
	public void testStepContent() {
		System.out.println("StepContent:\n" + newStepContent());
	}  

	@org.junit.Test
	public void testStepContentElement() {
		System.out.println("StepContentElement:\n" + newStepContentElement());
	}  

	@org.junit.Test
	public void testStepContentImport() {
		System.out.println("StepContentImport:\n" + newStepContentImport());
	}  

	@org.junit.Test
	public void testStepIcon() {
		System.out.println("StepIcon:\n" + newStepIcon());
	}  

	@org.junit.Test
	public void testStepIconElement() {
		System.out.println("StepIconElement:\n" + newStepIconElement());
	}  

	@org.junit.Test
	public void testStepIconImport() {
		System.out.println("StepIconImport:\n" + newStepIconImport());
	}  

	@org.junit.Test
	public void testStepLabel() {
		System.out.println("StepLabel:\n" + newStepLabel());
	}  

	@org.junit.Test
	public void testStepLabelElement() {
		System.out.println("StepLabelElement:\n" + newStepLabelElement());
	}  

	@org.junit.Test
	public void testStepLabelImport() {
		System.out.println("StepLabelImport:\n" + newStepLabelImport());
	}  

	@org.junit.Test
	public void testStepper() {
		System.out.println("Stepper:\n" + newStepper());
	}  

	@org.junit.Test
	public void testStepperElement() {
		System.out.println("StepperElement:\n" + newStepperElement());
	}  

	@org.junit.Test
	public void testStepperImport() {
		System.out.println("StepperImport:\n" + newStepperImport());
	}  

	@org.junit.Test
	public void testSvgIcon() {
		System.out.println("SvgIcon:\n" + newSvgIcon());
	}  

	@org.junit.Test
	public void testSvgIconElement() {
		System.out.println("SvgIconElement:\n" + newSvgIconElement());
	}  

	@org.junit.Test
	public void testSvgIconImport() {
		System.out.println("SvgIconImport:\n" + newSvgIconImport());
	}  

	@org.junit.Test
	public void testSwipeableDrawer() {
		System.out.println("SwipeableDrawer:\n" + newSwipeableDrawer());
	}  

	@org.junit.Test
	public void testSwipeableDrawerElement() {
		System.out.println("SwipeableDrawerElement:\n" + newSwipeableDrawerElement());
	}  

	@org.junit.Test
	public void testSwipeableDrawerImport() {
		System.out.println("SwipeableDrawerImport:\n" + newSwipeableDrawerImport());
	}  

	@org.junit.Test
	public void testSwitch() {
		System.out.println("Switch:\n" + newSwitch());
	}  

	@org.junit.Test
	public void testSwitchElement() {
		System.out.println("SwitchElement:\n" + newSwitchElement());
	}  

	@org.junit.Test
	public void testSwitchImport() {
		System.out.println("SwitchImport:\n" + newSwitchImport());
	}  

	@org.junit.Test
	public void testTab() {
		System.out.println("Tab:\n" + newTab());
	}  

	@org.junit.Test
	public void testTabElement() {
		System.out.println("TabElement:\n" + newTabElement());
	}  

	@org.junit.Test
	public void testTabImport() {
		System.out.println("TabImport:\n" + newTabImport());
	}  

	@org.junit.Test
	public void testTabContext() {
		System.out.println("TabContext:\n" + newTabContext());
	}  

	@org.junit.Test
	public void testTabContextElement() {
		System.out.println("TabContextElement:\n" + newTabContextElement());
	}  

	@org.junit.Test
	public void testTabContextImport() {
		System.out.println("TabContextImport:\n" + newTabContextImport());
	}  

	@org.junit.Test
	public void testTable() {
		System.out.println("Table:\n" + newTable());
	}  

	@org.junit.Test
	public void testTableElement() {
		System.out.println("TableElement:\n" + newTableElement());
	}  

	@org.junit.Test
	public void testTableImport() {
		System.out.println("TableImport:\n" + newTableImport());
	}  

	@org.junit.Test
	public void testTableBody() {
		System.out.println("TableBody:\n" + newTableBody());
	}  

	@org.junit.Test
	public void testTableBodyElement() {
		System.out.println("TableBodyElement:\n" + newTableBodyElement());
	}  

	@org.junit.Test
	public void testTableBodyImport() {
		System.out.println("TableBodyImport:\n" + newTableBodyImport());
	}  

	@org.junit.Test
	public void testTableCell() {
		System.out.println("TableCell:\n" + newTableCell());
	}  

	@org.junit.Test
	public void testTableCellElement() {
		System.out.println("TableCellElement:\n" + newTableCellElement());
	}  

	@org.junit.Test
	public void testTableCellImport() {
		System.out.println("TableCellImport:\n" + newTableCellImport());
	}  

	@org.junit.Test
	public void testTableContainer() {
		System.out.println("TableContainer:\n" + newTableContainer());
	}  

	@org.junit.Test
	public void testTableContainerElement() {
		System.out.println("TableContainerElement:\n" + newTableContainerElement());
	}  

	@org.junit.Test
	public void testTableContainerImport() {
		System.out.println("TableContainerImport:\n" + newTableContainerImport());
	}  

	@org.junit.Test
	public void testTableFooter() {
		System.out.println("TableFooter:\n" + newTableFooter());
	}  

	@org.junit.Test
	public void testTableFooterElement() {
		System.out.println("TableFooterElement:\n" + newTableFooterElement());
	}  

	@org.junit.Test
	public void testTableFooterImport() {
		System.out.println("TableFooterImport:\n" + newTableFooterImport());
	}  

	@org.junit.Test
	public void testTableHead() {
		System.out.println("TableHead:\n" + newTableHead());
	}  

	@org.junit.Test
	public void testTableHeadElement() {
		System.out.println("TableHeadElement:\n" + newTableHeadElement());
	}  

	@org.junit.Test
	public void testTableHeadImport() {
		System.out.println("TableHeadImport:\n" + newTableHeadImport());
	}  

	@org.junit.Test
	public void testTablePagination() {
		System.out.println("TablePagination:\n" + newTablePagination());
	}  

	@org.junit.Test
	public void testTablePaginationElement() {
		System.out.println("TablePaginationElement:\n" + newTablePaginationElement());
	}  

	@org.junit.Test
	public void testTablePaginationImport() {
		System.out.println("TablePaginationImport:\n" + newTablePaginationImport());
	}  

	@org.junit.Test
	public void testTableRow() {
		System.out.println("TableRow:\n" + newTableRow());
	}  

	@org.junit.Test
	public void testTableRowElement() {
		System.out.println("TableRowElement:\n" + newTableRowElement());
	}  

	@org.junit.Test
	public void testTableRowImport() {
		System.out.println("TableRowImport:\n" + newTableRowImport());
	}  

	@org.junit.Test
	public void testTableSortLabel() {
		System.out.println("TableSortLabel:\n" + newTableSortLabel());
	}  

	@org.junit.Test
	public void testTableSortLabelElement() {
		System.out.println("TableSortLabelElement:\n" + newTableSortLabelElement());
	}  

	@org.junit.Test
	public void testTableSortLabelImport() {
		System.out.println("TableSortLabelImport:\n" + newTableSortLabelImport());
	}  

	@org.junit.Test
	public void testTabList() {
		System.out.println("TabList:\n" + newTabList());
	}  

	@org.junit.Test
	public void testTabListElement() {
		System.out.println("TabListElement:\n" + newTabListElement());
	}  

	@org.junit.Test
	public void testTabListImport() {
		System.out.println("TabListImport:\n" + newTabListImport());
	}  

	@org.junit.Test
	public void testTabPanel() {
		System.out.println("TabPanel:\n" + newTabPanel());
	}  

	@org.junit.Test
	public void testTabPanelElement() {
		System.out.println("TabPanelElement:\n" + newTabPanelElement());
	}  

	@org.junit.Test
	public void testTabPanelImport() {
		System.out.println("TabPanelImport:\n" + newTabPanelImport());
	}  

	@org.junit.Test
	public void testTabs() {
		System.out.println("Tabs:\n" + newTabs());
	}  

	@org.junit.Test
	public void testTabsElement() {
		System.out.println("TabsElement:\n" + newTabsElement());
	}  

	@org.junit.Test
	public void testTabsImport() {
		System.out.println("TabsImport:\n" + newTabsImport());
	}  

	@org.junit.Test
	public void testTabScrollButton() {
		System.out.println("TabScrollButton:\n" + newTabScrollButton());
	}  

	@org.junit.Test
	public void testTabScrollButtonElement() {
		System.out.println("TabScrollButtonElement:\n" + newTabScrollButtonElement());
	}  

	@org.junit.Test
	public void testTabScrollButtonImport() {
		System.out.println("TabScrollButtonImport:\n" + newTabScrollButtonImport());
	}  

	@org.junit.Test
	public void testTextareaAutosize() {
		System.out.println("TextareaAutosize:\n" + newTextareaAutosize());
	}  

	@org.junit.Test
	public void testTextareaAutosizeElement() {
		System.out.println("TextareaAutosizeElement:\n" + newTextareaAutosizeElement());
	}  

	@org.junit.Test
	public void testTextareaAutosizeImport() {
		System.out.println("TextareaAutosizeImport:\n" + newTextareaAutosizeImport());
	}  

	@org.junit.Test
	public void testTextField() {
		System.out.println("TextField:\n" + newTextField());
	}  

	@org.junit.Test
	public void testTextFieldElement() {
		System.out.println("TextFieldElement:\n" + newTextFieldElement());
	}  

	@org.junit.Test
	public void testTextFieldImport() {
		System.out.println("TextFieldImport:\n" + newTextFieldImport());
	}  

	@org.junit.Test
	public void testTimeline() {
		System.out.println("Timeline:\n" + newTimeline());
	}  

	@org.junit.Test
	public void testTimelineElement() {
		System.out.println("TimelineElement:\n" + newTimelineElement());
	}  

	@org.junit.Test
	public void testTimelineImport() {
		System.out.println("TimelineImport:\n" + newTimelineImport());
	}  

	@org.junit.Test
	public void testTimelineConnector() {
		System.out.println("TimelineConnector:\n" + newTimelineConnector());
	}  

	@org.junit.Test
	public void testTimelineConnectorElement() {
		System.out.println("TimelineConnectorElement:\n" + newTimelineConnectorElement());
	}  

	@org.junit.Test
	public void testTimelineConnectorImport() {
		System.out.println("TimelineConnectorImport:\n" + newTimelineConnectorImport());
	}  

	@org.junit.Test
	public void testTimelineContent() {
		System.out.println("TimelineContent:\n" + newTimelineContent());
	}  

	@org.junit.Test
	public void testTimelineContentElement() {
		System.out.println("TimelineContentElement:\n" + newTimelineContentElement());
	}  

	@org.junit.Test
	public void testTimelineContentImport() {
		System.out.println("TimelineContentImport:\n" + newTimelineContentImport());
	}  

	@org.junit.Test
	public void testTimelineDot() {
		System.out.println("TimelineDot:\n" + newTimelineDot());
	}  

	@org.junit.Test
	public void testTimelineDotElement() {
		System.out.println("TimelineDotElement:\n" + newTimelineDotElement());
	}  

	@org.junit.Test
	public void testTimelineDotImport() {
		System.out.println("TimelineDotImport:\n" + newTimelineDotImport());
	}  

	@org.junit.Test
	public void testTimelineItem() {
		System.out.println("TimelineItem:\n" + newTimelineItem());
	}  

	@org.junit.Test
	public void testTimelineItemElement() {
		System.out.println("TimelineItemElement:\n" + newTimelineItemElement());
	}  

	@org.junit.Test
	public void testTimelineItemImport() {
		System.out.println("TimelineItemImport:\n" + newTimelineItemImport());
	}  

	@org.junit.Test
	public void testTimelineOppositeContent() {
		System.out.println("TimelineOppositeContent:\n" + newTimelineOppositeContent());
	}  

	@org.junit.Test
	public void testTimelineOppositeContentElement() {
		System.out.println("TimelineOppositeContentElement:\n" + newTimelineOppositeContentElement());
	}  

	@org.junit.Test
	public void testTimelineOppositeContentImport() {
		System.out.println("TimelineOppositeContentImport:\n" + newTimelineOppositeContentImport());
	}  

	@org.junit.Test
	public void testTimelineSeparator() {
		System.out.println("TimelineSeparator:\n" + newTimelineSeparator());
	}  

	@org.junit.Test
	public void testTimelineSeparatorElement() {
		System.out.println("TimelineSeparatorElement:\n" + newTimelineSeparatorElement());
	}  

	@org.junit.Test
	public void testTimelineSeparatorImport() {
		System.out.println("TimelineSeparatorImport:\n" + newTimelineSeparatorImport());
	}  

	@org.junit.Test
	public void testToggleButton() {
		System.out.println("ToggleButton:\n" + newToggleButton());
	}  

	@org.junit.Test
	public void testToggleButtonElement() {
		System.out.println("ToggleButtonElement:\n" + newToggleButtonElement());
	}  

	@org.junit.Test
	public void testToggleButtonImport() {
		System.out.println("ToggleButtonImport:\n" + newToggleButtonImport());
	}  

	@org.junit.Test
	public void testToggleButtonGroup() {
		System.out.println("ToggleButtonGroup:\n" + newToggleButtonGroup());
	}  

	@org.junit.Test
	public void testToggleButtonGroupElement() {
		System.out.println("ToggleButtonGroupElement:\n" + newToggleButtonGroupElement());
	}  

	@org.junit.Test
	public void testToggleButtonGroupImport() {
		System.out.println("ToggleButtonGroupImport:\n" + newToggleButtonGroupImport());
	}  

	@org.junit.Test
	public void testToolbar() {
		System.out.println("Toolbar:\n" + newToolbar());
	}  

	@org.junit.Test
	public void testToolbarElement() {
		System.out.println("ToolbarElement:\n" + newToolbarElement());
	}  

	@org.junit.Test
	public void testToolbarImport() {
		System.out.println("ToolbarImport:\n" + newToolbarImport());
	}  

	@org.junit.Test
	public void testTooltip() {
		System.out.println("Tooltip:\n" + newTooltip());
	}  

	@org.junit.Test
	public void testTooltipElement() {
		System.out.println("TooltipElement:\n" + newTooltipElement());
	}  

	@org.junit.Test
	public void testTooltipImport() {
		System.out.println("TooltipImport:\n" + newTooltipImport());
	}  

	@org.junit.Test
	public void testTreeItem() {
		System.out.println("TreeItem:\n" + newTreeItem());
	}  

	@org.junit.Test
	public void testTreeItemElement() {
		System.out.println("TreeItemElement:\n" + newTreeItemElement());
	}  

	@org.junit.Test
	public void testTreeItemImport() {
		System.out.println("TreeItemImport:\n" + newTreeItemImport());
	}  

	@org.junit.Test
	public void testTreeView() {
		System.out.println("TreeView:\n" + newTreeView());
	}  

	@org.junit.Test
	public void testTreeViewElement() {
		System.out.println("TreeViewElement:\n" + newTreeViewElement());
	}  

	@org.junit.Test
	public void testTreeViewImport() {
		System.out.println("TreeViewImport:\n" + newTreeViewImport());
	}  

	@org.junit.Test
	public void testTypography() {
		System.out.println("Typography:\n" + newTypography());
	}  

	@org.junit.Test
	public void testTypographyElement() {
		System.out.println("TypographyElement:\n" + newTypographyElement());
	}  

	@org.junit.Test
	public void testTypographyImport() {
		System.out.println("TypographyImport:\n" + newTypographyImport());
	}  

	@org.junit.Test
	public void testUnstableTrapFocus() {
		System.out.println("UnstableTrapFocus:\n" + newUnstableTrapFocus());
	}  

	@org.junit.Test
	public void testUnstableTrapFocusElement() {
		System.out.println("UnstableTrapFocusElement:\n" + newUnstableTrapFocusElement());
	}  

	@org.junit.Test
	public void testUnstableTrapFocusImport() {
		System.out.println("UnstableTrapFocusImport:\n" + newUnstableTrapFocusImport());
	}  

	@org.junit.Test
	public void testZoom() {
		System.out.println("Zoom:\n" + newZoom());
	}  

	@org.junit.Test
	public void testZoomElement() {
		System.out.println("ZoomElement:\n" + newZoomElement());
	}  

	@org.junit.Test
	public void testZoomImport() {
		System.out.println("ZoomImport:\n" + newZoomImport());
	}  
} 