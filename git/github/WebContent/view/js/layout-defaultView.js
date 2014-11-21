var layout, innerLayout;

$(document).ready(function () {
	// OUTER-LAYOUT
	layout = $('body').layout({
		center__paneSelector:	".outer-center"
	,	west__paneSelector:		".outer-west"
	,	east__paneSelector:		".outer-east"
	,	west__size:				125
	,	east__size:				125
	,	spacing_open:			8  // ALL panes
	,	spacing_closed:			12 // ALL panes
	//,	north__spacing_open:	0
	//,	south__spacing_open:	0
	,	north__maxSize:			200
	,	south__maxSize:			200
			// MIDDLE-LAYOUT (child of outer-center-pane)
	,	center__childOptions: {
			center__paneSelector:	".middle-center"
		,	west__size:				100
		,	east__size:				100
		,	spacing_open:			6  // ALL panes
		,	spacing_closed:			12 // ALL panes
				// INNER-LAYOUT (child of middle-center-pane)
		,	center__childOptions: {
				center__paneSelector:	".inner-center"
			,	west__paneSelector:		".inner-west"
			,   north__size:            45
			,	west__size:				440
			,	spacing_open:			8  // ALL panes
			,	spacing_closed:			8  // ALL panes
			,	west__spacing_closed:	12
			}
		}
	});
	innerLayout = $(".middle-center").layout();
});